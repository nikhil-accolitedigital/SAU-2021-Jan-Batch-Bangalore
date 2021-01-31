package com.spring.au.MockitoAssignment;

public class ClassA {
	
	public ClassB ob1;
	
	private String firstName="Nikhil";
	
	private String lastName = "Shrivastava"; 
	
	
	
	public String getfirstName()
	{
		return firstName;
	}
	
	public String getlastName()
	{
		return lastName;
	}
	
	public void showArray(ClassB ob1) {
		System.out.println(ob1.getArray());
		
	}
	
	public void showName(ClassB ob1) {
		System.out.println(ob1.getName());
	}

	public int getSum(ClassB ob2){
		int sum = 0;
		int[] arr = ob2.getArray();
		for(int i=0;i<5;i++) {
			sum+=arr[i];
		}
		
		return sum;
		
	}
	
	
	
	


}
