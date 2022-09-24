package com.automationtesting.javaconcepts;

public class JavaDemo {

	// [accessmodifer][returntype][methodname](){
	// business logic of the method}

	public void addition() {
		int a = 1234;
		int b = 1000;
		int c = a + b;
		System.out.println("Addition of two numbers is ::"+c);

	} // this method is non static so memeroy not allocated, we need 
	 // allcoate memeory with object creation
	
	public static void main(String[] args) {
		
		JavaDemo demo= new JavaDemo();
		demo.addition();
		
	}

}
