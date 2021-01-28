package LibraryManagementSystem;

public class DeleteCart implements Runnable{
	
	private Student student;
	private BookServices queue;
	private Book book;

	public DeleteCart(Student student, BookServices queue, Book book) {
		super();
		this.student = student;
		this.queue = queue;
		this.book = book;
	}

	@Override
	public void run() {
				try {
					queue.removeFromCart(student, book);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
	}
}

