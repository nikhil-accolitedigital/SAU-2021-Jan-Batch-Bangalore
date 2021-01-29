package LibraryManagementSystem;

import java.util.ArrayList;
import LibraryManagementSystem.Book;

public class Library {
	
	 public static ArrayList<Book> booksList = new ArrayList<>();
	 public static ArrayList<Student> studentsList = new ArrayList<>();
	


	public ArrayList<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(ArrayList<Book> booksList) {
		this.booksList = booksList;
	}

	public ArrayList<Student> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(ArrayList<Student> studentsList) {
		this.studentsList = studentsList;
	}
	
	
	
	
	
private static void addBooks(BookServices queue) {
		
		Integer[] bookId = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 };
		Integer[] ISBN = {12,14,34,26,45,32,63,52,43,61,67,81,94,13,20};
		String[]  bookName= {"Book-1","Book-2","Book-3","Book-4","Book-5","Book-6","Book-7","Book-8","Book-9","Book-10","Book-11","Book-12","Book-13","Book-14","Book-15"};
		Boolean[] addToCart = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
		Boolean[] isCheckedout = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};		
		Boolean[] underReview = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}; 
		String[] reviewUser = {"","","","","","","","","","","","","","","",""};
		
		
		
		
		Thread initializeBooks = new Thread(new AddingBooks(bookId,bookName,ISBN,addToCart,isCheckedout,underReview,reviewUser,queue));
		initializeBooks.start();
		
		for(int i=0;i<15;i++) {
			
			Book b = new Book(bookId[i] , bookName[i], ISBN[i], addToCart[i], isCheckedout[i], underReview[i],reviewUser[i]);
			booksList.add(b);
		}
	}
	 
	public static void main(String[] args) {
		Integer[] id = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 };
		
		
		String[] name = {"Ajay","Rohit","Rahul","Mohit","Sohan","Shivam","Saran","Abhi","Dinesh","Tarun","Manoj","Vishal","Vivek","Ashish","Rohan"};
	
		
		for(int i=0;i<15;i++)
		{
			studentsList.add(new Student(id[i],name[i]));
		}
			
			BookServices queue = new BookServices();
			addBooks(queue);
			
			
			System.out.println("---------Student Details------------");
			for(Student s : studentsList) {
				s.getdetails();
			}
			
			System.out.println("----------Book Details------------");
			for(Book b : booksList) {
				b.getdetails();
			}
			
			
			Thread t1 = new Thread(new ReviewBook(queue,studentsList.get(1),booksList,booksList.get(5)));
			t1.start();
			
			Thread t2 = new Thread(new Addcart(studentsList.get(4),queue,booksList.get(14)));
			t2.start();
			
			Thread t3 = new Thread(new DeleteCart(studentsList.get(9),queue,booksList.get(6)));
			t3.start();
			
			Thread t4 = new Thread(new OrderBook(queue,studentsList.get(8),booksList.get(13)));
			t4.start();
			
		}
		
		
	
	 
	
	

}
