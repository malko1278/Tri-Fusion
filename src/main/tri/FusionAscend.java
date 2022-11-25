/**
 * 
 */
package main.tri;

/**
 * @author Franck Armel Malko
 *
 */
public class FusionAscend implements TriAscend {

	/**
	 * 
	 */
	public FusionAscend() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void triFusion(int[] table) {
		// TODO Auto-generated method stub
		int lenth = table.length;
		if (lenth > 0) {
           triFusion(table, 0, lenth-1);
        }
	}

	@Override
	public void triFusion(int[] table, int start, int end) {
		// TODO Auto-generated method stub
		if (start != end) {
	    	int middle = (end+start) / 2;
	        triFusion(table, start, middle);
	        triFusion(table, middle+1, end);
	        fusionAsc(table, start, middle, end);
	    }
	}

	@Override
	public void fusionAsc(int[] table, int start, int middle, int end) {
		// TODO Auto-generated method stub
		int start_2 = middle+1;
		
	    // On recupère tous les éléments du début du tableau
	    int table1[] = new int[middle-start+1];
	    for(int i = start; i <= middle; i++)   table1[i-start] = table[i];
	    
	    int count1 = start;
	    int count2 = start_2;
	    
	    // Utilisation de tous les éléments du tableau
	    for(int i= start; i <= end; i++) {
	    	// Tous les éléments sont déjà classés
	    	if (count1 == start_2)   break;
	    	else {
	    		// Tous les éléments du second tableau sont déjà classés
	    		if (count2 == (end+1)) {
	    			 // On ajoute des éléments restants du premier tableau
	    			table[i] = table1[count1-start];
		    		count1++;
	    		} else {
	    			if (table1[count1-start] < table[count2]) {
	    	        	// On ajoute un élément du premier tableau
	    	        	table[i] = table1[count1-start];
	    	        	count1++;
	    	        } else {
	    	        	// On ajoute un élément du second tableau
	    	        	table[i] = table[count2];
	    	        	count2++;
	    	        }
	    		}
	    	}
	    }
	}

	@Override
	public void triFusion(String[] table) {
		// TODO Auto-generated method stub
		int lenth = table.length;
		if (lenth > 0) {
           triFusion(table, 0, lenth-1);
        }
	}

	@Override
	public void triFusion(String[] table, int start, int end) {
		// TODO Auto-generated method stub
		if (start != end) {
	    	int middle = (end+start) / 2;
	        triFusion(table, start, middle);
	        triFusion(table, middle+1, end);
	        fusionAsc(table, start, middle, end);
	    }
	}

	@Override
	public void fusionAsc(String[] table, int start, int middle, int end) {
		// TODO Auto-generated method stub
		int start_2 = middle+1;
		
	    // On recupère tous les éléments du début du tableau
		String table1[] = new String[middle-start+1];
	    for(int i = start; i <= middle; i++)   table1[i-start] = table[i];
	    
	    int count1 = start;
	    int count2 = start_2;
	    
	    // Utilisation de tous les éléments du tableau
	    for(int i= start; i <= end; i++) {
	    	// Tous les éléments sont déjà classés
	    	if (count1 == start_2)   break;
	    	else {
	    		// Tous les éléments du second tableau sont déjà classés
	    		if (count2 == (end+1)) {
	    			 // On ajoute des éléments restants du premier tableau
	    			table[i] = table1[count1-start];
		    		count1++;
	    		} else {
	    			int compChain = table1[count1-start].compareTo(table[count2]);
	    			if (compChain < 0) {
	    	        	// On ajoute un élément du premier tableau
	    	        	table[i] = table1[count1-start];
	    	        	count1++;
	    	        } else {
	    	        	// On ajoute un élément du second tableau
	    	        	table[i] = table[count2];
	    	        	count2++;
	    	        }
	    		}
	    	}
	    }
	}
}