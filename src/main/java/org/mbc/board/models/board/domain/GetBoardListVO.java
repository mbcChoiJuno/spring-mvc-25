package org.mbc.board.models.board.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GetBoardListVO {
	
	private Long boardIndex;
	private String title;
	private Long viewCount;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private String writer;
	
}
