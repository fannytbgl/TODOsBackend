package com.example.backApplication;

import com.example.backApplication.dto.ToDoDto;
import com.example.backApplication.enums.StatusType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

import static com.example.backApplication.enums.StatusType.TO_DO;

@SpringBootApplication
public class BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}

}
