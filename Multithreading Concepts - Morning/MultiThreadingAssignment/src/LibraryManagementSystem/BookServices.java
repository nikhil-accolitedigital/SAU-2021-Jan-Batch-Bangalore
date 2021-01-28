package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookServices {
	
	private ArrayList<Book> blockingQueue = new ArrayList<>();
	private Lock lock = new ReentrantLock();
	private Condition addBookCondition = lock.newCondition();
	private Condition buyerCondition = lock.newCondition();
	private int count = 0;
	
	
	BookServices() { };
	
	public void put(Book book) throws InterruptedException {
		lock.lock();
		
		try {
			blockingQueue.add(book);
			count++;
			buyerCondition.signal();
		}
		finally {
			lock.unlock();
		}
	}
	
	public List<Book> getBooks() {
		for(Book book : blockingQueue) {
			book.getdetails();
		}
		return blockingQueue;
	}
	
	public void addToCart(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			if(student.canAddInCart(book.getBookId())) {
				for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
					if(blockingQueue.get(i).getBookId() == book.getBookId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
						blockingQueue.get(i).setAddToCart(true);
						blockingQueue.get(i).setUnderReview(false);
						blockingQueue.get(i).setReviewUser(student.getName());
						student.addBooksInCart(blockingQueue.get(i));
						student.removeUnderReview(blockingQueue.get(i));
						break;
					}
				}
				addBookCondition.signalAll();
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		finally {
			lock.unlock();
		}
	}
	
	public void removeFromCart(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			if(student.canRemoveFromCart(book.getBookId())) {
			for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
				if(blockingQueue.get(i).getBookId() == book.getBookId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
					blockingQueue.get(i).setAddToCart(false);
					blockingQueue.get(i).setReviewUser("");
					student.removeBooksInCart(blockingQueue.get(i));
					break;
				}
			}
			}
			addBookCondition.signalAll();
		} finally {
			lock.unlock();	
		}
	}
	
	public void checkout(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			while(count == 0) {
				buyerCondition.await();
			}
			
			if(student.canBuy(book.getBookId())) {
				for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
					if(blockingQueue.get(i).getBookId().equals(book.getBookId()) && blockingQueue.get(i).getISBN() == book.getISBN()) {
						blockingQueue.get(i).setIsCheckedout(true);
						blockingQueue.get(i).setAddToCart(false);
						blockingQueue.get(i).setReviewUser(student.getName());
						student.addBooksCheckedout(blockingQueue.get(i));
						student.removeBooksInCart(blockingQueue.get(i));
						blockingQueue.remove(i);
						break;
					}
				}
				addBookCondition.signalAll();
			}
		} finally {
			
		}
	}

	public void review(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			
			if(book == null)
				System.out.println("Book already purchased");
			while(count == 0)
				buyerCondition.await();
			
				for(int i = 0 ; i < blockingQueue.size() ; i++ ) {
					if(blockingQueue.get(i).getBookId() == book.getBookId() && blockingQueue.get(i).getISBN() == book.getISBN() && blockingQueue.get(i).getUnderReview()==false && blockingQueue.get(i).getAddToCart()==false && blockingQueue.get(i).getIsCheckedout()==false) {
						blockingQueue.get(i).setUnderReview(true);
						blockingQueue.get(i).setReviewUser(student.getName());
						student.addUnderReview(blockingQueue.get(i));
						break;
					}
				}
				addBookCondition.signalAll();
			
		} finally {
			lock.unlock();
		}
	}
}
