package com.ebamberg.coaching.demos.springcore.services;

import org.springframework.stereotype.Component;

@Component
public class PrinterService {

    public void print() {
        System.out.println("Hello World!");
    }

}