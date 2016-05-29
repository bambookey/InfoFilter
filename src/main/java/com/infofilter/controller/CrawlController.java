package com.infofilter.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.infofilter.crawl.Crawl;
import com.infofilter.model.UrlInfo;

@Controller
@RequestMapping("/crawl")
public class CrawlController {
	
	@Autowired
	Crawl crawl;
	
	@RequestMapping("/start")
	public ModelAndView start(String searchUrl) throws InterruptedException {
	    
		String startUrl = "https://www.douban.com/group/zhufang/discussion?start=0";
		if(searchUrl != null && searchUrl.trim().length() != 0) {
			startUrl = searchUrl;
		}
		crawl.run(startUrl);
		List <UrlInfo> urlList = Crawl.urlInfoList;
		ModelAndView mav = new ModelAndView("result");  
        //将参数返回给页面  
        mav.addObject("urlList", urlList); 
        return mav;  
	}
}
