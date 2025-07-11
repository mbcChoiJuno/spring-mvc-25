package org.mbc.board.models.board.service;

import java.util.List;

import org.mbc.board.models.board.domain.CreateBoardVO;
import org.mbc.board.models.board.domain.GetBoardDetailVO;
import org.mbc.board.models.board.domain.GetBoardListVO;
import org.mbc.board.models.board.domain.UpdateBoardVO;

public interface IBoardService {

	List<GetBoardListVO> getBoardList();

	GetBoardDetailVO getBoardDetail(Long id);

	int postBoard(CreateBoardVO dto);
	int postBoardGetKey(CreateBoardVO dto);

	int updateBoard(UpdateBoardVO dto);

	int deleteBoard(Long id);

	int increaseViewCount(Long id);

}
