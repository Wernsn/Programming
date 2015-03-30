package bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet03;

public class TVShow extends Event {
	
	private String name;

	private int viewers;

	public int getViewers() {
		return viewers;

	}

	public void setViewers(int v) {
		if (v < 0)
			return;
		viewers = v;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().length() == 0)
			return;
		this.name = name;
	}

	public TVShow() {
		super();
	}

	public TVShow(TVShow tvs) {
		super(tvs);
		viewers = tvs.viewers;
		name=tvs.name;
	}

	public TVShow(Event e) {
		super(e);
	}

	@Override
	public String toString() {
		return String.format("%s @ %s on %s\n%s\n(%d attending (%d))",
				getArtist().getName(), (name==null)?"unknown":name, getDate(), getDescription(),
				getAttendees()+getViewers(), impact());
	}

	@Override
	public int impact() {
		return (viewers+getAttendees()) * 2;
	}

}
