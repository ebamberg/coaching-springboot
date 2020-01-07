package com.ebamberg.coaching.demos.springdata.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * Swaggger and Swagger configuration for Spring Boot
 *
 * configuration uses different properties from application.properties file
 * to configure the appearance of the swagger-ui page
 *
 * decent default values are provided where necessary
 *
 * - spring.application.name                 name of the application to display on swagger ui page
 * - spring.application.version             version of the application to display on swagger ui page
 * - swagger.controller.basepackage    base package where swagger scans for @Controller and @RestController defaults to dboss main package
 * - wm.environment                          environment to display along with the application name
 *
 */
@Configuration
@EnableSwagger2
@ConditionalOnWebApplication
public class SwaggerConfiguration {


  private @Value("${wm.environment:ENV UNSET}") String envName;

  /**
   * creates a Swagger Configuration Bean (Docket)
   *
   * which defines to look alike and base package and behaviour of swagger.
   *
   * @param appName
   * @param appVersion
   * @param basePackage
   * @return a configured Docket
   */
  @Bean
  public Docket api(@Value("${spring.application.name:!! APPLICATION.NAME IS UNSET !!}") String appName, @Value("${spring.application.version:!! APPLICATION.VERSION IS UNSET !!}") String appVersion, @Value("${swagger.controller.basepackage:com.ebamberg.coaching}") String basePackage) {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors
            .basePackage(basePackage))
        .paths(PathSelectors.any()).build().apiInfo(apiInfo(appName,appVersion));

  }

  /**
   * builds information to display
   *
    * @param appName
   * @param appVersion
   * @return
   */
  private ApiInfo apiInfo(String appName, String appVersion) {
    return new ApiInfoBuilder()
        .title(""+appName+ "@"+envName)
        .description(appName)
        .version(appVersion)
        .contact(new Contact("ebamberg","http://erik.bamberg","erik.bamberg@web.de"))
        .license("for coaching use only")
        .build();
  }

}
