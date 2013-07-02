package javasort;


public class InsertionSort implements Sort {
	private long count;

		/**
     * Sort the array into ascending order
     *
     * @throws IllegalArgumentException if the argument is null
     */
	public void sort( Comparable [ ] a ) {
		count = 0;
		for( int p = 1; p < a.length; p++ )
    {
    	Comparable tmp = a[ p ];
			int j = p;
      for( ; j > 0 && compare(tmp, a[j - 1] ) < 0; --j) {
      	a[ j ] = a[ j - 1 ];
			}
      a[ j ] = tmp;
    }
	}

	public int compare(Comparable tmp,Comparable a) { 
		count++;
	  return tmp.compareTo(a); 
	}

    /**
     * Returns the number of compares used in sort
     *
     * @return Returns the number of compares used in sort
     */
	public long getCompares() { 
	 /* counted = (counted == 0) ? 99 : 
			(counted == 99) ? 199 : 
			(counted == 199) ? 399 : 
			(counted == 399) ? 799 : 
			(counted == 799) ? 1599 : 0;*/
		return count;	
	}

}

