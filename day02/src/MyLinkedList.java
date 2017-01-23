//package solutions;

public class MyLinkedList {
	private Node head;
	private Node tail;
	private int size;

	private class Node {
		Chicken chicken;
		Node prev;
		Node next;
        
		private Node(Chicken c, Node prev, Node next) {
			this.chicken = c;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		size = 0;
	}

	public void addFirst(Chicken c) {
		// TODO
	}

	public void addLast(Chicken c) {
        // TODO
	}

	public int size(){
		return size;
	}

	public Chicken get(int index) {
        // TODO
		return null;
	}

	public Chicken removeFirst() {
        // TODO
		return null;
	}

	public Chicken removeLast() {
        // TODO
		return null;
	}
}
