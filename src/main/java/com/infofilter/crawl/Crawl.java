package com.infofilter.crawl;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.infofilter.model.SearchConfig;
import com.infofilter.model.UrlInfo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

@Component
public class Crawl implements PageProcessor {
	private static Log log = LogFactory.getLog(Crawl.class);

	public static String URL_LIST = "https://www.douban.com/group/zhufang/discussion";

	public static LinkedList<UrlInfo> urlInfoList = new LinkedList<UrlInfo>();

	public static int crawlCounter = 0;

	private static SearchConfig searchConfig;

	private Site site = Site.me().setDomain("douban.com").setSleepTime(1000).setUserAgent(
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

	public void process(Page page) {

		System.out.println(searchConfig.getKeys() + ":" + searchConfig.getFilterKeys() + ":" + searchConfig.getUrlSeed() + ":" + searchConfig.getMaxHint());
		if (searchConfig == null) {
			log.error("searchConfig is null!");
			return;
		}

		URL_LIST = searchConfig.getUrlSeed().split("\\?")[0];
		// 列表页
		if (page.getUrl().regex(URL_LIST).match()) {
			System.out.println();
			List<Selectable> links = page.getHtml().xpath("//td[@class='title']").nodes();
			System.out.println(links.size());
			String title = "";
			String link = "";
			for (Selectable s : links) {
				title = s.xpath("//a/@title").toString();
				link = s.xpath("//a/@href").toString();
				crawlCounter++;

				if (containsKeyOr(title) && notContainsKeyOr(title)) {
					System.out.println(title + ":" + link);
					UrlInfo ui = new UrlInfo(title, link);
					urlInfoList.add(ui);
					System.out.println(urlInfoList.size() + ":" + crawlCounter);
					if (urlInfoList.size() > searchConfig.getMaxHint() || crawlCounter > searchConfig.getMaxCrawl()) {
						return;
					}
				}
			}

			page.addTargetRequests(page.getHtml().xpath("//span[@class='next']").links().all());
			return;
			// 文章页
		} else {
			page.putField("title", page.getHtml().xpath("//h1[@id='h1title']/text()"));
			page.putField("source", page.getHtml().xpath("//a[@id='ne_article_source']/text()"));
		}
	}

	public Site getSite() {
		return site;
	}

	public void run() {
		this.clear();
		Spider.create(new Crawl()).addUrl(searchConfig.getUrlSeed()).run();
	}

	public SearchConfig getSearchConfig() {
		return searchConfig;
	}

	public void setSearchConfig(SearchConfig searchConfig) {
		Crawl.searchConfig = searchConfig;
	}
	
	public void clear() {
		Crawl.urlInfoList.clear();
		Crawl.crawlCounter = 0;
	}
	
	public boolean containsKeyOr(String title) {
		String[] keys = searchConfig.getKeys().split("#");
		for (String s : keys) {
			if(s.trim().length() == 0)
				continue;
			if (title.contains(s)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean notContainsKeyOr(String title) {
		String[] keys = searchConfig.getFilterKeys().split("#");
		for (String s : keys) {
			if(s.trim().length() == 0)
				continue;
			if (title.contains(s)) {
				return false;
			}
		}
		return true;
	}
	
}
