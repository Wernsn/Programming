package bwi.prog1D.WS1415.wi14b128_Leitner.ExerciseSheet03;

import bwi.prog.utils.TextIO;

public class MinMidMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextIO.putln("Enter three numbers");
		TextIO.put("a=");
		int a = TextIO.getInt();
		TextIO.put("b=");
		int b = TextIO.getInt();
		TextIO.put("c=");
		int c = TextIO.getInt();
		TextIO.putln();
		TextIO.putln("ordered:");

		if (a == b && b == c) {
			TextIO.putf("%d=%d=%d", a, b, c);
			TextIO.putln();
			TextIO.put("a=b=c");

		} else if (a == b) {
			if (b > c) {
				TextIO.putf("%d<%d=%d", c, a, b);
				TextIO.putln();
				TextIO.put("c<a=b");
			} else {
				TextIO.putf("%d=%d<%d", a, b, c);
				TextIO.putln();
				TextIO.put("a=b<c");
			}
		} else if (a == c) {
			if (c > b) {
				TextIO.putf("%d<%d=%d", b, a, c);
				TextIO.putln();
				TextIO.put("b<a=c");
			} else {
				TextIO.putf("%d=%d<%d", a, c, b);
				TextIO.putln();
				TextIO.put("a=c<b");
			}
		} else if (b == c) {
			if (b > a) {
				TextIO.putf("%d<%d=%d", a, b, c);
				TextIO.putln();
				TextIO.put("a<b=c");
			} else {
				TextIO.putf("%d=%d<%d", b, c, a);
				TextIO.putln();
				TextIO.put("b=c<a");
			}
		}

		// no equals------------------------

		else if (a > b) { 			// a>b
			if (a > c) { 			// a>b && a>c
				if (b > c) { 		// a>b && a>c && b>c
					TextIO.putf("%d<%d<%d", c, b, a);
					TextIO.putln();
					TextIO.putln("c<b<a");
				} else { 			// a>b && a>c && c>b
					TextIO.putf("%d<%d<%d", b, c, a);
					TextIO.putln();
					TextIO.putln("b<c<a");
				}
			} else { 				// b>a
				if (b > c) { 		// b>a && b>c
					if (c > a) { 	// b>a && b>c && c>a
						TextIO.putf("%d<%d<%d", a, c, b);
						TextIO.putln();
						TextIO.putln("a<c<b");
					} else { 		// b>a && b>c && a>c
						TextIO.putf("%d<%d<%d", c, a, b);
						TextIO.putln();
						TextIO.putln("c<a<b");
					}
				}
				else{				
						TextIO.putf("%d<%d<%d", b, a, c);
						TextIO.putln();
						TextIO.putln("b<a<c");
					
					
				}
			}
		}
		else if (b>a) { 			//b>a
			if (b>c){ 				// b>a && b>c 
				if (c>a){ 			// b>a && b>c && c>a
					TextIO.putf("%d<%d<%d", a, c, b);
					TextIO.putln();
					TextIO.putln("a<c<b");
				}
				else{				// b>a && b>c && a>c
					TextIO.putf("%d<%d<%d", c, a, b);
					TextIO.putln();
					TextIO.putln("c<a<b");
				}
			}
			else{ 					//b>a && c>b
				if (c>a){			//b>a && c>b %% c>a
					TextIO.putf("%d<%d<%d", a, b, c);
					TextIO.putln();
					TextIO.putln("a<b<c");
				}
				else{				//b>a && c>b %% a>c
					TextIO.putf("%d<%d<%d", c, a, b);
					TextIO.putln();
					TextIO.putln("c<a<b");
				}
			}
		}
	}
}
