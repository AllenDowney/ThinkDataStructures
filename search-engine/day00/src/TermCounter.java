import java.io.IOException;

import org.jsoup.select.Elements;

public class TermCounter {

	String label;

	public TermCounter(String label) {
        // TODO
	}

	public String getLabel() {
		return label;
	}

	public int size() {
        // TODO
		return 0;
	}

	public void processElements(Elements paragraphs) {
        // TODO
	}

	public void printCounts() {
        // TODO
	}

	public static void main(String[] args) throws IOException {
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";

		WikiFetcher wf = new WikiFetcher();
		Elements paragraphs = wf.fetchWikipedia(url);

		TermCounter counter = new TermCounter(url.toString());
		counter.processElements(paragraphs);
		counter.printCounts();
	}
}
