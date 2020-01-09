package com.lcl.demo.sbDemo.controller;

import com.lcl.demo.sbDemo.entity.Person;
import com.lcl.demo.sbDemo.service.impl.PersonServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("v2/personalization-management")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @ApiOperation(value="查看个性化推荐书籍", notes="查看书籍")
    @ApiImplicitParam(name = "userid", value = "用户手机号", required = true, paramType = "Long")
    @RequestMapping(value = "/booklists", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> showPersonalization(@RequestParam Long userid) {
        //personService =new PersonServiceImpl();
        List<Person> booklistList  = personService.select(userid);
        return booklistList;
    }

}
