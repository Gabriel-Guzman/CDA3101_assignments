package main;

// A Row instance represents a column in the SparseMatrix. 
// A Row is a Linked List of Nodes.
public class Row {
	private Node head = null; // The head of the element list.
	private int maxSize; // The max size of the Row.
	private int row; // Actual row number.
	
	public Row next = null;
	
	public int row() {
		return this.row;
	}
	
	public Row(int maxSize, int row) {
		this.maxSize = maxSize;
		this.row = row;
	}
	
	
	// Returns if the Row contains only zeroes. Basically 'isEmpty()'
	public boolean isAllZeroes() {
		return this.head == null;
	}
	
	// Sets the size of the Row.
	public void setSize(int size) {
		this.clear();
		this.maxSize = size;
	}
	
	// Sets the row to all 0s
	public void clear() {
		this.head = null;
	}
	
	// Pushes a new Node to the row
	public void add(int data, int col) {
		if (col >= maxSize) throw new Error("Error: attempted to add new element at column index " + col + " in Row instance of size " + maxSize);
		Node existingNode = this.referenceAt(col); // Either a reference to the node found at 'col' or null.
		
		if (existingNode == null) {
			// There does not exist a node in the Row with a column property equal to 'col'
			
			if (data == 0) {
				return;
			} else {
				// This is the only case where we actually add a Node.
				
				if (head == null) {
					head = new Node(data, col);
					return;
				}
				
				Node temp = head;
				while (temp.next != null) temp = temp.next;
				
				temp.next = new Node(data, col);
			}
			
		} else {
			// existingNode is the reference to the found node
			if (data == 0) {
				makeZero(existingNode);
			} else {
				existingNode.setData(data);
			}
		}
	}
	
	// This method make the element at column 'col' 0.
	public int makeZero(int col) {
		
		if (head.col() == col) {
			int val = this.head.data();
			this.head = this.head.next;
			
			return val;
		}
		
		// Navigating to either the Node previous to the target OR to the very last node
		Node temp = head;
		while (temp.next != null && temp.next.col() != col) {
			temp = temp.next;
		}
		
		// If we're at the last node, target couldn't be found and element is 0
		if (temp.next == null) return 0;
		
		// By here, temp.next is the target Node
		int val = temp.next.data();
		temp.next = temp.next.next;
		
		return val;
	}
	
	// This method will remove the Node in the Row at the specified col and return the value,
	// or 0 if it couldn't be found.
	public int makeZero(Node node) {
		
		if (this.head == node) {
			int val = this.head.data();
			this.head = this.head.next;
			
			return val;
		}
		
		// Navigating to either the Node previous to the target OR to the very last node
		Node temp = head;
		while (temp.next != null && temp.next != node) {
			temp = temp.next;
		}
		
		// If we're at the last node, target couldn't be found and element is 0
		if (temp.next == null) return 0;
		
		// By here, temp.next is the target Node
		int val = temp.next.data();
		temp.next = temp.next.next;
		
		return val;
	}
	
	// Returns the value at the specified column number in the row.
	public int at(int col) {
		if (col >= maxSize) throw new Error("Error: attempted to access col number " + col + " in Row instance of size " + maxSize);
		
		Node temp = head;
		
		while (temp != null) {
			if (temp.col() == col) {
				return temp.data();
			}
			
			temp = temp.next;
		}
		
		return 0;
	}
	
	// Returns the conceptual size of the row.
	public int size() {
		return this.maxSize;
	}
	
	// Returns a reference to the node at col 'col'.
	private Node referenceAt(int col) {
		Node temp = head;
		
		while (temp != null) {
			if (temp.col() == col) {
				return temp;
			}
			
			temp = temp.next;
		}
		
		return null;
	}
	
	// Returns a String representing the current Row instance.
	public String toString() {
		String result = "";
		
		for (int i = 0; i < this.maxSize; i++) {
			Node tempNode = this.referenceAt(i);
			if (tempNode != null) {
				result += this.row() + " " + tempNode.col() + " " + tempNode.data() + "\n";
			}
		}
		
		return result;
	}
	
}
