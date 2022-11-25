/**
 * 
 */
package main.fil;

import java.util.ArrayList;

/**
 * @author franck-malko
 *
 */
public class ColumnFile {
	ArrayList<Integer> column;

	/**
	 * 
	 */
	public ColumnFile() {
		// TODO Auto-generated constructor stub
		super();
		this.column = new ArrayList<Integer>(0);
	}

	/**
	 * @param column
	 */
	public ColumnFile(ArrayList<Integer> column) {
		super();
		this.column = column;
	}

	/**
	 * @return the column
	 */
	public ArrayList<Integer> getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(ArrayList<Integer> column) {
		this.column = column;
	}
}