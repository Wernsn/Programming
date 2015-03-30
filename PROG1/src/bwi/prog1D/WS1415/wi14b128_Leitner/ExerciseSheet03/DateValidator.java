package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class DateValidator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextIO.putln("enter date (yyyymmdd)");
		int date = TextIO.getInt();

		// 2222.33.44
		int day = date % 100; // get last 2 numbers
		int month = date % 10000; // last 4 numbers
		month = month / 100; // last 4 number & delete last 2
		int year = date / 10000; // delete last 4 numbers

		if (date >= 15821016 && date <= 21001231) {
			// MONTH-----------------------------------
			if (month >= 1 && month <= 12) {
				// DAY--------------------------------
				if (day >= 1 && day <= 31) {
					// LEAPDAY
					if (day == 29 && month == 2) {

						if ((year % 100) == 0 && (year % 400) == 0) {
							TextIO.putln("valid date");
						} else if ((year % 100) == 0) {
							TextIO.putln("invalid day (" + day + ")");
						} else if ((year % 4) == 0) {
							TextIO.putln("valid date");
						} else {
							TextIO.putln("invalid day (" + day + ")");
						}
					}
					// FEBRUARY
					else if (day <= 28 && month == 2) {
						TextIO.putln("valid date");
					}
					// 31 DAYS
					else if (day <= 31) {
						if (month == 1 || month == 3 || month == 5
								|| month == 7 || month == 8 || month == 10
								|| month == 12) {
							TextIO.putln("valid date");
						} else {
							TextIO.putln("invalid day (" + day + ")");
						}
					} else {
						if (month == 4 || month == 6 || month == 9
								|| month == 11) {
							TextIO.putln("valid date");
						} else {
							TextIO.putln("invalid day (" + day + ")");
						}
					}
				} else {
					TextIO.putln("invalid day (" + day + ")");
				}

				// MONTH-----------------
			} else {
				TextIO.put("invalid month (" + month + ")");
			}

			// 20001301
		} else if (date < 15821016) {
			TextIO.put("invalid date (must be after 15821015)");
		} else if (date > 21010101) {
			TextIO.put("invalid date (must be before 21010101)");
		} else {
			TextIO.put("invalid date (must be before 21010101)");
		}

	}

}
