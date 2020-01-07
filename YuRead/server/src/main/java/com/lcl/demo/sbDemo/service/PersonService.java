package com.lcl.demo.sbDemo.service;

import com.lcl.demo.sbDemo.entity.Person;

import java.util.List;

public interface PersonService {

	List<Person> select(Long userId);

}
