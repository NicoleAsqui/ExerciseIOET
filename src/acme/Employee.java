package acme;

import java.util.LinkedList;

public class Employee {
	
	String name;
	LinkedList<Schedule> schedule;
	
	public Employee(String name, LinkedList<Schedule> schedule) {
		this.name = name;
		this.schedule = schedule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkedList<Schedule> getSchedule() {
		return schedule;
	}
	public void setSchedule(LinkedList<Schedule> schedule) {
		this.schedule = schedule;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", schedule=" + schedule + "]";
	}


}
