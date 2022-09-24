package com.automationtesting.javaconcepts;

import java.util.HashMap;

public class JavaDemo3 {

	
	public static void main(String[] args) {
		
		HashMap<Integer, String> emplist= new HashMap<Integer, String>();
		emplist.put(101, "Ram");
		emplist.put(102, "Rahim");
		emplist.put(103, "Robert");
		
		System.out.println(emplist.get(102));// Rahim
		
		
		HashMap<String, String> credetials= new HashMap<String, String>();
		
		credetials.put("URl", "http://google.com");
		
		credetials.put("username", "admin");
		
		credetials.put("password", "admin123");
		
		
		System.out.println(credetials.get("URl"));// abvoe url
		
		System.out.println(credetials.get("password"));
		
		
		
	}
}
