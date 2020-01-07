package com.lcl.demo.sbDemo.controller;

import com.lcl.demo.sbDemo.entity.Statistic;
import com.lcl.demo.sbDemo.service.impl.StatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("v2/statistic-management")
public class StatisticController {
    @Autowired
    private StatisticServiceImpl statisticService;

//    @RequestMapping(value = "/users", method = RequestMethod.POST)
//    @ResponseBody
//    public int addUser(@RequestParam Long id) {
//        //userService =new userServiceImpl();
//        int user = userService.insertDataById(id);
//        return user;
//    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    @ResponseBody
    public Statistic checkStatistic(@RequestParam Long userid) {
        //statisticService =new statisticServiceImpl();
        Statistic statistic = statisticService.select(userid);
        return statistic;
    }

//    @RequestMapping(value = "/names", method = RequestMethod.PUT)
//    @ResponseBody
//    public int name(@RequestParam Long id, @RequestParam String name) {
//        //userService =new userServiceImpl();
//        int userName = userService.updateName(id, name);
//        return userName;
//    }
//
//    @RequestMapping(value = "/portraits", method = RequestMethod.PUT)
//    @ResponseBody
//    public int portrait(@RequestParam Long id, @RequestParam String url) {
//        //userService =new userServiceImpl();
//        int portrait = userService.updatePortrait(id, url);
//        return portrait;
//    }


}
