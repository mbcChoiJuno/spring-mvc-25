package org.mbc.board.models.board.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mbc.board.models.board.domain.CreateBoardVO;
import org.mbc.board.models.board.domain.UpdateBoardVO;
import org.mbc.board.models.board.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	BoardServiceImpl boardServiceImpl;
	
	@Test
	public void findAllTest() {
		log.info("BoardMapperTests.java findAllTest() in.......");
		
		boardServiceImpl.findAll().forEach(board -> {
			log.info(board);
		});
	}

	@Test
	public void insertTest() {
		log.info("BoardMapperTests.java insertTest() in.......");
		
		var board = new CreateBoardVO();
		board.setTitle("insertTest1");
		board.setContent("insertTest Content1");
		board.setWriter("junotest");
		
		boardServiceImpl.post(board);
		
		log.info(board);
		
		findAllTest();
	}

	@Test
	public void insertSelectKeyTest() {
		log.info("BoardMapperTests.java insertSelectKeyTest() in.......");

		var board = new CreateBoardVO();
		board.setTitle("insertTest1");
		board.setContent("insertTest Content1");
		board.setWriter("junotest");
		
		boardServiceImpl.postGetKey(board);
		
		log.info(board);
		log.info(board.getBoardIndex());

		findAllTest();
	}

	@Test
	@Transactional
	public void findByIdTest() {
		log.info("BoardMapperTests.java findByIdTest() in.......");
		
		long boardIndex = 1L;
		
		boardServiceImpl.increaseViewCount(boardIndex);
		var board = boardServiceImpl.getBoardDetail(boardIndex);

		log.info(board);
	}
	
	@Test
	public void deleteTest() {
		int count = boardServiceImpl.delete(39L);
		log.info("삭제됨. " + count);
	}
	
	@Test
	public void updateTest() {
		var board = new UpdateBoardVO();
		board.setBoardIndex(5L);
		board.setTitle("수정된 게시글 5");
		board.setContent("수정된 내용 5");
		
		int count = boardServiceImpl.update(board);
		log.info("수정됨. " + count);
	}
	
}
