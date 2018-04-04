package main;

public class SparseMatrix implements SparseInterface {
	
	private Row head = null;
	private int numRows = 3, numCols = 3;
	
	public SparseMatrix() {
	}

	@Override
	public void clear() {
		this.head = null;
	}

	@Override
	public void setSize(int numRows, int numCols) {
		this.clear();
		this.numRows = numRows;
		this.numCols = numCols;
	}

	@Override
	public int getNumRows() {
		return this.numRows;
	}

	@Override
	public int getNumCols() {
		return this.numCols;
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
		
		return temp;
	}

	@Override
	public void addElement(int row, int col, int data) {
		if (row >= numRows || col >= numCols) throw new Error("Error: attempted to add element out of SparseMatrix bounds.");
		
		if (this.head == null) {
			this.head = new Row(numRows, row);
			this.head.add(data, col);
			
			return;
		}
		
		Row existingRow = this.referenceAt(row);
		
		// TODO: Actually add, we're at the row before the last OR the row before the target row
		
		if (existingRow == null) {
			// There does not exist a row in the sparse matrix with the 'row' index equal to row
			
			if (data == 0) {
				return;
			} else {
				// This is the only case where we actually add a row.
				
				if (head == null) {
					head = new Row(this.numCols, row);
					head.add(data, col);
					return;
				}
				
				Row temp = head;
				while (temp.next != null) temp = temp.next;
				
				temp.next = new Row(this.numCols, row);
			}
			
		} else {
			// existingRow is the reference to the found Row
			if (data == 0 && existingRow.isAllZeroes()) {
				// TODO: Implement removeRow
				this.removeRow(existingRow);
				return;
				
			} else {
				existingRow.add(data, col);
			}
		}
		
	}
	
	// Removes the Row referenced by 'ref'.
	// This method is private due to the fact that a reference to a Row can
	// and should not be publicly accessible.
	private void removeRow(Row ref) {
		Row temp = head;
		
		if (temp == ref) {
			// Will make head null if head is the only element
			this.head = temp.next;
			return; 
		}
		
		while (temp.next != ref && temp.next != null) {
			temp = temp.next;
		}
		
		if (temp.next == null) {
			// ref does not exist in the SparseMatrix
			throw new Error("Attempted to remove row that does not exist in SparseMatrix");
		}
		
		temp.next = temp.next.next;
	}

	// Removes the element at the specified row and col. If the row is all zeroes, it removes it too.
	public void removeElement(int row, int col) {
		if (row >= this.getNumRows() || col >= this.getNumRows()) throw new Error("Attempted to remove element at out of bounds index from SparseMatrix.");
		
		Row temp = this.referenceAt(row);
		if (temp != null) {
			temp.makeZero(col);
			
			if (temp.isAllZeroes()) {
				this.removeRow(temp);
			}
		}
	}

	
	public int getElement(int row, int col) {
		return this.referenceAt(row).at(col);
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
	
	// Returns a string representing the SparseMatrix.
	public String toString() {
		Row temp = head;
		String result = "";
		
		while (temp != null) {
			result += temp.toString();
			temp = temp.next;
		}
		
		return result;
	}

}
