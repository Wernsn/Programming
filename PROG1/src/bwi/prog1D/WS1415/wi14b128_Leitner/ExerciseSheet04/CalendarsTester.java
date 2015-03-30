package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04;

import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.checkDate;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.dayName;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.dayNumber;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.dayShortName;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.daysInMonth;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.isLeap;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.printCalendar;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.printDate;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.printDay;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.printDayShort;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.printMonth;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.printMonthShort;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.printStatistics;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.scanDay;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.scanIntInRange;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.scanMonth;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.scanYear;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.weekNumber;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars.ymd2w;
import bwi.prog.utils.TextIO;
//importing all functions from Calendars

public class CalendarsTester {

	private static final int IS_LEAP = 1;
	private static final int DAYS_IN_MONTH = 2;
	private static final int CHECK_DATE_INT = 3;
	private static final int CHECK_DATE_INT_INT = 4;
	private static final int CHECK_DATE_INT_INT_INT = 5;

	private static final int SCAN_INT_IN_RANGE = 6;
	private static final int SCAN_YEAR = 7;
	private static final int SCAN_MONTH = 8;
	private static final int SCAN_DAY = 9;

	private static final int YMD_2_D = 10;
	private static final int DAY_NUMBER = 11;
	private static final int WEEK_NUMBER = 12;

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

		int op = TextIO.getInt();
		switch (op) {
		/*------------------------- BASICS ----------------------*/
		case IS_LEAP:
			TextIO.putln(isLeap(TextIO.getInt()));
			break;
		case DAYS_IN_MONTH:
			TextIO.putln(daysInMonth(TextIO.getInt(), TextIO.getInt()));
			break;
		case CHECK_DATE_INT_INT_INT:
			TextIO.putln(checkDate(TextIO.getInt(), TextIO.getInt(),
					TextIO.getInt()));
			break;
		case CHECK_DATE_INT_INT:
			TextIO.putln(checkDate(TextIO.getInt(), TextIO.getInt()));
			break;
		case CHECK_DATE_INT:
			TextIO.putln(checkDate(TextIO.getInt()));
			break;
		/*------------------------- INPUT ----------------------*/
		case SCAN_INT_IN_RANGE:
			TextIO.putln(scanIntInRange(TextIO.getInt(), TextIO.getInt()));
			break;
		case SCAN_YEAR:
			TextIO.putln(scanYear());
			break;
		case SCAN_MONTH:
			TextIO.putln(scanMonth(TextIO.getInt()));
			break;
		case SCAN_DAY:
			TextIO.putln(scanDay(TextIO.getInt(), TextIO.getInt()));
			break;
		/*------------------------- CALCULATIONS ----------------------*/
		case YMD_2_D:
			TextIO.putln(ymd2w(TextIO.getInt(), TextIO.getInt(),
					TextIO.getInt()));
			break;
		case DAY_NUMBER:
			TextIO.putln(dayNumber(TextIO.getInt(), TextIO.getInt(),
					TextIO.getInt()));
			break;
		case WEEK_NUMBER:
			TextIO.putln(weekNumber(TextIO.getInt(), TextIO.getInt(),
					TextIO.getInt()));
			break;
		/*------------------------- OUTPUT ----------------------*/
		case DAY_NAME:
			TextIO.putln(dayName(TextIO.getInt()));
			break;
		case PRINT_DAY:
			printDay(TextIO.getInt());
		case DAY_SHORT_NAME:
			TextIO.putln(dayShortName(TextIO.getInt()));
			break;
		case PRINT_DAY_SHORT:
			printDayShort(TextIO.getInt());
			break;
		case PRINT_MONTH:
			printMonth(TextIO.getInt());
			break;
		case PRINT_MONTH_SHORT:
			printMonthShort(TextIO.getInt());
			break;
		case PRINT_DATE:
			printDate(TextIO.getInt(), TextIO.getInt(), TextIO.getInt());
			break;
		case PRINT_STATISTICS:
			printStatistics(TextIO.getInt(), TextIO.getInt(), TextIO.getInt());
			break;

		/*------------------------- APPLICATIONS ----------------------*/
		case PRINT_CALENDAR_HIGHLIGHT:
			printCalendar(TextIO.getInt(), TextIO.getInt(), TextIO.getInt(),
					true);
			break;
		case PRINT_CALENDAR:
				printCalendar(TextIO.getInt(), TextIO.getInt(), TextIO.getInt());
				break;
		case GO:
			Calendars.go();
			break;

		}

	}

}
