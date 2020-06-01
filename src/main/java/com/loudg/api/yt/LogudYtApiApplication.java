package com.loudg.api.yt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.loudg.api.yt")
@SpringBootApplication
public class LogudYtApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogudYtApiApplication.class, args);
	}

}
