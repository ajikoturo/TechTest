package com.project.TechnicalTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TechnicalTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalTestApplication.class, args);

		// ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		TestRunner obj = (TestRunner) context.getBean("testRunner");
		obj.getMessage();

		context.close();
	}

}
