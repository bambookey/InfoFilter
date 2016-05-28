package com.infofilter.crawl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

@Component
public class Crawl implements PageProcessor {
	public static final String URL_LIST = "https://www.douban.com/group/zhufang/discussion";
	
    //public static final String URL_POST = "http://auto.163.com/blog/";

    private Site site = Site
            .me()
            .setDomain("douban.com")	
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    public void process(Page page) {
    	//列表页
        if (page.getUrl().regex(URL_LIST).match()) {
        	System.out.println();
        	List<Selectable> links = page.getHtml().xpath("//td[@class='title']").nodes();
        	String title = "";
        	String link = "";
        	for(Selectable s : links) {
        		title = s.xpath("//a/@title").toString();
        		link = s.xpath("//a/@href").toString();
        		if(title.contains("海淀")) {
        			System.out.println(title+":"+link);
        		}
        	}
        	
            page.addTargetRequests(page.getHtml().xpath("//span[@class='next']").links().all());
            return;
        //文章页
        } else {
            page.putField("title", page.getHtml().xpath("//h1[@id='h1title']/text()"));
            page.putField("source", page.getHtml().xpath("//a[@id='ne_article_source']/text()"));
        }
    }

    public Site getSite() {
        return site;
    }

    public void run(String startUrl) {
    	Spider.create(new Crawl()).addUrl(startUrl).run();
    }
    
}
