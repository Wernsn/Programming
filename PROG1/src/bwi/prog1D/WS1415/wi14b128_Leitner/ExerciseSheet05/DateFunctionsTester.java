package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05;

import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.checkDate;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.compare;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.copy;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.dayNumber;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.daysInMonth;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.isLeap;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.makeDate;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.printStatistics;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.scanDate;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.weekNumber;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.ymd2w;
import bwi.prog.utils.TextIO;
//importing all functions 
//import static YOUR_ES04_PACKAGE_HERE.Calendars.*; //if needed

public class DateFunctionsTester {

	private static final int IS_LEAP = 1;
	private static final int DAYS_IN_MONTH = 2;
	private static final int CHECK_DATE = 3;

	private static final int MAKE_DATE = 4;
	private static final int SCAN_DATE = 5;
	private static final int DATE_COPY = 6;

	private static final int YMD_2_W = 7;
	private static final int DAY_NUMBER = 8;
	private static final int WEEK_NUMBER = 9;
	private static final int COMPARE = 10;

	private static final int DAY_NAME = 13;
	private static final int PRINT_DAY = 14;
	private static final int DAY_SHORT_NAME = 15;
	private static final int PRINT_DAY_SHORT = 16;
	private static final int PRINT_MONTH = 17;
	private static final int PRINT_MONTH_SHORT = 18;
	private static final int PRINT_DATE = 19;
	private static final int PRINT_STATISTICS = 20;

	private static final int PRINT_CALENDAR_HIGHLIGHT = 21;
	private static final int PRINT_CALENDAR = 22;
	private static final int GO = 23;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		go();

	}

	public static void go() {
		while (true) {
			Date tmp, cp;
			int op = TextIO.getInt();
			switch (op) {
			/*------------------------- BASICS ----------------------*/
			case IS_LEAP:
				TextIO.put("isLeap: ");
				TextIO.put(isLeap(tmp=_(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt())));
				if (tmp == null)
					TextIO.putln(" null");
				else
					TextIO.putf(" %02d.%02d.%04d\n", tmp.d, tmp.m, tmp.y);
								break;
			case DAYS_IN_MONTH:
				TextIO.put("daysInMonth: ");
				TextIO.put(daysInMonth(tmp=_(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt())));
				if (tmp == null)
					TextIO.putln(" null");
				else
					TextIO.putf(" %02d.%02d.%04d\n", tmp.d, tmp.m, tmp.y);
				break;

			case CHECK_DATE:
				TextIO.put("checkDate: ");
				TextIO.put(checkDate(tmp=_(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt())));
				if (tmp == null)
					TextIO.putln(" null");
				else
					TextIO.putf(" %02d.%02d.%04d\n", tmp.d, tmp.m, tmp.y);
				break;
			/*------------------------- INPUT ----------------------*/
			case MAKE_DATE:
				TextIO.put("makeDate: ");
				tmp = makeDate(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt());
				if (tmp == null)
					TextIO.putln(" null");
				else
					TextIO.putf(" %02d.%02d.%04d\n", tmp.d, tmp.m, tmp.y);
				break;
			case SCAN_DATE:
				TextIO.put("scanDate: ");
				tmp = scanDate();
				if (tmp == null)
					TextIO.putln(" null");
				else
					TextIO.putf(" %02d.%02d.%04d\n", tmp.d, tmp.m, tmp.y);
				break;

			case DATE_COPY:
				TextIO.put("copy: ");
				tmp = copy(null);
				if (tmp == null)
					TextIO.putln("(null copied)");
				else
					TextIO.putf(" %02d.%02d.%04d\n", tmp.d, tmp.m, tmp.y);

				cp = copy(tmp = _(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt()));
				if (tmp == null)
					TextIO.putln("original: null");
				else
					TextIO.putf("original: %02d.%02d.%04d\n", tmp.d++, tmp.m++, tmp.y++);
				
				if (cp == null)
					TextIO.putln("copied: null");
				else
					TextIO.putf("copied: %02d.%02d.%04d\n", cp.d, cp.m, cp.y);
				
				TextIO.putf("equals: %s\n", cp==tmp);
				
				
				break;
			/*------------------------- CALCULATIONS ----------------------*/
			case YMD_2_W:
				TextIO.put("ymd_2_w: ");
				TextIO.put(ymd2w(tmp=_(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt())));
				if (tmp == null)
					TextIO.putln(" null");
				else
					TextIO.putf(" %02d.%02d.%04d\n", tmp.d, tmp.m, tmp.y);
				break;
				
			case DAY_NUMBER:
				TextIO.put("dayNumber: ");
				
				TextIO.put(dayNumber(tmp=_(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt())));
				
				if (tmp == null)
					TextIO.putln(" null");
				else
					TextIO.putf(" %02d.%02d.%04d\n", tmp.d, tmp.m, tmp.y);
				break;
				
		
			case WEEK_NUMBER:
				TextIO.put("weekNumber: ");
				
				TextIO.put(weekNumber(tmp=_(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt())));
				
				if (tmp == null)
					TextIO.putln(" null");
				else
					TextIO.putf(" %02d.%02d.%04d\n", tmp.d, tmp.m, tmp.y);
				break;
	
			case COMPARE:
				TextIO.put("compare: ");
				TextIO.put(compare(tmp=_(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt()),cp=_(TextIO.getInt(), TextIO.getInt(),
								TextIO.getInt())));
				TextIO.put(" "+compare(null,tmp));
				TextIO.put(" "+compare(tmp,null));
				TextIO.put(" "+compare(null, null));
				
				if (tmp == null)
					TextIO.putln(" null ");
				else
					TextIO.putf(" %02d.%02d.%04d ", tmp.d, tmp.m, tmp.y);
				if (cp == null)
					TextIO.putln(" null");
				else
					TextIO.putf(" %02d.%02d.%04d\n", cp.d, cp.m, cp.y);
				
				
				break;
			/*------------------------- OUTPUT ----------------------*/

			
			case PRINT_STATISTICS:
				printStatistics(tmp=_(TextIO.getInt(), TextIO.getInt(),
						TextIO.getInt()));
				break;

			/*------------------------- APPLICATIONS ----------------------*/
			/*
			 * case PRINT_CALENDAR_HIGHLIGHT: printCalendar(TextIO.getInt(),
			 * TextIO.getInt(), TextIO.getInt(), true); break; case
			 * PRINT_CALENDAR: printCalendar(TextIO.getInt(), TextIO.getInt(),
			 * TextIO.getInt()); break; case GO: // Calendars.go(); break;
			 */
			default:
				return;
			}

		}
	}

	public static Date _(int day, int month, int year) {
		

		Date ___ = new Date();
		___.y = year;
		___.m = month;
		___.d = day;
		return ___;
	}
}
