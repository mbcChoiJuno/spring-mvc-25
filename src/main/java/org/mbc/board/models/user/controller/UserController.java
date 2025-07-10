package org.mbc.board.models.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/api/account")
public class UserController {

	@GetMapping("/users")
	public void findAll() {
		log.info("UserController.java findAll() in.");
	}
}
