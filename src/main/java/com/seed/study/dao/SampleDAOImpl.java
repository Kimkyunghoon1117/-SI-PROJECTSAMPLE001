package com.seed.study.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seed.study.vo.SampleVO;
import com.seed.study.vo.SearchConditionVO;

//DAO를 인식시켜주기 위한 설정
@Repository("sampleDao")
public class SampleDAOImpl implements SampleDAO {

// mybatis를 사용하기 위한 객체 선언
	@Autowired
	private SqlSessionTemplate mybatis;

// mybatis.속성("[mapper namespace].[select id]",[정보를 주고 받을 VO])
	@Override
	public List<SampleVO> selectSampleList(SearchConditionVO searchVO) {
		// select를 위한 mybatis의 selectList 속성을 사용하여 mapper의 sql문을 실행시킨 후 값을 되받고
		// Controller에 주기 위한 return 작업
		System.out.println("DAO-searchVO:" + searchVO.getSearchType());
		System.out.println("DAO-searchVO:" + searchVO.getKeyword());
		List<SampleVO> list = mybatis.selectList("SampleMapper.selectSampleList", searchVO);
		System.out.println("VO LIST");
		for (SampleVO vo : list) {
			System.out.println(vo);
		}
		// return mybatis.selectList("SampleMapper.selectSampleList", searchVO);
		return list;
	}

	public int count() {
		return mybatis.selectOne("SampleMapper.count");
	}

}