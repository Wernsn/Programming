package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05;

import bwi.prog.utils.TextIO;
import bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04.Calendars;


public class DateFunctions {

	public static void main(String[] args) {
		// Date d= scanDate();
		Date invalidDate = new Date();
		invalidDate.d = 31;
		invalidDate.y = 2012;
		invalidDate.m = 1;
		TextIO.putln(isLeap(invalidDate));

		printCalendar(invalidDate, true);
	}

	/**
	 * returns true if thedate is a valid date in a leap year, false otherwise.
	 * Returns false if thedate is invalid or null
	 * 
	 * 
	 * */

	public static boolean isLeap(Date theDate) {
		if (theDate == null || !checkDate(theDate))
			return false;
		return Calendars.isLeap(theDate.y);

	}

	/**
	 * 
	 * returns the number of days of the month of thedate, or -1 if thedate is
	 * invalid or null
	 */
	public static int daysInMonth(Date theDate) {
		
		if (theDate == null)
			return -1;
		if ((theDate.y==1582 && theDate.m==10) || Calendars.checkDate(theDate.y, theDate.m, theDate.d))
			
		return Calendars.daysInMonth(theDate.y, theDate.m);
		
		return -1;
	}

	/**
	 * 
	 returns whether the given date actually exists/existed returns true if
	 * date is valid, false if thedate is invalid or null the earliest valid
	 * date is Oct. 16th 1582, the last date accepted is Dec, 31st, 2199.
	 */
	public static boolean checkDate(Date thedate) {
		if (thedate == null)
			return false;
		return Calendars.checkDate(thedate.y, thedate.m, thedate.d);
	}

	// -------------- Input and Creation --------------------

	/**
	 * Creates a new Date object representing the specified date. if the date
	 * specified is invalid this function returns null.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date makeDate(int year, int month, int day) {
		if (!Calendars.checkDate(year, month, day))
			return null;

		Date tmp = new Date();
		tmp.d = day;
		tmp.m = month;
		tmp.y = year;
		return tmp;
	}

	/**
	 * Scans a date on the console.
	 * 
	 * Prompts the user for year, month, day (in that order). Always returns a
	 * valid date, i.e. the function keeps prompting the user for input until
	 * the data entered represents a valid date. Displays an error message upon
	 * invalid input (see scanIntInRange())
	 */
	public static Date scanDate() {
		int y = Calendars.scanYear();
		int m = Calendars.scanMonth(y);
		int d = Calendars.scanDay(y, m);
		return makeDate(y, m, d);

	}

	/**
	 * returns a copy of theDate. If theDate is null, null is returned.
	 * 
	 */
	public static Date copy(Date theDate) {
		if (!checkDate(theDate))
			return null;
		Date copy = new Date();
		copy.d = theDate.d;
		copy.m = theDate.m;
		copy.y = theDate.y;
		return copy;
	}

	// -------------- Calculations --------------------

	/**
	 * calculates the weekday of a given date. Returns the weekday as an int
	 * according to Table 1 in Weekdays exercise or -1, if thedate is invalid or
	 * null
	 * 
	 * */

	public static int ymd2w(Date thedate) {
		if (thedate == null || !checkDate(thedate))
			return -1;
		return Calendars.ymd2w(thedate.y, thedate.m, thedate.d);
	}

	/**
	 * returns the day count, or -1 if thedate is invalid or null
	 * 
	 * The day count is the number of days passed since the start of the year
	 * plus one. E.g.: Jan, 1st is day 1 in any year; Dec. 31st is day 365 in a
	 * non-leap year and day 366 in a leap year. In 1582, Oct 16th is day 1.
	 */
	public static int dayNumber(Date thedate) {
		if (thedate == null || !checkDate(thedate))
			return -1;
		return Calendars.dayNumber(thedate.y, thedate.m, thedate.d);
	}

	/**
	 * returns the week number of a given date, or -1 if thedate is invalid or
	 * null. Week 1 in any year (except 1582) is the week of Jan, 1st. Weeks
	 * start on Mondays (note: this is in contrast to the week counting method
	 * defined in ISO, where week one of a year is set to be the week of the
	 * first Thursday of the year) In 1582, week 1 is the week of Oct. 16th
	 * 
	 * @param thedate
	 * @return
	 */
	public static int weekNumber(Date thedate) {
		if (thedate == null || !checkDate(thedate))
			return -1;
		return Calendars.weekNumber(thedate.y, thedate.m, thedate.d);
	}

	/**
	 * returns -1 if date1 is before date2 returns 0 if the dates are equal
	 * returns 1 if date1 is after date2 Note: any two null-dates are equal and
	 * any null-date goes before any non-null date.
	 * 
	 * */
	public static int compare(Date date1, Date date2) {
		if (date1 == null && date2 == null)
			return 0;
		if (date1 == null)
			return -1;
		if (date2 == null)
			return 1;

		int diff = date1.y * 10000 + date1.m * 100 + date1.d
				- (date2.y * 10000 + date2.m * 100 + date2.d);
		if (diff < 0)
			return -1;
		else if (diff > 0)
			return 1;
		return 0;
	}

	// -------------- Output --------------------

	/**
	 * returns a String representation of thedate in the following format:
	 * <Weekday>, <Month> <day> <number_ending> <year> number_ending is o st for
	 * numbers ending with 1, except 11 o nd for numbers ending with 2, except
	 * 12 o rd for number ending with 3 except 13 o th otherwise. example:
	 * Saturday, January 1st 2000 This function returns invalid date
	 * (year/month/day) if thedate is invalid or null.
	 */
	public static String dateString(Date thedate) {
		if (thedate == null)
			return "invalid date (null)";
		return Calendars.dateString(thedate.y, thedate.m, thedate.d);
	}

	/**
	 * displays thedate in the format explained in dateString
	 * 
	 * 
	 * example: Saturday, January 1st 2000
	 * 
	 * Prints invalid date (year/month/day) for invalid, where year, month, day
	 * are substituted with the values passed to the function. Or invalid date
	 * (null) for null dates
	 */
	public static void printDate(Date thedate) {
		TextIO.putln(dateString(thedate));
	}

	/**
	 * returns a String representation of thedate in the following format:
	 * <Weekday>, <dd>.<mm>.<yyyy> if the fields are shorter than specified,
	 * leading zeros are included. This function returns invalid date
	 * (year/month/day) if thedate is invalid or null.
	 */
	public static String dateStringNumeric(Date thedate) {
		if (thedate == null)
			return "invalid date (null)";
		if (!checkDate(thedate))
			return String.format("invalid date %04d/%02d/%02d", thedate.y,
					thedate.m, thedate.d);

		return String.format("%s, %02d.%02d.%04d",
				Calendars.dayName(ymd2w(thedate)), thedate.d, thedate.m,
				thedate.y);
	}

	/**
	 * prints thedate in the format explained in dateStringNumeric: example:
	 * Saturday, 01.01.2000 Prints invalid date (year/month/day) for invalid,
	 * where year, month, day are substituted with the values passed to the
	 * function. Or invalid date (null) for null dates
	 */
	public static void printDateNumeric(Date thedate) {
		TextIO.putln(dateStringNumeric(thedate));
	}

	/**
	 * prints various information on the given date:
	 * 
	 * o date as described in printDate(Date) 
	 * o the year and whether it is a leap year or not 
	 * o the number of days in the month of the given date 
	 * o the day count of the date 
	 * o the week of the date 
	 * 
	 * example: statistics for
	 * Saturday, January 1st 2000 
	 * 2000 is a leap year 
	 * January 2000 has 31 days
	 * it is day 1 of year 2000 
	 * it is in week 1 of year 2000 
	 * 
	 * Prints 
	 * invalid date (year/month/day) for invalid dates, where year, month, day are substituted with
	 * the values passed to the function. Or invalid date (null) for null dates
	 */
	public static void printStatistics(Date thedate) {
		Calendars.printStatistics(thedate.y,  thedate.m,  thedate.d);
	}

/**
 * Same as in exercise Calendars
	Prints
	invalid date (year/month/day)
	for invalid, where year, month, day are substituted with the values passed to the function.
	Or
	invalid date (null)
	for null dates
 */
	public static void printCalendar(Date thedate, boolean highlight){
		if (thedate == null){
			TextIO.put("invalid date (null)");
			return;
		}
		if (!checkDate(thedate)){
			TextIO.putf("invalid date %04d/%02d/%02d", thedate.y,
					thedate.m, thedate.d);
			return;
		}
		
		Calendars.printCalendar(thedate.y,  thedate.m,  thedate.d,  highlight);

	}
	

}
