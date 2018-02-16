package com.nike.dao;

import java.util.List;

import com.nike.dto.Review;

public interface ReviewDAO {
	public void insert(Review dto);
	public void delete(int num);
	public List<Review> getList(int product_num);
	public void update(Review dto);
	public int getTotalCount(int product_num);
	public float getAverageRatings(int product_num);
	

}
