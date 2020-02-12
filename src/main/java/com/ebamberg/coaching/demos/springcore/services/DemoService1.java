package com.ebamberg.coaching.demos.springcore.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService1 {

    @Autowired
    private PrinterService printer;

    @PostConstruct
    public void init() {
        printer.print();
    }
    

}