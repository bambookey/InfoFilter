import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infofilter.crawl.Crawl;
import com.infofilter.model.SearchConfig;

public class CrawlTest {

	private static Log log = LogFactory.getLog(CrawlTest.class);
	@Test
	public void crawlTestSpring() {
		log.info("crawl with IoC");
		
		String startUrl = "https://www.douban.com/group/zufan/discussion?start=0";
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml"); 
		Crawl c = ac.getBean(Crawl.class);
		
		SearchConfig searchConfig = new SearchConfig();
		searchConfig.setKeys("租");
		searchConfig.setMaxCrawl(100);
		searchConfig.setMaxHint(100);
		searchConfig.setUrlSeed(startUrl);
		c.setSearchConfig(searchConfig);
		c.run();
	}
	
	//@Test
	public void crawlTest() {
		Crawl c = new Crawl();
    	String startUrl = "https://www.douban.com/group/zhufang/discussion?start=0";
        c.run();
	}
}
