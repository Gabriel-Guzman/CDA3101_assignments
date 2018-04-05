package test;

import main.SparseMatrix;

public class TestSparseMatrix {
	public static void main(String args[]) {
		run();
	}
	
	public static void run() {
		// TODO: Start with toString to check for zeroes, then add.
		
		SparseMatrix sm = new SparseMatrix();
		p("BEGIN SPARSEMATRIX TESTING");
		p("Testing toString() on empty matrix");
		
		p(sm.toString());
		
		p("Testing add element once.");
		sm.addElement(0, 0, 1);
		p(sm.toString());
		
		p("Testing adding multiple elements");
		sm.addElement(0, 0, 2);
		sm.addElement(0, 0, 2);
		sm.addElement(0, 0, 2);
		sm.addElement(0, 0, 2);
		p(sm.toString());
	}
	
	private static void p(String string) {
		System.out.println(string);
	}
}
