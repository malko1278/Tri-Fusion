/**
 * 
 */
package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import main.fil.ColumnFile;
import main.fil.FileManage;
import main.tri.FusionAscend;
import main.tri.FusionDescend;
import main.util.Utils;

/**
 * @author Franck Armel Malko
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass(args);
	}
	
	public MainClass(String[] args) {
		super();
		
		boolean argStatut = false;
		if(("-a".equals(args[0])) && ("-d".equals(args[1])) 
				|| ("-s".equals(args[0])) && ("-i".equals(args[1]))
				|| ("-d".equals(args[0])) && ("-a".equals(args[1]))
				|| ("-i".equals(args[0])) && ("-s".equals(args[1]))) {
			System.out.println("Les combinaisons de vos arguments ne sont pas respectées.");
			System.out.println("Les combinaisons tel que : \"-a\" et \"-d\",");
			System.out.println("                           \"-s\" et \"-i\",");
			System.out.println("                           \"-d\" et \"-a\",");
			System.out.println("                           \"-i\" et \"-s\";");
		} else {
			if(("-a".equals(args[0])) && ("-s".equals(args[1])) 
					|| ("-s".equals(args[0])) && ("-a".equals(args[1]))
					|| ("-a".equals(args[0])) && ("-i".equals(args[1]))
					|| ("-i".equals(args[0])) && ("-a".equals(args[1]))
					|| ("-d".equals(args[0])) && ("-s".equals(args[1]))
					|| ("-s".equals(args[0])) && ("-d".equals(args[1]))
					|| ("-d".equals(args[0])) && ("-i".equals(args[1]))
					|| ("-i".equals(args[0])) && ("-d".equals(args[1]))
					|| ("-s".equals(args[0])) && (args[1].charAt(0) != '-')) {
				argStatut = true;
			}
		}
		String outputFile = "";
		if(argStatut == true) {
			int nbrFile = 0;
			// Объявление и выделение контейнера файлов, подлежащих сортировке
			FileReader tabFileRead[] = null;
			if(args.length > 3) {
				outputFile = args[2];
				int j = 0;
				if(args[1].charAt(0) != '-') {
					nbrFile = args.length-2;
					j = 2;
				} else {
					nbrFile = args.length-3;
					j = 3;
				}
				tabFileRead = new FileReader[nbrFile];
				int k = 0;
				while(k < nbrFile) {
					try {
						tabFileRead[k++] = new FileReader(args[j++]);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				if(args.length < 3) {
					Scanner lire = new Scanner(System.in);
					System.out.println("Please enter the number of files you want to sort :");
					while(nbrFile <= 0) {
						nbrFile = lire.nextInt();
						if(nbrFile <= 0)   System.out.println("Пожалуйста, введите строго положительное целое число.");
					}
					tabFileRead = new FileReader[nbrFile];
					System.out.println("Пожалуйста, введите пути к различным файлам, которые вы хотите отсортировать :");
					String pathFile = "";
					int i = 0;
					while(i < nbrFile+1) {
						if(i == 0)   System.out.println("Первая ссылка на файл для сортировки :");
						else {
							if(i < nbrFile)   System.out.println((i+1) + "-я ссылка на файл для сортировки :");
							else {
								if(i == nbrFile)   System.out.println("Пожалуйста, напишите ссылку на выходной файл ");
							}
						}
						try {
							pathFile = lire.next();
							System.out.println("Путь к записанному файлу : " + pathFile);
							if(i < nbrFile)   tabFileRead[i] = new FileReader(pathFile);
							else   outputFile = pathFile;
							i++;
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					lire.close();
				}
			}
			FileManage[] tabFilMan = new FileManage[nbrFile];
			for(int j = 0; j < tabFileRead.length; j++)	{
				FileManage fileMan = new FileManage();
				fileMan.readFile(Utils.readFile(tabFileRead[j]));
				tabFilMan[j] = fileMan;
			}
			
			FileManage fileMan = new FileManage();
			for(int i = 0; i < tabFilMan.length; i++)	fileMan.addListLine(tabFilMan[i].getListLine());
			
			boolean typeValue = true;
			if(args[0].equals("-s") || args[1].equals("-s"))   typeValue = false;
			// ./doc/param_1.txt

			ArrayList<ColumnFile> listColumn = new ArrayList<ColumnFile>(0);
			ArrayList<Integer> listInteg = new ArrayList<Integer>(0);
			ArrayList<String> listString = new ArrayList<String>(0);
			
			for(int i = 0; i < fileMan.getListLine().size(); i++) {
				if(typeValue == true) {
					listInteg.addAll(Utils.getLineElts(fileMan.getListLine().get(i).getLine()));
		        } else {
		        	listString.addAll(Utils.getStringListLine(fileMan.getListLine().get(i).getLine()));
		        }
		    }

			int tailTab = 0;
			if(typeValue == true)	tailTab = listInteg.size();
			else	tailTab = listString.size();
			
			int[] tabIntData = null;
			String[] tabStringData = null;
			for(int i = 0; i < tailTab; i++) {
				if(typeValue == true) {
					tabIntData = new int[tailTab];
					for(int j = 0; j < listInteg.size(); j++) {
						tabIntData[j] = listInteg.get(j);
					}
				} else {
					tabStringData = new String[tailTab];
					for(int j = 0; j < listString.size(); j++) {
						tabStringData[j] = listString.get(j);
					}
				}
			}

			System.out.println("Представление таблицы перед выполнением сортировки слияния полученной таблицы.");
			if(typeValue == true)   System.out.println(Arrays.toString(tabIntData));
			else   System.out.println(Arrays.toString(tabStringData));
			
			if(typeValue == true) {
				if(args[0].equals("-a") || args[1].equals("-a")) {
					FusionAscend fusionASC = new FusionAscend();
					fusionASC.triFusion(tabIntData);
				} else {
					if(args[0].equals("-d") || args[0].equals("-d")) {
						FusionDescend fusionDESC = new FusionDescend();
						fusionDESC.triFusion(tabIntData);
					}
				}
				System.out.println("После выполнения сортировки массива слиянием по убыванию.");
				Utils.writeInteger(outputFile, tabIntData);
			} else {
				if(args[0].equals("-a") || args[1].equals("-a")) {
					FusionAscend fusionASC = new FusionAscend();
					fusionASC.triFusion(tabStringData);
				} else {
					if(args[0].equals("-d") || args[0].equals("-d")) {
						FusionDescend fusionDESC = new FusionDescend();
						fusionDESC.triFusion(tabStringData);
					}
				}
				System.out.println("\nПосле выполнения сортировки массива слиянием по убыванию.");
				Utils.writeCharacters(outputFile, tabStringData);
			}
			System.out.println();
			if(typeValue == true)   System.out.println(Arrays.toString(tabIntData));
			else   System.out.println(Arrays.toString(tabStringData));
		}
	}
}