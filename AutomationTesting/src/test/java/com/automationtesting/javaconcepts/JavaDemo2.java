package com.automationtesting.javaconcepts;

public class JavaDemo2 {

	public static void subtraction() {

		int a = 1000;
		int b = 547;
		int c = a - b;
		System.out.println("Subtraction of two numbers is " + c);
	} // above method is static so memory allocated no need to create

	// here we are performing sub operation, every time you are changing values in
	// the method body or logic area
	// As per java won't recommend every time changing values at method level for
	// that we are creating re-usable
	// method

	public static void subraction_Test(int a, int b) {  

		int c = a - b;
		System.out.println("Value of two numbers  subtration is :: " + c);

	}
	
	public static void addition_Test(int a, int b) {  

		int c = a + b;
		System.out.println("Value of two numbers  addition is :: " + c);

	}

	public static void main(String[] args) {
		subtraction();
		subraction_Test(29902, 2564);
	    addition_Test(12233, 25465);
	}

}
