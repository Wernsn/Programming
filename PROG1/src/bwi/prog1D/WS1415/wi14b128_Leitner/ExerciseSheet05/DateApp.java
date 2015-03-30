package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05;

import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.compare;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.dateString;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.dateStringNumeric;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.printCalendar;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.scanDate;
import bwi.prog.utils.TextIO;

public class DateApp {

	
	public static void main(String[] args) {
		int opcode;
		Date date1 = new Date();
		Date date2 = new Date();
		boolean highlight = true;
		String dateOutput1;
		String dateOutput2;
		boolean dateOutputB = true;
		
		TextIO.putln("Welcome to the Date App");
		do {
			if (dateOutputB){
				dateOutput1 = dateString(date1);
				dateOutput2 = dateString(date2);
			}else{
				dateOutput1 = dateStringNumeric(date1);
				dateOutput2 = dateStringNumeric(date2);
			}
			
			TextIO.putln("\n\ndate1: "+dateOutput1);
			TextIO.putln("date2: "+dateOutput2+"\n");
			
			TextIO.put("please enter opcode (9 for usage):");
			opcode = TextIO.getInt();
			
			
			switch(opcode) {
			case 0:
				break;
			case 1:
				date1 = scanDate();
				break;
			case 2:
				date2 = scanDate();
				break;
			case 3:
				printCalendar(date1, highlight);
				break;
			case 4:
				printCalendar(date2, highlight);
				break;
			case 5:
				int comp = compare(date1, date2);
				if (comp == 0){
					TextIO.putln("dates are equal");
				}
				if (comp == 1) {
					TextIO.putln("date2 is later");
				}
				if (comp == -1) {
					TextIO.putln("date1 is later");
				}
				break;
			case 6:
				TextIO.putln("set highlighting: (0=off) ");
				int highl = TextIO.getInt();
				if (highl == 0){
					highlight = false;
					break;
				}
				break;
			case 7:
				TextIO.putln("set format: 0=numeric, 1=default ");
				int format = TextIO.getInt();
				if (format == 0){
					dateOutputB = false;
					break;
				}
				else if (format == 1){
					dateOutputB = true;
					break;
				}
				else {
					TextIO.putln("wrong choice");
					break;
				}
			case 9: 
				TextIO.putln ("1 enter date1 ");
				TextIO.putln ("2 enter date2 ");
				TextIO.putln ("3 printCalendar (1) ");
				TextIO.putln ("4 printCalendar (2) ");
				TextIO.putln ("5 compare the dates ");
				TextIO.putln ("6 set highlighting  ");
				TextIO.putln ("7 set format ");
				TextIO.putln ("0 exit ");
				TextIO.putln ("9 display this message ");
				
				default: return; 
			}
		} while (opcode != 0);
		TextIO.put("Thank you for using the DateApp");
	}

}
