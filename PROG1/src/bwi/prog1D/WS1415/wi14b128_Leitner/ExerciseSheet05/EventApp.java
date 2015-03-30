package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05;

import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.printCalendar;
import bwi.prog.utils.TextIO;

public class EventApp {

	private static final int BY_TITLE = 1;
	private static final int BY_DATE = 2;
	private static final int BY_ATTENDEES = 3;

	private static final int DEFAULT_FORMAT = 0;
	private static final int NO_DATE_FORMAT = 1;
	private static final int DATE_FIRST_FORMAT = 2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextIO.putln("Welcome to the EventApp");
		Event event1 = new Event(), event2 = new Event();
		int compareFormat = BY_TITLE;
		int format = DEFAULT_FORMAT;

		int input;
		do {

			TextIO.putln();
			TextIO.putln();

			if (format == DEFAULT_FORMAT) {
				TextIO.putf("event1: ");
				EventFunctions.display(event1);
				TextIO.putf("event2: ");
				EventFunctions.display(event2);
			} else if (format == NO_DATE_FORMAT) {
				TextIO.putf("event1: %s\n", EventFunctions.noDateString(event1));
				TextIO.putf("event2: %s\n", EventFunctions.noDateString(event2));
			} else {
				TextIO.putf("event1: %s\n",
						EventFunctions.dateFirstString(event1));
				TextIO.putf("event2: %s\n",
						EventFunctions.dateFirstString(event2));
			}
			TextIO.putf("\nplease enter opcode (9 for usage):");
			input = TextIO.getInt();
			while(TextIO.getAnyChar()!='\n');
			
			switch (input) {
			case 0:
				break;
			case 1:
					
				event1 = EventFunctions.scanEvent();
				break;
			case 2:
						
				event2 = EventFunctions.scanEvent();
				break;
			case 3:
				TextIO.putf("set event format: (1=no date, 2=date first)\n");
				int n = TextIO.getInt();
				if (n == 1)
					format = NO_DATE_FORMAT;
				else if (n == 2)
					format = DATE_FIRST_FORMAT;
				else
					format = DEFAULT_FORMAT;
				break;
			case 4:
				printCalendar(event1.date, true);
				break;
			case 5:
				printCalendar(event2.date, true);
				break;
			case 6:
				TextIO.putf("set highlighting: ((1=by title, 2=by date, 3=by attendees)\n");
				int nn = TextIO.getInt();
				if (nn == 2)
					compareFormat = BY_DATE;
				else if (nn == 3)
					compareFormat = BY_ATTENDEES;
				else
					compareFormat = BY_TITLE;
				break;
			case 7:
				int cmp = EventFunctions.compare(event1, event2, compareFormat);
				if (cmp < 0)
					bwi.prog.utils.TextIO.putf("event1 is before event2\n");
				else if (cmp > 0)
					bwi.prog.utils.TextIO.putf("event1 is after event2\n");
				else
					bwi.prog.utils.TextIO.putf("events are equal\n");
				break;

			case 9:
				TextIO.putf("\n\n1 enter event1" + "\n2 enter event2"
						+ "\n3 set event format"
						+ "\n4 display calendar for event1"
						+ "\n5 display calendar for event2"
						+ "\n6 set comparison" + "\n7 compare events"
						+ "\n0 exit" + "\n9 display this message\n\n");
				break;
			default:
				TextIO.putln("invalid op code");

			}

		} while (input != 0);
		TextIO.putln("Thank you for using the EventApp");

		
		String str="";
		while( (str = TextIO.getln()).equals(""));
				
	}

}
