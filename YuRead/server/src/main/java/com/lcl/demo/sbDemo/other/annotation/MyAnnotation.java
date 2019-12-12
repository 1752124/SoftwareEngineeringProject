package com.lcl.demo.sbDemo.other.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {
	/**操作*/
	String operate();
	/**是否存入数据库*/
	boolean isSave() default true;
}
