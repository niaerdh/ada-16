/**
 * Bubble sort
 * 
 */
package sortingAlgorithms;

import java.util.ArrayList;

/**
 * @author ccottap & glasnak
 *
 */
public class BubbleSort extends SortingAlgorithm {



	/* (non-Javadoc)
	 * @see sortingAlgorithms.SortingAlgorithm#getName()
	 */
	@Override
	public String getName() {
		return "Bubble Sort";
	}


	/* (non-Javadoc)
	 * @see sortingAlgorithms.SortingAlgorithm#sort(int[],int,int)
	 */
	@Override
	public <E extends Comparable<? super E>> void sort(ArrayList<E> A, int l, int r) {
		//System.out.println(A.toString());
		for (int i=r; i>l+1; i--) { // for all endpoints:
			for (int j = l; j < i; j++) {
				if (A.get(j).compareTo(A.get(j+1)) > 0)
					swap (A, j, j+1);
					//System.out.println(A.toString());
			}
		}
	}

}
