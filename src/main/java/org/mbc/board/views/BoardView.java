package org.mbc.board.views;

import org.mbc.board.models.board.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/views/board")
@Log4j2
public class BoardView {

	@Autowired
	BoardServiceImpl boardService;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/boardListView")
	public String boardListView(Model model) {

		var boards = boardService.getBoardList();
		boards.forEach(board -> {
			log.info(board);
		});

	    model.addAttribute("list", boards);
		
		return "/board/list";
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/registBoardView")
	public String registBoardView() {
		return "/board/register";
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/modifyBoardView")
	public String modifyBoardView() {
		return "/board/modify";
	}
	
}
