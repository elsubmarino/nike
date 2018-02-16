package com.nike.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nike.dto.Quantity;
import com.nike.dto.Size;

@Repository
public class QuantityDAOImpl implements QuantityDAO {
	private final String namespace = "QuantityDAO";

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Quantity dto) {
		sqlSession.insert(namespace + ".insert");

	}

	@Override
	public void delete(int num) {
		sqlSession.delete(namespace + ".delete", num);

	}

	@Override
	public List<Size> getList(int size_num) {
		return sqlSession.selectList(namespace + ".getList", size_num);
	}

	@Override
	public void update(Quantity dto) {
		sqlSession.update(namespace + ".update", dto);

	}

	@Override
	public int getTotalCount(int size_num) {
		return sqlSession.selectOne(namespace+".getTotalCount",size_num);

	}

}
