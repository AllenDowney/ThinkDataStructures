/**
 * 
 */
package com.allendowney.thinkdast;

import java.util.Arrays;
import java.util.Map;

/**
 * @author downey
 *
 */
public class SillyArray {
	private final char[] array;

	public SillyArray(char[] array) {
		this.array = array;
	}

	public String toString() {
		return Arrays.toString(array);
	}
	
	public void setChar(int i, char c) {
		this.array[i] = c;
	}
	
	@Override
	public boolean equals(Object other) {
		return this.toString().equals(other.toString());
	}
	
	@Override
	public int hashCode() {
		int total = 0;
		for (int i=0; i<array.length; i++) {
			total += array[i];
		}
		System.out.println(total);
		return total;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<SillyArray, Integer> map = new MyBetterMap<SillyArray, Integer>();

		SillyArray array1 = new SillyArray("Word1".toCharArray());
		map.put(array1, 1);

		// what happens if we mutate a key while it's in the Map?
		array1.setChar(0, 'C');
		
		Integer value = map.get(array1);
		System.out.println(value);
		
		for (SillyArray key: map.keySet()) {
			System.out.println(key + ", " + map.get(key));
		}
	}
}
