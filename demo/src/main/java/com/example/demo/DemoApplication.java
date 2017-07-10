package com.example.demo;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		int maxSatisfaction=0, maxTimeEating=0, menuItems,amountOfSatisfaction,amountOfTimeInEating,selectedMenuItem=0,timeSpentInEating=0;
		String[] lineData;

		try
		{
			//Menu.txt contains data
		Scanner scanner=new Scanner(new ClassPathResource("Menu.txt").getFile());
		lineData=scanner.nextLine().split(" ");
		// Max time godmon can spare in eating in minutes passed in first line of file
		int minuts = Integer.parseInt(lineData[0]);
		// No of Total menu Items passed in first line of file
		int noOfMenuItems=Integer.parseInt(lineData[1]);
		// Dish/Menu Item Number
		int dishNum=0;
		
		while(scanner.hasNextLine())
		{
			dishNum++;
			lineData=scanner.nextLine().split(" ");
			//parsing amount of satisfaction for each dish
			amountOfSatisfaction=Integer.parseInt(lineData[0]);
			//parsing time to eat for each dish
			amountOfTimeInEating=Integer.parseInt(lineData[1]);
			
			if(amountOfTimeInEating<minuts && amountOfSatisfaction>maxSatisfaction)
			{
				maxSatisfaction=amountOfSatisfaction;
				timeSpentInEating=amountOfTimeInEating;
			}
		
		
		}
		
		System.out.println("Godmon could get "+maxSatisfaction+" satisfaction in "+timeSpentInEating+" minutes by eating dish number "+ dishNum);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
