package linkedList;

public class LinkedList {
	private Node head = null;
	private Node tail = null;
	private int length = 0;
	public LinkedList() {
		
	}
	
	public void append(int data) {
		Node node = new Node(data, null);
		if (head == null) {
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
		length++;
	}
	
	public void insert(int idx, int data) {
		Node node = new Node(data, null);
		
		if(idx == 0) {
			node.next = head;
			head = node;
		} else {
			int i = 0;
			Node curr = head;
			while(i < idx-1 ) {
				curr = curr.next;
				i++;
			}
			node.next = curr.next;
			curr.next = node;
		}
		length++;
	}
	
	public int getData(int idx) {
		if(idx == 0)
			return head.data;
		else if (idx == length - 1)
			return tail.data;
		else {
			int i = 0;
			Node curr = head;
			while( i < idx) {
				curr = curr.next;
				i++;
			}
			return curr.data;
		}
	}
	
	public int delete(int idx) {
		Node curr = head;
		int returnData = 0;
		if(idx == 0) {
			returnData = head.data;
			head = head.next;
			if(length == 1)
				tail = null;
		}
		else {
			int i = 0;
			while( i < idx -1) {
				curr = curr.next;
				i++;
			}
			returnData = curr.next.data;
			if( idx == length -1) {
				tail = curr;
			}
				
			curr.next = curr.next.next;
			
		}
		length--;
		return returnData;
	}
	
	public int getLength() {
		return length;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public void printList() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data + " " );
			curr = curr.next;
		}
		System.out.println();

	}
	
	private class Node{
		  int data;
		  Node next;
		
		private Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
		
		private Node() {
			this(0, null);
		}
	}
}
