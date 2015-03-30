//change bwi.prog.Assignments.Landscapes.Music to your package bwi.prog2<group>.SS201<X>.<id>_<Lastname>.<submissionname><NN>
package bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet01.tests;

//change bwi.prog.Assignments.Landscapes.Music.entities to your package bwi.prog2<group>.SS201<X>.<id>_<Lastname>.<submissionname><NN>
import bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet01.*;
import bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet02.Artist;

import java.lang.reflect.Field;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ArtistTest {

	@Test
	/**
	 * checks if initial value of name is null
	 */
	public void checkInit(){
		Artist toTest= new Artist();
	    //reflect private field name
	
	    try {
	    	Field privateStringField = Artist.class.getDeclaredField("name");
	    	privateStringField.setAccessible(true);
			assertEquals(privateStringField.get(toTest),null,"initial value should be null");
		} catch (Exception e) {}		
	}
	
  @Test(dataProvider = "names")
  public void getName(String in, String out) {
    Artist toTest= new Artist();
    //reflect private field name

    try {
    	Field privateStringField = Artist.class.getDeclaredField("name");
    	privateStringField.setAccessible(true);
		privateStringField.set(toTest, in);
	} catch (Exception e) {}
		
    assertEquals(toTest.getName(),in);
  }

  @Test(dataProvider = "names")
  public void setName(String in, String out) {
	  Artist toTest= new Artist();
	  toTest.setName(in);
	  try {
	    	Field privateStringField = Artist.class.getDeclaredField("name");
	    	privateStringField.setAccessible(true);
			
			assertEquals(privateStringField.get(toTest),out);
		} catch (Exception e) {} 
  }
  
  @DataProvider(name = "names")
  public static Object[][] names() {
      return new Object[][] { { null,null }, { "kiss", "kiss" }, {"",null },
      	{ "  ", null }, { "Jon Bon Jovi", "Jon Bon Jovi" } };
  }
  
  
  
  

  
}
