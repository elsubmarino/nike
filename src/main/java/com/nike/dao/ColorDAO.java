package com.nike.dao;

import java.util.List;

import com.nike.dto.Color;

public interface ColorDAO {
	public void insert(Color dto);

	public void delete(int num);

	public List<Color> getList(int product_num);

	public void update(Color dto);
	
	public int getTotalCount(int product_num);
}
