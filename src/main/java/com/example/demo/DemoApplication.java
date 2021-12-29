package com.example.demo;

import com.example.demo.services.HttpService;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//Run Application Server
//		SpringApplication.run(DemoApplication.class, args);

		String url = "http://10.62.25.70/awdServer/awd/services/v1/users";
		System.out.println(HttpService.GETRequest(url));
	}


}
