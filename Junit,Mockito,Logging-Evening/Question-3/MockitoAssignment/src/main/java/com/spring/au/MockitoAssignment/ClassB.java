package com.spring.au.MockitoAssignment;

public class ClassB {
	
	public ClassA ob1;
	
	private int[] arr = {1,2,3,4,5};
	
	private String[] name = {"Raj","Ram","Rahul", "Rohit"};
	
	
	
	
	
	public void showfirstName(ClassA ob1) {
		System.out.println(ob1.getfirstName());
	}
	
	public void showlastName(ClassA ob1) {
		System.out.println(ob1.getlastName());
		
	}
	
	public int[] getArray()
	{
		return arr;
	}
	
	public String[] getName() {
		return name;
	}

}
