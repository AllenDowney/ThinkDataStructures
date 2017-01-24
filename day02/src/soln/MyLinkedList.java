package soln;

/**
 * Doubly Linked List implementation
 */
public class MyLinkedList<T> {

	private Node head;
	private Node tail;
	private int size;

	private class Node {
		T data;
		Node prev;
		Node next;
        
		private Node(T d, Node prev, Node next) {
			this.data = d;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		size = 0;
	}

	public void addFirst(T e) {
		Node newNode = new Node(e, null, head);

		if (head != null) head.prev = newNode;
		head = newNode;
		if (tail == null) tail = newNode;
		size++;
	}

	public void addLast(T e) {
		Node newNode = new Node(e, tail, null);

		if (tail != null) tail.next = newNode;
		tail = newNode;
		if (head == null) head = newNode;
		size++;
	}

	public int size(){
		return size;
	}

	private boolean withinBounds(int index) {
		return (index < size && index >= 0);
	}

	private Node getNodeAtIndex(int index) {
		Node current = head;
		int i = 0;
		while (i != index) {
			i++;
			current = current.next;
		}
		return current;
	}

	public T get(int index) {
		if (!withinBounds(index)) throw new IndexOutOfBoundsException();
		return getNodeAtIndex(index).data;
	}

	public T removeFirst() {
		Node toRemove = head;
		head = toRemove.next;
        head.prev = null;
        size--;

		return toRemove.data;
	}

	public T removeLast() {
		Node toRemove = tail;
		tail = toRemove.prev;
		tail.next = null;
		size--;

		return toRemove.data;
	}
}
