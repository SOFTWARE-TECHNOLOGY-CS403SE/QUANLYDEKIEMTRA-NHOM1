package com.example.thionline;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThiOnlineApplication {

	@Value("${server.port}")
	private static int PORT;

	public static void main(String[] args) {

		SpringApplication.run(ThiOnlineApplication.class, args);

		System.out.println("server running on port: " + 9090);
	}

}
