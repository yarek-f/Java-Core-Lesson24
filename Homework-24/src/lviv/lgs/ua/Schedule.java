package lviv.lgs.ua;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	Set<Seance> scheduleSeances = new TreeSet<>();
	
	public List<Seance> getSeances() {
		 List<Seance> s =  new ArrayList<Seance>();
		 s.addAll(scheduleSeances);
		 return s;
	}

	public void addSeance(Seance seance) {
		scheduleSeances.add(seance);
	}

	public void deleteSeance(Seance seance) {
		scheduleSeances.remove(seance);
	}

	@Override
	public String toString() {
		return "Schedule: \n" + scheduleSeances;
	}

}
