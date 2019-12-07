package com.lcl.demo.sbDemo.other.util;

import java.io.File;

public class PathUtil {
	
	public static String getPath(){
		String filePath = System.getProperty("java.class.path");
		String pathSplit = System.getProperty("path.separator");//windows下是";",linux下是":"
		
		if(filePath.contains(pathSplit)){
			filePath = filePath.substring(0,filePath.indexOf(pathSplit));
		}else if (filePath.endsWith(".jar")) {//截取路径中的jar包名,可执行jar包运行的结果里包含".jar"
			filePath = filePath.substring(0, filePath.lastIndexOf(File.separator) + 1);
		}
		return filePath;
	}

}
