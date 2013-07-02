
package javasort;

public class NewTestDriver {
	
  private static Long[] sortedData;
  private static Long[] reverseData;
  private static Long[] randomData;
  private static long a;
  private static long b;
  private static long c;
  private static long d;
  private static long e;
	private static final int three = 3;
	private static final int four = 4;
	private static final int five = 5;
	private static final int ten = 10;
	private static final int oneHundred = 100;
	private static final int twoHundred = 200;
	private static final int fourHundred = 400;
	private static final int eightHundred = 800;
	private static final int sixteenHundred = 1600;

  public static void makeSorted(int foo) {
    sortedData = new Long[foo];
    for (int i = 0; i < sortedData.length; i++)
      sortedData[i] = (long)i;
  }

  public static void makeReverse(int foo) {
    reverseData = new Long[foo];
		int i;
		int j;
		for (i = foo - 1, j = 0; i >= 0 ; --i, ++j) {
      reverseData[j] = (long)i;
    }
  }

  public static void makeRandom(int foo) {
    double random = 0.0;
    randomData = new Long[foo];
    for (int i = 0; i < randomData.length; i++) {
      random = Math.random() * ten;
      randomData[i] = (long)random;
    }
  }
 
  public static void makeSorted(Sort bob) {
    makeSorted(oneHundred);
    bob.sort(sortedData);
    a = bob.getCompares();
    makeSorted(twoHundred);
    bob.sort(sortedData);
    b = bob.getCompares();
    makeSorted(fourHundred);
    bob.sort(sortedData);
    c = bob.getCompares();
    makeSorted(eightHundred);
    bob.sort(sortedData);
    d = bob.getCompares();
    makeSorted(sixteenHundred);
    bob.sort(sortedData);
    e = bob.getCompares();
  }

  public static void makeReversed(Sort bob) {
    makeReverse(oneHundred);
    bob.sort(reverseData);
    a = bob.getCompares();
    makeReverse(twoHundred);
    bob.sort(reverseData);
    b = bob.getCompares();
    makeReverse(fourHundred);
    bob.sort(reverseData);
    c = bob.getCompares();
    makeReverse(eightHundred);
    bob.sort(reverseData);
    d = bob.getCompares();
    makeReverse(sixteenHundred);
    bob.sort(reverseData);
    e = bob.getCompares();
  }

  public static void makeRandom(Sort bob) {
    makeRandom(oneHundred);
    bob.sort(randomData);
    a = bob.getCompares();
    makeRandom(twoHundred);
    bob.sort(randomData);
    b = bob.getCompares();
    makeRandom(fourHundred);
    bob.sort(randomData);
    c = bob.getCompares();
    makeRandom(eightHundred);
    bob.sort(randomData);
    d = bob.getCompares();
    makeRandom(sixteenHundred);
    bob.sort(randomData);
    e = bob.getCompares();
  }

  public static void testInsertionSorted() {
    InsertionSort bob = new InsertionSort();
    makeSorted(bob);
  }

  public static void testInsertionReversed() {
    InsertionSort bob = new InsertionSort();
    makeReversed(bob);
  }

  public static void testInsertionRandom() {
    InsertionSort bob = new InsertionSort();
	  makeRandom(bob);
  }

  public static void testQuickSorted() {
    QuickSort bob = new QuickSort();
    makeSorted(bob);
  }
  
  public static void testQuickReversed() {
    QuickSort bob = new QuickSort();
    makeReversed(bob);
  }

  public static void testQuickRandom() {
    QuickSort bob = new QuickSort();
    makeRandom(bob);
  }

  public static void testMergeSorted() {
    MergeSort bob = new MergeSort();
    makeSorted(bob);
  }

  public static void testMergeReversed() {
    MergeSort bob = new MergeSort();
    makeReversed(bob);
  }

  public static void testMergeRandom() {
    MergeSort bob = new MergeSort();
    makeRandom(bob);
  }

  public static void testSelectionSorted() {
    SelectionSort bob = new SelectionSort();
    makeSorted(bob);
  }

  public static void testSelectionReversed() {
    SelectionSort bob = new SelectionSort();
    makeReversed(bob);
  }

  public static void testSelectionRandom() {
    SelectionSort bob = new SelectionSort();
    makeRandom(bob);
  }

  public static void toAnalyze() {
  long[] data = new long[five];
  int[] sizes = new int[five];
  sizes[0] = oneHundred;
  sizes[1] = twoHundred;
  sizes[2] = fourHundred;
  sizes[three] = eightHundred;
  sizes[four] = sixteenHundred;

  data[0] = (long)a;
  data[1] = (long)b;
  data[2] = (long)c;
  data[three] = (long)d;
  data[four] = (long)e;

  Analyzer blah = new AnalyzerImpl();
  blah.analyze(sizes, data);
  //blah.getBigOh();
  System.out.println(blah.getBigOh());
  }

	public static void generic() {
    System.out.println("sizes: 100 200 400 800 1600");
    System.out.println(a + " " + b + " "  + " " + c + " " + d + " " + e);
    toAnalyze();	
    System.out.println('\n');	
	}

	public static void printInsertionTest() {
    testInsertionSorted();
    System.out.println("INSERTION sort with SORTED data");
    generic();

    testInsertionReversed();
    System.out.println("INSERTION sort with REVERSED data");
    generic();
   
    testInsertionRandom();
    System.out.println("INSERTION sort with RANDOM data");
    generic();
	
	}

	public static void printMergeTest() {
    testMergeSorted();
    System.out.println("MERGE sort with SORTED data");
    generic();
    
    testMergeReversed();
    System.out.println("MERGE sort with REVERSED data");
    generic();
   
    testMergeRandom();
    System.out.println("MERGE sort with RANDOM data");
    generic();
	
	}

  public static void main (String[] args) {
    printInsertionTest();
		printMergeTest();

		testQuickSorted();
    System.out.println("QUICK sort with SORTED data");
    generic();
    
    testQuickReversed();
    System.out.println("QUICK sort with REVERSED data");
    generic();
   
    testQuickRandom();
    System.out.println("QUICK sort with RANDOM data");
    generic();
	
    testSelectionSorted();
    System.out.println("SELECTION sort with SORTED data");
    generic();
    
    testSelectionReversed();
    System.out.println("SELECTION sort with REVERSED data");
    generic();
   
    testSelectionRandom();
    System.out.println("SELECTION sort with RANDOM data");
    generic();

  }
}

