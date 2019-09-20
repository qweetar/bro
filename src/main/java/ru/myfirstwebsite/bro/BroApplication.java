package ru.myfirstwebsite.bro;

import io.sentry.Sentry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BroApplication {

	public static void main(String[] args) {
    Sentry.capture("Application started");
		SpringApplication.run(BroApplication.class, args);
	}

}
