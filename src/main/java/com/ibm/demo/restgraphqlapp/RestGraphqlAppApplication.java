package com.ibm.demo.restgraphqlapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

@SpringBootApplication
public class RestGraphqlAppApplication {

	static {
		File file = new File("./stdout.log");
		PrintStream stream = null;
		try {
			stream = new PrintStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.setOut(stream);
	}
	public static void main(String[] args) {
		SpringApplication.run(RestGraphqlAppApplication.class, args);
	}

}
