import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Crawler {
	// the index where the results go
	private Index index;

	// queue of URLs to be indexed
	private Queue<String> queue = new LinkedList<>();

	// fetcher used to get pages from Wikipedia
	final static WikiFetcher wf = new WikiFetcher();

	public Crawler(String source, Index index) {
		this.index = index;
		queue.offer(source);
	}

	public int queueSize() {
		return queue.size();
	}

	/**
	 * For all links in the queue, fetch the page using WikiFetcher and
	 * call queueInternalLinks to enqueue all the hyperlinks into the queue.
	 * For each page your come across, index the data on that page.
	 * @param limit How many pages to crawl before you stop.
	 * @throws IOException
	 */
	public void crawl(int limit) throws IOException {
		// TODO
	}

	void queueInternalLinks(Elements paragraphs) {
		for (Element paragraph: paragraphs) {
			queueInternalLinks(paragraph);
		}
	}

	private void queueInternalLinks(Element paragraph) {

		Elements elts = paragraph.select("a[href]");
		for (Element elt: elts) {
			String relURL = elt.attr("href");
			
			if (relURL.startsWith("/wiki/")) {
				String absURL = "https://en.wikipedia.org" + relURL;
				queue.offer(absURL);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// make a WikiCrawler
		Jedis jedis = JedisMaker.make();
		Index index = new Index();
		String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Crawler wc = new Crawler(source, index);

		// for testing purposes, load up the queue
		Elements paragraphs = wf.fetchWikipedia(source);
		wc.queueInternalLinks(paragraphs);

        // TODO: Crawl outward starting at source

		// TODO: Test that your index contains multiple pages.
		// Here is some sample code that tests your index, which assumes
		// you have written a getCounts() method in Index, which returns
		// a map from {url: count} for a given keyword
		// Map<String, Integer> map = index.getCounts("programming");
		// for (Map.Entry<String, Integer> entry: map.entrySet()) {
		// 	System.out.println(entry);
		// }

	}
}
