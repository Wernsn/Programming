package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet01;

import bwi.prog.utils.TextIO;

public class TimeCalculator {

	public static void main(String[] args) {

		long ms = 0L;

		TextIO.putln("Welcome to the TimeCalculator!");
		TextIO.put("please enter a duration in milliseconds:");
		ms = TextIO.getLong();
		TextIO.putf("%d ms are exactly:\n", ms);

		long d = ms / 86400000;
		long h = (ms % 86400000) / 3600000;
		long m = (ms % 3600000) / 60000;
		long s = (ms % 60000) / 1000;
		long mr = (ms % 1000);

		TextIO.putf(
				"   days %d\n  hours %d\nminutes %d\nseconds %d\n     ms %d\n",
				d, h, m, s, mr);

	}

}
