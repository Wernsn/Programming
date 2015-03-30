package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class SimpleCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double v0 = 0.;
		double v1 = 0.;
		int opcode=0;
		double tmp = 0;
		
	
		TextIO.putln("Welcome to the SimpleCalculator");
		
		do {
			
		TextIO.putf("v0=%12.5f\n", v0);
		TextIO.putf("v1=%12.5f\n", v1);
		TextIO.putln("please enter opcode (9 for usage): ");
		
		opcode = TextIO.getInt();
		
		switch(opcode){
		
		case 0:
			break;
		case 1: 
			TextIO.put("enter number:");
			v0 = v1;
			v1 = TextIO.getDouble();
			break;
		
		case 2: 
			tmp = v0+v1;
			v0 = v1;
			v1=tmp;
			break;
	
		case 3: 
			tmp = v0-v1;
			v0 = v1;
			v1=tmp;
			break;
			
		case 4: 
			tmp = v0*v1;
			v0 = v1;
			v1=tmp;
			break;
			
		case 5: 
			tmp = v0/v1;
			v0 = v1;
			v1=tmp;
			break;
		
		case 9: 
			TextIO.putln("1 enter a number");
			TextIO.putln("2 +");
			TextIO.putln("3 -");
			TextIO.putln("4 *");
			TextIO.putln("5 /");
			TextIO.putln("9 display this message");
			TextIO.putln("0 exit");	
			TextIO.putln();
			break;
			
		default: TextIO.putln("invalid op code");
		
			}
		} while(opcode != 0);{
			TextIO.putln("Thank you for using the SimpleCalculator");
		}
	}
}
