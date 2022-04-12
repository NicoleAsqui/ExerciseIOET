package acme;

public class Schedule {
	String day;
	String timeStart;
	String timeFinish;
	
	public Schedule(String day, String timeStart, String timeFinish) {
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
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeFinish() {
		return timeFinish;
	}
	public void setTimeFinish(String timeFinish) {
		this.timeFinish = timeFinish;
	}
	
	@Override
	public String toString() {
		return "Schedule [day=" + day + ", timeStart=" + timeStart + ", timeFinish=" + timeFinish + "]";
	}
	
	
}
