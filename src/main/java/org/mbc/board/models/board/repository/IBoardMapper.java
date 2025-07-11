package org.mbc.board.models.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mbc.board.models.board.domain.GetBoardListVO;
import org.mbc.board.models.board.domain.UpdateBoardVO;
import org.mbc.board.models.board.domain.CreateBoardVO;
import org.mbc.board.models.board.domain.GetBoardDetailVO;

@Mapper
public interface IBoardMapper {
	
	public int post(CreateBoardVO board);
	public int postGetKey(CreateBoardVO board);
	
//	@Select("SELECT board_index as boardIndex, board_title as title, board_view_count as viewCount, board_create_date as createDate, board_update_date as updateDate, user_name as writer FROM board_tbl B JOIN user_tbl U ON B.user_id = U.user_id")
	public List<GetBoardListVO> findAll();
	
	public GetBoardDetailVO findById(Long boardIndex);
	
	public int delete(Long boardIndex);
	
	public int update(UpdateBoardVO board);
	
	public int increaseViewCount(Long boardIndex);
}
