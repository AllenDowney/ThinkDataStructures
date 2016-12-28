package solutions;

/**
 * Doubly Linked List implementation
 * @param <T>
 */
public class MyLinkedList<T> {

	private MyLinkedListNode header;
	private MyLinkedListNode end;
	private int numElems;

	private class MyLinkedListNode {

		T data;
		MyLinkedListNode next;
		MyLinkedListNode prev;

		private MyLinkedListNode(T d, MyLinkedListNode n, MyLinkedListNode p){
			data = d;
			next = n;
			prev = p;
		}

	}

	public MyLinkedList(){
		header = new MyLinkedListNode(null,null,null);
		end = new MyLinkedListNode(null,null,header);
		header.next = end;
		numElems = 0;
	}

	public void add(T c){
		MyLinkedListNode newNode = new MyLinkedListNode(c,end,end.prev);
		end.prev.next = newNode;
		end.prev = newNode;
		numElems++;
	}

	public int size(){
		return numElems;
	}

	public T get(int index){
		if(index >= numElems) throw new IndexOutOfBoundsException("Index is out of bounds");
		MyLinkedListNode curNode = header;
		while(index>=0){
			index--;
			curNode = curNode.next;
		}
		return curNode.data;
	}

	public T remove(int index){
		if(index >= numElems) throw new IndexOutOfBoundsException("Index is out of bounds");
		MyLinkedListNode curNode = header;
		while(index>=0){
			index--;
			curNode = curNode.next;
		}
		curNode.prev.next = curNode.next;
		curNode.next.prev = curNode.prev;
		numElems--;
		return curNode.data;
	}

	public void add(int index, T c){
		if(index > numElems) throw new IndexOutOfBoundsException("Index is out of bounds");
		MyLinkedListNode curNode = header;
		while(index>0){
			index--;
			curNode = curNode.next;
		}
		MyLinkedListNode newNode = new MyLinkedListNode(c,curNode.next,curNode);
		curNode.next.prev = curNode.prev;
		curNode.next = newNode;
		numElems++;
	}

}
