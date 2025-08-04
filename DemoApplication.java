package com.uberLLD.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uberLLD.demo.Main;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

//		SpringApplication.run(DemoApplication.class, args);

		Main.main();
	}

}
