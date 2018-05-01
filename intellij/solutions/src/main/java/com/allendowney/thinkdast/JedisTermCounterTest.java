/**
 * 
 */
package com.allendowney.thinkdast;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Map;

import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * @author downey
 *
 */
public class JedisTermCounterTest {

	private Jedis jedis;
	private JedisTermCounter counter;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		
		WikiFetcher wf = new WikiFetcher();
		Elements paragraphs = wf.readWikipedia(url);

		jedis = JedisMaker.make();
		
		counter = new JedisTermCounter(url.toString());
		counter.processElements(paragraphs);
	}

	/**
	 * Test method for {@link JedisTermCounter#pushToRedis(redis.clients.jedis.Jedis)}.
	 * @throws  
	 */
	@Test
	public void testPushToRedis() {
		counter.pushToRedis(jedis);
		assertThat(counter.size(), is(4798));

		Map<String, String> map = counter.pullFromRedis(jedis);
		
		assertThat(map.size(), is(1184));
		assertThat(map.get("the"), is("339"));
	}
}
