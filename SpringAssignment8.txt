8.Write a Program For InitializingBean and DisposableBean

Person.java

package com.java.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
 
public class Person implements DisposableBean, InitializingBean {
 
    private String name;
 
    Person() {
        System.out.println("Constructor of person bean is invoked!");
    }
 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    //Bean initialization code
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing method of person bean is invoked!");
    }
 
    //Bean destruction code
    public void destroy() throws Exception {
        System.out.println("Destroy method of person bean is invoked!");
    }
}

-------------------------------------------------------------------------------------------
Test.java

package com.java.bean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext   context = new ClassPathXmlApplicationContext("com/java/bean/bean.xml");
		 
        Person myperson = context.getBean("personBean", Person.class);
 
        System.out.println("Name= " + myperson.getName());
 
        // Closing the context object.
        context.close();
    }
}


Bean.xml

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
    
    
    
    
    <bean name="personBean" class="com.java.bean.Person">
        <property name="name" value="Tom" />
    </bean>
    
    
 </beans>


