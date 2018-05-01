package com.allendowney.thinkdast;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.util.Map;

import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @author downey
 *
 */
public class JedisIndexTest {

	private static String url1, url2;
	private Jedis jedis;
	private JedisIndex index;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		jedis = JedisMaker.make();
		index = new JedisIndex(jedis);

		loadIndex(index);
	}

	/**
	 * Loads the index with two pages read from files.
	 *
	 * @return
	 * @throws IOException
	 */
	private static void loadIndex(JedisIndex index) throws IOException {
		WikiFetcher wf = new WikiFetcher();

		url1 = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Elements paragraphs = wf.readWikipedia(url1);
		index.indexPage(url1, paragraphs);

		url2 = "https://en.wikipedia.org/wiki/Programming_language";
		paragraphs = wf.readWikipedia(url2);
		index.indexPage(url2, paragraphs);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		jedis.close();
	}

	/**
	 * Test method for {@link JedisIndex#getCounts(java.lang.String)}.
	 */
	@Test
	public void testGetCounts() {
		Map<String, Integer> map = index.getCounts("the");
		assertThat(map.get(url1), is(339));
		assertThat(map.get(url2), is(264));
	}
}
