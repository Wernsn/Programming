package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet02;

import bwi.prog.utils.TextIO;

public class Classifier {

	public static void main(String[] args) {
		
		TextIO.put("enter price: ");
		int price = TextIO.getInt();
		TextIO.put("enter quality: ");
		int quality = TextIO.getInt();
		
		if (price >= 50){
			if (quality >= 50){
				TextIO.putln("high price");
				TextIO.putln("high quality");
				TextIO.putln("luxury");
			}
			else {
				TextIO.putln("high price");
				TextIO.putln("low quality");
				TextIO.putln("rip off");
				}
		
	}
		else
			if (quality >= 50){
				TextIO.putln("low price");
				TextIO.putln("high quality");
				TextIO.putln("bargain");
			}
			else {
				TextIO.putln("low price");
				TextIO.putln("low quality");
				TextIO.putln("junk");
			}
				
		}

}
