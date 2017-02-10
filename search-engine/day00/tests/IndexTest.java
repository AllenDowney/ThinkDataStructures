import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.util.Set;

import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

public class IndexTest {

	private Index index;
	private WikiFetcher wf;

	@Before
	public void setUp() {
		wf = new WikiFetcher();
		index = new Index();
	}

	@Test
	public void testIndexPage() throws IOException {
		// add two pages to the index
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Elements paragraphs = wf.readWikipedia(url);
		index.indexPage(url, paragraphs);

		url = "https://en.wikipedia.org/wiki/Programming_language";
		paragraphs = wf.readWikipedia(url);
		index.indexPage(url, paragraphs);

		// check the results: the word "occur" only appears on one page, twice


		Set<TermCounter> set = index.get("occur");
		assertThat(set.size(), is(1));

		for (TermCounter tc: set) {
			// this loop only happens once
			assertThat(tc.size(), is(4798));
			assertThat(tc.get("occur"), is(2));
			assertThat(tc.get("not there"), is(0));
		}
	}
}
