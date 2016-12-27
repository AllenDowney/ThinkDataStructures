/**
 * 
 */
package com.allendowney.thinkdast;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * @author downey
 *
 */
public class WikiParserTest {

	final static WikiFetcher wf = new WikiFetcher();
	
	/**
	 * Test method for {@link WikiParser#findFirstLink()}.
	 * @throws IOException 
	 */
	@Test
	public void testFindFirstLink1() throws IOException {
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		String href = findFirstLink(url);
		assertThat(href, is("/wiki/Programming_language"));
	}

	/**
	 * Test method for {@link WikiParser#findFirstLink()}.
	 * @throws IOException 
	 */
	@Test
	public void testFindFirstLink2() throws IOException {
		String url = "https://en.wikipedia.org/wiki/Mathematics";
		String href = findFirstLink(url);
		assertThat(href, is("/wiki/Quantity"));
	}

	/**
	 * Uses WikiParser to find the first link in the given URL.
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	private String findFirstLink(String url) throws IOException {
		Elements paragraphs = wf.readWikipedia(url);
		WikiParser wp = new WikiParser(paragraphs);
		Element elt = wp.findFirstLink();
		String href = elt.attr("href");
		return href;
	}

}
