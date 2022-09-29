package com.automationtesting.testngconcepts;

import org.testng.annotations.Test;

public class OrangeHRMLoginUsingTestNGConcept {
	
	@Test
	public void launchbrowser() {
		System.out.println("Launch browser");
	}
	
	@Test
	public void launchURL() {
		System.out.println("Launch URL");
	}
	
	@Test
	public void login() {
		System.out.println("Login into application");
	}
	
	@Test
	public void sendMail() {
		System.out.println("user has to send mail");
	}
	
	@Test
	public void logout() {
		System.out.println("Logout application");
	}
	
	@Test
	public void tearDown() {
		System.out.println("Close Browser");
	}

}
