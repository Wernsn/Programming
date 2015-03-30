package bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet02;

import bwi.prog.utils.Date;
import bwi.prog.utils.Venue;

public class Event {

	private Artist artist; // = new Artist();
	private int attendees;
	private Date date;
	private String description;
	private Venue venue;
	
	public Event() {
		artist = new Artist();
		description = "";
	}
	
	public Artist getArtist() {
		return artist;
	}
	
	public void setArtist(Artist artist) {
		if (artist == null) {
			this.artist = new Artist();
		} else {
			this.artist = artist;
		}
	}
	public int getAttendees() {
		return attendees;
	}
	public void setAttendees(int attendees) {
		if (attendees >= 0) {
			this.attendees = attendees;			
		}
	}
	public Date getDate() {
		if (date != null) {
			return date = new Date();
		} else {
			return null;
		}
	}
	public void setDate(Date date) {
		if (date != null) {
			this.date = new Date();
		}
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description != null) {
			this.description = description;
		} else {
			this.description = "";
		}
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
}
