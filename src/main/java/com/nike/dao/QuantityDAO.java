package com.nike.dao;

import java.util.List;

import com.nike.dto.Quantity;
import com.nike.dto.Size;

public interface QuantityDAO {
	public void insert(Quantity dto);
	public void delete(int num);
	public List<Size> getList(int size_num);
	public void update(Quantity dto);
	public int getTotalCount(int size_num);


}
