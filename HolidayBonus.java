
public class HolidayBonus {

	
	
	
	
	
	
	public static double[] calculateHolidayBonus(double[][] data,double high,double low,double other) {
		double[] Bonus = new double [data.length];
		int column = data[0].length;
		int Hi = 0;
		int Lo = 0;
		for(int i = 0; i < data.length; i++) {
			if(data[i].length > column) {
				column = data[i].length;
				
			}
 
		}
		for(int i = 0; i < column; i++  ) {
			Hi = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data,i);
			Lo = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,i);
            if(Hi == Lo) {
            	Bonus[Hi] += high;
            	
            }
            else{
            for(int row = 0; row < Bonus.length; row++) {
            if(row == Hi) {
            if(data[row][i] > 0)
            Bonus[row] += high;
        }
            else if(row == Lo) {
                if(data[row][i] > 0)
                Bonus[row] += low;
            }
            else if( data[row].length > i) {
                if(data[row][i] > 0)
                Bonus[row] += other;
            }
                			
      }
            	
     }
			
		}
		return  Bonus; 
		
	}
	
	public static double calculateTotalHolidayBonus(double[][] data,double high,double low,double other) {
		double[] bonus = calculateHolidayBonus(data, high, low, other);
		 double total = 0;
		 for(int i = 0; i < bonus.length; i++ )
		 total += bonus[i];
		 return total;
	}
	
}
