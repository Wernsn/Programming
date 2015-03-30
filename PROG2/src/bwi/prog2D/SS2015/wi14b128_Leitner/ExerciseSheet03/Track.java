// **************************************************
//
//
//  THIS IS GENERATED CODE - > DO NOTE EDIT!!
//
//
// ***************************************************/

package bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet03;

/**
 * represents a piece of music that has been released on some kind of media (CD,
 * vinyl, video, ...)
 *
 *
 * @author TeM
 * @author JS
 * @ProgrammingProblem.Category simple entity classes
 * @ProgrammingProblem.Introduced ExerciseSheet01
 */
public class Track

{

	/**
	 * the title of this track. a null title represents an unknown title
	 *
	 * @ProgrammingProblem.Aspect String member
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	private String title = null;

	/**
	 * the duration of this track in seconds
	 *
	 * the duration is a non-negative number, duration 0 (zero) represents
	 * unknown duration
	 *
	 * @ProgrammingProblem.Aspect primitive member
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	private int duration = 0;

	/**
	 * the artist who wrote this track
	 *
	 * the writer cannot be null
	 *
	 * @ProgrammingProblem.Aspect reference type member
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	private Artist writer = new Artist();

	/**
	 * the artist who performs this track
	 *
	 * the performer cannot be null
	 *
	 * @ProgrammingProblem.Aspect reference type member
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	private Artist performer = new Artist();

	/**
	 * the year in which the Track was or will be produced valid years are
	 * between 1900- 2999
	 * 
	 * @ProgrammingProblem.Aspect primitive type member
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	private int year = 0;

	public Track() {
		this.title = null; // should be "unknown";
		this.duration = 0;
		this.year = 0; //should be 1900;
		this.writer = new Artist();
		this.performer = new Artist();
		
	}

	public Track(String title) {
		this.title = title;
	}

	public Track(Track t) {
		
		this.duration = t.duration;
		this.performer = new Artist(t.performer);
		this.title = t.title;
		this.writer = new Artist(t.writer);
		this.year = t.year;
		
	}

	/**
	 * gets the production year of this track
	 * 
	 * @return the year
	 * @ProgrammingProblem.Aspect primitive type member getter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public int getYear() {
		return year;
	}

	/**
	 * sets the production year of this track valid years are between 1900 and
	 * 2999 other values are ignored, the object remains unchanged
	 * 
	 * @param year
	 *            the year to set
	 * 
	 * @ProgrammingProblem.Aspect primitive type member setter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public void setYear(int year) {
		if (year > 1899 && year < 3000)
			this.year = year;
	}

	/**
	 * gets the duration of this track
	 *
	 * @return the duration
	 * @ProgrammingProblem.Aspect primitive type member getter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * sets the duration
	 *
	 * a negative value is ignored, the object remains unchanged
	 *
	 * @param duration
	 *            the duration to set
	 * @ProgrammingProblem.Aspect primitive type member setter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public void setDuration(int duration) {
		if (duration < 0)
			return;
		this.duration = duration;
	}

	/**
	 * gets the title of this track.
	 *
	 * if the title is not known (null) "unknown title" is returned (without
	 * quotes)
	 *
	 * @return the title
	 * @ProgrammingProblem.Aspect reference type member getter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public String getTitle() {
		if (title == null)
			return "unknown title";
		return title;
	}

	/**
	 *
	 * sets the title of this track.
	 *
	 * @param title
	 *            the title to set
	 * @ProgrammingProblem.Aspect reference type member setter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 *
	 * returns the writer of this track
	 * 
	 *
	 * @return the writer
	 * @ProgrammingProblem.Aspect reference type member getter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public Artist getWriter() {
		return writer;
	}

	/**
	 * sets the the writer of this track
	 *
	 * null arguments are ignored
	 *
	 * @param writer
	 *            the writer to set
	 * @ProgrammingProblem.Aspect reference type member setter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public void setWriter(Artist writer) {
		if (writer == null)
			return;
		this.writer = writer;
	}

	/**
	 * returns the performer of this track
	 *
	 * @return the performer
	 * @ProgrammingProblem.Aspect reference type member getter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public Artist getPerformer() {
		return performer;
	}

	/**
	 * sets the performer of this track
	 *
	 * null arguments are ignored
	 *
	 * @param performer
	 *            the performer to set
	 * @ProgrammingProblem.Aspect reference type member setter
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public void setPerformer(Artist performer) {
		if (performer == null) {
			return;
		}

		this.performer = performer;
	}

	/**
	 * this getter is used to check if the writer of this Track is known. A
	 * writer is considered as known if the name is not equal to null .
	 * 
	 * @return true if the writer of this track is known (and has a name), false
	 *         otherwise
	 * @ProgrammingProblem.Aspect getter without member
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 */
	public boolean writerIsKnown() {
		if (writer == null)
			return false;
		return writer.getName() != null;
	}

	/**
	 * returns a formatted String containing all information of this track.
	 *
	 * the String representation is (without quotes):
	 * <p>
	 * <code>"title by writer performed by performer (min:sec)"</code>
	 * <p>
	 * where
	 * <ul>
	 * <li>title stands for the title (exactly 10 chars wide) if not set, return
	 * unknown
	 * <li>writer stands for the writer name (exactly 10 chars wide)
	 * <li>performer stands for the performer name (exactly 10 chars wide)
	 * <li>min is the duration's amount of full minutes (at least two digits,
	 * leading zeros)
	 * <li>sec is the duration's remaining amount of seconds (at least two
	 * digits, leading zeros)
	 * </ul>
	 *
	 * @return a String representation of this track
	 * @ProgrammingProblem.Aspect string representation
	 * @ProgrammingProblem.Introduced ExerciseSheet01
	 *
	 */
	public String getString() {
		return String.format(
				"%10.10s by %10.10s performed by %10.10s (%02d:%02d)",
				title == null ? "unknown" : title,
				writer == null ? "unknown"
						: writer.getName() == null ? "unknown" : writer
								.getName(),
				performer == null ? "unknown"
						: performer.getName() == null ? "unknown" : performer
								.getName(), duration / 60, duration % 60);
	}

}
