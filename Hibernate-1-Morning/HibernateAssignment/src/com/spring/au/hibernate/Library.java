package com.spring.au.hibernate;

public class Library {
	
	private int id;
	private String BookName;
	private String AuthorName;
	private int PublishedYear;
	private int price;
	
	public Library() {
		
	}
	
	public Library(String bookName, String authorName, int publishedYear, int price) {
		super();
		this.BookName = bookName;
		this.AuthorName = authorName;
		this.PublishedYear = publishedYear;
		this.price = price;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	public int getPublishedYear() {
		return PublishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		PublishedYear = publishedYear;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}