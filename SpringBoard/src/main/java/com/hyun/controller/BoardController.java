package com.hyun.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyun.domain.BoardDTO;
import com.hyun.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	/* # 게시판 조회 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) throws Exception{
		List<BoardDTO> list = service.list();
		model.addAttribute("list", list);
		
		return "/board/list";
	}
	
	@RequestMapping(value = "/regiView", method = RequestMethod.GET)
	public String regiView(Locale locale, Model model) throws Exception {
		return "/board/regi";
	}
	
	@ResponseBody
	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public String regi(Locale locale, Model model, HttpServletRequest request) throws Exception {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		
		BoardDTO dto = new BoardDTO();
		dto.setName(request.getParameter("name"));
		dto.setContent(request.getParameter("content"));
		dto.setSubject(request.getParameter("subject"));
		dto.setReg_date(format.format(date));
		
		if(service.regi(dto) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}
	
}
