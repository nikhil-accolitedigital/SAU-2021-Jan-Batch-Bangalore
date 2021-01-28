package LibraryManagementSystem;

public class OrderBook implements Runnable {
	
	private BookServices queue;
	private Student student;
	private Book book;
	
	
	public OrderBook(BookServices queue, Student student, Book book) {
		super();
		this.queue = queue;
		this.student = student;
		this.book = book;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			queue.checkout(student,book);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
