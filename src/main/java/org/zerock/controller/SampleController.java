package org.zerock.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import com.fasterxml.jackson.databind.util.JSONPObject;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SampleController {

	
	@RequestMapping(value =  "/sample/**", method = RequestMethod.GET)
	public void basic(Locale locale, Model model) {

		model.addAttribute("serverTime", "basic");
	}

	@RequestMapping(value =  "/test/**", method = RequestMethod.GET)
	public String test1(Locale locale, Model model) {

		model.addAttribute("serverTime", "GET");
		return "home";
	}

	@RequestMapping(value =  "/test/**", method = RequestMethod.POST)
	public String test2(Locale locale, Model model) {

		model.addAttribute("serverTime", "POST");
		return "home";
	}
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		
	}
	
	@PostMapping("/basicOnlyPost")
	public void basicPost2() {
		
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		log.info(dto.toString());
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(
			@RequestParam("owner") 
			String name, 
			@RequestParam("age") 
			int age) {

		log.info("name:" + name);
		log.info("age:" + age);

		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(
			@RequestParam("ids") 
			ArrayList<String> ids) {

		log.info("list:" + ids);
		log.info("list[1]:" + ids.get(1));

		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {

		log.info("list:" + list);
		log.info("list sampleDtos:" + list.getList());

		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {

		log.info("todo:" + todo);

		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("dto:" + dto);
		log.info("page:" + page);

		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("dto:");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("ex06() in.");
		
		var dto = new SampleDTO();
		dto.setName("kkw");
		dto.setAge(33);
		
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
//		var response = new ResponseEntity<String>("{\"resCode\": 200}", HttpStatus.OK);
//		return response;

		String msg = "{\"age\": 200}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
}
