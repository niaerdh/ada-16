/**
 *  Testing the running time of different sorting algorithms
 *  
 */
package sortingAlgorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;



/**
 * @author ccottap
 *
 */
public class TestSortingAlgorithms {
	
	
	static SortingAlgorithm getMethod (String name) {
		if (name.equals("selection"))
			return new SelectionSort();
		else if (name.equals("insertion"))
			return new InsertionSort();
		else if (name.equals("bubble"))
			return new BubbleSort();
		else 
			return null;
	}
	
	static final int defaultArraySize = 2000;
	static final int defaultDoublings = 6;
	static final int defaultTests = 10;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		final int n1  = args.length > 1 ? Integer.parseInt(args[1]) : defaultArraySize; // initial array size
	    final int dup = args.length > 2 ? Integer.parseInt(args[2]) : defaultDoublings; // no. of times the size is double
	    final int nt  = args.length > 3 ? Integer.parseInt(args[3]) : defaultTests; 	// no. of tests per array size
	    final Random random = new Random(1);								// RNG
	    SortingAlgorithm method;											// sorting method
	    
	    if (args.length > 0) {
	    	method = getMethod(args[0]); 
	    	if (method == null) {
		    	System.out.println("ERROR: sorting method must be one of {selection, insertion, bubble}");
		    	System.exit(1);
	    	}
	    	
	        long[][] stats = new long [dup][nt+1]; // to store runtimes

	        for (int n=n1, k=0; k<dup; k++, n*=2) {
	        	ArrayList<Integer> a = new ArrayList<Integer>(n);

	        	System.out.println("n = " + n);

	        	stats[k][0] = n;

	        	for (int j = 0; j < nt; ++j) {
	        		for(int k1=0; k1<n; k1++) {
	           			a.add(random.nextInt(n));
	            	}
	        		stats[k][j+1] = timeSorts(method, a);
	        		assert checkSorted(a) : "Sorting Error";
	        		a.clear();
	        	}
	        }
			writeStats (args[0]+".txt", stats);
	    }
	    else {
	    	System.out.println("Parameters:");
	    	System.out.println("\tsorting method:     selection, insertion, bubble");
	    	System.out.println("\tinitial size (opt): initial size of the array (default " + defaultArraySize + ")");
	    	System.out.println("\tdoublings    (opt): times the size os doubled (default " + defaultDoublings + ")");
	    	System.out.println("\ttests        (opt): test per array size (default " + defaultTests + ")");
	    	System.exit(1);
	    }
	    


        		
    }
	
	static <E extends Comparable<? super E>> boolean checkSorted (ArrayList<E> a) {
        boolean OK = true;

        for (int i=1; i<a.size(); i++)
        	if (a.get(i-1).compareTo(a.get(i))>0)
        		return false;
        
        return OK;
	}
	
	static <E extends Comparable<? super E>> long timeSorts (SortingAlgorithm algorithm, ArrayList<E> a) {
	        long interval;
	        final long start = System.currentTimeMillis();
	        algorithm.sort(a);
	        final long finish = System.currentTimeMillis();
	        interval = finish - start;
	        System.out.println(algorithm.getName() + " took " + interval + "ms");
	        return interval;
	}

    static void writeStats (String filename, long[][] stats) throws IOException {
    	PrintWriter out = new PrintWriter(new FileWriter(filename));
    	final int n1 = stats.length;
    	final int n2 = stats[0].length;
    	for (int i=0; i<n1; i++) {
			out.print(stats[i][0]);
    		for (int j=1; j<n2; j++)
    			out.print("\t" + stats[i][j]);
    		out.println();
    	}
    	out.close();
    }

}
