/**
 * 
 */
package com.allendowney.thinkdast;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * @author downey
 *
 */
public class MyTreeMapTest {

	private MyTreeMap<String, Integer> map;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		map = new MyTreeMap<String, Integer>();
		MyTreeMap<String, Integer>.Node node08 = map.makeNode("08", 8);
		
		MyTreeMap<String, Integer>.Node node03 = map.makeNode("03", 3);
		MyTreeMap<String, Integer>.Node node10 = map.makeNode("10", 10);
		node08.left = node03;
		node08.right = node10;
		
		MyTreeMap<String, Integer>.Node node01 = map.makeNode("01", 1);
		MyTreeMap<String, Integer>.Node node06 = map.makeNode("06", 6);
		MyTreeMap<String, Integer>.Node node14 = map.makeNode("14", 14);
		node03.left = node01;
		node03.right = node06;
		node10.right = node14;
		
		MyTreeMap<String, Integer>.Node node04 = map.makeNode("04", 4);
		MyTreeMap<String, Integer>.Node node07 = map.makeNode("07", 7);
		MyTreeMap<String, Integer>.Node node13 = map.makeNode("13", 13);
		node06.left = node04;
		node06.right = node07;
		node14.left = node13;
		
		map.setTree(node08, 9);
	}

	/**
	 * Test method for {@link MyLinearMap#clear()}.
	 */
	@Test
	public void testClear() {
		map.clear();
		assertThat(map.size(), is(0));
	}

	/**
	 * Test method for {@link MyLinearMap#containsKey(java.lang.Object)}.
	 */
	@Test
	public void testContainsKey() {
		assertThat(map.containsKey("03"), is(true));
		assertThat(map.containsKey("05"), is(false));
	}

	/**
	 * Test method for {@link MyLinearMap#containsValue(java.lang.Object)}.
	 */
	@Test
	public void testContainsValue() {
		assertThat(map.containsValue(3), is(true));
		assertThat(map.containsValue(5), is(false));
	}

	/**
	 * Test method for {@link MyLinearMap#get(java.lang.Object)}.
	 */
	@Test
	public void testGet() {
		assertThat(map.get("01"), is(1));
		assertThat(map.get("03"), is(3));
		assertThat(map.get("04"), is(4));
		assertThat(map.get("06"), is(6));
		assertThat(map.get("07"), is(7));
		assertThat(map.get("08"), is(8));
		assertThat(map.get("10"), is(10));
		assertThat(map.get("13"), is(13));
		assertThat(map.get("14"), is(14));
		
		assertThat(map.get("02"), nullValue());
		assertThat(map.get("05"), nullValue());
	}

	/**
	 * Test method for {@link MyLinearMap#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertThat(map.isEmpty(), is(false));
		map.clear();
		assertThat(map.isEmpty(), is(true));
	}

	/**
	 * Test method for {@link MyLinearMap#keySet()}.
	 */
	@Test
	public void testKeySet() {
		Set<String> keySet = map.keySet();
		assertThat(keySet.size(), is(9));
		assertThat(keySet.contains("03"), is(true));
		assertThat(keySet.contains("05"), is(false));
		
		List<String> list = new ArrayList<String>();
		list.addAll(keySet);
		
		// check that the keys are in ascending order
		for (int i=0; i<list.size()-1; i++) {
			System.out.println(list.get(i));
			if (list.get(i).compareTo(list.get(i+1)) > 0) {
				assert(false);
			}
		}
		// TODO: fight with hamcrest
		// Collections.sort(list);
		// assertThat(keySet, contains(list));
	}

	/**
	 * Test method for {@link MyLinearMap#put(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public void testPut() {
		map.put("06", 66);
		assertThat(map.size(), is(9));
		assertThat(map.get("06"), is(66));
		
		map.put("05", 5);
		assertThat(map.size(), is(10));
		assertThat(map.get("05"), is(5));
	}

	/**
	 * Test method for {@link MyLinearMap#putAll(java.util.Map)}.
	 */
	@Test
	public void testPutAll() {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("02", 2);
		m.put("05", 5);
		m.put("12", 12);
		map.putAll(m);
		assertThat(map.size(), is(12));
	}

	/**
	 * Test method for {@link MyLinearMap#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemove() {
		// nothing to test, since this method is not implemented
	}

	/**
	 * Test method for {@link MyLinearMap#size()}.
	 */
	@Test
	public void testSize() {
		assertThat(map.size(), is(9));
	}

	/**
	 * Test method for {@link MyLinearMap#values()}.
	 */
	@Test
	public void testValues() {
		Collection<Integer> keySet = map.values();
		assertThat(keySet.size(), is(9));
		assertThat(keySet.contains(3), is(true));
		assertThat(keySet.contains(5), is(false));
	}
}
