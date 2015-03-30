package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05;

import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions.compare;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.EventFunctions.compare;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.EventFunctions.display;
import static bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.EventFunctions.scanEvent;
import bwi.prog.utils.TextIO;
//importing all functions 

public class EventFunctionsTester {

	private static final int SCAN_EVENT = 1;

	private static final int COMPARE = 5;

	private static final int COMPARE_NULL = 6;

	private static final int DISPLAY = 7;

	public static void main(String[] args) {
		go();

	}

	public static void go() {
		while (true) {
			Event e1 = new Event(), e2 = new Event();
			int op = TextIO.getInt();
			
			switch (op) {
			case SCAN_EVENT:
				TextIO.put("scanEvent: ");
				e1 = scanEvent();
				TextIO.putf("|%s|%s|%d||\n", e1.title,
						DateFunctions.dateString(e1.date), e1.n);
				break;
			case COMPARE:
				TextIO.put("compare: ");
				TextIO.putln(compare(scanEvent(), scanEvent(), TextIO.getInt()));
				break;
				
			case COMPARE_NULL:
				int n;
				TextIO.put("compare null: ");
				TextIO.putln(compare(null, e1=scanEvent(), n=TextIO.getInt()));
				TextIO.putln(compare(null, null, n));
				TextIO.putln(compare(e1,null, n));
				break;
				
			case DISPLAY:
				TextIO.put("display: ");
				display(null);
				display(e1=scanEvent(), n=TextIO.getInt());
				display(null, n);
				
				break;
			default:
				return;
			}

		}
	}

}
