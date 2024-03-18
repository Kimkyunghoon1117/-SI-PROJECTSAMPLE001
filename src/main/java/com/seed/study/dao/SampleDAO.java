package com.seed.study.dao;

import java.util.List;

import com.seed.study.vo.SampleVO;
import com.seed.study.vo.SearchConditionVO;

public interface SampleDAO {

	// ServiceImpl에서 인자와 함께 전달된 메소드
	List<SampleVO> selectSampleList(SearchConditionVO searchVO);

	int count();
}