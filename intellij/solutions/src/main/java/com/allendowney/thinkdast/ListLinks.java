package com.allendowney.thinkdast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Example program to list links from a URL.
 * 
 * From: http://jsoup.org/cookbook/extracting-data/example-list-links
 */
public class ListLinks {
	
	public static void main(String[] args) throws IOException {
		
		String dirname = System.getProperty("user.dir");
		String filename = "src/resources/en.wikipedia.org/wiki/Computer_science";
		String baseURI = dirname + "/" + filename;

		File input = new File(baseURI);
		Document doc = Jsoup.parse(input, "UTF-8", baseURI);
		
		//print("Fetching %s...", url);
		//Document doc = Jsoup.connect(url).get();
		
		Element content = doc.getElementById("mw-content-text");
		Elements paragraphs = content.getElementsByTag("p");
		
		
		for (Element p : paragraphs) {
			Elements links = p.select("a[href]");
			for (Element link : links) {
				print(" * a: <%s>  (%s)", link.attr("href"), trim(link.text(), 35));
			}
			break;
		}

		
//		Elements media = doc.select("[src]");
//		Elements imports = doc.select("link[href]");
//
//		print("\nMedia: (%d)", media.size());
//		for (Element src : media) {
//			if (src.tagName().equals("img")) {
//				print(" * %s: <%s> %sx%s (%s)",
//						src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
//						trim(src.attr("alt"), 20));
//			} else {	
//				print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
//			}
//		}
//
//		print("\nImports: (%d)", imports.size());
//		for (Element link : imports) {
//			print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
//		}
//
//		print("\nLinks: (%d)", links.size());
//		for (Element link : links) {
//			print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
//			break;
//		}
	}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width-1) + ".";
		else
			return s;
	}
}
