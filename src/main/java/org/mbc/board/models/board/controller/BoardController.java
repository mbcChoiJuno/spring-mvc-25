package org.mbc.board.models.board.controller;

import org.mbc.board.models.board.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/board/v1")
public class BoardController {

	@Autowired
	BoardServiceImpl boardService;
	
	@GetMapping("/boards")
	public void findAll() {
		
		
	}
}
