package com.spring.au.JunitAssignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitAssignmentApplicationTests {

	@Test
	public void check1() {
		leapYear leap = new leapYear();
        boolean res = leap.isLeapYear(2000);
        assertEquals(true, res);
	}
	
	@Test
	public void check2() {
		leapYear leap = new leapYear();
        boolean res = leap.isLeapYear(2020);
        assertEquals(true, res);
	}
	
	@Test
	public void check3() {
		leapYear leap = new leapYear();
        boolean res = leap.isLeapYear(2018);
        assertEquals(false, res);
	}
	
	@Test
	public void check4() {
		leapYear leap = new leapYear();
        boolean res = leap.isLeapYear(2004);
        assertEquals(true, res);
	}
	
	
	@Test
	public void check5() {
		leapYear leap = new leapYear();
        boolean res = leap.isLeapYear(2006);
        assertEquals(false, res);
	}
	
	@Test
	public void check6() {
		leapYear leap = new leapYear();
        boolean res = leap.isLeapYear(-1526);
        assertEquals(false, res);
	}

}
