/**
 * 
 */
package main.tri;

/**
 * @author Franck Armel Malko
 *
 */
public interface TriDescend {
	void triFusion(int table[]);
	void triFusion(int table[], int end, int start);
	void fusionDesc(int table[], int end, int middle, int start);
	void triFusion(String table[]);
	void triFusion(String table[], int end, int start);
	void fusionDesc(String table[], int end, int middle, int start);
}
