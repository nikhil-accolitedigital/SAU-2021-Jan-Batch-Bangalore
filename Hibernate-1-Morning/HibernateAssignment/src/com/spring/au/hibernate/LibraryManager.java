package com.spring.au.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class LibraryManager {
	
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Exception e) {
			System.err.println(e);
		}
		
		LibraryManager libraryManager = new LibraryManager();
		
		Integer bookId1 = libraryManager.addBooks("C++", "Bjarne Stroustrup",2006,200);
		System.out.println("Book is inserted :"+ bookId1.intValue());
		
		Integer bookId2 = libraryManager.addBooks("Java", "James Gosling",2007,250);
		System.out.println("Book is inserted :"+ bookId2.intValue());
		
		Integer bookId3 = libraryManager.addBooks("Python", "Guido van Rossum",2008,220);
		System.out.println("Book is inserted :"+ bookId3.intValue());
		
		Integer bookId4 = libraryManager.addBooks("Javascript", "Brendan Eich",2004,180);
		System.out.println("Book is inserted :"+ bookId4.intValue());
		
		Integer bookId5 = libraryManager.addBooks("DBMS", "Abraham Silberschatz",2002,230);
		System.out.println("Book is inserted :"+ bookId5.intValue());
		
		
		libraryManager.getBooks();
		libraryManager.updateMovieById(11);
		libraryManager.deleteBookById(1);
		libraryManager.BooksCount();
		
 
		

	}
	
	
	private Integer addBooks(String BookName, String AuthorName,int PublishedYear, int price) {
		Session session = factory.openSession();
		Transaction tx  = null;
		Integer bookId = null;
		try {
			tx = session.beginTransaction();
			Library library = new Library(BookName,AuthorName,PublishedYear,price);
			bookId = (Integer) session.save(library);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
		return bookId;
	}
	
	
	private void getBooks() {
		Session session = factory.openSession();
		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			List<Library> libraryList = session.createQuery("FROM Library").list();
			for(Library result : libraryList) {
				System.out.print(result.getId()+" ");
				System.out.print(result.getBookName()+" ");
				System.out.print(result.getAuthorName()+" ");
				System.out.print(result.getPublishedYear()+" ");
				System.out.print(result.getPrice()+" ");
				System.out.println( );
			}
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
		
	}
	
	private void updateMovieById(int i) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Library library = session.get(Library.class, i);
			
			library.setPrice(300);
			library.setPublishedYear(2015);
			System.out.println("Updated book details ");
			session.update(library);
			System.out.println(library.getId());
			System.out.println(library.getBookName());
			System.out.println(library.getAuthorName());
			System.out.println(library.getPrice());
			System.out.println(library.getPublishedYear());
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
		
	}
	
	private void deleteBookById(int i) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Library library = session.get(Library.class, i);
			System.out.println("Deleted book details ");
			System.out.println("Book Id: "+library.getId());
			System.out.println("Book Name: "+library.getBookName());
			System.out.println("Author Name: "+library.getAuthorName());
			System.out.println("Published Year: "+library.getPublishedYear());
			System.out.println("Price: "+library.getPrice());
			session.remove(library);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
		
		
	}
		
	private void BooksCount() {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            session.getTransaction();
            List<Library> books = session.createQuery("FROM Library").list();
            System.out.println("Total books: "+ books.size());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    } 
	
	
	
}
	
	


