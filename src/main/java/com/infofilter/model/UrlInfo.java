package com.infofilter.model;

import java.io.Serializable;
/**
 * 
 * @ClassName: UrlInfo 
 * @Description: 连接类
 * @author lixiangyu
 * @date 2016年5月29日 下午7:34:02 
 *
 */
public class UrlInfo implements Serializable {

	private static final long serialVersionUID = 991098245104641985L;
	
	String href;
	
	String title;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 
	 * @param name
	 * @param url
	 */
	public UrlInfo (String name, String url) {
		this.title = name;
		this.href = url;
	}
}
