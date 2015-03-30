package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet02;

import bwi.prog.utils.TextIO;

public class DateFormatConverter {

	public static void main(String[] args) {
		
		TextIO.putln("enter date (yyyymmdd)");
		
		int date = TextIO.getInt();
		
		if (date >= 15821016 && date <= 21001231){
													//      2222.33.44
			int day = date % 100; 					// get last 2 numbers
	
			int month = date % 10000; 				// last 4 numbers
			month = month /100; 					// last 4 number & delete last 2
	
			int year = date / 10000;				 // delete last 4 numbers

			//TextIO.putln(day+"."+month+"."+year);  // Zeros missing
			TextIO.putf("%02d.%02d.%04d", day, month, year);
		}
		else{
			TextIO.put("invalid date");
		}
		
	}
}
