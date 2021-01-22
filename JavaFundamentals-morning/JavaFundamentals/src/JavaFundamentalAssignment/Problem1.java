package JavaFundamentalAssignment;

import java.util.ArrayList;
import java.util.Collections;



public class Problem1 {

	public static void main(String[] args) {
		ArrayList<Integer> arr= new ArrayList<Integer>();
		arr.add(3);
		arr.add(1);
		arr.add(4);
		arr.add(2);
		arr.add(5);
		
		System.out.println("Unsorted Numbers in List "+arr);
		
		Collections.sort(arr);
		
		System.out.println("Sort Numbers in List "+arr);
		
	}

}
