package com.allendowney.thinkdast;

/**
 * @author downey
 *
 */
public class LinkedListExample {	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		
		ListNode node0 = new ListNode(0, node1);
		System.out.println(node0);
	}
}
