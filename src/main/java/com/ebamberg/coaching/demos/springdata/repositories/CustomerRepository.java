package com.ebamberg.coaching.demos.springdata.repositories;

import com.ebamberg.coaching.demos.springdata.model.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

    @Query("select c from Customer c")
    public Stream<Customer> streamAllCustomers();

    public List<Customer> findByLastnameAndFirstname(String lastname, String firstname);

    @Query("select c from Customer c WHERE c.lastname = ?1 ")
    public Customer findByLastname(String name);

    public List<Customer> findByDateOfBirthBetween (Date from, Date to);

    public List<Customer> findByDateOfBirthAfter (Date startDate);

    public List<Customer> findByLastnameOrderByDateOfBirthDesc(String lastname);


}