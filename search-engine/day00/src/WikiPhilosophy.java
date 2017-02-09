import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikiPhilosophy {

	private final static WikiFetcher wf = new WikiFetcher();

	/**
	 * Tests a conjecture about Wikipedia and Philosophy.
	 * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
	 *
	 * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
	 */
	public static void main(String[] args) throws IOException {

		String destination = "https://en.wikipedia.org/wiki/Philosophy";
		String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

		testConjecture(destination, source, 10);
	}

	/**
	 * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
	 * @param source: url to start from
	 * @param destination: url to end up at
	 * @param limit: maximum number of clicks before we give up
	 */
	public static void testConjecture(String destination, String source, int limit) throws IOException {
		// TODO
	}

	/**
	 * @param url: url of the page we are visitng
	 * @return the Element containing the first hyperlink, or null.
	 */
	private static Element getFirstValidLink(String url) throws IOException {
		Elements paragraphs = wf.fetchWikipedia(url);
		WikiParser wp = new WikiParser(paragraphs);
		Element elt = wp.findFirstLink();
		return elt;
	}
}
