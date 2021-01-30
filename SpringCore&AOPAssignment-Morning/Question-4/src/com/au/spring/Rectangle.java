package com.au.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value="prototype")
public class Rectangle {
	
	@Autowired
	@Qualifier("P1")
	private Point P1;
	
	@Autowired
	@Qualifier("P2")
	private Point P2;
	
	@Autowired
	@Qualifier("P3")
	private Point P3;
	
	@Autowired
	@Qualifier("P4")
	private Point P4;
	
	public Point getP1() {
		return P1;
	}

	public void setP1(Point p1) {
		P1 = p1;
	}

	public Point getP2() {
		return P2;
	}

	public void setP2(Point p2) {
		P2 = p2;
	}

	public Point getP3() {
		return P3;
	}

	public void setP3(Point p3) {
		P3 = p3;
	}

	public Point getP4() {
		return P4;
	}

	public void setP4(Point p4) {
		P4 = p4;
	}

	
	public void draw() {
		System.out.println("--------Rectangle Class Executing-------");
		System.out.println("P1 have " + getP1().getX() + " as x-axis and " + getP1().getY() + " as y-axis");
		System.out.println("P2 have " + getP2().getX() + " as x-axis and " + getP2().getY() + " as y-axis");
		System.out.println("P3 have " + getP3().getX() + " as x-axis and " + getP3().getY() + " as y-axis");
		System.out.println("P4 have " + getP4().getX() + " as x-axis and " + getP4().getY() + " as y-axis");
		System.out.println();
	}
	

}
