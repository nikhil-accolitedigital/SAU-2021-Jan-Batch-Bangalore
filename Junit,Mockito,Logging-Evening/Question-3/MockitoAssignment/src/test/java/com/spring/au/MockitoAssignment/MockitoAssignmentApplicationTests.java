package com.spring.au.MockitoAssignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MockitoAssignmentApplicationTests {
	
	ClassA ob1 = new ClassA();
	ClassB ob2 = new ClassB();

	@Test
	public void get_Sum() {
		System.out.println("<-----------Get Sum--------->");
		ClassB ob2 = mock(ClassB.class);
		int[] arr = {1,2,3,4,5};
		when(ob2.getArray()).thenReturn(arr);
		int sum = ob1.getSum(ob2);
		//System.out.println(sum);
		assertEquals(15,sum );
		
	}
	
	@Test
	public void getUpperCase() {
		
		System.out.println("<------Upper Case---------->");
		ClassA ob1 = mock(ClassA.class);
		when(ob1.getfirstName()).thenReturn("NIKHIL");
		String res= ob1.getfirstName().toUpperCase();
		assertEquals("NIKHIL", res);
	}
	
	
	@Test
	public void getLowerCase() {
		
		System.out.println("<------Lower Case---------->");
		ClassA ob1 = mock(ClassA.class);
		when(ob1.getfirstName()).thenReturn("nikhil");
		String res= ob1.getfirstName().toLowerCase();
		assertEquals("nikhil", res);
	}

}
