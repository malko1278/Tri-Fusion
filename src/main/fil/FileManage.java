/**
 * 
 */
package main.fil;

import java.util.ArrayList;

/**
 * @author franck-malko
 *
 */
public class FileManage {
	private ArrayList<LineValue> listLine;
		
	/**
	 * 
	 */
	public FileManage() {
		// TODO Auto-generated constructor stub
		super();
		this.listLine = new ArrayList<LineValue>(0);
	}
	
	/**
	 * @param listLigne
	 */
	public FileManage(ArrayList<LineValue> listLine) {
		super();
		this.listLine = listLine;
	}
	
	/**
	 * 
	 * @param listLin
	 */
	public void readFile(ArrayList<String> listLin) {
		for(int i = 0; i < listLin.size(); i++)	  listLine.add(new LineValue(listLin.get(i)));
	}


	/**
	 * @return the listLine
	 */
	public ArrayList<LineValue> getListLine() {
		return listLine;
	}

	/**
	 * @param listLine the listLine to set
	 */
	public void setListLine(ArrayList<LineValue> listLine) {
		this.listLine = listLine;
	}
	
	public void addListLine(ArrayList<LineValue> list) {
		this.listLine.addAll(list);
	}
}