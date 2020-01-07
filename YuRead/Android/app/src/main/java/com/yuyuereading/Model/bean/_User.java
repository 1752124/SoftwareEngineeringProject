package com.yuyuereading.model.bean;

import android.graphics.Bitmap;

import cn.bmob.v3.BmobUser;


public class _User extends BmobUser {
    private Bitmap portrait;
    private String name;
    public Bitmap getPortrait(){
        return portrait;
    }
    public String getName(){
        return name;
    }
    public void setPortrait(Bitmap image){
        portrait=image;
    }
    public void setName(String username){
        name=username;
    }
//    username: 用户的用户名（必需）。
//    password: 用户的密码（必需）。
//    email: 用户的电子邮件地址（可选）。
//    emailVerified:邮箱认证状态（可选）。
//    mobilePhoneNumber：手机号码（可选）。
//    mobilePhoneNumberVerified：手机号码的认证状态（可选）


}
