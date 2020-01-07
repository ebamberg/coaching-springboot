package com.ebamberg.coaching.demos.springdata.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String lastname;
    private String firstname;

    private Date dateOfBirth;

    public Customer () {
        
    }

    public Customer (String lastname,String firstname,Date dateOfBirth) {
        this.lastname=lastname;
        this.firstname=firstname;
        this.dateOfBirth=dateOfBirth;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname=lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }


}