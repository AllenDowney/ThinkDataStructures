/**
 *
 */
package com.allendowney.thinkdast;

import java.util.Map;

/**
 * @author downey
 *
 */
public class SillyString {
	private final String innerString;

	public SillyString(String innerString) {
		this.innerString = innerString;
	}

	public String toString() {
		return innerString;
	}

	@Override
	public boolean equals(Object other) {
		return this.toString().equals(other.toString());
	}

	@Override
	public int hashCode() {
		int total = 0;
		for (int i=0; i<innerString.length(); i++) {
			total += innerString.charAt(i);
		}
		System.out.println(total);
		return total;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<SillyString, Integer> map = new MyBetterMap<SillyString, Integer>();

		map.put(new SillyString("Word1"), 1);
		map.put(new SillyString("Word2"), 2);
		Integer value = map.get(new SillyString("Word1"));
		System.out.println(value);

		for (SillyString key: map.keySet()) {
			System.out.println(key + ", " + map.get(key));
		}
	}
}
