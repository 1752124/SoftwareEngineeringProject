package com.lcl.demo.sbDemo.other.annotation;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
@Aspect
public class MyAspect {

	@Pointcut("@annotation(com.lcl.demo.sbDemo.other.annotation.MyAnnotation)")
	public void myAspect(){}
	
	@Before("myAspect()")
	public void doBeforeMyAspect(JoinPoint joinPoint){
		
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String[]> paraMap = request.getParameterMap();
        //根据joinPoint获取方法上的注入值
        String operate = getControllerOperate(joinPoint);
        boolean isSave = getControllerIsSave(joinPoint);
        //根据request获取请求中的参数值
        String name = paraMap.get("name")!=null?paraMap.get("name")[0]:"游客";
    	String record = "[姓名]:"+name + " [操作]："+operate + " [存储]："+isSave;
    	System.err.println("执行记录=："+record);
    	//根据isSave决定是否存入数据库。
	}
	
	 /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerOperate(JoinPoint joinPoint) {
    	String operate = "";
    	try {
    		String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class<?> targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class<?>[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                    	operate = method.getAnnotation(MyAnnotation. class).operate();
                         break;
                    }
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return operate;
    }
    
    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static boolean getControllerIsSave(JoinPoint joinPoint) {
    	boolean isSave = false;
    	try {
    		String targetName = joinPoint.getTarget().getClass().getName();
    		String methodName = joinPoint.getSignature().getName();
    		Object[] arguments = joinPoint.getArgs();
    		Class<?> targetClass = Class.forName(targetName);
    		Method[] methods = targetClass.getMethods();
    		for (Method method : methods) {
    			if (method.getName().equals(methodName)) {
    				Class<?>[] clazzs = method.getParameterTypes();
    				if (clazzs.length == arguments.length) {
    					isSave = method.getAnnotation(MyAnnotation. class).isSave();
    					break;
    				}
    			}
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSave;
    }
}
