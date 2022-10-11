package com.automationtesting.javaconcepts;

public class child extends Parent {
	
	
	public void properties() {
		System.out.println("Villa in jublihills");
	}
	
	public static void main(String[] args) {
		child c= new child();
		
		c.assets();
		c.land();
		c.properties();
	}

}
