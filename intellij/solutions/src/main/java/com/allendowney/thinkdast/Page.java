/**
 * 
 */
package com.allendowney.thinkdast;

import java.io.IOException;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author downey
 *
 */
public class Page implements Readable {
	public URL url;
	public List<String> content;
	
	public Page(URL url) {
		this.url = url;
		this.content = new ArrayList<String>();
	}
	
	public void addLine(String line) {
		content.add(line);
	}

	@Override
	public int read(CharBuffer arg0) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
}
