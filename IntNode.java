
/********************************************************
* IntNode is a single Linked List program.
* 
* @author Nicholas Trujillo
* @note This is Lab 4 - Single Linked List. New methods were added to the java
* program from Lab3. These new 
* methods will give the number of even numbers in a linked
* list, add numbed to the end of the list, and add up the data
* in a selected amount of nodes. It will also copy the odd 
* numbers to a new linked list, remove all instances of a
* number in the linked list, reverse the order of the linked list,
* and determine of the list is cyclic or acyclic.
*  - 02/19/2019
 ********************************************************/


public class IntNode {
	
	private int data;
	private IntNode link;
	
	// No Argument Constructor
	public IntNode() {
		data = 0;
		link = null;
	}
	
	// Default Constructor
	public IntNode(int _data, IntNode _node) {
		data = _data;
		link = _node;
	}
	
	// Accessors
	public int getValue() {
		return data;
	}
	
	public IntNode getLink() {
		return link;
	}
	
	// Mutators
	public void setValue(int _data) {
		data = _data;
	}
	
	public void setLink(IntNode _node) {
		link = _node;
	}
	
	/****************************************************
	 * @note Checks and returns the length 
	 * of the list.
	 * @param head
	 * @return
	 ****************************************************/
	public static int listLength(IntNode head) {
		int length = 0;
			for(IntNode cursor = head; cursor != null; cursor = cursor.link) {
				length++;
			}
		return length;
	}
	
	public String toString() {		
		if(link == null)
			return data + "";
		else 
			return data + " -> " + link.toString();
	}

	
	// Add After method
	public void addNodeAfterThis(int newData) {
		
		link = new IntNode(newData, link);
			
	}
	/****************************************************
	 * @note This method searches for the given paramter
	 * in the node.
	 * @param head
	 * @param data
	 * @return
	 *******************************************************/
	public static boolean search(IntNode head, int data) {	
		
		for(IntNode cursor = head; cursor != null; cursor = cursor.link) {
			if(cursor.data == data) {				
				return true;
			}
		}
	return false;
} // end search
	
	// Remove Node Method
	public void removeNodeAfterThis() {
		
		if(link != null)
			link = link.link;

} // end removeNodeAfterThis
	/****************************************************
	 * @note This method counts the number of even numbers
	 * in the linked list.
	 * @param head
	 * @return
	 *****************************************************/
	public static int listEvenNumber(IntNode head) {		
		int count = 0;
		
		if(head == null)
			return 0;
			else
				for(IntNode cursor = head; cursor != null; cursor = cursor.link) 
					if(cursor.getValue() % 2 == 0) 
						count++;			
			return count;
	} // end listEvenNumber
	
	/*****************************************************
	 * @note This method adds a new entry to the end of
	 * the linked list. 
	 * @param newdata
	 *****************************************************/
	
	public void addToEnd(int newdata) {
		IntNode cursor = this;
		while(cursor.link != null) 
			cursor = cursor.link;		
		cursor.addNodeAfterThis(newdata);
		
	} // end addToEnd
	
	/**************************************************
	 * @note This method adds up the numbers contained
	 * in the node. If the number passed is greater
	 * than the number of nodes, it will add everything
	 * in the linked list. 
	 * @param head
	 * @param num
	 * @return
	 *************************************************/
	public static int sumLast(IntNode head, int num){		
		int sum = 0;
		
		
			for(IntNode cursor = head; cursor != null; cursor = cursor.link) {  
				if(num > IntNode.listLength(head)) { 			
				sum = sum + cursor.getValue();
				num++;				
				} else if(num <= IntNode.listLength(head)) {
					sum = cursor.getValue();
				num++;
				}
				
			}
			return sum;	
	} // end sumLast
	
	/**************************************************
	 * @note This method copies the odd numbers into 
	 * a new linked list and returns the new linked list. 
	 * @param head
	 * @return
	 *************************************************/
	public static IntNode copyOdd(IntNode head) {
		IntNode odds = new IntNode();
		IntNode cursor = head;

			if(head == null) {
				return null;
			}
			
		while(cursor != null) {
		if(cursor.getValue() % 2 != 0)
				odds.addToEnd(cursor.getValue());
		cursor = cursor.link;
	}

		return odds.link;
} // end copyOdd
	
	public static IntNode removeAll(IntNode head,int e) {
		IntNode preCursor =  head;
		IntNode Cursor = preCursor.getLink();
		
		
		if(head != null && head.getValue() == e) {
			head = head.link;
		}
		
		if(head == null) {
			return null;
		}
		
		while(Cursor != null) {
			if(Cursor.getValue() == e) {
				preCursor.setLink(Cursor.getLink());
				Cursor= Cursor.getLink();
				} else {
					preCursor = Cursor;
					Cursor = Cursor.getLink();
				}
			}
		

		return Cursor;
		}
	
	public static IntNode reverse (IntNode head) {
		
		IntNode copyHead;
		IntNode copyTail;
		IntNode temp;
		
		copyHead = new IntNode(head.data, null);
		copyTail = copyHead;
		
		while(head != null) {

			temp = copyHead;
			copyHead = copyTail;
			copyTail = temp;			
			copyTail.addNodeAfterThis(head.data);
			head = head.link;
		}
		return copyHead.link;
	} // end reverse
	
	public static boolean hasCycle(IntNode head) {
		
		for(IntNode cursor = head; cursor != null; cursor = cursor.link)
			if(cursor.link == null) 
				return false;
		return true;
				
	} // end hasCycle
	
} // end IntNode

