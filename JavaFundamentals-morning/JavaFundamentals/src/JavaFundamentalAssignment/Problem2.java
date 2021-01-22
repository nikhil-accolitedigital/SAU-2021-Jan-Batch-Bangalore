package JavaFundamentalAssignment;

public class Problem2 {

	public void divide(int a, int b) throws ArithmeticException{  
		
		try{
			if(b==6) {
				throw new ArithmeticException("Exception using throw");
			}
			
			else if(b==0) {
				throw new ArithmeticException("Number cannot divide by 0");
			}
			else
			{
				int t = a/b;
				System.out.println(t);
			}
		}

		catch(ArithmeticException e){
			   System.out.println("Exception caught is "+e);
			}
		
	}  
	   public static void main(String args[]){  
		   Problem2 obj = new Problem2();
		   obj.divide(12,4); // output 3
		   obj.divide(12,6); 
		   obj.divide(12,0);
		   System.out.println("Program ends here");
		   
		
		
	  }  
 
}

