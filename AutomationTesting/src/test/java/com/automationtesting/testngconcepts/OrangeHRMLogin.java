package com.automationtesting.testngconcepts;

public class OrangeHRMLogin {
	
	
	public void launchbrowser() {
		System.out.println("Launch browser");
	}
	
	public void launchURL() {
		System.out.println("Launch URL");
	}
	
	public void login() {
		System.out.println("Login into application");
	}
	
	public void sendMail() {
		System.out.println("user has to send mail");
	}
	
	public void logout() {
		System.out.println("Logout application");
	}
	
	public void tearDown() {
		System.out.println("Close Browser");
	}
	
	public static void main(String[] args) {
		OrangeHRMLogin test= new OrangeHRMLogin();
		
		test.launchbrowser();
		
		test.launchURL();
		
		test.login();
		
		test.sendMail();
		
		test.logout();
		
		test.tearDown(); 
		
		// here in normal approach we need to create object explicitly and we need call by object creation
	}	
}
