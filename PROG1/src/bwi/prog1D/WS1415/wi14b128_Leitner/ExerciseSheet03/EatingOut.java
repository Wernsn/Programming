package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class EatingOut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String steakChoice = "default";
		String degreeChoice = "default";
		String potatoeChoice = "default";
		String sideChoice = "default";
		String toppingChoice = "default";
		
		
		TextIO.putln("Welcome to our steak house! I will now take your order.");
		
		//---------------STEAK
		TextIO.putln("Which steak can I get you?");
		TextIO.putln("please select:");
		TextIO.putln("1 T-Bone");
		TextIO.putln("2 Sirloin");
		TextIO.putln("3 Rib Eye");
		TextIO.put("your choice: ");
		int steak = TextIO.getInt();
		
		if (steak==1){
			steakChoice = "T-Bone";
		}
		else if (steak==2){
			steakChoice = "Sirloin";
		}
		else if (steak ==3){
			steakChoice = "Rib Eye";
		}
		else {
			TextIO.put("not a choice");
		}

		//---------------COOKING
		TextIO.putln("How do you want your steak cooked?");
		TextIO.putln("please select:");
		TextIO.putln("1 rare");
		TextIO.putln("2 medium rare");
		TextIO.putln("3 medium");
		TextIO.putln("4 medium done");
		TextIO.putln("5 done");
		TextIO.put("your choice: ");
		int degree = TextIO.getInt();
		
		if (degree==1){
			degreeChoice = "rare";
		}
		else if (degree==2){
			degreeChoice = "medium rare";
		}
		else if (degree ==3){
			degreeChoice = "medium";
		}
		else if (degree==4){
			degreeChoice = "medium done";
		}
		else if (degree ==5){
			degreeChoice = "done";
		}
		else {
			TextIO.put("not a choice");
		}
		
		//---------------Sidedishes
		TextIO.putln("What do you want on the side?");
		TextIO.putln("please select:");
		TextIO.putln("1 bread");
		TextIO.putln("2 potatoes");
		TextIO.put("your choice: ");
		int side = TextIO.getInt();
		
		if (side==1){
			sideChoice = "bread";
			TextIO.put("Thank you, you ordered: "+steakChoice+", "+degreeChoice+" with "+sideChoice+".");
		}
		else if (side==2){
			sideChoice = "potatoes";
			
			// -------------------POTATOES
			TextIO.putln("How do you want your potatoes?");
			TextIO.putln("please select:");
			TextIO.putln("1 fried");
			TextIO.putln("2 wedged");
			TextIO.putln("3 baked");
			TextIO.put("your choice: ");
			int potatoe = TextIO.getInt();
			
			if (potatoe==1){
				potatoeChoice = "fried";
				TextIO.put("Thank you, you ordered: "+steakChoice+", "+degreeChoice+" with "+potatoeChoice+" "+sideChoice+".");
			}
			else if (potatoe==2){
				potatoeChoice = "wedged";
				TextIO.put("Thank you, you ordered: "+steakChoice+", "+degreeChoice+" with "+potatoeChoice+" "+sideChoice+".");
			}
			else if (potatoe ==3){
				potatoeChoice = "baked";
				
				// ---------------------------- TOPPING
				TextIO.putln("Which topping do you want?");
				TextIO.putln("please select:");
				TextIO.putln("1 butter");
				TextIO.putln("2 French dressing");
				TextIO.putln("3 garlic");
				TextIO.put("your choice: ");
				
				int topping = TextIO.getInt();
				if (topping==1){
					toppingChoice= "fried";
				}
				else if (topping==2){
					toppingChoice = "French dressing topping";
				}
				else if (topping==3){
					toppingChoice = "garlic";
				}
				else {
					TextIO.put("not a choice");
				}
				
				TextIO.put("Thank you, you ordered: "+steakChoice+", "+degreeChoice+" with "+potatoeChoice+" "+sideChoice+" and "+toppingChoice+".");
				
			}
			else {
				TextIO.put("not a choice");
			}
			
		}
		else {
			TextIO.put("not a choice");
		}
		
	}

}
