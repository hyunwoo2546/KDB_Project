package com.hyun.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hyun.domain.BoardDTO;
import com.hyun.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	/* # 게시판 조회 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Locale locale, Model model) throws Exception{
		List<BoardDTO> list = service.list();
		model.addAttribute("list", list);
	}
	
}
