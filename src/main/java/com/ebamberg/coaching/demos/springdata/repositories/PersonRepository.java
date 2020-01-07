package com.ebamberg.coaching.demos.springdata.repositories;

import com.ebamberg.coaching.demos.springdata.model.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

import java.util.Date;
import java.util.List;

/**
 * not yet an extends JpaRepository<Person,Long>
 * 
 */


@Repository
public interface PersonRepository {

 

}