package com.nike.dao;

import java.util.List;

import com.nike.dto.Size;

public interface SizeDAO {
	public void insert(Size dto);
	public void delete(int num);
	public List<Size> getList(int product_num);
	public void update(Size dto);
	public int getTotalCount(int product_num);


}
