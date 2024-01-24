package com.example.newdemo;

import com.example.newdemo.controller.AdminController;
import com.example.newdemo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NewDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(NewDemoApplication.class, args);
		System.out.println("success!");





		//***********comment out to create new ADMIN for the App*********************
//		UserService userService = SpringApplication.run(NewDemoApplication.class, args)
//						.getBean(UserService.class);
//		AdminController.addNewAdmin("Admin",userService);
//		SpringApplication.run(NewDemoApplication.class, args).close();

		//**************************************************************************







	}

}
