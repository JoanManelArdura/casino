package com.reki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reki.services.Services;

@SpringBootApplication
public class CasinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasinoApplication.class, args);
		Player player = Services.createRandomPlayer();
	}
}
