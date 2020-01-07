package com.lcl.demo.sbDemo.service.impl;

import com.lcl.demo.sbDemo.dao.PersonMapper;
import com.lcl.demo.sbDemo.entity.Person;
import com.lcl.demo.sbDemo.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;


    @Override
    public List<Person> select(Long userId) { return personMapper.select(userId); }

}
