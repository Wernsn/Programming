package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class DateValidator1 {

	public static void main(String[] args) {
		TextIO.putln("enter date (yyyymmdd)");
		int date = TextIO.getInt();
		if (date < 15821016) {
			TextIO.putln("invalid date (must be after 15821015)");
			return;
		}
		if (date > 21001231) {
			TextIO.putln("invalid date (must be before 21010101)");
			return;
		}

		// range ok.
		int inDay = date % 100, inMonth = date % 10000 / 100, intYear = date / 10000;
		boolean isLeap = ((intYear % 4 == 0) && (intYear % 100 != 0 || intYear % 400 == 0));
		
		if (inMonth < 1 || inMonth > 12) {
			TextIO.putf("invalid month (%d)\n", inMonth);
			return;
		}
		
		int nDays=0;
		switch (inMonth){
		
		case 2: if (isLeap) nDays = 29; else nDays =28;break;
		case 4: case 6: case 9: case 11: nDays = 30;break;
		default: nDays = 31; break;
		
		
		}
		if (inDay<1 || inDay > nDays) {
			TextIO.putf("invalid day (%d)\n", inDay);
			return;
		
		
		
		
		
		}
		//date ok
		TextIO.putf("valid date\n");

	}
}
