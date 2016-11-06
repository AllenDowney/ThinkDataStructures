import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Assert.*;
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
		Assert.assertThat(mylist.size(), CoreMatchers.is(3));
	}

	/**
	 * Test method for {@link MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddT() {
		for (int i = 4; i < 20; i++) {
			mylist.add(i);
		}
		//System.out.println(Arrays.toString(mal.toArray()));
		Assert.assertThat(mylist.get(18), CoreMatchers.is(new Integer(19)));
	}

	/**
	 * Test method for {@link MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntT() {
		mylist.add(1, 5);
		//System.out.println(Arrays.toString(mal.toArray()));
		Assert.assertThat(mylist.get(1), CoreMatchers.is(new Integer(5)));
		Assert.assertThat(mylist.size(), CoreMatchers.is(4));
		
		try {
		    mylist.set(-1, 0);
		    Assert.fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mylist.set(4, 0);
		    Assert.fail();
		} catch (IndexOutOfBoundsException e) {} // good
		
		mylist.add(0, 6);
		//System.out.println(Arrays.toString(mal.toArray()));
		Assert.assertThat(mylist.get(0), CoreMatchers.is(6));

		mylist.add(5, 7);
		//System.out.println(Arrays.toString(mal.toArray()));
		Assert.assertThat(mylist.get(5), CoreMatchers.is(new Integer(7)));
	}

	/**
	 * Test method for {@link MyArrayList#addAll(java.util.Collection)}.
	 */
	@Test
	public void testAddAllCollectionOfQextendsT() {
		mylist.addAll(list);
		mylist.addAll(list);
		mylist.addAll(list);
		Assert.assertThat(mylist.size(), CoreMatchers.is(12));
		Assert.assertThat(mylist.get(5), CoreMatchers.is(new Integer(3)));
	}

	/**
	 * Test method for {@link MyArrayList#clear()}.
	 */
	@Test
	public void testClear() {
		mylist.clear();
		Assert.assertThat(mylist.size(), CoreMatchers.is(0));
	}

	/**
	 * Test method for {@link MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		Assert.assertThat(mylist.contains(1), CoreMatchers.equalTo(true));
		Assert.assertThat(mylist.contains(4), CoreMatchers.equalTo(false));
		Assert.assertThat(mylist.contains(null), CoreMatchers.equalTo(false));
		mylist.add(null);
		Assert.assertThat(mylist.contains(null), CoreMatchers.equalTo(true));
	}

	/**
	 * Test method for {@link MyArrayList#containsAll(java.util.Collection)}.
	 */
	@Test
	public void testContainsAll() {
		Assert.assertThat(mylist.containsAll(list), CoreMatchers.equalTo(true));
	}

	/**
	 * Test method for {@link MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		Assert.assertThat(mylist.get(1), CoreMatchers.is(new Integer(2)));
	}

	/**
	 * Test method for {@link MyArrayList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOf() {
		Assert.assertThat(mylist.indexOf(1), CoreMatchers.is(0));
		Assert.assertThat(mylist.indexOf(2), CoreMatchers.is(1));
		Assert.assertThat(mylist.indexOf(3), CoreMatchers.is(2));
		Assert.assertThat(mylist.indexOf(4), CoreMatchers.is(-1));
	}
	
	/**
	 * Test method for {@link MyArrayList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOfNull() {
		Assert.assertThat(mylist.indexOf(null), CoreMatchers.is(-1));
		mylist.add(null);
		Assert.assertThat(mylist.indexOf(null), CoreMatchers.is(3));
	}

	/**
	 * Test method for {@link MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		Assert.assertThat(mylist.isEmpty(), CoreMatchers.equalTo(false));
		mylist.clear();
		Assert.assertThat(mylist.isEmpty(), CoreMatchers.equalTo(true));
	}

	/**
	 * Test method for {@link MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator() {
		Iterator<Integer> iter = mylist.iterator();
		Assert.assertThat(iter.next(), CoreMatchers.is(new Integer(1)));
		Assert.assertThat(iter.next(), CoreMatchers.is(new Integer(2)));
		Assert.assertThat(iter.next(), CoreMatchers.is(new Integer(3)));
		Assert.assertThat(iter.hasNext(), CoreMatchers.equalTo(false));
	}

	/**
	 * Test method for {@link MyArrayList#lastIndexOf(java.lang.Object)}.
	 */
	@Test
	public void testLastIndexOf() {
		mylist.add(2);
		Assert.assertThat(mylist.lastIndexOf(new Integer(2)), CoreMatchers.is(3));
	}

	/**
	 * Test method for {@link MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveObject() {
		boolean flag = mylist.remove(new Integer(2));
		Assert.assertThat(flag, CoreMatchers.equalTo(true));
		Assert.assertThat(mylist.size(), CoreMatchers.is(2));
		Assert.assertThat(mylist.get(1), CoreMatchers.is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));

		flag = mylist.remove(new Integer(1));
		Assert.assertThat(flag, CoreMatchers.equalTo(true));
		Assert.assertThat(mylist.size(), CoreMatchers.is(1));
		Assert.assertThat(mylist.get(0), CoreMatchers.is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));
		
		flag = mylist.remove(new Integer(5));
		Assert.assertThat(flag, CoreMatchers.equalTo(false));
		Assert.assertThat(mylist.size(), CoreMatchers.is(1));
		Assert.assertThat(mylist.get(0), CoreMatchers.is(new Integer(3)));
		//System.out.println(Arrays.toString(mal.toArray()));
		
		flag = mylist.remove(new Integer(3));
		Assert.assertThat(flag, CoreMatchers.equalTo(true));
		Assert.assertThat(mylist.size(), CoreMatchers.is(0));
		//System.out.println(Arrays.toString(mal.toArray()));
	}

	/**
	 * Test method for {@link MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		Integer val = mylist.remove(1);
		Assert.assertThat(val, CoreMatchers.is(new Integer(2)));
		Assert.assertThat(mylist.size(), CoreMatchers.is(2));
		Assert.assertThat(mylist.get(1), CoreMatchers.is(new Integer(3)));
	}

	/**
	 * Test method for {@link MyArrayList#removeAll(java.util.Collection)}.
	 */
	@Test
	public void testRemoveAll() {
		mylist.removeAll(list);
		Assert.assertThat(mylist.size(), CoreMatchers.is(0));
	}

	/**
	 * Test method for {@link MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		Integer val = mylist.set(1, 5);
		Assert.assertThat(val, CoreMatchers.is(new Integer(2)));

		val = mylist.set(0, 6);
		Assert.assertThat(val, CoreMatchers.is(new Integer(1)));

		val = mylist.set(2, 7);
		Assert.assertThat(val, CoreMatchers.is(new Integer(3)));

		// return value should be 2
		// list should be [6, 5, 7]
		Assert.assertThat(mylist.get(0), CoreMatchers.is(new Integer(6)));
		Assert.assertThat(mylist.get(1), CoreMatchers.is(new Integer(5)));
		Assert.assertThat(mylist.get(2), CoreMatchers.is(new Integer(7)));
		//System.out.println(Arrays.toString(mal.toArray()));

		try {
		    mylist.set(-1, 0);
		    Assert.fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mylist.set(4, 0);
		    Assert.fail();
		} catch (IndexOutOfBoundsException e) {} // good
}

	/**
	 * Test method for {@link MyArrayList#size()}.
	 */
	@Test
	public void testSize() {
		Assert.assertThat(mylist.size(), CoreMatchers.is(3));
	}

	/**
	 * Test method for {@link MyArrayList#subList(int, int)}.
	 */
	@Test
	public void testSubList() {
		mylist.addAll(list);
		List<Integer> sub = mylist.subList(1, 4);
		Assert.assertThat(sub.get(1), CoreMatchers.is(new Integer(3)));
	}

	/**
	 * Test method for {@link MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		Object[] array = mylist.toArray();
		Assert.assertThat((Integer)array[0], CoreMatchers.is(new Integer(1)));
	}

}
