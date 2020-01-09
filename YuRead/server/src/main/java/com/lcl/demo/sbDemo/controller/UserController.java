package com.lcl.demo.sbDemo.controller;

import com.lcl.demo.sbDemo.entity.User;
import com.lcl.demo.sbDemo.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("v2/user-management")
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @ApiOperation(value="注册用户", notes="增加用户信息")
    @ApiImplicitParam(name = "id", value = "用户手机号", required = true, dataType = "Long")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public int addUser(@RequestParam Long id) {
        //userService =new userServiceImpl();
        int user = userService.insertDataById(id);
        return user;
    }

    @ApiOperation(value="获取某个用户信息", notes="获取某个用户信息")
    @ApiImplicitParam(name = "id", value = "用户手机号", required = true, dataType = "Long")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public User checkUser(@RequestParam Long id) {
        //userService =new userServiceImpl();
        User user = userService.selectByPrimaryKey(id);
        return user;
    }

    @ApiOperation(value="修改用户姓名", notes="修改某个用户姓名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户手机号", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "name", value = "用户姓名", required = true, paramType = "String")
    })
    @RequestMapping(value = "/names", method = RequestMethod.PUT)
    @ResponseBody
    public int name(@RequestParam Long id, @RequestParam String name) {
        //userService =new userServiceImpl();
        int userName = userService.updateName(id, name);
        return userName;
    }

    @ApiOperation(value="上传用户头像", notes="修改某个用户头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户手机号", required = true, paramType = "Long"),
            @ApiImplicitParam(name = "url", value = "用户头像", required = true, paramType = "String")
    })
    @RequestMapping(value = "/portraits", method = RequestMethod.PUT)
    @ResponseBody
    public int portrait(@RequestParam Long id, @RequestParam String url) {
        //userService =new userServiceImpl();
        int portrait = userService.updatePortrait(id, url);
        return portrait;
    }

    @ApiOperation(value="管理员查看用户信息", notes="查看用户信息")
    @RequestMapping(value = "/userlists", method = RequestMethod.GET)
    @ResponseBody
    public List<User> userList () {
        //userService =new userServiceImpl();
       List<User> user = userService.select();
        return user;
    }


}
