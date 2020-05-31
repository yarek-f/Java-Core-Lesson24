package lviv.lgs.ua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cinema {
	Map<Days, Schedule> schedules = new HashMap<>();
	ArrayList<Movie> moviesLibrary = new ArrayList<>();
	
	public List<Seance> getSeances() {
		List<Seance> seanses = new ArrayList<Seance>();
		for (Schedule schedule : schedules.values()) {
			seanses.addAll(schedule.getSeances());
		}
		return seanses;
	}
	
	Schedule shed1 = new Schedule();
	Schedule shed2 = new Schedule();
	Schedule shed3 = new Schedule();
	Schedule shed4 = new Schedule();
	Schedule shed5 = new Schedule();
	Schedule shed6 = new Schedule();
	Schedule shed7 = new Schedule();

	Time open;
	Time close;

	public Cinema(Time open, Time close) {
		super();
		this.open = open;
		this.close = close;
	}

	public Time getOpen() {
		return open;
	}

	public void setOpen(Time open) {
		this.open = open;
	}

	public Time getClose() {
		return close;
	}

	public void setClose(Time close) {
		this.close = close;
	}

	public void addMovie(Movie movie) {
		moviesLibrary.add(movie);
	}

	public void addSeance(Seance seans, String day) {

		switch (day.toUpperCase()) {
		case "monday":
			shed1.addSeance(seans);
			schedules.put(Days.MONDAY, shed1);
			break;
		case "tuesday":
			shed2.addSeance(seans);
			schedules.put(Days.TUESDAY, shed2);
			break;
		case "wednesday":
			shed3.addSeance(seans);
			schedules.put(Days.WEDNESDAY, shed3);
			break;
		case "thursday":
			shed4.addSeance(seans);
			schedules.put(Days.THURSDAY, shed4);
			break;
		case "friday":
			shed5.addSeance(seans);
			schedules.put(Days.FRIDAY, shed5);
			break;
		case "saturday":
			shed6.addSeance(seans);
			schedules.put(Days.SATURDAY, shed6);
			break;
		case "sunday":
			shed7.addSeance(seans);
			schedules.put(Days.SUNDAY, shed7);
			break;

		default:
			System.out.println("next week");
			break;

		}

	}

	public void removeMovie(Movie movie) {
		moviesLibrary.remove(movie);
	}
	
	public void removeSeance(Seance seance, String day) {
		if (schedules.keySet().stream().anyMatch(t -> t.name().equalsIgnoreCase(day))) {
			schedules.get(schedules.keySet().stream().filter(t -> t.name().equalsIgnoreCase(day)).findAny().get())
					.deleteSeance(seance);
		} else
			System.out.println("There is no seanses in day " + day);
	}
	
	public void printSeanes() {
		System.out.println(schedules);
	}

}