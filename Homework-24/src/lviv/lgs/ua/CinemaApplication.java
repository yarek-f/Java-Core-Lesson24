package lviv.lgs.ua;

import java.util.Optional;
import java.util.Scanner;

public class CinemaApplication {

	public static void main(String[] args) throws TimeException {
			
		Cinema cinema = new Cinema(new Time(10, 00), new Time(22, 00));
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			menu();
			String str = sc.next();
			switch (str) {
			case "1":
				System.out.println("Enter film name:");
				String name = sc.next();
				System.out.println("Enter number of hours duraction of film:");
				int hour = sc.nextInt();
				System.out.println("Enter number of minutes duraction of film:");
				int min = sc.nextInt();
				Time timeDuration = new Time(hour, min);
				Movie mov = new Movie(name, timeDuration);
				cinema.addMovie(mov);
				System.out.println("The movie successfully added!");
				break;

			case "2":
				System.out.println("Enter index of film:");
				int index = sc.nextInt();
				System.out.println("Enter start hour:");
				int hour2 = sc.nextInt();
				System.out.println("Enter start minute:");
				int min2 = sc.nextInt();
				System.out.println("Enter day");
				String day = sc.next();
				Time startTime = new Time(hour2, min2);
				Seance seans = new Seance(cinema.moviesLibrary.get(index), startTime);
				cinema.addSeance(seans, day);
				System.out.println("The seance successfully added!");
				break;

			case "3":
				System.out.println("Enter index of film");
				int index3 = sc.nextInt();
				cinema.removeMovie(cinema.moviesLibrary.get(index3));
				break;
				
			case "4":
				System.out.println("Write title of movie");
				String title = sc.next();
				System.out.println("Enter start hour:");
				int hour3 = sc.nextInt();
				System.out.println("Enter start minute:");
				int min3 = sc.nextInt();
				Time time = new Time(hour3, min3);
				System.out.println("Write day");
				String day1 = sc.next();
				Optional<Seance> findAny = cinema.getSeances().stream().filter(
						t -> t.getMovie().getTitle().equalsIgnoreCase(title) && t.getStartTime().compareTo(time) == 0)
						.findAny();
				if (findAny.isPresent())
					cinema.removeSeance(findAny.get(), day1);
				break;

			case "5":
				System.out.println("Monday: " + cinema.schedules.get(Days.MONDAY));
				System.out.println("Tuesday: " + cinema.schedules.get(Days.TUESDAY));
				System.out.println("Wednesday: " + cinema.schedules.get(Days.WEDNESDAY));
				System.out.println("Thursday: " + cinema.schedules.get(Days.THURSDAY));
				System.out.println("Friday: " + cinema.schedules.get(Days.FRIDAY));
				System.out.println("Saturday: " + cinema.schedules.get(Days.SATURDAY));
				System.out.println("Sunday: " + cinema.schedules.get(Days.SUNDAY));
				break;

			case "0":
				System.exit(0);
			}
		}

	}
	
	private static void menu() {
		System.out.println("Press 1 if you want ro add film");
		System.out.println("Press 2 if you want to add seance");
		System.out.println("Press 3, if you want to remove film");
		System.out.println("Press 4, if you want to remove seance");
		System.out.println("Press 5, if you want to deduce the schedule");
		System.out.println("Press 0, if you want to");
		System.out.println();

	}
}


