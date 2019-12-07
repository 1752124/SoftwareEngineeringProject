package com.lcl.demo.sbDemo.dao;

public class UserMapperProvider {

	public String  getDatas(String name){
		String sql =  "SELECT id,name,age FROM users where 1 = 1 ";
		if(name !=null && name.length() > 0 ){
			sql += "and name like CONCAT ('%', #{name}, '%')  "  ;
		}
		return sql;
	}

}
