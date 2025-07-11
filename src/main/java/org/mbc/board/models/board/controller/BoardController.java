package org.mbc.board.models.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.mbc.board.models.board.domain.CreateBoardVO;
import org.mbc.board.models.board.domain.UpdateBoardVO;
import org.mbc.board.models.board.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("/api/board/v1")
@Log4j2
public class BoardController {

	@Autowired
	BoardServiceImpl boardService;
	
	
	/**
	 * 게시글 목록 전체 조회
	 */
	@GetMapping("/boards") //192.168.111.104:80/mbc-board/api/board/v1/boards
	public String getBoardList(Model model) {

		var boards = boardService.getBoardList();
		boards.forEach(board -> {
			log.info(board);
		});

	    model.addAttribute("list", boards);
	    
		return "/board/list";
	}


	/**
	 * 게시글 상세 조회
	 * @param boardIndex
	 * @param model
	 */
	@GetMapping("/boards/{boardIndex}")
	@Transactional
	public String getBoardDetail(
			@PathVariable("boardIndex")
			Long boardIndex,

			Model model) {
		// 조회수 증가
		boardService.increaseViewCount(boardIndex);
		var board = boardService.getBoardDetail(boardIndex);
	    log.info(board);

	    model.addAttribute("board", board);

	    return "redirect:/views/board/get";
	}

	
	/**
	 * 게시글 등록
	 * @param board
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/boards")
	public String registBoard(@RequestBody CreateBoardVO board, RedirectAttributes redirectAttributes) {

	    if (boardService.postBoardGetKey(board) > 0)
	    	redirectAttributes.addFlashAttribute("result", board.getBoardIndex());

	    return "redirect:/board/list";
	}

	@PutMapping("/boards")
	public String updateBoard(@RequestBody UpdateBoardVO board, RedirectAttributes redirectAttributes) {

	    if (boardService.updateBoard(board) > 0)
	    	redirectAttributes.addFlashAttribute("result", "success");

	    return "redirect:/board/list";
	}

	@DeleteMapping("/boards/{boardIndex}")
	public String deleteBoard(
			@PathVariable("boardIndex")
			Long boardIndex,
			RedirectAttributes redirectAttributes) {

	    if (boardService.deleteBoard(boardIndex) > 0)
	    	redirectAttributes.addFlashAttribute("result", "success");

	    return "redirect:/board/list";
	}
}
