package acme;

import java.time.LocalTime;

public class Schedule {
	String day;
	LocalTime timeStart;
	LocalTime timeFinish;
	
	public Schedule(String day, LocalTime timeStart, LocalTime timeFinish) {
		this.day = day;
		this.timeStart = timeStart;
		this.timeFinish = timeFinish;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public LocalTime getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(LocalTime timeStart) {
		this.timeStart = timeStart;
	}
	public LocalTime getTimeFinish() {
		return timeFinish;
	}
	public void setTimeFinish(LocalTime timeFinish) {
		this.timeFinish = timeFinish;
	}
	
	@Override
	public String toString() {
		return "Schedule [day=" + day + ", timeStart=" + timeStart + ", timeFinish=" + timeFinish + "]";
	}
	
	
}
