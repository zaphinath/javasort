
package javasort;

public class AnalyzerImpl implements Analyzer {

		private double[] column1;
		private double[] column2;
		private double[] column3;
		private double[] column4;
		private double[] column5;
		private double[] column6;
		private double[] column7;
		private double[] theMean;
    private double[] Eratio1;
    private double[] Eratio2;
    private double[] Eratio3;
    private double[] Eratio4;
    private double[] Eratio5;
    private double[] Eratio6;
    private double[] Eratio7;
		private Double[] EtheMean;
    private String foo1 = new String("O(1)");
		private String foo2 = new String("O(log N)");
		private String foo3 = new String("O(N)");
		private String foo4 = new String("O(N log N)");
		private String foo5 = new String("O(N^2)");
		private String foo6 = new String("O(N^3)");
		private String foo7 = new String("O(2^N)");
	  private static final int three = 3;
	  private static final int four = 4;
    private static final int five = 5;
    private static final int six = 6;
    private static final int seven = 7;
    private int[] counter;
    private int l;
		private double add1;
		private double add2; 
		private double add3; 
	  private double add4; 
		private double add5; 
		private double add6; 
		private double add7; 

    public void makeColumns(int l) {
			column1 = new double[l];
			column2 = new double[l];
			column3 = new double[l];
			column4 = new double[l];
			column5 = new double[l];
			column6 = new double[l];
			column7 = new double[l];
    }

    public void makeAdd() {
			add1 = 0;
			add2 = 0; 
			add3 = 0; 
			add4 = 0; 
			add5 = 0; 
			add6 = 0; 
			add7 = 0; 
    }

    /**
     * Analyze the data to determine the BigOh function
     *
     * @throws IllegalArgumentException if either argument is null
     */
    public void analyze(int[] sizes, long[] data) {
			int l = sizes.length;
      makeAdd();
      makeColumns(l);
      for (int i = 0; i < sizes.length; i++) {
			 	column1[i] = (double)data[i];
			 	column2[i] = (double)data[i]/Math.log(sizes[i]);
			 	column3[i] = (double)data[i]/sizes[i];
			 	column4[i] = (double)data[i]/(sizes[i] * Math.log(sizes[i]));
				column5[i] = (double)data[i]/Math.pow(sizes[i], 2);
				column6[i] = (double)data[i]/Math.pow(sizes[i], three);
				column7[i] = (double)data[i]/(Math.pow(2, sizes[i]));
			}
			theMean = new double[seven];
			for (int i = 0; i < l; i++) {
				add1 += column1[i];
				add2 += column2[i];
				add3 += column3[i];
				add4 += column4[i];
				add5 += column5[i];
				add6 += column6[i];
				add7 += column7[i];
			}
			theMean[0] = add1/(double)l;
			theMean[1] = add2/(double)l;
			theMean[2] = add3/(double)l;
			theMean[three] = add4/(double)l;
			theMean[four] = add5/(double)l;
			theMean[five] = add6/(double)l;
			theMean[six] = add7/(double)l;
		}

    public double[] getRatios() {
			return theMean;
		}
    
		public double getError() {
			int length = column1.length;
	  	double Nadd1 = 0;
			return Nadd1;
		}
		
		public void Start() {
			int length = column1.length;
			EtheMean = new Double[seven];
      Eratio1 = new double[length];
			Eratio2 = new double[length];
			Eratio3 = new double[length];
			Eratio4 = new double[length];
			Eratio5 = new double[length];
			Eratio6 = new double[length];
			Eratio7 = new double[length];
	  }

    public void calculateError() {
			double Nadd1 = 0;
			double Nadd2 = 0; 
			double Nadd3 = 0; 
			double Nadd4 = 0; 
			double Nadd5 = 0; 
			double Nadd6 = 0; 
			double Nadd7 = 0; 
			int length = column1.length;
      for (int i = 0; i < column1.length; i++) {
				Eratio1[i] = Math.abs(column1[i] - theMean[0])/theMean[0];
				Eratio2[i] = Math.abs(column2[i] - theMean[1])/theMean[1];
				Eratio3[i] = Math.abs(column3[i] - theMean[2])/theMean[2];
				Eratio4[i] = Math.abs(column4[i] - theMean[three])/theMean[three];
				Eratio5[i] = Math.abs(column5[i] - theMean[four])/theMean[four];
				Eratio6[i] = Math.abs(column6[i] - theMean[five])/theMean[five];
				Eratio7[i] = Math.abs(column7[i] - theMean[six])/theMean[six];
			}
   		 
			for (int i = 0; i < column1.length; i++) {
				Nadd1 += Eratio1[i];
				Nadd2 += Eratio2[i];
				Nadd3 += Eratio3[i];
				Nadd4 += Eratio4[i];
				Nadd5 += Eratio5[i];
				Nadd6 += Eratio6[i];
				Nadd7 += Eratio7[i];
			}

			EtheMean[0] = Nadd1/(double)length;
			EtheMean[1] = Nadd2/(double)length;
			EtheMean[2] = Nadd3/(double)length;
			EtheMean[three] = Nadd4/(double)length;
			EtheMean[four] = Nadd5/(double)length;
			EtheMean[five] = Nadd6/(double)length;
			EtheMean[six] = Nadd7/(double)length;
    }
    
    public void mergeSort() {
      counter = new int[seven];
      for (int i = 0; i < seven; i++) {
        counter[i] = i;
			}
      for( int p = 1; p < EtheMean.length; p++ )
      {	
				int foo = counter[p];
        Double tmp = EtheMean[ p ];
        int j = p;
        for( ; j > 0 && tmp.compareTo( EtheMean[ j - 1 ] ) < 0; j-- ) {
          EtheMean[j] = EtheMean[j - 1];
          counter[j] = counter[j-1];
        }
        EtheMean[ j ] = tmp;
				counter[j] = foo;
      }
    }

	  /**
     * Returns the BigOh function determined by analyze
     *
     * @return Returns the BigOh function determined by analyze
     */
    public String getBigOh() {
			Start();
			calculateError();
			String toReturn = new String("");
      mergeSort(); 
      int low = counter[0];
      switch (low) {
        case 0: toReturn = foo1;
          break;
        case 1:
          toReturn = foo2;
          break;
        case 2: toReturn = foo3;
          break;
        case three: toReturn = foo4;
          break;
        case four: toReturn = foo5;
          break;
        case five: toReturn = foo6;
          break;
        case six: toReturn = foo7;
          break;
				default: toReturn = "out of luck";
		  }  
      return toReturn;
    }
}

