// **************************************************
// 
// 
// 
//   THIS IS GENERATED CODE - > DO NOT EDIT!! 
//
// 
// ***************************************************/

package bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet02;

/**
 * This class represents an artist of performing arts, like a band.
 * 
 * 
 * @author TeM
 * @author JS
 * @ProgrammingProblem.Category simple entity classes
 * @ProgrammingProblem.Introduced ExerciseSheet01
 */
public class Artist

{

	/**
	 * holds the name of the artist initial value should be unchanged
	 * 
	 * @ProgrammingProblem.Aspect String member
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	private String name;

	/**
	 * gets the name of this artist
	 * 
	 * @return the name
	 * 
	 * @ProgrammingProblem.Aspect reference type member getter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public Artist (String name) {
		this.name = name;
	}
	public Artist (Artist a) {
		this.name = a.name;
	}
	public Artist() {
		this.name = "unknown";
	}
	public String getName() {
		return this.name;
	}

	/**
	 * sets the name of this artist.
	 * 
	 * the name of an artist cannot be null or empty. if an invalid argument is
	 * passed to the method the state of the object remains unchanged
	 * 
	 * 
	 * @param name
	 *            the new name of the artist
	 * 
	 * @ProgrammingProblem.Aspect reference type member setter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 * 
	 */
	public void setName(String name) {
		if (name != null && name.trim().length() > 0)
			this.name = name;
	}

}
