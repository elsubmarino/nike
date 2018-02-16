package com.nike.dao;

import java.util.List;

import com.nike.dto.Cart;
import com.nike.dto.Color;

public interface CartDAO {
	public void insert(Cart dto);

	public void delete(int num);

	public List<Cart> getList(String username);

	
	public int getTotalCount(String username);
}
