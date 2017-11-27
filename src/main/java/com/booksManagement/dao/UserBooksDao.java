package com.booksManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.booksManagement.entity.BookEntity;
import com.booksManagement.entity.UserBooks;
import com.booksManagement.util.DatabaseUtil;
import com.booksManagement.util.UserBooksUtil;

public class UserBooksDao implements UserBooksUtil {

	DatabaseUtil dao;

	public UserBooksDao() {
		dao = DatabaseDao.getInstance();
	}

	@Override
	public List<BookEntity> getBooks(String email) throws SQLException {
		Connection con = dao.getConnection();
		List<BookEntity> list = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			ps = con
					.prepareStatement("SELECT b.book_id,b.book_name,b.author,b.publication_date,b.short_desc,b.rating,u.notes "
							+ "FROM booksManagement.books b left join booksManagement.user_books u  "
							+ "on b.book_id=u.book_id and "
							+ "u.user_id = (select user_id from booksManagement.user_info where email = ?)");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			BookEntity b = new BookEntity(rs.getInt(1),rs.getString(2),rs.getString(3)
					,rs.getDate(4).toString(),rs.getString(5),rs.getInt(6),((rs.getString(7) != null) ? rs.getString(7) : "Add Note"));
			list.add(b);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally{
			ps.close();
		}
		return list;
	}

	@Override
	public boolean addBook(BookEntity book) {
		Connection con = dao.getConnection();
		boolean result = false;
		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into books (book_name, author, publication_date, short_desc) values (?,?,?,?)");
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthor());
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			Date dt = format.parse(book.getPublicationDate());
			ps.setDate(3, new java.sql.Date(dt.getTime()));
			ps.setString(4, book.getShortDesc());
			result = (ps.executeUpdate() == 1);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			dao.close(con);
		}
		return result;
	}

	@Override
	public boolean addNote(UserBooks userbooks, String email) {
		Connection con = dao.getConnection();
		boolean result = false;
		try{
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO booksManagement.user_books (book_id, user_id, notes) VALUES (?,"
					+ "(select user_id from booksManagement.user_info where email =?),?) "
					+ "ON DUPLICATE KEY UPDATE notes = VALUES(notes)");
			ps.setInt(1, userbooks.getBookId());
			ps.setString(2, email);
			ps.setString(3, userbooks.getNotes());
			int x = ps.executeUpdate();
			result = (x == 1 || x == 2);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return result;
	}

	// public static void main(String[] args) throws IOException {
	// BufferedReader br = new BufferedReader(new FileReader("books.txt"));
	// UserBooksDao userDao = new UserBooksDao();
	// String temp = "";
	// int i=1;
	// while((temp = br.readLine()) != null){
	// String book[] = temp.split(":");
	// BookEntity b = new BookEntity(book[0],book[1],book[2],book[3]);
	// if(!userDao.addBook(b)){
	// System.out.println(i + "-> Failed to load to DB");
	// }
	// i++;
	// }
	// br.close();
	// }

}
