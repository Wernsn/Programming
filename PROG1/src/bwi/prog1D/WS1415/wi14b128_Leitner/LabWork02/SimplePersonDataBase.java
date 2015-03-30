package bwi.prog1D.WS1415.wi14b128_Leitner.LabWork02;

import java.util.Scanner;

import bwi.prog.utils.TextIO;
import bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions;

public class SimplePersonDataBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int opcode;
		int idcount = 1;
		int opcodeSet;
		int persSetting = 0;
		int dateSetting = 0;
		String persForm = "with ID";
		String dateForm = "numeric date";

		Person[] database = new Person[20];

		TextIO.putln("Welcome to the SimplePersonDatabase.");

		do {

			TextIO.putln("\n" + "available options:\n" + "1) list\n"
					+ "2) add\n" + "3) remove\n" + "4) sort\n" + "5) find\n"
					+ "6) settings\n" + "0) quit");
			TextIO.put("your choice: ");

			opcode = TextIO.getInt();

			switch (opcode) {
			case 0: break;
				
			case 1:
				if (database[0] != null) {
					SPDBFunctions.displayList(database, persSetting, dateSetting);
				} else
					TextIO.putln("\ndatabase empty.");
				break;

			case 2:
				if (database[database.length - 1] == null) {
					for (int i = 0; i < database.length; i++) {
						if (database[i] == null) {
							database[i] = SPDBFunctions.addPerson(); // <-- Eintragen in datenbank
							database[i].id = idcount;
							idcount++;
							break;
						}
					}
				} else {
					TextIO.putln("\ncannot add. database full");
				}
				break;

			case 3:
				if (database[0] != null) {
					TextIO.putln("enter ID of Person to be removed: ");
					int removeID = TextIO.getInt();
					SPDBFunctions.removePerson(database, removeID); // <-- Austragen aus datenbank
				} else
					TextIO.putln("\ncannot remove. database empty.");
				break;

			case 4:
				if (database[0] != null) {
					//TODO sort
					
				} else
					TextIO.putln("\nnothing to sort. database empty.");
				break;

			case 5:
				if (database[0] != null) {
					//TODO find
					
				} else
					TextIO.putln("\ncannot find. database empty.");
				break;
				
			case 6:
				do {
					TextIO.put("\n" + "current settings:\n" + "Person format: "
							+ persForm + "\n" + "  Date format: " + dateForm
							+ "\n" + "\navailable options:\n" + "0) return\n"
							+ "1) toggle Person format\n"
							+ "2) toggle Date format\n" + "your choice: ");
					opcodeSet = TextIO.getInt();
					switch (opcodeSet) {
					case 1:
						if (dateSetting == 0) {
							persForm = "without id";
							persSetting = 1;
						} else {
							persForm = "with ID";
							persSetting = 0;
						}
						break;
					case 2:
						if (dateSetting == 0) {
							dateForm = "long date";
							dateSetting = 1;
						} else {
							dateForm = "numeric date";
							dateSetting = 0;
						}
						break;
					case 0: 
						break;
					default: 
						TextIO.putln("illegal option.");
						break;
					}
				} while (opcodeSet != 0);
				break;

			case 99:
				//TextIO.putln("Hidden menu");
				

			default:
				TextIO.putln("\n"+"illegal option.");
				break;

			}

		} while (opcode != 0);
		{
			TextIO.putln("\n"+"Thank you for using the SimplePersonDatabase.\n");
		}

	}

}
