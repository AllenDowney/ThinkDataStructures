package com.allendowney.javacs;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import redis.clients.jedis.Jedis;


public class JedisMaker {
	
	/**
	 * Make a Jedis object and authenticate it.
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static Jedis make() throws IOException {
		
		
		// assemble the directory name
		String slash = File.separator;
		String filename = System.getProperty("user.dir") + slash + 
				"src" + slash + "resources" + slash + "redis_url.txt";

	    StringBuilder sb = new StringBuilder();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e1) {
			System.out.println("File not found: " + filename);
			printInstructions();
			return null;
		}

		while (true) {
			String line = br.readLine();
			if (line == null) break;
			sb.append(line);
		}
		br.close();
		
		URI uri;
		try {
			uri = new URI(sb.toString());
		} catch (URISyntaxException e) {
			System.out.println("Reading file: " + filename);
			System.out.println("It looks like this file does not contain a valid URI.");
			printInstructions();
			return null;
		}
		String host = uri.getHost();
		int port = uri.getPort();
		
		String[] array = uri.getAuthority().split("[:@]");
		String auth = array[1];
		
		//Here's an older version that read the auth code from an environment variable.
		//String host = "dory.redistogo.com";
		//int port = 10534;
		//String auth = System.getenv("REDISTOGO_AUTH");
		
		Jedis jedis = new Jedis(host, port);
		
		try {
			jedis.auth(auth);
		} catch (Exception e) {
			System.out.println("Trying to connect to " + host);
			System.out.println("on port " + port);
			System.out.println("with authcode " + auth);
			System.out.println("Got exception " + e);
			printInstructions();
			return null;
		}
		return jedis;
	}


	/**
	 * 
	 */
	private static void printInstructions() {
		System.out.println("");
		System.out.println("To connect to RedisToGo, you have to provide a file called");
		System.out.println("redis_url.txt that contains the URL of your Redis server.");
		System.out.println("If you select an instance on the RedisToGo web page,");
		System.out.println("you should see a URL that contains the information you need:");
		System.out.println("redis://redistogo:AUTH@HOST:PORT");
		System.out.println("Create a file called redis_url.txt in the src/resources");
		System.out.println("directory, and paste in the URL.");
	}


	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Jedis jedis = make();
		
		// String
		jedis.set("mykey", "myvalue");
		String value = jedis.get("mykey");
	    System.out.println("Got value: " + value);
	    
	    // Set
	    jedis.sadd("myset", "element1", "element2", "element3");
	    System.out.println("element2 is member: " + jedis.sismember("myset", "element2"));
	    
	    // List
	    jedis.rpush("mylist", "element1", "element2", "element3");
	    System.out.println("element at index 1: " + jedis.lindex("mylist", 1));
	    
	    // Hash
	    jedis.hset("myhash", "word1", Integer.toString(2));
	    jedis.hincrBy("myhash", "word2", 1);
	    System.out.println("frequency of word1: " + jedis.hget("myhash", "word1"));
	    System.out.println("frequency of word2: " + jedis.hget("myhash", "word2"));
	    
	    jedis.close();
	}
}
