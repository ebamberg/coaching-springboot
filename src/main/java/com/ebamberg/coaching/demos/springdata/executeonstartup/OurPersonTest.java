package com.ebamberg.coaching.demos.springdata.executeonstartup;

import java.util.Date;

import com.ebamberg.coaching.demos.springdata.RunOnStartup;
import com.ebamberg.coaching.demos.springdata.model.Customer;
import com.ebamberg.coaching.demos.springdata.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OurPersonTest implements RunOnStartup {

 //   private @Autowired CustomerRepository costumerRepository;

    @Override
    public void execute() {
         System.out.println("Test out code");
        

    }

    

}