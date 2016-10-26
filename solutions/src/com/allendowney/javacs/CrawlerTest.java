/**
 * 
 */
package com.allendowney.javacs;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author downey
 *
 */
public class CrawlerTest {

	public CrawlerTest() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.allendowney.javacs.Crawler#Crawler(java.net.URL)}.
	 */
	@Test
	public void testCrawler() {
		makeCrawler();
	}

	/**
	 * @return 
	 * 
	 */
	private Crawler makeCrawler() {
		URL url = null;

		try {
			url = new URL("http://mit.edu");
		} catch (MalformedURLException e) {
			fail("This is an error in the test, not the code under test.");
		}
		Crawler crawler = new Crawler(url);
		return crawler;
	}

	/**
	 * Test method for {@link com.allendowney.javacs.Crawler#crawl()}.
	 */
	@Test
	public void testCrawl() {
		Crawler crawler = makeCrawler();
		crawler.crawl();
	}

}
