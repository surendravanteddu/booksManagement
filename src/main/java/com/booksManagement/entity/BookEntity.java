package com.booksManagement.entity;

import java.util.ArrayList;
import java.util.List;

public class BookEntity {
    
	private int bookId;
	private String bookName;
	private String author;
	private String publicationDate;
	private String shortDesc;
	private int rating;
	private String notes;
	
	private List<BookEntity> data = new ArrayList<>();
	
	public List<BookEntity> getData() {
		return data;
	}
	public void setData(List<BookEntity> data) {
		this.data = data;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public BookEntity(){
		
	}
	
	public BookEntity(String bookName, String author, String publicationDate, String shortDesc) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publicationDate = publicationDate;
		this.shortDesc = shortDesc;
	}
	public BookEntity(int bookId, String bookName, String author, String publicationDate, String shortDesc, int rating,
			String notes) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publicationDate = publicationDate;
		this.shortDesc = shortDesc;
		this.rating = rating;
		this.notes = notes;
	}
}
