package com.nike.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nike.dto.Wish;

@Repository
public class WishDAOImpl implements WishDAO{
	private final String namespace="WishDAO";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Wish dto) {
		sqlSession.insert(namespace+".insert");
	}

	@Override
	public void delete(int num) {
		sqlSession.delete(namespace+".delete",num);
	}

	@Override
	public List<Wish> getList(String username) {
		return sqlSession.selectOne(namespace+".getList",username);
	}

	

	@Override
	public int getTotalCount(String username) {
		return sqlSession.selectOne(namespace+".getTotalCount",username);
	}

}
