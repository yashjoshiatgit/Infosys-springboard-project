package com.CommUnity.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CommUnityWebAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CommUnityWebAppApplication.class, args);
		Runtime.getRuntime().addShutdownHook(new Thread(context::close));
	}
}
