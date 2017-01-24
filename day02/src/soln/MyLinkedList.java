import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Doubly Linked List implementation
 */
public class MyLinkedList<T> {

	private Node head;
	private Node tail;
	private int size;

	private class Node {
		T val;
		Node prev;
		Node next;

		private Node(T d, Node prev, Node next) {
			this.val = d;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(T c) {
		addLast(c);
	}

	public T pop() {
		return removeLast();
	}

	public void addLast(T e) {
		Node newNode = new Node(e, tail, null);

		if (tail != null) tail.next = newNode;
		tail = newNode;
		if (head == null) head = newNode;
		size++;
	}

	public void addFirst(T e) {
		Node newNode = new Node(e, null, head);

		if (head != null) head.prev = newNode;
		head = newNode;
		if (tail == null) tail = newNode;
		size++;
	}

	private boolean withinBounds(int index) {
		return (index < size && index >= 0);
	}

	private Node getNodeAtIndex(int index) {
		Node current = head;
		int i = 0;
		while (i < index) {
			i++;
			current = current.next;
		}
		return current;
	}

	public T get(int index) {
		if (!withinBounds(index)) throw new IndexOutOfBoundsException();
		return getNodeAtIndex(index).val;
	}

	public T removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		Node toRemove = head;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head = toRemove.next;
			head.prev = null;
		}
		size--;
		return toRemove.val;
	}

	public T removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		Node toRemove = tail;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			tail = toRemove.prev;
			tail.next = null;
		}
		size--;
		return toRemove.val;
	}

	public T remove(int index) {
		if (!withinBounds(index)) throw new IndexOutOfBoundsException();
		if (index == 0) return removeFirst();
		if (index == size-1) return removeLast();
		Node n = getNodeAtIndex(index);
		n.prev.next = n.next;
		n.next.prev = n.prev;
		size--;
		return n.val;
	}

}
