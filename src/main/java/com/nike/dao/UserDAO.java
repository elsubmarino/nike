package com.nike.dao;

import com.nike.dto.User;

public interface UserDAO {
	public void insert(User dto);
	public void delete(String username);
	public User getOne(String username);
	public void update(User user);

}
