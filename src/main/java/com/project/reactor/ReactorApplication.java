package com.project.reactor;

import com.project.reactor.config.CassandraSetup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactorApplication {

	public static void main(String[] args)
	{
		CassandraSetup.init();
		SpringApplication.run(ReactorApplication.class, args);
	}
}
