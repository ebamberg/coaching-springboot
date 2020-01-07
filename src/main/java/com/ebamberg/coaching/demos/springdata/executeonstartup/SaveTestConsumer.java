package com.ebamberg.coaching.demos.springdata.executeonstartup;

import java.util.Date;

import javax.transaction.Transactional;

import com.ebamberg.coaching.demos.springdata.RunOnStartup;
import com.ebamberg.coaching.demos.springdata.model.Customer;
import com.ebamberg.coaching.demos.springdata.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTestConsumer implements RunOnStartup {

    private @Autowired CustomerRepository costumerRepository;

    @Override
    @Transactional
    public void execute() {
         System.out.println("Save a costumer");

         System.out.println("customers in database"+costumerRepository.count());

         Customer costumer=new Customer("Smith","John",new Date());
         
         costumerRepository.save(costumer);

         Customer johnSmith=costumerRepository.findByLastname("Smith");

         johnSmith.setLastname("Trump");

         System.out.println("loaded from database: "+johnSmith.getLastname());

         System.out.println("customers in database"+costumerRepository.count());
    }

    

}