package com.nike.dao;

import java.util.List;

import com.nike.dto.Color;
import com.nike.dto.Wish;

public interface WishDAO {
	public void insert(Wish dto);

	public void delete(int num);

	public List<Wish> getList(String username);

	
	public int getTotalCount(String username);
}
