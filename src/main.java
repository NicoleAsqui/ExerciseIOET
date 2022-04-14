import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;

import acme.Employee;
import acme.Schedule;
import filesReader.FileRead;
import controller.Controller;

public class main {

	public static void main(String[] args) {
				
		LinkedList<Employee> schedulesByEmployees = FileRead.readFiles();
		Controller.calculateSamePeriod(schedulesByEmployees);		
	}
	
}
