/**
 * 
 */
package com.allendowney.javacs;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/**
 * @author downey
 *
 */
public class Crawler {
	private Queue<URL> queue;
	private Set<URL> crawled_urls;
	private URL current_url = null;

	public Crawler(URL url) {
		queue = new LinkedList<URL>();
		crawled_urls = new HashSet<URL>();
		queue.offer(url);
	}
	
	/** Prints the contents of the queue.
	 * 
	 */
	public void printQueue() {
		for (URL url: queue) {
			System.out.println(url);
		}
	}
	
	/** Takes a URL from the queue, reads and emits it.
	 * 
	 * @return  Number of pages crawled.
	 */
	public int crawl() {
		if (queue.isEmpty()) {
			return 0;
		}
		this.current_url = queue.remove();
		Page page = readPage(this.current_url);
		emit(page);
		crawled_urls.add(this.current_url);
		return 1;
	}

	/**
	 * @param page
	 */
	private void emit(Page page) {
		// send the page to the indexer
		
	}

	/** Reads the URL and prints the results.
	 * 
	 * @param url
	 * @return
	 */
	private void printURL(URL url) {
		BufferedReader rd = this.openURL(url);
		System.out.println(rd);
		
		String line;
		try {
			while ((line = rd.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Opens the URL and returns a BufferedReader.
	 * 
	 * @param url
	 * @return
	 */
	private BufferedReader openURL(URL url) {
		BufferedReader rd;
		
		try {
			rd  = new BufferedReader(
					new InputStreamReader(
							url.openStream()));
	        return rd;
	        
	    } catch (ProtocolException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
    	return null;
	}
	
	/** Reads the URL and puts the results into a page.
	 * 
	 * @param url
	 * @return
	 * @throws FileNotFoundException 
	 */
	private Page readPage(URL url) {
		Page page = new Page(url);
		
		System.out.println("opening " + url);
		BufferedReader rd = this.openURL(url);
		
		Scanner scanner = new Scanner(rd);
		Pattern pattern = Pattern.compile("[<>]");
		scanner.useDelimiter(pattern);
		
		boolean tag = true;
		
		while (scanner.hasNext()) {
	          String token = scanner.next();
	          System.out.println("token " + token);
	          
	          token = skipComment(scanner, token);
	          
	          if (tag) {
	        	  checkLink(token);
	          } else {
	        	  page.addLine(token);
	          }
	          tag ^= true;
	    }
		scanner.close();
		return page;
	}

	/** Checks to see if token starts a comment; if so, skips to the end.
	 * 
	 * @param scanner
	 * @param token
	 * @return
	 */
	private String skipComment(Scanner scanner, String token) {
		if (token.matches("!--.*")) {
			if (token.matches("!--.*--$")) {
				//System.out.println("complete comment " + token);
			} else {
				//System.out.println("start comment " + token);
				findEndComment(scanner);
			}
		}
		return token;
	}
		
	/** Reads tokens until the end of the current comment.
	 * 
	 * Precondition: the scanner is in the middle of a comment.
	 * 
	 * @param scanner
	 */
	private void findEndComment(Scanner scanner) {
	    while (scanner.hasNext()) {
		    String token = scanner.next();
			if (token.matches("(.|\\s)*--")) {
				//System.out.println("end comment " + token);
			    return;	
			}
			// System.out.println("skipping '" + token + "'");
		}
	}

	/** Checks to see if a token contains an href; if so, adds a URL to the queue.
	 * 
	 * @param token
	 */
	private void checkLink(String token) {
		String regex = ".*href\\s*=\\s*\"(.*)\".*";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(token);
		
		if (m.matches()) {
			String link = m.group(1);
			URL url = null;
			try {
				url = new URL(this.current_url, link);
				if (!crawled_urls.contains(url)) {
					this.queue.offer(url);
				}
			} catch (MalformedURLException e) {
				System.out.println("bad link: " + link);
			}
			
		}
		/*
		System.out.println(token);
		if (token.matches(regex)) {
			System.out.println("link: " + token);
		
		}
		*/
	}

	/** Makes a URL from an absolute or relative link.
	 * 
	 * @param link
	 * @return
	 * @throws MalformedURLException
	 */
	private URL makeURL(String link) throws MalformedURLException {
		if (link.matches("http://.*")) {
			// absolute path
			return new URL(link);
		} else {
			// relative path
			return new URL(this.current_url, link);
		}
	}
	
	public void parseURL() {
		Document doc = null;
		try {
			doc = Jsoup.connect("http://en.wikipedia.org/").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements newsHeadlines = doc.select("#mp-itn b a");
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL url = null;

		try {
			url = new URL("file://../../../resources/en.wikipedia.org/wiki/Computer_science");
			url = new URL("https://en.wikipedia.org/wiki/Computer_science");
		} catch (MalformedURLException e) {
			fail("This is an error in the test, not the code under test.");
		}
		
		Crawler crawler = new Crawler(url);
		crawler.printURL(url);
		
//		for (int i=0; i<2; i++) {
//			crawler.crawl();
//			crawler.printQueue();
//		}
//		
		
	}
}
