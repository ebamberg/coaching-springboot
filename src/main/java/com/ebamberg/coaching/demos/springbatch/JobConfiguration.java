package com.ebamberg.coaching.demos.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  private Resource inputResource  = new ClassPathResource("sample-data.csv");
  private Resource outputResource = new FileSystemResource("testOutput.csv");

  @Bean
  public Job importUserJob() {
    return jobBuilderFactory.get("copyPeronsJob")
        .incrementer(new RunIdIncrementer())
        .flow(instrumentSteps())
        .end()
        .build();
  }


  @Bean
  public Step instrumentSteps() {
    return stepBuilderFactory.get("personSteps")
        .<Person, Person> chunk(10)
        .reader(reader())
        .writer(personWriter())
        .build();
  }

  @Bean
  public FlatFileItemReader<Person> reader() {
    return new FlatFileItemReaderBuilder<Person>()
        .name("personItemReader")
        .resource(inputResource)
        .delimited()
        .delimiter(";")
        .names(new String[]{"name", "title"})
        .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
          setTargetType(Person.class);
        }})
        .build();
  }


  @Bean
  public FlatFileItemWriter<Person> personWriter() {
    FlatFileItemWriter<Person> writer = new FlatFileItemWriter<>();
    writer.setResource(outputResource);
    writer.setAppendAllowed(true);
    writer.setLineAggregator(new DelimitedLineAggregator<Person>() {
      {
        setDelimiter("~");
        setFieldExtractor(new BeanWrapperFieldExtractor<Person>() {
          {
            setNames(new String[] { "name", "title" });
          }
        });
      }
    });
    return writer;
  }




}





