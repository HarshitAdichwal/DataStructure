import java.util.Scanner;

public class Solution {

	/** Static class for Doubly Linked List */
	static class DoublyLinkedList {
		DoublyLinkedListNode head;
		DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;

		}

		/** Method to insert node at the end of Linked List */
		public void insertNodeAtLast(int data) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(data);
			if (head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}
			this.tail = node;
		}

		/** Method to print doubly LinkedList */
		public void printList(DoublyLinkedList list) {
			DoublyLinkedListNode p = list.head;
			System.out.println();
			while (p != null) {
				System.out.print(p.data);
				if (p.next != null)
					System.out.print("<=>");
				p = p.next;
			}
		}
		
		/** Reversing the doubly Linked List **/
		private void reverse(DoublyLinkedListNode head) {
			
		}
	}

	/** Static class of Doubly LinkedList Node */
	static class DoublyLinkedListNode {
		int data;
		DoublyLinkedListNode next;
		DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	/** Main method to drive the logic */
	public static void main(String[] args) {
		System.out.println("Enter the number of nodes in Doubly LinkedList - ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DoublyLinkedList dList = new DoublyLinkedList();
		DoublyLinkedListNode head = null;
		for (int i = 0; i < n; i++) {
			System.out.println("Insert data for node " + i + " ");
			dList.insertNodeAtLast(sc.nextInt());
		}
		System.out.println("Linked List is - ");
		dList.printList(dList);
		System.out.println("************************************");
		System.out.println("Reverse the List");
		System.out.println("**********************************");
		dList.reverse(dList.head);
	}

	

}
