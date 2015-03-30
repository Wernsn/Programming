package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05;

import bwi.prog.utils.TextIO;


public class EventFunctions {

	public static void main(String[] args) {
		Event e = scanEvent();
		display(e);
	}

	/**
	 * prompts the user for all information required (until complete and valid)
	 * and returns an Event object
	 * 
	 * @return
	 */

	public static Event scanEvent() {
		Event tmp = new Event();
		TextIO.put("enter title: ");
	
		while( (tmp.title = TextIO.getln()).equals(""));
		tmp.date = DateFunctions.scanDate();
		do {
			TextIO.put("enter number of attendees: ");
			tmp.n = TextIO.getInt();
			if (tmp.n < 0)
				TextIO.put("cannot be negative!");
		} while (tmp.n < 0);

		return tmp;
	}

	/**
	 * returns -1 if title of event1 goes before event2 lexicographically, 1 if
	 * the other way round, 0 if they are the same. You can use
	 * someString.compareTo(otherString) for lexicographic comparison of two
	 * Strings. Note: any two null-events are equal and any null-event goes
	 * before any non-null event.
	 */
	public static int compareByTitle(Event event1, Event event2) {
		if (event1 == null && event2 == null)
			return 0;
		if (event1 == null)
			return -1;
		if (event2 == null)
			return 1;

		int res=event1.title.compareTo(event2.title);
		if(res<0) return -1;
		else if (res>0) return 1;
		return 0;

	}

	/**
	 * compares two events by number of attendees
	 * 
	 * returns -1 if the number of attendees of event1 is lower than of event2,
	 * 1 if the other way round, 0 if they are the same. Note: any two
	 * null-events are equal and any null-event goes before any non-null event.
	 */
	public static int compareByAttendees(Event event1, Event event2) {
		if (event1 == null && event2 == null)
			return 0;
		if (event1 == null)
			return -1;
		if (event2 == null)
			return 1;

		int diff = event1.n - event2.n;
		if (diff < 0)
			return -1;
		else if (diff > 0)
			return 1;
		else
			return 0;

	}

	/**
	 * compares two events by date returns -1 if event1 is before event2, 1 if
	 * the other way round, 0 if they are the same. Note: any two null-events
	 * are equal and any null-event goes before any non-null event.
	 * 
	 * @param event1
	 * @return
	 */
	public static int compareByDate(Event event1, Event event2) {
		if (event1 == null && event2 == null)
			return 0;
		if (event1 == null)
			return -1;
		if (event2 == null)
			return 1;

		return DateFunctions.compare(event1.date, event2.date);

	}

	/**
	 * compares e1 to e2 for given order
	 * 
	 * \li o order 1 stands for comparison by Title o order 2 stands for
	 * comparison by date o order 3 stands for comparison by number of attendees
	 * returns -1 if e1 is before e2 (for given order), 1 if the other way round
	 * and 0 if they are equal in the sense defined by order. Note: any two
	 * null-events are equal and any null-event goes before any non-null event.
	 * 
	 * @param e1
	 * @param e2
	 * @param order
	 * @return
	 */
	public static int compare(Event e1, Event e2, int order) {
		switch (order) {
		case 1:
			return compareByTitle(e1, e2);
		case 2:
			return compareByDate(e1, e2);
		case 3:
			return compareByAttendees(e1, e2);
		default:
			return 0;
		}
	}

	/**
	 * 
	 * produces a one-line output of event.
	 * 
	 * 
	 * The data of an event is displayed as <br>
	 * &lttitle&gt, &ltdate&gt, &ltn&gt <br>
	 * where
	 * <ul>
	 * <li>title is maximum 30 character wide,
	 * <li>date is displayed as in DateFunctions.dateString
	 * <li>and n is an integer <br>
	 * </ul>
	 * Examples:
	 * <ul>
	 * <li>BWI kick-off event, Monday, December 31st 2012, 33
	 * <li>title that is too lo, Sunday, January 1st 2012, 1
	 * <li>lecture, Tuesday, February 28th 2012, 12
	 * </ul>
	 * <br>
	 * This function prints invalid event if event is null. <br>
	 * This function prints a newline character at the end of line.
	 */
	public static void display(Event event) {
		if (event == null){
			TextIO.putln("invalid event\n");
			return;
		}
		TextIO.putf("%.30s, %s, %d\n", event.title,
				DateFunctions.dateString(event.date), event.n);
	}

	/**
	 * produces a one-line String representation of event
	 * 
	 * The data of an event is represented in the following format <br>
	 * &ltdate&gt, &lttitle&gt, &ltn&gt <br>
	 * where
	 * <ul>
	 * <li>date is displayed as in DateFunctions.dateString
	 * <li>title is maximum 30 character wide,
	 * <li>and n is an integer <br>
	 * </ul>
	 * Examples:
	 * <ul>
	 * <li>Monday, December 31st 2012, BWI kick-off event, 33
	 * <li>Sunday, January 1st 2012, title that is too lo, 1
	 * <li>Tuesday, February 28th 2012, lecture, 12
	 * </ul>
	 * <br>
	 * This function returns invalid event if event is null. <br>
	 * 
	 * @param event
	 * @return
	 */
	public static String dateFirstString(Event event) {
		if (event == null)
			return String.format("invalid event\n");
		return String.format("%s, %.30s, %d\n",
				DateFunctions.dateString(event.date), event.title, event.n);
	}

	/**
	 * produces a one-line String representation of event
	 * 
	 * The data of an event is represented in the following format <br>
	 * &lttitle&gt, &ltn&gt <br>
	 * where
	 * <ul>
	 * <li>title is maximum 30 character wide,
	 * <li>and n is an integer <br>
	 * </ul>
	 * Examples:
	 * <ul>
	 * <li>BWI kick-off event, 33
	 * <li>title that is too lo, 1
	 * <li>lecture, 12
	 * </ul>
	 * <br>
	 * This function returns invalid event if event is null. <br>
	 * 
	 * @param event
	 * @return
	 */
	public static String noDateString(Event event) {
		if (event == null)
			return String.format("invalid event\n");
		return String.format("%.30s, %d\n", event.title, event.n);
	}

	/**
	 * prints event to the console in the specified format format 0 produces a
	 * dateFirst output, all other values produce a noDate output. This function
	 * prints invalid event if event is null.
	 * 
	 * @param event
	 * @param format
	 */
	public static void display(Event event, int format) {
		if (format==0) TextIO.putln(dateFirstString(event));
		else TextIO.putln(noDateString(event));
	}

}
