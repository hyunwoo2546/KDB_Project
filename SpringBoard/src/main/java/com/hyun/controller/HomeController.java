package com.hyun.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/* # ȸ������ ������ GET ���� */
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public void join() {
	}
	
	/* # �̸��� ���� */
	@ResponseBody
	@RequestMapping(value = "/emailAuth", method = RequestMethod.POST)
	public String emailAuth(String email) {		
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		/* �̸��� ������ */
        String setFrom = "�ڽ��� �̸����� �Է����ּ���";
        String toMail = email;
        String title = "ȸ������ ���� �̸��� �Դϴ�.";
        String content = 
                "Ȩ�������� �湮���ּż� �����մϴ�." +
                "<br><br>" + 
                "���� ��ȣ�� " + checkNum + "�Դϴ�." + 
                "<br>" + 
                "�ش� ������ȣ�� ������ȣ Ȯ�ζ��� �����Ͽ� �ּ���.";
        
        try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return Integer.toString(checkNum);
 
	}
	
}
