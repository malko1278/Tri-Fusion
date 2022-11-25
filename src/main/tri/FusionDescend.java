/**
 * 
 */
package main.tri;

/**
 * @author Franck Armel Malko
 *
 */
public class FusionDescend implements TriDescend {

	/**
	 * 
	 */
	public FusionDescend() {
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
	        fusionDesc(table, start, middle, end);
	    }
	}

	@Override
	public void fusionDesc(int[] table, int start, int middle, int end) {
		// TODO Auto-generated method stub
int start_2 = middle+1;
		
	    // Мы извлекаем все элементы из начала массива
	    int table1[] = new int[middle-start+1];
	    for(int i = start; i <= middle; i++)   table1[i-start] = table[i];
	    
	    int count1 = start;
	    int count2 = start_2;
	    
	    // Использование всех элементов массива
	    for(int i= start; i <= end; i++) {
	    	// Все элементы уже классифицированы
	    	if (count1 == start_2)   break;
	    	else {
	    		// Все элементы во втором массиве уже упорядочены
	    		if (count2 == (end+1)) {
	    			 // Добавляем оставшиеся элементы из первого массива
	    			table[i] = table1[count1-start];
		    		count1++;
	    		} else {
	    			if (table1[count1-start] > table[count2]) {
	    	        	// Добавляется элемент из первого массива
	    	        	table[i] = table1[count1-start];
	    	        	count1++;
	    	        } else {
	    	        	// Добавляется элемент из второго массива
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
	        fusionDesc(table, start, middle, end);
	    }
	}

	@Override
	public void fusionDesc(String[] table, int start, int middle, int end) {
		// TODO Auto-generated method stub
		int start_2 = middle+1;
		
	    // Мы извлекаем все элементы из начала массива
		String table1[] = new String[middle-start+1];
	    for(int i = start; i <= middle; i++)   table1[i-start] = table[i];
	    
	    int count1 = start;
	    int count2 = start_2;
	    
	    // Использование всех элементов массива
	    for(int i= start; i <= end; i++) {
	    	// Все элементы уже классифицированы
	    	if (count1 == start_2)   break;
	    	else {
	    		// Все элементы во втором массиве уже упорядочены
	    		if (count2 == (end+1)) {
	    			 // Добавляем оставшиеся элементы из первого массива
	    			table[i] = table1[count1-start];
		    		count1++;
	    		} else {
	    			int compChain = table1[count1-start].compareTo(table[count2]);
	    			if (compChain > 0) {
	    	        	// Добавляется элемент из первого массива
	    	        	table[i] = table1[count1-start];
	    	        	count1++;
	    	        } else {
	    	        	// Добавляется элемент из второго массива
	    	        	table[i] = table[count2];
	    	        	count2++;
	    	        }
	    		}
	    	}
	    }
	}
}