package com.spring.au.JunitAssignment;


import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JunitAssignmentApplication {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        leapYear leap = new leapYear();
        System.out.println("Enter the year:");
        int year = sc.nextInt();
        if (leap.isLeapYear(year)) {
            System.out.println("It's a Leap Year");
        } 
        else {
            System.out.println("It's not a Leap Year");
        }
    }
		
		
}


