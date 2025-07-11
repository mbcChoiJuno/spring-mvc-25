package org.mbc.board.models.board.service;

import java.util.List;

import org.mbc.board.core.interfaces.IService;
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
		return boardMapper.findAll();
	}

	@Override
	public GetBoardDetailVO getBoardDetail(Long id) {
		
		return boardMapper.findById(id);
	}

	@Override
	public List<GetBoardListVO> findAll() {
		return boardMapper.findAll();
	}

	@Override
	public int post(CreateBoardVO dto) {
		return boardMapper.post(dto);
	}
	
	@Override
	public int postGetKey(CreateBoardVO dto) {
		return boardMapper.postGetKey(dto);
	}

	@Override
	public int update(UpdateBoardVO dto) {
		return boardMapper.update(dto);
	}

	@Override
	public int delete(Long id) {
		return boardMapper.delete(id);
	} 
	
	@Override
	public int increaseViewCount(Long id) {
		return boardMapper.increaseViewCount(id);
	}
}
