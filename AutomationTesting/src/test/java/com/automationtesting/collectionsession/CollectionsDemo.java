package com.automationtesting.collectionsession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsDemo {
	
	
	public static void main(String[] args) {
		
		//list and set
		
		List<String> fruits= new ArrayList<String>();
		
		fruits.add("Apple");
		fruits.add("Mango");
		fruits.add("Kiwi");
		fruits.add("Apple");
		
		System.out.println(fruits);
		
		//OP: [Apple, Mango, Kiwi, Apple]
		
		// Here in arraylist or list duplicates are allowed and insertion order is preserved
		
		
		
		Set<String> fruts= new HashSet<String>();
		
		fruts.add("Apple");
		fruts.add("Mango");
		fruts.add("Kiwi");
		fruts.add("Apple");
		fruts.add("Banana");
		
		System.out.println(fruts);
		
		
		//OP: [Apple, Kiwi, Mango]
		
		//here hashset or set won't allows duplicate and insertion order is not preserved		
	}

}
