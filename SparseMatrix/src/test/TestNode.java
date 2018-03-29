package test;

import main.Node;

public class TestNode {
	public void run() {
		Node node = new Node(12, 12);
		
		System.out.println("data() test. Should be 12:");
		System.out.println(node.data());
		System.out.println();
		
		System.out.println("col() test. Should be 12");
		System.out.println(node.col());
		System.out.println();
		
		System.out.println("setData() test. Should be 10");
		node.setData(10);
		System.out.println(node.data());
		System.out.println();
		
		System.out.println("Node(Node inputNode, int col) test. Should print 10, 13 \n\n");
		Node fromNode = new Node(node, 13);
		System.out.println(Integer.toString(fromNode.data()) + ", " + Integer.toString(fromNode.col()));
	}
}
