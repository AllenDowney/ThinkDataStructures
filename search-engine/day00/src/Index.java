import java.io.IOException;

import org.jsoup.select.Elements;

public class Index {

	public void get(String term) {
        // TODO
	}

	public void indexPage(String url, Elements paragraphs) {
        // TODO
	}

	public void printIndex() {
        // TODO
	}

	public static void main(String[] args) throws IOException {

		WikiFetcher wf = new WikiFetcher();
		Index indexer = new Index();

		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Elements paragraphs = wf.fetchWikipedia(url);
		indexer.indexPage(url, paragraphs);

		url = "https://en.wikipedia.org/wiki/Programming_language";
		paragraphs = wf.fetchWikipedia(url);
		indexer.indexPage(url, paragraphs);

		indexer.printIndex();
	}


}
