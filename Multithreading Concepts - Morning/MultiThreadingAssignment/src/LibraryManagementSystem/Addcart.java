package LibraryManagementSystem;

public class Addcart implements Runnable{
	
	
	private Student student;
	private BookServices queue;
	private Book book;
	
	

	public Addcart(Student student, BookServices queue, Book book) {
		super();
		this.student = student;
		this.queue = queue;
		this.book = book;
	}



	@Override
	public void run() {
		try {
			queue.addToCart(student, book);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
	}

}
