package com.booksManagement.services;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.booksManagement.dao.UserBooksDao;
import com.booksManagement.dao.UserDao;
import com.booksManagement.entity.BookEntity;
import com.booksManagement.entity.ResponseToken;
import com.booksManagement.entity.UserBooks;
import com.booksManagement.entity.UserEntity;
import com.booksManagement.util.ErrorMessages;
import com.booksManagement.util.UserBooksUtil;
import com.booksManagement.util.UserUtil;

@Path("/")
public class UserService extends FilterService {

	JWTTokenService jwt = new JWTTokenService();

	@Path("register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(UserEntity user) {
		String result = "";
		int status = 400;
		ResponseToken token = new ResponseToken();
		try {
			UserUtil userdao = new UserDao();
			result = userdao.registerUser(user);
			if (result.equals("SUCCESS")) {
				status = 201;
				token.setMessage(ErrorMessages.registration_success);
				token.setToken(jwt.createJWT(user.getEmail()));
			} else if (result.contains("email_UNIQUE")) {
				token.setMessage(ErrorMessages.email_exists);
			} else {
				token.setMessage(ErrorMessages.registration_fail);
			}

		} catch (Exception ex) {
			token.setMessage(ErrorMessages.registration_fail);
		}
		return Response.status(status).entity(token).build();
	}

	@Path("login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUser(UserEntity user, @Context HttpServletResponse response) {
		int status = 400;
        ResponseToken token = new ResponseToken();
		try {
			UserUtil userdao = new UserDao();
			if (userdao.loginUser(user.getEmail(), user.getPassword())) {
				token.setMessage(ErrorMessages.login_success);
				status = 200;
				token.setToken(jwt.createJWT(user.getEmail()));
			} else {
				token.setMessage(ErrorMessages.login_fail);
			}
		} catch (Exception ex) {
			token.setMessage(ErrorMessages.login_fail);
		}
		return Response.status(status).entity(token).build();
	}

	@Path("books")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public BookEntity getBooks(@Context HttpHeaders headers) throws SQLException {
		String jwtToken = headers.getRequestHeader("x-jwt-token").get(0);
		String email = jwt.getUsernameFromToken(jwtToken);
		BookEntity b = new BookEntity();
		b.setData(new UserBooksDao().getBooks(email));
		return b;
	}
	
	@Path("savenote")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNote(UserBooks userbooks, @Context HttpHeaders headers){
		int status = 400;
        ResponseToken token = new ResponseToken();
		String jwtToken = headers.getRequestHeader("x-jwt-token").get(0);
		String email = jwt.getUsernameFromToken(jwtToken);
		UserBooksUtil ubutil= new UserBooksDao();
		if(ubutil.addNote(userbooks, email)){
			status = 200;
			token.setToken(jwt.createJWT(email));
			token.setMessage(ErrorMessages.note_update_success);
		}else{
			token.setMessage(ErrorMessages.note_update_fail);
		}
		return Response.status(status).entity(token).build();
	}
	
	
	@Path("validatetoken/{token}")
	@GET
	public String validateToken(@PathParam("token") String token){
		if(token.split("\\.").length == 3){
			return jwt.parseJWT(token) ? "valid" : "invalid";	
		}else{
			return "invalid";
		}
	}

}
