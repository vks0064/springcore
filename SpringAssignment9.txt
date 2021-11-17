9.Complete Bean Life Cycle

Example.java

package com.java.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Example() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Example [subject=" + subject + "]";
	}
	
	@PostConstruct
	public void start() {
		System.out.println("starting method");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("ending method");
		
	}

}
-----------------------------------------------------------------------------
Test.java

package com.java.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/java/lifecycle/bean.xml");
		
		context.registerShutdownHook();
		
		Example example=(Example) context.getBean("example");
		System.out.println(example);
		

	}

}
----------------------------------------------------------------------------------
bean.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans  
    xmlns="http://www.springframework.org/schema/beans"  
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"  
    xmlns:p="http://www.springframework.org/schema/p"  
    xsi:schemaLocation="http://www.springframework.org/schema/beans   
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">
    
    <context:annotation-config />
    
    
    <bean class="com.bean.lifecycle.Example" name="example">
         <property name="subject" value="Maths" />
    </bean>
    
    
 </beans>