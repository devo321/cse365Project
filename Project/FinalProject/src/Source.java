import java.util.ArrayList;
import java.util.Observable;

public class Source extends Observable {
	
	private ArrayList<Person> roster = new ArrayList<Person>();
	
	public void clearRoster() {
		roster.clear();
	}
	
	public void updateRoster(Person p) {
		roster.add(p);
	}
	
	public void updateAttendance(Attendance a, String date) {
		for (Person p : roster) {
			if (p.getAsuRite().compareTo(a.getAsuRite()) == 0) {
				p.addTime(date, a.getTime());
			}
		}
	}
	
	public boolean didFindAsuRite(String asuRite) {
		for (Person p : roster) {
			if (p.getAsuRite().compareTo(asuRite) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public void rosterCompleted() {
		setChanged();
		notifyObservers();
	}
	
	// returns the private variable value
	public ArrayList<Person> getRoster() {
		return roster;
	}


}
