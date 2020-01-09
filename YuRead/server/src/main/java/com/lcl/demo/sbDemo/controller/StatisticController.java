package com.lcl.demo.sbDemo.controller;

import com.lcl.demo.sbDemo.entity.Statistic;
import com.lcl.demo.sbDemo.service.impl.StatisticServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("v2/statistic-management")
public class StatisticController {
    @Autowired
    private StatisticServiceImpl statisticService;

    @ApiOperation(value="查看用户阅读数据统计", notes="查看数据统计")
    @ApiImplicitParam(name = "userid", value = "用户手机号", required = true, paramType = "Long")
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    @ResponseBody
    public Statistic checkStatistic(@RequestParam Long userid) {
        //statisticService =new statisticServiceImpl();
        Statistic statistic = statisticService.select(userid);
        return statistic;
    }


}
