/**
 * 
 */
package main.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.fil.ColumnFile;

/**
 * @author Franck Armel Malko
 *
 */
public class Utils {
	
	public static ArrayList<String> readFile(FileReader fileR) {
		ArrayList<String> lineFile = new ArrayList<String>(0);
	    String currLine = "";
	    try {
		    BufferedReader reader = new BufferedReader(fileR);
			while ((currLine = reader.readLine()) != null) {
				lineFile.add(currLine);
				System.out.println(currLine);
			}
		    reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // 
		return lineFile;
	}
	
	public static void writeInteger(String pathFile, int[] table) {
		File file = new File(pathFile);
		try {			
			FileWriter fwriter = new FileWriter(file);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			for(int i = 0; i < table.length; i++) {
				bwriter.write(table[i]);
				bwriter.write("\n");
			}
			bwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeCharacters(String pathFile, String[] table) {
		File file = new File(pathFile);
		try {
			FileWriter fwriter = new FileWriter(file);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			for(int i = 0; i < table.length; i++) {
				bwriter.write(table[i]);
				bwriter.write("\n");
			}
			bwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<ColumnFile> getListsColumns() {
		ArrayList<ColumnFile> listColFiles = null;
		
		listColFiles = new ArrayList<ColumnFile>(0);
		
		return listColFiles;
	}
	
	public static String getLineElt(String line) {
		int i = 0;
		String str = "";
		while(i < line.length()) {
			if(line.charAt(i) == ' ')   i++;
			else {
				str += line.charAt(i++);
			}
		}
		return str;
	}
	
	public static ArrayList<Integer> getListLine(String line) {
		ArrayList<Integer> listElt = new ArrayList<Integer>(0);
		if(line != "") {
			if(line.charAt(0) == ' ') {
				if(line.length() > 0) {
					line = line.substring(1, line.length());
					listElt.add(Integer.parseInt(getLineElt(line)));
				}
			} else   listElt.add(Integer.parseInt(getLineElt(line)));
		}
		return listElt;
	}
	
	public static ArrayList<Integer> getLineElts(String line) {
		ArrayList<Integer> listElt = new ArrayList<Integer>(0);
		while(line != "") {
			int j = 0;
			boolean exit = true;
			while(exit == true) {
				if(line.charAt(j) == ' ')   j++;
				else   exit = false;
			}
			line = line.substring(j, line.length());
			j = 0;
			int i = 0;
			boolean end = false;
			while(end == false) {
				if(j < line.length()) {
					if(line.charAt(j) != ' ')   j++;
					else {
						String lin = line.substring(i, j);
						if(!lin.equals(" ") && !lin.equals("")) {
							listElt.add(Integer.parseInt(getLineElt(lin)));
							j++;
							i = j;
						} else {
							if(lin.equals(" ") || lin.equals("")) {
								j++;
								i = j;
							}
						}
					}
				} else {
					String lin = line.substring(i, j);
					if(!lin.equals(" ") && !lin.equals("")) {
						listElt.add(Integer.parseInt(getLineElt(lin)));
						j++;
						i = j;
					} else {
						if(lin.equals(" ") || lin.equals("")) {
							j++;
							i = j;
						}
					}
					end = true;
				}
			}
			line = "";
		}
		return listElt;
	}
	
	/**
	 * @param line
	 * @return
	 */
	public static ArrayList<String> getStringListLine(String line) {
		ArrayList<String> listElt = new ArrayList<String>(0);
		while(line != "") {
			int j = 0;
			boolean exit = true;
			while(exit == true) {
				if(line.charAt(j) == ' ')   j++;
				else   exit = false;
			}
			line = line.substring(j, line.length());
			j = 0;
			int i = 0;
			boolean end = false;
			while(end == false) {
				if(j < line.length()) {
					if(line.charAt(j) != ' ')   j++;
					else {
						String lin = line.substring(i, j);
						if(!lin.equals(" ") && !lin.equals("")) {
							listElt.add(lin);
							j++;
							i = j;
						} else {
							if(lin.equals(" ") || lin.equals("")) {
								j++;
								i = j;
							}
						}
					}
				} else {
					String lin = line.substring(i, j);
					if(!lin.equals(" ") && !lin.equals("")) {
						listElt.add(lin);
						j++;
						i = j;
					} else {
						if(lin.equals(" ") || lin.equals("")) {
							j++;
							i = j;
						}
					}
					end = true;
				}
			}
			line = "";
		}
		return listElt;
	}

}