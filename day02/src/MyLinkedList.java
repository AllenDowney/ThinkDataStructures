public class MyLinkedList {

	private Node head;
	private Node tail;
	private int size;

	private class Node {
		Chicken val;
		Node prev;
		Node next;

		private Node(Chicken d, Node prev, Node next) {
			this.val = d;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		// TODO
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(Chicken c) {
		addLast(c);
	}

	public Chicken pop() {
		return removeLast();
	}

	public void addLast(Chicken c) {
		// TODO
	}

	public void addFirst(Chicken c) {
		// TODO
	}

	public Chicken get(int index) {
		// TODO
		return null;
	}

	public Chicken remove(int index) {
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