package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class Weekdays {

	/**
	 * @param args
	 */
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
		int inDay = date % 100, inMonth = date % 10000 / 100, inYear = date / 10000;
		boolean isLeap = ((inYear % 4 == 0) && (inYear % 100 != 0 || inYear % 400 == 0));
		
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
		//TextIO.putf("valid date\n");
		
		int d=inDay;
		int yy =inYear;
		if (inMonth<3) yy--;			
		int m=(inMonth+9)%12+1;
		int y = yy%100;
		int c = yy/100;
		
		int A = d + (int)(2.6*m-0.2) + y + (int)(y/4)+(int)(c/4)-2*c;
		int W = ((A %7)+7)%7;
		
		String weekday ="";
		switch(W){
		case 0:weekday="Sunday";break;
		case 1:weekday="Monday";break;
		case 2:weekday="Tuesday";break;
		case 3:weekday="Wednesday";break;
		case 4:weekday="Thursday";break;
		case 5:weekday="Friday";break;
		case 6:weekday="Saturday";break;		
		
		}
		
		TextIO.putf("%02d.%02d.%4d was/is or will be a %s", date % 100, date % 10000 / 100,
				date / 10000, weekday);
	}
}
