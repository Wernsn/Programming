package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet04;

import bwi.prog.utils.TextIO;


public class Calendars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*------------------------- BASICS ----------------------*/
	/**
	 * returns true if year is a leap year, false otherwise (see LeapTester for
	 * details)
	 * 
	 * @param year
	 * @return
	 */
	public static boolean isLeap(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}

	/**
	 * returns the number of days in month of year, or -1 if date is invalid.
	 */
	public static int daysInMonth(int year, int month) {
		if (!checkDate(year, month))
			return -1;

		if (year == 1582 && month == 10)
			return 16;

		if (month == 2)
			return (isLeap(year)) ? 29 : 28;
		if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
			return 30;
		return 31;

	}

	/**
	 * returns whether the given date actually exists/existed returns true if
	 * date is valid, false otherwise the earliest valid date is Oct. 16th 1582,
	 * the last date accepted is Dec, 31st, 2199.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static boolean checkDate(int year, int month, int day) {
		if (year == 1582 && month == 10) {
			if (day <= 15)
				return false;
			else if (day <= 31)
				return true;
		}

		return checkDate(year, month) && day > 0
				&& day <= daysInMonth(year, month);
	}

	public static boolean checkDate(int year, int month) {
		if (year == 1582 && month < 10)
			return false;
		return checkDate(year) && (month >= 1) && (month <= 12);
	}

	/**
	 * returns whether the given year is in the accepted range or exists at all
	 * returns true if year is valid, false otherwise the earliest valid date is
	 * Oct. 16th 1582, the last date accepted is Dec, 31st, 2199.
	 * 
	 * @param year
	 * @return
	 */
	public static boolean checkDate(int year) {
		if (year < 1582 || year > 2199)
			return false;
		return true;
	}

	/*------------------------- INPUT ----------------------*/
	/**
	 * scans an int value in a specified range and returns that value. keeps
	 * asking for input until value entered lies within range. The lowest value
	 * accepted is lower, the highest value accepted is upper. The accepted
	 * value is returned.
	 * 
	 * @param lower
	 * @param upper
	 * @return
	 */
	public static int scanIntInRange(int b1, int b2) {
		int input, lower, upper;
		if (b1 < b2) {
			lower = b1;
			upper = b2;
		} else {
			lower = b2;
			upper = b1;
		}
		do {
			input = TextIO.getInt();
			if (input < lower) {
				TextIO.putf("too low!");
				continue;
			}
			if (input > upper) {
				TextIO.putf("too high!");
				continue;
			}
			return input;
		} while (true);

	}

	/**
	 * scans a valid year and returns it. always returns a year in the allowed
	 * range (See checkDate for allowed range)
	 * 
	 * @return
	 */
	public static int scanYear() {
		TextIO.putf("enter year (%d-%d): ", 1582, 2199);
		return scanIntInRange(1582, 2199);
	}

	/**
	 * scans a valid month for given year and returns it. Always returns a month
	 * in the allowed range. (See checkDate for allowed range)
	 * 
	 * @param year
	 * @return
	 */
	public static int scanMonth(int year) {
		if (!checkDate(year))
			return -1;
		TextIO.putf("enter month (%d-%d): ", (year == 1582) ? 10 : 1, 12);
		return scanIntInRange((year == 1582) ? 10 : 1, 12);
	}

	/**
	 * scans a valid day for given year and month. Always returns a day in the
	 * allowed range. (See checkDate for allowed range)
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int scanDay(int year, int month) {
		if (!checkDate(year, month))
			return -1;
		if (year == 1582 && month==10) {
			TextIO.putf("enter day (%d-%d): ", 16,31);
			return scanIntInRange(16,31);
		}
		TextIO.putf("enter day (%d-%d): ", 1, daysInMonth(year, month));
		return scanIntInRange(1, daysInMonth(year, month));

	}

	/*------------------------- CALCULATIONS ----------------------*/

	/**
	 * calculates the weekday of a given date.
	 * 
	 * The date is passed to the function as three ints. returns the weekday
	 * according to Table 1 in Weekdays exercise or -1, if date is invalid,
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static int ymd2w(int year, int month, int day) {
		if (!checkDate(year, month, day))
			return -1;
		int y = year, c, d = day, m;

		if (month < 3) {
			y--;
			month += 10;
		} else {
			month -= 2;
		}
		m = month;

		c = y / 100;
		y = y % 100;

		int A = d + (int) (2.6 * m - 0.2) + y + (y / 4) + (c / 4) - 2 * c;
		int W = A % 7;

		if (W < 0)
			W += 7;
		return W;

	}

	/**
	 * calculates the day count of a given date
	 * 
	 * returns the day count, or -1 if the given date is invalid. The day count
	 * is the number of days passed since the start of the year plus one. E.g.:
	 * Jan, 1st is day 1 in any year; Dec. 31st is day 365 in a non-leap year
	 * and day 366 in a leap year.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static int dayNumber(int year, int month, int day) {
		if (!checkDate(year, month, day))
			return -1;
		int cnt = day;
		int i = 1;
		if (year == 1582 && month == 10)
			return day - 15;
		if (year == 1582)
			i = 10;

		for (; i < month; i++)
			cnt += daysInMonth(year, i);
		return cnt;
	}

	/**
	 * returns the week number of a given date, or -1 if date is invalid.
	 * 
	 * Week 1 in any year is the week of Jan, 1st, weeks start on Mondays (note:
	 * this is in contrast to the week counting method defined in ISO, where
	 * week one of a year is set to be the week of the first Thursday of the
	 * year.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static int weekNumber(int year, int month, int day) {
		if (!checkDate(year, month, day))
			return -1;

		int dayCount = dayNumber(year, month, day);
		int fd = 1, fm = 1; // first day, first month (jan 1st)
		if (year == 1582) { // in 1582 first day is oct 16th
			fd = 16;
			fm = 10;
		}

		int daysInFirstWeek = (7 - ymd2w(year, fd, fm)) % 7 + 1;

		int daysInCurrentWeek = (dayCount - daysInFirstWeek) % 7;
		int weeknumber = (dayCount - daysInFirstWeek) / 7 + 1
				+ ((daysInCurrentWeek <= 0) ? 0 : 1);
		// TextIO.putln(dayCount + " " + daysInFirstWeek + " " +
		// daysInCurrentWeek
		// + " " + weeknumber);
		return weeknumber;

	}

	/*------------------------- OUTPUT ----------------------*/
	/**
	 * prints the name of day
	 * 
	 * 
	 * The name of a day is given in Table 1 in Exercise Weekdays. prints
	 * invalid day if day is not in the range 0-6. The output produced contains
	 * no whitespace or other additional characters before or after the name.
	 * The names are the full English names, e.g. “Monday”, “Friday”…
	 * 
	 * @param day
	 */
	public static void printDay(int day) {
		TextIO.put(dayName(day));
	}

	/**
	 * returns a String representation of weekday number w.
	 * 
	 * The name of a day is given in Table 1 in Exercise Weekdays. The names are
	 * the full English names, e.g. “Monday”, “Friday” Returns invalid day, if w
	 * is out of range 0-6.
	 * 
	 * @param w
	 * @return
	 */
	public static String dayName(int w) {
		switch (w) {
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		default:
			return "invalid day (" + w + ")";
		}
	}

	/**
	 * prints the three-letter name of a day
	 * 
	 * same as void printDay(int day) but prints three-letter names of days in
	 * English. E.g. “Mon”, “Fri”,…
	 * 
	 * @param day
	 */
	public static void printDayShort(int day) {
		TextIO.put(dayShortName(day));
	}

	/**
	 * 
	 * returns a three-letter String representation of weekday number w
	 * 
	 * same as dayName but returns three-letter names of days in English. Eg.
	 * “Mon”, Fri”,…
	 * 
	 * @param w
	 * @return
	 */
	public static String dayShortName(int w) {
		switch (w) {
		case 0:
			return "Sun";
		case 1:
			return "Mon";
		case 2:
			return "Tue";
		case 3:
			return "Wed";
		case 4:
			return "Thu";
		case 5:
			return "Fri";
		case 6:
			return "Sat";
		default:
			return "invalid day (" + w + ")";
		}
	}

	/**
	 * 
	 * @param month
	 * @return
	 */
	public static String monthName(int month) {
		switch (month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return "invalid month (" + month + ")";
		}
	}

	/**
	 * prints the name of month.
	 * 
	 * The months accepted are in the range 1-12, 1 being January. The output
	 * produced contains no whitespace or other additional characters before or
	 * after the name. The names are the full English names, e.g. “January”,
	 * “February”… If month is out of range, the function prints invalid month
	 * (m), where m is substituted with the value of month passed to the
	 * function.
	 * 
	 * @param month
	 */
	public static void printMonth(int month) {
		TextIO.put(monthName(month));
	}

	public static void printMonthShort(int month) {
		TextIO.put(monthShortName(month));
	}

	public static String monthShortName(int month) {
		switch (month) {
		case 1:
			return "Jan";
		case 2:
			return "Feb";
		case 3:
			return "Mar";
		case 4:
			return "Apr";
		case 5:
			return "May";
		case 6:
			return "Jun";
		case 7:
			return "Jul";
		case 8:
			return "Aug";
		case 9:
			return "Sep";
		case 10:
			return "Oct";
		case 11:
			return "Nov";
		case 12:
			return "Dec";
		default:
			return "invalid month (" + month + ")";
		}
	}

	public static void printDate(int year, int month, int day) {
		TextIO.put(dateString(year, month, day));
	}

	public static String dateString(int year, int month, int day) {
		if (!checkDate(year, month, day)) {
			return String.format("invalid date (%d/%d/%d)", year, month, day);
		}
		return String.format("%s, %s %d%s %d",
				dayName(ymd2w(year, month, day)), monthName(month), day,
				numberEnding(day), year);
	}

	public static String numberEnding(int n) {
		if (n % 10 == 1 && n != 11)
			return "st";
		if (n % 10 == 2 && n != 12)
			return "nd";
		if (n % 10 == 3 && n != 13)
			return "rd";
		return "th";
	}

	public static void printStatistics(int year, int month, int day) {
		if (!checkDate(year, month, day)){
			printDate(year, month, day);
			return;
		}
		TextIO.put("statistics for\n");
		printDate(year, month, day);
		TextIO.putf("\n%d is %sa leap year\n", year, isLeap(year) ? "" : "not ");
		
		TextIO.putf("%s %d has %d days\n", monthName(month), year, daysInMonth(year, month));
		TextIO.putf("it is day %d of year %d\n", dayNumber(year, month, day),
				year);
		TextIO.putf("it is in week %d of year %d\n",
				weekNumber(year, month, day), year);
	}

	/*------------------------- APPLICATIONS ----------------------*/
	/**
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public static void printCalendar(int year, int month, int day) {
		printCalendar(year, month, day, false);
	}

	/**
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param highlight
	 */
	public static void printCalendar(int year, int month, int day,
			boolean highlight) {
		if (!checkDate(year, month) || (year!=1582 && !checkDate(year, month,day ))){
			printDate(year, month, day);
			return;
		}
		
		int fd, ld; // first day, last day
		if (year == 1582 && month == 10) { // in oct 1582 first day is 16th
			fd = 16;
			ld = 31; // in oct 1582 last day is oct 31st
		} else {
			fd = 1;
			ld = daysInMonth(year, month); // ld
		}

		int n = ((ymd2w(year, month, fd) + 6) % 7) + 1;
		TextIO.putf("%s %d\n", monthName(month), year); // TODO
		TextIO.putln("Mon Tue Wed Thu Fri Sat Sun ");
		int i;
		for (i = 1; i < n; i++)
			TextIO.put("    ");

		for (int j = fd; j <= ld; i++) {
			if (highlight && j == day)
				TextIO.putf("<%2d>", j++);
			else
				TextIO.putf("%3d ", j++);
			if (i % 7 == 0) {
				// TextIO.put(weekNumber(year, month, j));
				TextIO.putln();
			}
		}
		if (i % 7 != 1)TextIO.putln();

	}

	public static void go() {
		// TODO Auto-generated method stub
		
	}
}
