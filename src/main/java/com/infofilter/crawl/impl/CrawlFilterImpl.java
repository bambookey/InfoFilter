package com.infofilter.crawl.impl;

import java.util.HashSet;
import org.springframework.stereotype.Component;
import com.infofilter.crawl.ICrawlFilter;

@Component
public class CrawlFilterImpl implements ICrawlFilter {

	private int crawlItemsMax = 200;
	
	private HashSet<String> orPara;
	
	private HashSet<String> andPara;
	
	public void setCrawlItemsMax(int max) {
		this.crawlItemsMax = max;
	}
	
	public int getCrawlItemsMax() {
		return crawlItemsMax;
	}
	
	public void setOrPara(HashSet<String> orpara) {
		this.orPara = orpara;
	}
	
	public void setAndPara(HashSet<String> andpara) {
		this.andPara = andpara;
	}
	
	public boolean isLegalTitle(String title) {
		if(orPara != null) {
			boolean orLegal = false;
			for(String orpara : orPara) {
				if(title.contains(orpara)) {
					orLegal = true;
					break;
				}
			}
			if(!orLegal) {
				return false;
			}
		}
		if(andPara != null) {
			for(String andpara : andPara) {
				if(!title.contains(andpara)) {
					return false;
				}
			}
		}
		return true;
	}

}
