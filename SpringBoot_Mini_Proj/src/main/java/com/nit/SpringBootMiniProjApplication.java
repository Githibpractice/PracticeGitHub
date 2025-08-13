package com.nit;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.controller.EmployeeDegnController;
import com.nit.model.Employee;

@SpringBootApplication
public class SpringBootMiniProjApplication {

    private final EmployeeDegnController employeeDegnController;

    SpringBootMiniProjApplication(EmployeeDegnController employeeDegnController) {
        this.employeeDegnController = employeeDegnController;
    }

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootMiniProjApplication.class, args);Scanner sc = new Scanner(System.in)){
			
			EmployeeDegnController eD = ctx.getBean(EmployeeDegnController.class);
			System.out.println("Enter the Designation1: ");
			String deg1 = sc.nextLine();
			System.out.println("Enter the Designation2: ");
			String deg2 = sc.nextLine();
			System.out.println("Enter the Designation3: ");
			String deg3 = sc.nextLine();
			List<Employee> emp = eD.DesgnControl(deg1, deg2, deg3);
			emp.forEach(System.out::println);
			System.out.println("Enter the Employee Name: ");
			String eName = sc.nextLine();
			System.out.println("Enter the Employee Designation: ");
			String deg = sc.nextLine();
			System.out.println("Enter the Employee Sal: ");
			Double sal = sc.nextDouble();
			
			Employee emp1 = new Employee(eName,deg,sal);
			eD.insert(emp1);
			
			//modification in main.java
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
