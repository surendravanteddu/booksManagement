package com.booksManagement.util;

import com.booksManagement.entity.UserEntity;

public interface UserUtil {

	public String registerUser(UserEntity user);
	public boolean loginUser(String email, String password);
}
