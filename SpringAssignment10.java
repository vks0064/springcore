
App.java

package com.java.org;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

		Applicationclass n = (Applicationclass) context.getBean("noob");

		n.walk();

		Build a = (Build) context.getBean("pro");
		a.Slow();

	}

}
-------------------------------------------------------------------------------------------
Application.java

package com.java.org;

public class Application {

	public void go() {

		System.out.println("Groot");
	}

}
-------------------------------------------------------------------------------------------
ApplicationClass.java

package com.java.org;

public class Applicationclass {

	public void walk() {

		System.out.println("Hulk Walk");
	}

	
}
---------------------------------------------------------------------------------------------
Build.java

package com.java.org;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Build implements ApplicationContextAware {

	private ApplicationContext context;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public void Slow() {

		Application a = (Application) context.getBean("app");

		a.go();

	}

}
