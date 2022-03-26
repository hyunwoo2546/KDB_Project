package com.hyun.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyun.domain.MemberDTO;
import com.hyun.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	/* # ∆‰¿Ã¡ˆ ∏ «Œ */
    @RequestMapping(value = "/member/login", method = RequestMethod.GET)
    public void login() {
    }
	 
	@ResponseBody
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String regi(Locale locale,Model model,MemberDTO dto,HttpSession session) throws Exception {
		MemberDTO dto2 = service.login(dto);
		
		if(dto != null) {
			session.setAttribute("id", dto2.getId());
			return "Y";
		} else {
			return "N";
		}
	}
}
