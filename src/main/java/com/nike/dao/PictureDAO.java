package com.nike.dao;

import java.util.List;

import com.nike.dto.Picture;

public interface PictureDAO {
	public void insert(Picture dto);
	public void delete(int num);
	public List<Picture> getList(int product_num);
	public void update(Picture dto);
	public int getTotalCount(int product_num);


}
