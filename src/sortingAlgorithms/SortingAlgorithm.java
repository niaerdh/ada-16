/**
 * Generic Superclass of Sorting Algorithms
 * 
 */
package sortingAlgorithms;

import java.util.ArrayList;

/**
 * @author ccottap
 *
 */
public abstract class SortingAlgorithm {
	// sorts array A
    public <E extends Comparable<? super E>> void sort (ArrayList<E> A)
    {
    	sort (A, 0, A.size()-1);
    }
    
	// sorts array A[l..r]
    public abstract <E extends Comparable<? super E>> void sort (ArrayList<E> A, int l, int r);
    
    // returns the name of the algorithm used for sorting
    public abstract String getName ();
    
	protected <E> void swap (ArrayList<E> A, int i, int j) 
	{
		if (i!=j) {
			E tmp = A.get(i);
			A.set(i, A.get(j));
			A.set(j, tmp);
		}
	}

}
