package cn.itcast.annocation.demo01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HelloWorld {
	
	public String name() default "default name";
	
	public String value() default "default value";
}
