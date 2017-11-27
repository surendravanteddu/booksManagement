package com.booksManagement.util;

import java.sql.SQLException;
import java.util.List;

import com.booksManagement.entity.BookEntity;
import com.booksManagement.entity.UserBooks;

public interface UserBooksUtil {

	public List<BookEntity> getBooks(String email) throws SQLException;
	public boolean addBook(BookEntity book);
	public boolean addNote(UserBooks userbooks, String email);
}
