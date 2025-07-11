package org.mbc.board.models.board.service;

import java.util.List;

import org.mbc.board.models.board.domain.CreateBoardVO;
import org.mbc.board.models.board.domain.GetBoardDetailVO;
import org.mbc.board.models.board.domain.GetBoardListVO;
import org.mbc.board.models.board.domain.UpdateBoardVO;

public interface IBoardService {

	List<GetBoardListVO> getBoardList();

	GetBoardDetailVO getBoardDetail(Long id);

	List<GetBoardListVO> findAll();

	int post(CreateBoardVO dto);
	int postGetKey(CreateBoardVO dto);

	int update(UpdateBoardVO dto);

	int delete(Long id);

	int increaseViewCount(Long id);

}
