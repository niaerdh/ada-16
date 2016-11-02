/**
 * Selection sort
 * 
 */
package sortingAlgorithms;

import java.util.ArrayList;

/**
 * @author ccottap
 *
 */
public class SelectionSort extends SortingAlgorithm {



	/* (non-Javadoc)
	 * @see sortingAlgorithms.SortingAlgorithm#getName()
	 */
	@Override
	public String getName() {
		return "Selection Sort";
	}


	/* (non-Javadoc)
	 * @see sortingAlgorithms.SortingAlgorithm#sort(int[],int,int)
	 */
	@Override
	public <E extends Comparable<? super E>> void sort(ArrayList<E> A, int l, int r) {
		for (int i=l; i<r; i++) {
			int minimum = i;
			for (int j=i+1; j<=r; j++)
				if (A.get(j).compareTo(A.get(minimum))<0)
					minimum = j;
			swap (A, i, minimum);
		}		
	}

}
