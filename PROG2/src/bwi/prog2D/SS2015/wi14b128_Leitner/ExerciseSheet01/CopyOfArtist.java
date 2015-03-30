package bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet01;

import bwi.prog.utils.TextIO;

public class CopyOfArtist {

	private String name;
	
	public void display() {
		TextIO.putln("Name: "+ this.name);
	}

	public String getName() {
		return this.name;
		
	}

	public void setName(String name) {
		if (!name.equals("") && !name.matches("\\s*")) {
			this.name = name;
		}
	}
}
