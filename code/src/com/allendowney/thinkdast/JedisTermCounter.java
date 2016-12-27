package com.allendowney.thinkdast;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.jsoup.select.Elements;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;


/**
 * Encapsulates a map from search term to frequency (count).
 * 
 * @author downey
 *
 */
public class JedisTermCounter extends TermCounter {
	
	public JedisTermCounter(String label) {
		super(label);
	}

	/**
	 * 
	 * @return 
	 */
	public List<Object> pushToRedis(Jedis jedis) {
		Transaction t = jedis.multi();
		
		String hashname = hashName();
		t.del(hashname);

		for (String key: keySet()) {
			Integer count = get(key);
			t.hset(hashname, key, count.toString());
		}
		List<Object> res = t.exec();
		return res;
	}

	/**
	 * Returns the Redis key for this TermCounter.
	 * 
	 * @return
	 */
	private String hashName() {
		return "TermCounter:" + getLabel();
	}

	public Map<String, String> pullFromRedis(Jedis jedis) {
		Map<String, String> result = jedis.hgetAll(hashName());
		return result;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		
		WikiFetcher wf = new WikiFetcher();
		Elements paragraphs = wf.fetchWikipedia(url);
		JedisTermCounter counter = new JedisTermCounter(url.toString());
		counter.processElements(paragraphs);

		Jedis jedis = JedisMaker.make();
		
		counter.pushToRedis(jedis);
		System.out.println("Done pushing.");
		
		Map<String, String> map = counter.pullFromRedis(jedis);
		for (Map.Entry<String, String> entry: map.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	}
}
