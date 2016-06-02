package com.infofilter.model;

import java.util.HashSet;

/**
 * 
 * @ClassName: SearchConfig 
 * @Description: 检索条件
 * @author lixiangyu
 * @date 2016年6月1日 上午12:53:07 
 *
 */
public class SearchConfig {
	/**
	 * 抓取起始种子
	 */
	private String urlSeed;
	/**
	 * 最大有效结果数
	 */
	private Integer maxHint;
	/**
	 * 最大抓取数
	 */
	private Integer maxCrawl;
	/**
	 * 关键字集合
	 */
	private String keys;
	/**
	 * 过滤关键字集合
	 */
	private String filterKeys;
	
	public String getFilterKeys() {
		return filterKeys;
	}
	public void setFilterKeys(String filterKeys) {
		this.filterKeys = filterKeys;
	}
	public String getUrlSeed() {
		return urlSeed;
	}
	public void setUrlSeed(String urlSeed) {
		this.urlSeed = urlSeed;
	}
	public Integer getMaxHint() {
		return maxHint;
	}
	public void setMaxHint(Integer maxHint) {
		this.maxHint = maxHint;
	}
	public Integer getMaxCrawl() {
		return maxCrawl;
	}
	public void setMaxCrawl(Integer maxCrawl) {
		this.maxCrawl = maxCrawl;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	
}
