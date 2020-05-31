package lviv.lgs.ua;

public class Time {

	private int hour;
	private int min;

	public Time(int hour, int min) throws TimeException {
		if ((hour >= 0 && hour < 24) && (min >= 0 && min < 60)) {
			this.hour = hour;
			this.min = min;
		} else {
			throw new TimeException("It's not the correct time");
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}

	public static Time timeSum(Time time1, Time time2) throws TimeException {
		int hour = time1.getHour() + time2.getHour();
		int min = time1.getMin() + time2.getMin();
		if (hour >= 24) {
			hour -=24;
		}
		if (min > 60) {
			hour += 1;
			min -= 60;
		}
		return new Time(hour, min);
	}
	
	public int compareTo(Time o) {
		if (Integer.compare(hour, o.hour) != 0)
			return Integer.compare(hour, o.hour);
		else
			return Integer.compare(min, o.min);
	}

}
