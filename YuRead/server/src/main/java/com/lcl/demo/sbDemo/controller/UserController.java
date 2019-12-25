package com.lcl.demo.sbDemo.controller;

import com.lcl.demo.sbDemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("v1/user-management")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public int users(@RequestParam Long id) {
        //userService =new userServiceImpl();
        int user = userService.insertDataById(id);
        return user;
    }

    @RequestMapping(value = "/names", method = RequestMethod.POST)
    @ResponseBody
    public int names(@RequestParam Long id, @RequestParam String name) {
        //userService =new userServiceImpl();
        int userName = userService.updateName(id, name);
        return userName;
    }

    @RequestMapping(value = "/portraits", method = RequestMethod.POST)
    @ResponseBody
    public int portraits(@RequestParam Long id, @RequestParam String url) {
        //userService =new userServiceImpl();
        int portrait = userService.updatePortrait(id, url);
        return portrait;
    }


}
