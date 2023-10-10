package com.example.springapp;

import com.example.springapp.services.TaskServiceImpl;
import com.example.springapp.services.TaskServiceTestImpl;
import com.example.springapp.services.TasksService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringappApplication {
	private static boolean isTestingEnv=false;
	public static void main(String[] args) {
		if(args.length>0)
		{
			if(args[0].equals("test"))
			{
				isTestingEnv=true;
			}
		}
		SpringApplication.run(SpringappApplication.class, args);
	}

	@Bean
	public TasksService tasksService(){
		if(isTestingEnv)
		{
			System.out.println("Testing environment mock services");
			return new TaskServiceTestImpl();
		}
		else {
			System.out.println("Production environment real services");
			return new TaskServiceImpl();
		}
	}

}
