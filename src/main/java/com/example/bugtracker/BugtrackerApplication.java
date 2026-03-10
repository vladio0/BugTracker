package com.example.bugtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class BugtrackerApplication {

	public static void main(String[] args) throws Exception {
      SpringApplication.run(BugtrackerApplication.class, args);
	}

}
