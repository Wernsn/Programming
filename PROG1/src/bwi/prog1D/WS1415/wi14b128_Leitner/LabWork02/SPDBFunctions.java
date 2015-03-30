package bwi.prog1D.WS1415.wi14b128_Leitner.LabWork02;

import bwi.prog.utils.TextIO;
import bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions;

public class SPDBFunctions {

	public static Person addPerson() {
		Person person = new Person();
		do {
			TextIO.put("Firstname: ");
			person.firstname = TextIO.getlnWord();
		} while (person.firstname.equals(""));
		do {
			TextIO.put("Lastname: ");
			person.lastname = TextIO.getlnWord();
		} while (person.lastname.equals(""));

		person.dateOfBirth = DateFunctions.scanDate();

		return person;
	}

	public static void removePerson(Person[] database, int removeID) {
		if (removeID > 0) {
			for (int i = 0; i < database.length; i++) {
				if (database[i] != null) {
					if (database[i].id == removeID) {
						int tmp = i;
						
						for (int k = tmp; k < database.length - 1; k++){
							database[k] = database[k + 1];
						}
						database[database.length - 1] = null;
						TextIO.putln("1 Person removed.");
						
						return;
					}
				}
			}
			TextIO.putln("Person not found (ID " + removeID + ").");
		} else
			TextIO.putln("Person not found (ID " + removeID + ").");
	}

	public static void displayList(Person[] database, int persSetting,
			int dateSetting) {
		
		String birthdate;
		int stringMax = 0;
		int pers = 0;
		
		if (persSetting == 0) { // with iD
			if (dateSetting == 0) { // numberic Date
				TextIO.putf("\n" +
						"%-3s %-20.20s %-20.20s %s\n" +
						"", "ID", "Lastname",
						"Firstname", "Birth");
				for (int i = 0; i < database.length; i++) {
					if (database[i] != null) {
						birthdate = bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions
								.dateStringNumeric(database[i].dateOfBirth);
						if (birthdate.length() > stringMax){
							stringMax = birthdate.length();
						}
							
					}
				}
				
				printLine(68);
				
				for (int i = 0; i < database.length; i++) {
					if (database[i] != null) {
						birthdate = bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions
								.dateStringNumeric(database[i].dateOfBirth);
						TextIO.putf("%03d %-20.20s %-20.20s %s\n",
								database[i].id, database[i].lastname,
								database[i].firstname, birthdate);
						pers = i + 1;
					}
				}
				
				printLine(68);
				
				TextIO.putln(pers + " Person(s) in database, "
						+ (20 - pers) + " free.");
			} else { // long Date
				TextIO.putf("\n%-3s %-20.20s %-20.20s %s\n", "ID", "Lastname",
						"Firstname", "Birth");
				for (int i = 0; i < database.length; i++) {
					if (database[i] != null) {
						birthdate = bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions
								.dateString(database[i].dateOfBirth);
						if (birthdate.length() > stringMax){
							stringMax = birthdate.length();
						}
							
					}
				}
				
				printLine(47 + stringMax);
				
				for (int i = 0; i < database.length; i++) {
					if (database[i] != null) {
						birthdate = bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions
								.dateString(database[i].dateOfBirth);
						TextIO.putf("%03d %-20.20s %-20.20s %s\n",
								database[i].id, database[i].lastname,
								database[i].firstname, birthdate);
						pers = i + 1;
					}
				}
				
				printLine(47 + stringMax);
				
				TextIO.putln(pers + " Person(s) in database, "
						+ (20 - pers) + " free.");
			}
		} else { // without ID
			if (dateSetting == 0) {
				TextIO.putf("\n%-20.20s %-20.20s %s\n", "Lastname",
						"Firstname", "Birth");
				for (int i = 0; i < database.length; i++) {
					if (database[i] != null) {
						birthdate = bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions
								.dateStringNumeric(database[i].dateOfBirth);
						if (birthdate.length() > stringMax){
							stringMax = birthdate.length();
						}
					}
				}
				printLine(43 + stringMax);
				for (int i = 0; i < database.length; i++) {
					if (database[i] != null) {
						birthdate = bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions
								.dateStringNumeric(database[i].dateOfBirth);
						TextIO.putf("%-20.20s %-20.20s %s\n",
								database[i].lastname, database[i].firstname,
								birthdate);
						pers = i + 1;
					}
				}
				
				printLine(43 + stringMax);
				
				TextIO.putln(pers + " Person(s) in database, "
						+ (20 - pers) + " free.");
			} else {
				TextIO.putf("\n%-20.20s %-20.20s %s\n", "Lastname",
						"Firstname", "Birth");
				for (int i = 0; i < database.length; i++) {
					if (database[i] != null) {
						birthdate = bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions
								.dateString(database[i].dateOfBirth);
						if (birthdate.length() > stringMax){
							stringMax = birthdate.length();
						}
					}
				}
				
				printLine(43 + stringMax);
				
				for (int i = 0; i < database.length; i++) {
					if (database[i] != null) {
						birthdate = bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet05.DateFunctions
								.dateString(database[i].dateOfBirth);
						TextIO.putf("%-20.20s %-20.20s %s\n",
								database[i].lastname, database[i].firstname,
								birthdate);
						pers = i + 1;
					}
				}
				
				printLine(43 + stringMax);
				
				TextIO.putln(pers + " Person(s) in database, "
						+ (20 - pers) + " free.");
			}
		}
	}

	public static void printLine(int length) {
		for (int i = 0; i < length; i++)
			TextIO.put("-");
		TextIO.put("\n");
	}
}
