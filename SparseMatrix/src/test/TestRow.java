package test;
import main.Row;

public class TestRow {
	public void run() {
		Row row = new Row(4, 0);
		
		row.add(0, 0);
		row.add(1, 1);
		row.add(2, 2);
		row.add(3, 3);
		
		System.out.println("BEGIN TESTROW");
		
		System.out.println("Testing size(). Should be 4");
		System.out.println(row.size());
		System.out.println();
		
		System.out.println("Testing toString(). Should be 0 1 2 3");
		System.out.println(row.toString());
		System.out.println();
		
		System.out.println("Testing toString(). Should be 0 0 0 0");
		System.out.println((new Row(4, 0)).toString());
		System.out.println();
		
		System.out.println("Testing add() overwriting. Should be 2 3 0 1");
		
		row.add(2, 0);
		row.add(3, 1);
		row.add(0, 2);
		row.add(1, 3);
		
		System.out.println(row.toString());
		System.out.println();
		
		System.out.println("Testing add() overwriting. Should be 0 0 0 0");
		
		row.add(0, 0);
		row.add(0, 1);
		row.add(0, 2);
		row.add(0, 3);
		
		System.out.println(row.toString());
		System.out.println();
		
		System.out.println("Testing clear(). Should be 0 0 0 0");
		
		row.add(12312, 0);
		row.add(123345, 1);
		row.add(1234, 2);
		row.add(123, 3);
		
		row.clear();
		
		System.out.println(row.toString());
		System.out.println();
	}
}
