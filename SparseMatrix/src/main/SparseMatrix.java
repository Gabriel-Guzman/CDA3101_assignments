package main;

public class SparseMatrix implements SparseInterface {
	
	private Row head = null;
	private int numRows, numCols;
	
	public SparseMatrix() {
		this.numRows = this.numCols = 3;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSize(int numRows, int numCols) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumCols() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Row referenceAt(int row) {
		if (row >= this.numRows) throw new Error("Error: Attempted to reference out of bounds Row");
		
		Row temp = this.head;
		
		while (temp != null) {
			if (temp.row() == row) {
				return temp;
			}
			
			temp = temp.next;
		}
		
		return null;
	}

	@Override
	public void addElement(int row, int col, int data) {
		if (row >= numRows || col >= numCols) throw new Error("Error: attempted to add element out of SparseMatrix bounds.");
		
		if (this.head == null) {
			this.head = new Row(numRows, row);
			this.head.add(data, col);
			
			return;
		}
		
		Row temp = this.head;
		while(temp.next != null || temp.next.row() == row) {
			temp = temp.next;
		}
		
		// TODO: Actually add, we're at the row before the last OR the row before the target row
	}

	@Override
	public void removeElement(int row, int col) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getElement(int row, int col) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SparseInterface addMatrices(SparseInterface matrixToAdd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SparseInterface multiplyMatrices(SparseInterface matrixToMultiply) {
		// TODO Auto-generated method stub
		return null;
	}

}
