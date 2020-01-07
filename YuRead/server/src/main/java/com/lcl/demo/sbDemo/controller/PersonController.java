package com.lcl.demo.sbDemo.controller;

import com.lcl.demo.sbDemo.entity.Person;
import com.lcl.demo.sbDemo.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("v2/personalization-management")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @RequestMapping(value = "/booklists", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> showPersonalization(@RequestParam Long userid) {
        //personService =new PersonServiceImpl();
        List<Person> booklistList  = personService.select(userid);
        return booklistList;
    }

}
