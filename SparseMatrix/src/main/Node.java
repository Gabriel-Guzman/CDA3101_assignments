package main;

// A Node object is an element in a SparseMatrix row.
// Its members are its position (column number), data, and next Node.
// It performs no operations on the rest of the row or matrix.
public class Node {
	Node next = null;
	private int data;
	private int col;
	
	public Node(int data, int col) {
		this.data = data;
		this.col = col;
	}
	
	public Node(Node inputNode, int col) {
		this.data = inputNode.data();
		this.col = col;
	}
	
	public int data() {
		return this.data;
	}
	
	public int col() {
		return this.col;
	}
	
	public void setData(int data) {
		this.data = data;
	}
}
