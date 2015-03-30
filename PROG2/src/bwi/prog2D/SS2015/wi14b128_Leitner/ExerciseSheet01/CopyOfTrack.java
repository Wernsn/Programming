package bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet01;

import bwi.prog.utils.TextIO;
import bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet02.Artist;

public class CopyOfTrack {
	
	private String title;
	private int duration;
	private Artist writer = new Artist();
	private Artist performer = new Artist();
	private int year;
	
	
	public int getDuration() {
		return this.duration;	
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		if (year >= 1900 && year <= 2999) {
			this.year = year;
		}
		return;
	}
	
	public void setDuration(int duration) {
		if (duration>0) {
			this.duration = duration;
		}
		return;
	}
	
	public String getTitle() {
		if (this.title == null) {
			this.title = "unknown title";
		}
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Artist getWriter() {
		return this.writer;
	}
	
	public void setWriter(Artist writer) {
	
		this.writer = writer;
	}
	
	public Artist getPerformer() {
		return this.performer;
	}
	
	public void setPerformer(Artist performer) {
		this.performer = performer;
	}
	
	public boolean writerIsKnown() {
		if (this.writer.getName() != null) {
			return true;
		}
		return false;
	}
	
	public String getString() {
		
		if (this.title == null) this.title = "unknown";
		
		if (this.writer.getName() == null) this.writer.setName("unknown");
		
		if (this.performer.getName() == null) this.performer.setName("unknown");
		
		
		String info = String.format("%10s by %10s performed by %10s (%2d)", this.title, this.writer.getName(), this.performer.getName(), this.duration);

		
		return info;
		
//		"title by writer performed by performer (min:sec)"
//
//		where
//
//		title stands for the title (exactly 10 chars wide) if not set, return unknown
//		writer stands for the writer name (exactly 10 chars wide)
//		performer stands for the performer name (exactly 10 chars wide)
//		min is the duration's amount of full minutes (at least two digits, leading zeros)
//		sec is the duration's remaining amount of seconds (at least two digits, leading zeros)
		
	}
	
	public String testName() {
		
		return this.performer.getName();
	}

}
