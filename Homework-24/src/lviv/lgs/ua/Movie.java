package lviv.lgs.ua;

public class Movie {
	
	private String title;
	private Time duration;
	
	public Movie(String title, Time duration) {
		super();
		this.title = title;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", duration=" + duration + "]";
	}
	
	

}
