package com.jdc.assignment.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.GenericXmlApplicationContext;

@WebListener
public class SpringContainerManagement implements ServletContextListener {

	private GenericXmlApplicationContext springContext;
	public static final String SPRING_CONFI = "springContext";

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Start");
		// add IoC container to application scope
		springContext = new GenericXmlApplicationContext("classpath:application.xml");
		sce.getServletContext().setAttribute(SPRING_CONFI, springContext);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Stop");
		if (springContext != null) {
			springContext.close();
		}
	}

}
