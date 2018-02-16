package com.nike.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nike.dto.Review;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	private final String namespace = "ReviewDAO";

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Review dto) {
		sqlSession.insert(namespace + ".insert");

	}

	@Override
	public void delete(int num) {
		sqlSession.delete(namespace + ".delete", num);

	}

	@Override
	public List<Review> getList(int product_num) {
		return sqlSession.selectList(namespace + ".getList", product_num);
	}

	@Override
	public void update(Review dto) {
		sqlSession.update(namespace + ".update", dto);

	}

	@Override
	public int getTotalCount(int product_num) {
		return sqlSession.selectOne(namespace+".getTotalCount",product_num);

	}

	@Override
	public float getAverageRatings(int product_num) {
		return sqlSession.selectOne(namespace+".getAverageRatings",product_num);
	}

}
