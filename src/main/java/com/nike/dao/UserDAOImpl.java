package com.nike.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nike.dto.User;

@Repository
public class UserDAOImpl implements UserDAO {
	private final String namespace = "UserDAO";

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(User dto) {
		sqlSession.insert(namespace + ".insert");

	}

	@Override
	public void delete(String username) {
		sqlSession.delete(namespace + ".delete", username);

	}

	@Override
	public User getOne(String username) {
		return sqlSession.selectOne(namespace + ".getOne", username);
	}

	@Override
	public void update(User user) {
		sqlSession.update(namespace + ".update", user);
	}

}
