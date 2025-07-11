package org.mbc.board.models.board.domain;

import lombok.Data;

@Data
public class UpdateBoardVO {

	private Long boardIndex;
	private String title;
	private String content;
	private String writer;

}
