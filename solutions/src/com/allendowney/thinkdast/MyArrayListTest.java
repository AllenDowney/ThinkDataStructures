package com.allendowney.thinkdast;

//import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author downey
 *
 */
public class MyArrayListTest {

	protected List<Integer> mylist;
	protected List<Integer> list;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		mylist = new MyArrayList<Integer>();
		mylist.addAll(list);
	}

	/**
	 * Test method for {@link MyArrayList#MyArrayList()}.
	 */
	@Test
	public void testMyList() {
		assertThat(mylist.size(), is(3));
	}

	/**
	 * Test method for {@link MyArrayList#add(Object)}.
	 */
	@Test
	public void testAddT() {
		for (int i = 4; i < 20; i++) {
			mylist.add(i);
		}
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mylist.get(18), is(new Integer(19)));
	}

	/**
	 * Test method for {@link MyArrayList#add(int, Object)}.
	 */
	@Test
	public void testAddIntT() {
		mylist.add(1, 5);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mylist.get(1), is(new Integer(5)));
		assertThat(mylist.size(), is(4));

		try {
		    mylist.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mylist.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		mylist.add(0, 6);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mylist.get(0), is(6));

		mylist.add(5, 7);
		//System.out.println(Arrays.toString(mal.toArray()));
		assertThat(mylist.get(5), is(new Integer(7)));
	}

	/**
	 * Test method for {@link MyArrayList#addAll(java.util.Collection)}.
	 */
	@Test
	public void testAddAllCollectionOfQextendsT() {
		mylist.addAll(list);
		mylist.addAll(list);
		mylist.addAll(list);
		assertThat(mylist.size(), is(12));
		assertThat(mylist.get(5), is(new Integer(3)));
	}

	/**
	 * Test method for {@link MyArrayList#clear()}.
	 */
	@Test
	public void testClear() {
		mylist.clear();
		assertThat(mylist.size(), is(0));
	}

	/**
	 * Test method for {@link MyArrayList#contains(Object)}.
	 */
	@Test
	public void testContains() {
		assertThat(mylist.contains(1), equalTo(true));
		assertThat(mylist.contains(4), equalTo(false));
		assertThat(mylist.contains(null), equalTo(false));
		mylist.add(null);
		assertThat(mylist.contains(null), equalTo(true));
	}

	/**
	 * Test method for {@link MyArrayList#containsAll(java.util.Collection)}.
	 */
	@Test
	public void testContainsAll() {
		assertThat(mylist.containsAll(list), equalTo(true));
	}

	/**
	 * Test method for {@link MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		assertThat(mylist.get(1), is(new Integer(2)));
	}

	/**
	 * Test method for {@link MyArrayList#indexOf(Object)}.
	 */
	@Test
	public void testIndexOf() {
		assertThat(mylist.indexOf(1), is(0));
		assertThat(mylist.indexOf(2), is(1));
		assertThat(mylist.indexOf(3), is(2));
		assertThat(mylist.indexOf(4), is(-1));
	}

	/**
	 * Test method for {@link MyArrayList#indexOf(Object)}.
	 */
	@Test
	public void testIndexOfNull() {
		assertThat(mylist.indexOf(null), is(-1));
		mylist.add(null);
		assertThat(mylist.indexOf(null), is(3));
	}

	/**
	 * Test method for {@link MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertThat(mylist.isEmpty(), equalTo(false));
		mylist.clear();
		assertThat(mylist.isEmpty(), equalTo(true));
	}

	/**
	 * Test method for {@link MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator() {
		Iterator<Integer> iter = mylist.iterator();
		assertThat(iter.next(), is(new Integer(1)));
		assertThat(iter.next(), is(new Integer(2)));
		assertThat(iter.next(), is(new Integer(3)));
		assertThat(iter.hasNext(), equalTo(false));
	}

	/**
	 * Test method for {@link MyArrayList#lastIndexOf(Object)}.
	 */
	@Test
	public void testLastIndexOf() {
		mylist.add(2);
		assertThat(mylist.lastIndexOf(new Integer(2)), is(3));
	}

	/**
	 * Test method for {@link MyArrayList#remove(Object)}.
	 */
	@Test
	public void testRemoveObject() {
		boolean flag = mylist.remove(new Integer(2));
		assertThat(flag, equalTo(true));
		assertThat(mylist.size(), is(2));
		assertThat(mylist.get(1), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));

		flag = mylist.remove(new Integer(1));
		assertThat(flag, equalTo(true));
		assertThat(mylist.size(), is(1));
		assertThat(mylist.get(0), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));

		flag = mylist.remove(new Integer(5));
		assertThat(flag, equalTo(false));
		assertThat(mylist.size(), is(1));
		assertThat(mylist.get(0), is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));

		flag = mylist.remove(new Integer(3));
		assertThat(flag, equalTo(true));
		assertThat(mylist.size(), is(0));
		//System.out.println(Arrays.toString(mal.toArray()));
	}

	/**
	 * Test method for {@link MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		Integer val = mylist.remove(1);
		assertThat(val, is(new Integer(2)));
		assertThat(mylist.size(), is(2));
		assertThat(mylist.get(1), is(new Integer(3)));
	}

	/**
	 * Test method for {@link MyArrayList#removeAll(java.util.Collection)}.
	 */
	@Test
	public void testRemoveAll() {
		mylist.removeAll(list);
		assertThat(mylist.size(), is(0));
	}

	/**
	 * Test method for {@link MyArrayList#set(int, Object)}.
	 */
	@Test
	public void testSet() {
		Integer val = mylist.set(1, 5);
		assertThat(val, is(new Integer(2)));

		val = mylist.set(0, 6);
		assertThat(val, is(new Integer(1)));

		val = mylist.set(2, 7);
		assertThat(val, is(new Integer(3)));

		// return value should be 2
		// list should be [6, 5, 7]
		assertThat(mylist.get(0), is(new Integer(6)));
		assertThat(mylist.get(1), is(new Integer(5)));
		assertThat(mylist.get(2), is(new Integer(7)));
		//System.out.println(Arrays.toString(mal.toArray()));

		try {
		    mylist.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mylist.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good
}

	/**
	 * Test method for {@link MyArrayList#size()}.
	 */
	@Test
	public void testSize() {
		assertThat(mylist.size(), is(3));
	}

	/**
	 * Test method for {@link MyArrayList#subList(int, int)}.
	 */
	@Test
	public void testSubList() {
		mylist.addAll(list);
		List<Integer> sub = mylist.subList(1, 4);
		assertThat(sub.get(1), is(new Integer(3)));
	}

	/**
	 * Test method for {@link MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		Object[] array = mylist.toArray();
		assertThat((Integer)array[0], is(new Integer(1)));
	}

}
