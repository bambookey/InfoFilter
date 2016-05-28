package com.infofilter.crawl;

import java.util.HashSet;

/**
 * 
 * @ClassName: ICrawlFilter 
 * @Description: 过滤条件接口
 * @author lixiangyu
 * @date 2016年5月29日 上午3:31:39 
 *
 */
public interface ICrawlFilter {
	/**
	 * @Title: isLegalTitle 
	 * @Description: 是否为感兴趣的title
	 * @param @param orPara 或的筛选条件
	 * @param @param andPara 与的筛选条件
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean isLegalTitle(String title);
}
