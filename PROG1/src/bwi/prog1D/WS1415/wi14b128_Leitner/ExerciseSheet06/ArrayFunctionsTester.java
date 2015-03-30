package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet06;

import bwi.prog.utils.TextIO;
import bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.Event;
import bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.EventFunctions;


public class ArrayFunctionsTester{

	private static final int LINEAR_FILL = 1;
	private static final int CONTAINS = 2;
	private static final int COUNT_BELOW = 3;
	private static final int FIND_1 = 4;
	private static final int FIND_2 = 5;
	private static final int FILTER = 6;
	private static final int SORT_1 = 7;
	private static final int SORT_2 = 8;

	public static void main(String[] args) {
		go();

	}

	public static void go() {
		double[] dArr = null;
		int[][] iArr2 = { { 0 }, { 10, 11 }, { 20, 21, 22 },
				{ 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 },
				{ 5, 8, 58, 85, 5, 8, 8, 5, 8, 5 },{900,800,700,600,500,400,300,200,100} };
		Item[] items = null;
		Event[] events=null;

		while (true) {

			int choice = TextIO.getInt();
			int n;
			switch (choice) {
			case LINEAR_FILL:
				TextIO.putln("LinearFill");
				ArrayFunctions.linearFill(dArr = new double[TextIO.getInt()],
						TextIO.getDouble(), TextIO.getDouble());
				display(dArr);
				continue;

			case CONTAINS:
				TextIO.putln("contains: "
						+ ArrayFunctions.contains(iArr2, n = TextIO.getInt())
						+ " (" + n + ")");
				continue;

			case COUNT_BELOW:
				TextIO.putln("CountBelow");
				items = new Item[TextIO.getInt()];
				for (int i = 0; i < items.length; i++) {
					Item it = new Item();
					TextIO.put("description: ");
					while ((it.description = TextIO.getln()).equals(""))
						;
					TextIO.put("price: ");
					it.price = TextIO.getInt();
					items[i] = it;
				}
				TextIO.putf("%d",
						ArrayFunctions.countBelow(items, TextIO.getInt()));

				continue;

			case FIND_1:
				TextIO.putln("find 1: "
						+ ArrayFunctions.find(iArr2[3], n = TextIO.getInt())
						+ " (" + n + ")");
				continue;

			case FIND_2:
				TextIO.putln("find 2: "
						+ ArrayFunctions.find(iArr2[4], n = TextIO.getInt(),
								TextIO.getInt()) + " (" + n + ")");
				continue;

			case FILTER:
				TextIO.putln("Filter");
				items = new Item[TextIO.getInt()];
				for (int i = 0; i < items.length; i++) {
					Item it = new Item();
					TextIO.put("description: ");
					while ((it.description = TextIO.getln()).equals(""))
						;
					TextIO.put("price: ");
					it.price = TextIO.getInt();
					items[i] = it;
				}
				display(items);
				display(ArrayFunctions.filter(items, TextIO.getInt()));

				continue;

			case SORT_1:
				TextIO.put("sort 1: ");
				for(int[] a:iArr2){
					ArrayFunctions.sort(a);
					display(a);
				}
				continue;
				
			case SORT_2:
				TextIO.putln("sort 2: ");
				events = new Event[TextIO.getInt()];
				for (int i = 0; i < events.length; i++) {
					events[i] = EventFunctions.scanEvent();
				}
				display(events);
				ArrayFunctions.sort(events, TextIO.getInt());
				display(events);
				
				continue;
	
				
				
				
			}
			break;
		}

	}

	public static void display(Item[] items) {
		TextIO.put("[\n");
		for (Item i : items)
			TextIO.putf("[%5.5s|%5d]\n", i.description, i.price);
		TextIO.putln("]");

	}

	public static void display(double[] d) {
		TextIO.put("[");
		for (double i : d)
			TextIO.putf("%.2f ", i);
		TextIO.putln("]");
	}

	public static void display(int[] d) {
		TextIO.put("[");
		for (int i : d)
			TextIO.putf("%3d ", i);
		TextIO.putln("]");
	}

	public static void display(Event[] d) {
		TextIO.putln("[");
		for (Event i : d)
			EventFunctions.display(i);
		TextIO.putln("]");

	}

}
