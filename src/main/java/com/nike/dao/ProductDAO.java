package com.nike.dao;

import java.util.List;

import com.nike.dto.Product;
import com.nike.vo.Criteria;

public interface ProductDAO {
	public void insert(Product dto);
	public void delete(int num);
	public List<Object> getProductDetails(int num);
	public List<Object> getList(Criteria cri);
	public void update(Product dto);
	public int getTotalCount(Criteria cri);


}
