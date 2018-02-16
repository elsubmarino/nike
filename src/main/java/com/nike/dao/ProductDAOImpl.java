package com.nike.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nike.dto.Product;
import com.nike.vo.Criteria;

@Repository
public class ProductDAOImpl implements ProductDAO {
	private final String namespace = "ProductDAO";

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(Product dto) {
		sqlSession.insert(namespace + ".insert");

	}

	@Override
	public void delete(int num) {
		sqlSession.delete(namespace + ".delete", num);

	}

	@Override
	public List<Object> getProductDetails(int num) {
		return sqlSession.selectList(namespace + ".getProductDetails", num);
	}

	@Override
	public List<Object> getList(Criteria cri) {
		return sqlSession.selectList(namespace + ".getList", cri);
	}

	@Override
	public void update(Product dto) {
		sqlSession.update(namespace + ".update", dto);

	}

	@Override
	public int getTotalCount(Criteria cri) {
		return sqlSession.selectOne(namespace + ".getTotalCount", cri);

	}

}
