
Main.java

package com.java.org;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Configuration
@PropertySource("classpath:app.properties")
@SpringBootConfiguration
public class Main {

	public static void main(String[] args) {
		
		

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		
		
		Service s= (Service)context.getBean("service");
		
		s.Show();
		
	
		

	}

}

Service.java

package com.java.org;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Service {
	
	
	@Value("${classurl}")
	private String url;
	
	@Value("${classusername}")
	private String username;
	
	@Value("${classpassword}")
	private String pass;
	
	
	
public void Show()
{
	System.out.println("url ="+url+", Username= " +username+ " ,Passoword= "+pass);
	
}
	

}

