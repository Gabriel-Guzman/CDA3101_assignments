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
	
	public String toString() {
		Row temp = head;
		String result = "";
		while (temp != null) {
			result += temp.toString();
		}
		
		return result;
	}

}
