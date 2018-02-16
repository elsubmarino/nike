package com.nike.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nike.dto.Size;

@Repository
public class SizeDAOImpl implements SizeDAO {
	private final String namespace = "SizeDAO";

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Size dto) {
		sqlSession.insert(namespace + ".insert");

	}

	@Override
	public void delete(int num) {
		sqlSession.delete(namespace + ".delete", num);

	}

	@Override
	public List<Size> getList(int product_num) {
		return sqlSession.selectList(namespace + ".getList", product_num);
	}

	@Override
	public void update(Size dto) {
		sqlSession.update(namespace + ".update", dto);

	}

	@Override
	public int getTotalCount(int product_num) {
		return sqlSession.selectOne(namespace+".getTotalCount",product_num);

	}

}
