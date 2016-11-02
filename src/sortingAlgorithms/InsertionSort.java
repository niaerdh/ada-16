/**
 * Insertion sort
 * 
 */
package sortingAlgorithms;

import java.util.ArrayList;

/**
 * @author ccottap & glasnak
 *
 */
public class InsertionSort extends SortingAlgorithm {



	/* (non-Javadoc)
	 * @see sortingAlgorithms.SortingAlgorithm#getName()
	 */
	@Override
	public String getName() {
		return "Insertion Sort";
	}


	/* (non-Javadoc)
	 * @see sortingAlgorithms.SortingAlgorithm#sort(int[],int,int)
	 */
	@Override
	public <E extends Comparable<? super E>> void sort(ArrayList<E> A, int l, int r) {
		
		for (int i=l+1; i<=r; i++) { // move the barrier
			for (int j=i; j > l; j--) {	
				if (A.get(j).compareTo(A.get(j-1)) < 0) { // second is smaller? swap.
					swap (A, j, j-1);
				}
			}
		}	
	}

}
