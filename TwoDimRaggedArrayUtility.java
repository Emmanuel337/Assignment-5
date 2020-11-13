import java.io.*;
import java.util.Scanner;
public class TwoDimRaggedArrayUtility {

	
	
	
	
	
	
	
	public static double[][] readFile(java.io.File file) throws FileNotFoundException{
	        
 
	       String[][] strArr = new String[10][10];
 
	   
	       Scanner Sc = new Scanner (file);
 
	       String line;

	       int row= 0;

	       while(( Sc.hasNext()) ){
	           
	    	   line = Sc.nextLine();
	           String currStrArr[] = line.split(" ");
	           for(int j = 0; j <currStrArr.length; j++)
				{
	        	   strArr[row][j] = currStrArr[j];
				}
				row++;

	       }
	       row = 0;
	       for(int i=0; i<10; i++) {
	    	   if(strArr[i][0] != null ) {
	    		   row++;
	    		   
	    	   }
	    		   
	    		   
	       }
	       
	       
	       System.out.println("Number of rows: "+ row);
  

	       double[][] arr = new double[row][];
 
	       for(int i=0; i<row; i++){
             int colum = 0;
	    	   for(int j=0; j<10; j++) {
		    	   if(strArr[i][j] != null ) {
		    		   colum++;
		    		   
		    	   }
		    		   
		    		   
		       }
 
	            arr[i] = new double[colum ];
  
	           for(int j=0; j<colum; j++){

	               arr[i][j] = Double.parseDouble(strArr[i][j]);

	           }
  
	       }
 
	       return arr;
 
	   }
	 
	
	 public static void writeToFile(double[][] data,java.io.File outputFile) throws IOException,FileNotFoundException{
	       
	       PrintWriter Fw = new PrintWriter(outputFile);
	      
	       for(int i=0; i<data.length; i++){
	           String line = "";
	           for(int j=0; j<data[i].length; j++){
	        	   
	               Fw.print( data[i][j]+" ");
	               
	           }
	           Fw.println();
	       }
	       Fw.close();
	   }
	
	 public static double getTotal(double[][] data) {
		    double total = 0;

		    for (int row = 0; row < data.length; row++) {
		        for (int col = 0; col < data[row].length; col++) {
		            total += data[row][col];
		        }
		    }

		    return total;
		}
	
	 public static double getAverage(double[][] data) {
		    double total = 0;
            int count = 0;
		    for (int row = 0; row < data.length; row++) {
		        for (int col = 0; col < data[row].length; col++) {
		            total += data[row][col];
		            count++;
		        }
		    }

		    return total/count;
		}
 

	 

	public static double getRowTotal(double[][] array, int row) {
	    double total = 0;

	    for (int col = 0; col < array[row].length; col++) {
	        total += array[row][col];
	    }

	    return total;
	}
	
	public static double getColumnTotal(double[][] array, int col) {
	    double total = 0;

	    for (int row = 0; row < array.length; row++){
	    	if(array[row].length > col  )
	        total += array[row][col];
	    }

	    return total;
	}

	public static double getHighestInRow(double[][] array, int row) {
	    double highest = array[row][0];

	    for (int col = 1; col < array[row].length; col++) {
	        if (array[row][col] > highest) {
	            highest = array[row][col];
	        }
	    }
	    return highest;
	}
	
	public static int getHighestInRowIndex(double[][] data,int row){
	    int Highest =  0;

	    
        for (int col = 0; col < data[row].length; col++) {
        	if(data[row][col] > data[row][Highest] ) 
            Highest = col;

}
    return  Highest;
}
	
	
	public static double getLowestInRow(double[][] data,int row) {
	    double Lowest = data[row][0];

	    
	        for (int col = 0; col < data[row].length; col++) {
	        	if(data[row][col] < Lowest ) 
	            Lowest = data[row][col];
	 

	    
	}
	    return Lowest;
	}
	
	public static int getLowestInRowIndex(double[][] data,int row) {
	    int Lowest =  0;

	    
        for (int col = 0; col < data[row].length; col++) {
        	if(data[row][col] < data[row][Lowest] ) 
            Lowest = col;

}
    return Lowest;
}
	
	public static double getHighestInColumn(double[][] data,int col) {
		   double Highest = 0;

		    
	        for (int row = 0; row < data.length; row++) {
	        	if(data[row].length > col ) {
	            Highest =  data[row][col];
	            break;}
	}
	        for (int row = 0; row < data.length; row++) {
	        	if(data[row].length > col && data[row][col] > Highest ) {
	            Highest =  data[row][col];
	            }
	}     
	    return Highest;
	}
	
	public static int getHighestInColumnIndex(double[][] data,int col) {
		   int Highest = 0;

		    
	        for (int row = 0; row < data.length; row++) {
	        	if(data[row].length > col ) {
	            Highest =  row;
	            break;}
	}
	        for (int row = 0; row < data.length; row++) {
	        	if(data[row].length > col && data[row][col] > data[Highest][col] ) {
	            Highest =  row;
	            }
	}     
	    return Highest;
	}
	
	public static double getLowestInColumn(double[][] data,int col){
	    double Lowest = 0;

	    
        for (int row = 0; row < data.length; row++) {
        	if(data[row].length > col ) {
            Lowest = data[row][col];
            break;}
}
        for (int row = 0; row < data.length; row++) {
        	if(data[row].length > col && data[row][col] < Lowest  ) {
            Lowest = data[row][col];
             }
}     
    return Lowest;
}
	
	public static int getLowestInColumnIndex(double[][] data,int col) {
	   int Lowest = 0;

	    
        for (int row = 0; row < data.length; row++) {
        	if(data[row].length > col ) {
            Lowest =  row;
            break;}
}
        for (int row = 0; row < data.length; row++) {
        	if(data[row].length > col && data[row][col] < data[Lowest][col] ) {
            Lowest =  row;
            }
}     
    return Lowest;
}
	public static double getHighestInArray(double[][] data)  {
	    double  Highest = data[0][0];

	    for (int row = 0; row < data.length; row++) {
	        for (int col = 0; col < data[row].length; col++) {
	        	if(data[row][col] > Highest) 
	        		Highest = data[row][col];
	 }  

	    
	}
	    return Highest;
	}
	
	public static double getLowestInArray(double[][] data) {
	    double Lowest = data[0][0];

	    for (int row = 0; row < data.length; row++) {
	        for (int col = 0; col < data[row].length; col++) {
	        	if(data[row][col] < Lowest ) 
	            Lowest = data[row][col];
	 }  

	    
	}
	    return Lowest;
	}
}