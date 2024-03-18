package com.seed.study;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seed.study.dao.SampleDAO;
import com.seed.study.dao.TestDao;
import com.seed.study.vo.SampleVO;
import com.seed.study.vo.SearchConditionVO;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/root-context.xml")
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
//		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class DBConnectionTest {
	@Autowired
	DataSource ds;
	@Autowired
	TestDao dao;
	@Autowired
	SampleDAO sdao;

//	@Test
//	public void test1() throws Exception {
//		Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.
//		System.out.println("conn = " + conn);
//		assertTrue(conn != null);
//	}
//
	@Test
	public void test2() throws Exception {
		System.out.println("dao = " + dao);
		System.out.println("dao.now() = " + dao.now());
		assertTrue(dao.now() != null);
	}

	@Test
	public void test3() throws Exception {
		SearchConditionVO vo = new SearchConditionVO();
		vo.setSearchType("ID");
		List<SampleVO> list = sdao.selectSampleList(vo);
		System.out.println("VO LIST");
		for (SampleVO v : list) {
			System.out.println(v);
		}

		int cnt = 0;
		cnt = sdao.count();
		System.out.println(cnt);
		assertTrue(cnt != 0);
	}
}