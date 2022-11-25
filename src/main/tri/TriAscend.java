package main.tri;

/**
 * @author Franck Armel Malko
 *
 */
public interface TriAscend {
	void triFusion(int table[]);
	void triFusion(int table[], int start, int end);
	void fusionAsc(int table[], int start, int middle, int end);
	void triFusion(String table[]);
	void triFusion(String table[], int start, int end);
	void fusionAsc(String table[], int start, int middle, int end);
}