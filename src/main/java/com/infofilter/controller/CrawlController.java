package com.infofilter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/crawl")
public class CrawlController {
	
	@RequestMapping("/start")
	public ModelAndView start() {
	    
		ModelAndView mav = new ModelAndView("start");  
        //将参数返回给页面  
        mav.addObject("age",11);  
        mav.addObject("name", "kkk");  
        return mav;  
	}
}
