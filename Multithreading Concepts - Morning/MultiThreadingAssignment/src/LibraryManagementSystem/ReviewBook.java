package LibraryManagementSystem;

import java.util.ArrayList;

public class ReviewBook implements Runnable {
	
	private BookServices queue;
	private Student student;
	private ArrayList<Book> books;
	private Book book;
	
	

	public ReviewBook(BookServices queue, Student student, ArrayList<Book> books, Book book) {
		super();
		this.queue = queue;
		this.student = student;
		this.books = books;
		this.book = book;
	}



	@Override
	public void run() {
		try {
			queue.review(student,book);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(books.size() > 0) {
			try {
				Thread.sleep(5000); // for  minutes delay for each student
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(Book b: books) {
				try {
					if(b.getBookId()== book.getBookId())
						queue.removeFromCart(student,book);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
		
	}

}
