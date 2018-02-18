package io.egen.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
//@Profile("prod")
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Starter of spring-boot app. Entry point
		//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		SpringApplication.run(Application.class, args);

	}

}
