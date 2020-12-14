package com.allendowney.thinkdast;

/**
 * @author downey
 *
 */
public class ListNode {

	public Object cargo;
	public ListNode next;

	public ListNode() {
		this.cargo = null;
		this.next = null;
	}
	
	public ListNode(Object cargo) {
		this.cargo = cargo;
		this.next = null;
	}
	
	public ListNode(Object cargo, ListNode next) {
		this.cargo = cargo;
		this.next = next;
	}
	
	public String toString() {
		return "ListNode(" + cargo.toString() + ")";
	}
}
