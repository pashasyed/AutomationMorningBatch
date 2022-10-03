package com.automationtesting.testngconcepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRMAnnotationConcept {

	// req is to test organe hrm application with muliple user creation on every
	// login

	@BeforeTest  // This command will excute first
	public void launchbrowser() {
		System.out.println("Launching browser");
	}

	@BeforeClass // This command will execute after test execution
	public void launchur() {
		System.out.println("Launching url");

	}

	@BeforeMethod
	public void login() {
		System.out.println("Login");
	}

	@Test (priority = 2, enabled= false)
	public void addEmployee() {
		System.out.println("Add employeee");
	}

	@Test (priority = 1)
	public void deleteEmp() {

		System.out.println("Delete Employee");
	}

	@AfterMethod
	public void logout() {
		System.out.println("Log-out");
	}

	
	@AfterClass
	public void tearDown() {
		System.out.println("Close Browser");
	}
	
	@AfterTest
	public void produceReport() {
		System.out.println("Produce Report");
	}

}
