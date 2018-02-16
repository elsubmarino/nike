package com.nike.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nike.dto.Color;

@Repository
public class ColorDAOImpl implements ColorDAO{
	private final String namespace="ColorDAO";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Color dto) {
		sqlSession.insert(namespace+".insert");
	}

	@Override
	public void delete(int num) {
		sqlSession.delete(namespace+".delete",num);
	}

	@Override
	public List<Color> getList(int product_num) {
		return sqlSession.selectList(namespace+".getList",product_num);
	}

	@Override
	public void update(Color dto) {
		sqlSession.update(namespace+".update",dto);
		
	}

	@Override
	public int getTotalCount(int product_num) {
		return sqlSession.selectOne(namespace+".getTotalCount",product_num);
	}

}
