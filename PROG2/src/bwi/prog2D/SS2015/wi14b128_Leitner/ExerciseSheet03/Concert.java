package bwi.prog2D.SS2015.wi14b128_Leitner.ExerciseSheet03;

public class Concert extends Event {
	
	private int nextIdx = 0;
	private Track[] setList = new Track[16];
	
	public boolean addTrack(Track t) {
		if (t == null)
			return false;
		if (nextIdx >= setList.length)
			ensureCapacity(setList.length * 2);

		setList[nextIdx++] = t;
		return true;
	}
	private void ensureCapacity(int length) {
		if (setList.length >= length)
			return; // nothing to do

		Track[] newList = new Track[length];

		for (int i = 0; i <= setList.length; i++) {
			Track t = new Track();
			t = setList[i];
			newList[i] = t;
		}
//		int i = 0;
//		for (Track t : setList)
//			// copy existing entries
//			newList[i++] = t;

		setList = newList;
	}
	public Track[] getSetList() {
		Track[] ret = new Track[nextIdx];
		for (int i = 0; i < nextIdx; i++) {
			ret[i] = new Track(setList[i]);
		}
		return ret;
	}
	public void setSetList(Track[] tracks) {
		if (tracks == null)
			return;
		int cnt = 0;
		for (Track t : tracks)
			if (t != null)
				cnt++;
		resetSetList();
		ensureCapacity(cnt);

		for (Track t : tracks)
			if (t != null)
				addTrack(new Track(t));
	}
	public void resetSetList() {
		for (int i = 0; i < setList.length; i++) {
			setList[i] = null;
		}
		nextIdx = 0;
	}
	public int nrTracks() {
		return nextIdx;
	}
	public int duration() {
		int sum = 0;
		for (int i = 0; i < nextIdx; i++)
			sum += setList[i].getDuration();
		return sum;
	}
	@Override
	public int impact() {
		int dur = duration();
		return getAttendees() * (dur / (1800) + ((dur % 1800 == 0) ? 0 : 1));
	}
	public String toString() {
		return String.format(
				"%s\n%d tracks played, total duration %02d:%02d.",
				super.toString(), nrTracks(), duration() / 3600,
				duration() % 3600 / 60);
	}

}
