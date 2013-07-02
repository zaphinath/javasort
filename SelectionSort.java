package javasort;


public class SelectionSort implements Sort {
	private long count;	
    /**
     * Sort the array into ascending order
     *
     * @throws IllegalArgumentException if the argument is null
     */
	public void sort( Comparable [ ] a ) {
		count = 0;
		for (int i = 0; i < a.length-1; i++)
		{
    	int min = i;
    	for (int j = i+1; j < a.length; j++)
				if (/*a[j].compareTo(a[min])*/compare(a[j],a[min])  < 0) 
					min = j;
    	
			Comparable tmp = a[min];
    	a[min] = a[i];
    	a[i] = tmp;
		}
	}
	
	public int compare(Comparable a, Comparable foo) {
		count ++;
		return a.compareTo(foo);
	}
    
		/**
     * Returns the number of compares used in sort
     *
     * @return Returns the number of compares used in sort
     */
	public long getCompares() {
		return count;
	}
}

