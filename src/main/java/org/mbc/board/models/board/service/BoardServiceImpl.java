package org.mbc.board.models.board.service;

import java.util.List;

import org.mbc.board.models.board.domain.CreateBoardVO;
import org.mbc.board.models.board.domain.GetBoardDetailVO;
import org.mbc.board.models.board.domain.GetBoardListVO;
import org.mbc.board.models.board.domain.UpdateBoardVO;
import org.mbc.board.models.board.repository.IBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements IBoardService {
	
	@Autowired
	IBoardMapper boardMapper;
	
	@Override
	public List<GetBoardListVO> getBoardList() {
		return boardMapper.getBoardList();
	}

	@Override
	public GetBoardDetailVO getBoardDetail(Long id) {
		
		return boardMapper.getBoardDetail(id);
	}

	@Override
	public int postBoard(CreateBoardVO dto) {
		return boardMapper.postBoard(dto);
	}
	
	@Override
	public int postBoardGetKey(CreateBoardVO dto) {
		return boardMapper.postBoardGetKey(dto);
	}

	@Override
	public int updateBoard(UpdateBoardVO dto) {
		return boardMapper.updateBoard(dto);
	}

	@Override
	public int deleteBoard(Long id) {
		return boardMapper.deleteBoard(id);
	} 
	
	@Override
	public int increaseViewCount(Long id) {
		return boardMapper.increaseViewCount(id);
	}
}
