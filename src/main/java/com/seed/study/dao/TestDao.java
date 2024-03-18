package com.seed.study.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	@Autowired
	private SqlSession session;
	private static String namespace = "com.seed.study.TestMapper.";

	public Date now() throws Exception {
		return session.selectOne(namespace + "now");
	}

	public int count() {
		return session.selectOne(namespace + "count");
	}
}