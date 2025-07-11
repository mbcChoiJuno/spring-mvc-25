package org.mbc.board.models.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class GetBoardListVO {

	private Long boardIndex;
	private String title;
	private Long viewCount;
	private Date createDate;
	private Date updateDate;
	private String writer;

}
