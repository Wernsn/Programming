package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet06;

import bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.Event;
import bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.EventFunctions;
import bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet06.Item;
import java.util.Arrays;

public class ArrayFunctions {
	public static void linearFill(double[] array, double start, double inc) {
		for (int i = 0; i < array.length; i++) {

			if (i == 0) {
				array[0] = start;

			} else {

				array[i] = array[i - 1] + inc;
			}
		}
	}

	public static boolean contains(int[][] array, int key) {
		boolean contain = false;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == key) {
					return contain = true;
				}
			}
		}
		return contain;
	}

	public static int countBelow(Item[] arr, int p) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].price < p) {
				count++;
			}
		}
		return count;
	}

	public static int find(int[] arr, int key) {
		int contain = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				contain = i;
				break;
			}
		}
		return contain;
	}

	public static int find(int[] arr, int key, int startIdx) {
		int contain = -1;
		int startIndex = startIdx;
		if (startIdx < 0) {
			startIndex = 0;
		}
		for (int i = startIndex; i < arr.length; i++) {

			if (arr[i] == key) {
				contain = i;
				break;
			}
		}
		return contain;
	}

	public static Item[] filter(Item[] arr, int upper) {
		// int next =0;
		int size = countBelow(arr, upper);

		Item[] arrTest = new Item[size];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].price < upper) {
				arrTest[i] = arr[i];
			}
		}
		return arrTest;

	}

	public static void sort(int[] numbers) {
		Arrays.sort(numbers);

	}

	public static void sort(Event[] numbers, int order) {
		boolean notSorted = true;
		Event temp = new Event();

		while (notSorted) {
			notSorted = false;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (EventFunctions.compare(numbers[i], numbers[i + 1] , order) > 0) {
					temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
					notSorted = true;
				}
			}
		}

		// Arrays.sort(numbers); break;

		/*
		 * public static void sort(Event[] numbers, int order) { int i; Event
		 * temp = new Event(); boolean finished = false; while (!finished) {
		 * finished = true; for (i = 0; i < numbers.length - 1; i++) { if
		 * (EventFunctions.compare(numbers[i], numbers[i + 1], order) == 1) {
		 * temp = numbers[i]; numbers[i] = numbers[i + 1]; numbers[i + 1] =
		 * temp; finished = false; } } }
		 */

	}

}
