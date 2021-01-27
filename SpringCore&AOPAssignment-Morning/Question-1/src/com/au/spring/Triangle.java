package com.au.spring;

import java.util.Map;
import java.util.Set;

public class Triangle {
	
	private Set<Point> points; 
	
	private Map<Point,String> isAt;
	


	public Set<Point> getPoints() {
		return points;
	}



	public void setPoints(Set<Point> points) {
		this.points = points;
	}


	public Map<Point, String> getIsAt() {
		return isAt;
	}



	public void setIsAt(Map<Point, String> isAt) {
		this.isAt = isAt;
	}




	public void draw() {
		
		for(Point point:points) {
			System.out.println("Point "+isAt.get(point)+" is At ("+point.getX()+","+point.getY()+")");
		}
	}

}
