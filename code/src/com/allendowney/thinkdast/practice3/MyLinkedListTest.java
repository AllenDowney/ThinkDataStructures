/**
 * 
 */
package com.allendowney.thinkdast.practice3;

import java.util.ArrayList;

import com.allendowney.thinkdast.practice2.MyArrayListTest;
import com.allendowney.thinkdast.practice3.MyLinkedList;
import org.junit.Before;


/**
 * @author downey
 *
 */
public class MyLinkedListTest extends MyArrayListTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		mylist = new MyLinkedList<Integer>();
		mylist.addAll(list);
	}
}
