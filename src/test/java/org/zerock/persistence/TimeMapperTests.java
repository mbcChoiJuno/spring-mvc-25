package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.ITimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class TimeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ITimeMapper timeMapper;

	@Test
	public void getTimeTest() {
		// 어노테이션으로 sql 문 작성
		log.info("       name: " + timeMapper.getClass().getSimpleName());
		log.info("       time: " + timeMapper.getTime());
	}
	
	@Test
	public void getTimeTest2() {
		// xml으로 sql 문 작성
		log.info("       name: " + timeMapper.getClass().getSimpleName());
		log.info("       time: " + timeMapper.getTime2());
	}
	
	@Test
	public void getTimeTest2Log4jdbc() {
		// xml으로 sql 문 작성
		log.info("       time: " + timeMapper.getTime2());
	}
	
	
}
