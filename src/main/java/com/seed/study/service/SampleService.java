package com.seed.study.service;

import java.util.List;

import com.seed.study.vo.SampleVO;
import com.seed.study.vo.SearchConditionVO;

//interface는 개발 코드와 객체가 서로 통신하는 접점 역할을 함
//개발 코드가 인터페이스의 메소드를 호출하면 인터페이스는 객체의 메소드를 호출
public interface SampleService {
// Controller에서 인자와 함께 전달된 메소드
	List<SampleVO> selectSampleList(SearchConditionVO searchVO);

}