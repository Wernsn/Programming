package bwi.prog1D.WS1415.wi14b128_Leitner.LabWork01;

import bwi.prog.utils.TextIO;

public class TwoPersonDataBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int opcode = 0;
		String firstname1 = "";
		String lastname1 = "";
		String firstname2 = "";
		String lastname2 = "";
		int date1 = 0;
		int date2 = 0;
		String weekday1 = "";
		String weekday2 = "";
		int id1 = 0;
		int id2 = 0;
		Boolean input1 = false;
		Boolean input2 = false;
		String f1 = "";
		Boolean f1b = true;
		String f2 = "";
		Boolean f2b = true;
		String l1 = "";
		Boolean l1b = true;
		String l2 = "";
		Boolean l2b = true;
		Boolean d1b;
		Boolean d2b; 
		
		

		TextIO.putln("Welcome to TwoPersonDataBase!");

		do {

			TextIO.putln("\navailable options:\n1) enter data of person1\n2) enter data of person2\n3) list by firstname\n4) list by lastname\n5) list by age\n0) quit");
			TextIO.put("your choice: ");

			opcode = TextIO.getInt();

			switch (opcode) {

			case 0:
				break;

			case 1:

				id1 = 1;
				do {
					TextIO.put("enter firstname (1)");
					f1 = TextIO.getlnWord();

					if (f1.equals("-")) {
						if (firstname1.equals("")) {
							TextIO.putln("cannot keep old name!");
						} else {
							f1b = false;
						}
					} else {
						firstname1 = f1;
						f1b = false;
					}

				} while (f1b);

				do {
					TextIO.put("enter lastname (1)");
					l1 = TextIO.getlnWord();

					if (l1.equals("-")) {
						if (lastname1.equals("")) {
							TextIO.putln("cannot keep old name!");
						} else {
							l1b = false;
						}
					} else {
						lastname1 = l1;
						l1b = false;
					}

				} while (l1b);

				// weekdays

				do {
					d1b = true;
					TextIO.put("please enter date of birth (1) (yyyymmdd)");
					date1 = TextIO.getInt();

					if (date1 < 15821016) {
						TextIO.putln("invalid date (must be after 15821015)");
						d1b = true;

					} else if (date1 > 21001231) {
						TextIO.putln("invalid date (must be before 21010101)");
						d1b = true;

					} else { // range ok.
						int inDay = date1 % 100, inMonth = date1 % 10000 / 100, inYear = date1 / 10000;
						boolean isLeap = ((inYear % 4 == 0) && (inYear % 100 != 0 || inYear % 400 == 0));

						if (inMonth < 1 || inMonth > 12) {
							TextIO.putf("invalid month (%d)\n", inMonth);
							d1b = true;

						} else { // month ok

							int nDays = 0;
							switch (inMonth) {

							case 2:
								if (isLeap)
									nDays = 29;
								else
									nDays = 28;
								break;
							case 4:
							case 6:
							case 9:
							case 11:
								nDays = 30;
								break;
							default:
								nDays = 31;
								break;

							}
							if (inDay < 1 || inDay > nDays) {
								TextIO.putf("invalid day (%d)\n", inDay);

							} else { // date ok
								
								d1b = false;

								int d = inDay;
								int yy = inYear;
								if (inMonth < 3)
									yy--;
								int m = (inMonth + 9) % 12 + 1;
								int y = yy % 100;
								int c = yy / 100;

								int A = d + (int) (2.6 * m - 0.2) + y
										+ (int) (y / 4) + (int) (c / 4) - 2 * c;
								int W = ((A % 7) + 7) % 7;

								switch (W) {
								case 0:
									weekday1 = "Sunday";
									break;
								case 1:
									weekday1 = "Monday";
									break;
								case 2:
									weekday1 = "Tuesday";
									break;
								case 3:
									weekday1 = "Wednesday";
									break;
								case 4:
									weekday1 = "Thursday";
									break;
								case 5:
									weekday1 = "Friday";
									break;
								case 6:
									weekday1 = "Saturday";
									break;

								}
								
							}

						}
					}

				} while (d1b); // WEEKDAYS END

				input1 = true;

				break;

			case 2:

				id2 = 2;

				do {
					TextIO.put("enter firstname (2)");
					f2 = TextIO.getlnWord();

					if (f2.equals("-")) {
						if (firstname2.equals("")) {
							TextIO.putln("cannot keep old name!");
						} else {
							f2b = false;
						}
					} else {
						firstname2 = f2;
						f2b = false;
					}

				} while (f2b);

				do {
					TextIO.put("enter lastname (2)");
					l2 = TextIO.getlnWord();

					if (l2.equals("-")) {
						if (lastname2.equals("")) {
							TextIO.putln("cannot keep old name!");
						} else {
							l2b = false;
						}
					} else {
						lastname2 = l2;
						l2b = false;
					}

				} while (l2b);

				// weekdays

				do {
					d2b = true;
					TextIO.put("please enter date of birth (2) (yyyymmdd)");
					date2 = TextIO.getInt();

					if (date2 < 15821016) {
						TextIO.putln("invalid date (must be after 15821015)");
						d2b = true;
					}
					else if (date2 > 21001231) {
						TextIO.putln("invalid date (must be before 21010101)");
						d2b = true;
						
					} else { // range ok.
						int inDay = date2 % 100, inMonth = date2 % 10000 / 100, inYear = date2 / 10000;
						boolean isLeap = ((inYear % 4 == 0) && (inYear % 100 != 0 || inYear % 400 == 0));

						if (inMonth < 1 || inMonth > 12) {
							TextIO.putf("invalid month (%d)\n", inMonth);
							d2b = true;
							
						} else { // month ok

							int nDays = 0;
							switch (inMonth) {

							case 2:
								if (isLeap)
									nDays = 29;
								else
									nDays = 28;
								break;
							case 4:
							case 6:
							case 9:
							case 11:
								nDays = 30;
								break;
							default:
								nDays = 31;
								break;

							}
							if (inDay < 1 || inDay > nDays) {
								TextIO.putf("invalid day (%d)\n", inDay);
								
							} else { // date ok

								int d = inDay;
								int yy = inYear;
								if (inMonth < 3)
									yy--;
								int m = (inMonth + 9) % 12 + 1;
								int y = yy % 100;
								int c = yy / 100;

								int A = d + (int) (2.6 * m - 0.2) + y
										+ (int) (y / 4) + (int) (c / 4) - 2 * c;
								int W = ((A % 7) + 7) % 7;

								switch (W) {
								case 0:
									weekday2 = "Sunday";
									break;
								case 1:
									weekday2 = "Monday";
									break;
								case 2:
									weekday2 = "Tuesday";
									break;
								case 3:
									weekday2 = "Wednesday";
									break;
								case 4:
									weekday2 = "Thursday";
									break;
								case 5:
									weekday2 = "Friday";
									break;
								case 6:
									weekday2 = "Saturday";
									break;
								}
								d2b = false;
							}

						}
					}

				} while (d2b); // WEEKDAYS END

				input2 = true;

				break;

			case 3:

				if (input1 && input2) {
					if (firstname1.compareTo(firstname2) < 0) {
						TextIO.putf(
								"\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
								id1, firstname1, lastname1, weekday1,
								date1 % 10000 / 100, date1 % 100, date1 / 10000);
						TextIO.putf(
								"\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
								id2, firstname2, lastname2, weekday2,
								date2 % 10000 / 100, date2 % 100, date2 / 10000);
					} else {
						TextIO.putf(
								"\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
								id2, firstname2, lastname2, weekday2,
								date2 % 10000 / 100, date2 % 100, date2 / 10000);
						TextIO.putf(
								"\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
								id1, firstname1, lastname1, weekday1,
								date1 % 10000 / 100, date1 % 100, date1 / 10000);
					}
				} else if (input1 && !input2) {

					TextIO.putf("\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
							id1, firstname1, lastname1, weekday1,
							date1 % 10000 / 100, date1 % 100, date1 / 10000);
				} else if (!input1 && input2) {

					TextIO.putf("\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
							id2, firstname2, lastname2, weekday2,
							date2 % 10000 / 100, date2 % 100, date2 / 10000);
				} else {
					TextIO.putln("no entries yet.");
				}

				break;

			case 4:

				if (input1 && input2) {
					if (lastname1.compareTo(lastname2) < 0) {
						TextIO.putf(
								"\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
								id1, lastname1, firstname1, weekday1,
								date1 % 10000 / 100, date1 % 100, date1 / 10000);
						TextIO.putf(
								"\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
								id2, lastname2, firstname2, weekday2,
								date2 % 10000 / 100, date2 % 100, date2 / 10000);
					} else {
						TextIO.putf(
								"\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
								id2, lastname2, firstname2, weekday2,
								date2 % 10000 / 100, date2 % 100, date2 / 10000);
						TextIO.putf(
								"\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
								id1, lastname1, firstname1, weekday1,
								date1 % 10000 / 100, date1 % 100, date1 / 10000);
					}
				} else if (input1 && !input2) {

					TextIO.putf("\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
							id1, lastname1, firstname1, weekday1,
							date1 % 10000 / 100, date1 % 100, date1 / 10000);
				} else if (!input1 && input2) {

					TextIO.putf("\n%d: %-10.10S %-10.10S %9s, %02d/%02d/%4d",
							id2, lastname2, firstname2, weekday2,
							date2 % 10000 / 100, date2 % 100, date2 / 10000);
				} else {
					TextIO.putln("no entries yet.");
				}

				break;

			case 5:

				if (input1 && input2) {
					if (date1 >= date2) {
						TextIO.putf(
								"\n%d: %9s, %02d/%02d/%4d %-10.10S %-10.10S",
								id1, weekday1, date1 % 10000 / 100,
								date1 % 100, date1 / 10000, firstname1,
								lastname1);
						TextIO.putf(
								"\n%d: %9s, %02d/%02d/%4d %-10.10S %-10.10S",
								id2, weekday2, date2 % 10000 / 100,
								date2 % 100, date2 / 10000, firstname2,
								lastname2);
					} else {
						TextIO.putf(
								"\n%d: %9s, %02d/%02d/%4d %-10.10S %-10.10S",
								id2, weekday2, date2 % 10000 / 100,
								date2 % 100, date2 / 10000, firstname2,
								lastname2);
						TextIO.putf(
								"\n%d: %9s, %02d/%02d/%4d %-10.10S %-10.10S",
								id1, weekday1, date1 % 10000 / 100,
								date1 % 100, date1 / 10000, firstname1,
								lastname1);
					}
				} else if (input1 && !input2) {

					TextIO.putf("\n%d: %9s, %02d/%02d/%4d %-10.10S %-10.10S",
							id1, weekday1, date1 % 10000 / 100, date1 % 100,
							date1 / 10000, firstname1, lastname1);
				} else if (!input1 && input2) {

					TextIO.putf("\n%d: %9s, %02d/%02d/%4d %-10.10S %-10.10S",
							id2, weekday2, date2 % 10000 / 100, date2 % 100,
							date2 / 10000, firstname2, lastname2);
				} else {
					TextIO.putln("no entries yet.");
				}

				break;

			default:
				TextIO.put("illegal option (" + opcode + ")\n");
			}

		} while (opcode != 0);
		{
			TextIO.put("Thank you for using TwoPersonDataBase");
		}

	}

}
