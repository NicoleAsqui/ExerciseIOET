import java.time.LocalTime;
import java.util.LinkedList;

import acme.Employee;
import acme.Schedule;
import filesReader.FileRead;

public class main {

	public static void main(String[] args) {
		
		//LinkedList<Employee> scheduleByEmployees = FileRead.leerArchivo();
		//iterateList(scheduleByEmployees);
		//recorrerSchedules(scheduleByEmployees);
		
		LinkedList<Employee> schedulesByEmployees = FileRead.leerArchivo();
		for (int i = 0; i < schedulesByEmployees.size(); i++) {
			Employee employee = schedulesByEmployees.get(i);
			LinkedList<Schedule> schedulees  = employee.getSchedule();
			for (int y = 0; y < schedulees.size(); y++) {		
				Schedule schedule1 = schedulees.get(y);
				Schedule schedule2 = schedulees.get(y+1);
				compareSchedules(schedule1, schedule2);
			}
		}
	}
	/*public static void iterateList(LinkedList<Employee> linkedList){	
		
		linkedList.forEach( (element) -> System.out.print(element + " "));
		
	}*/
	public static void compareSchedules(Schedule schedule1, Schedule schedule2){
		//Schedule schedule1 = new Schedule();
		//Schedule schedule2 = new Schedule();
		
		
	}
	public static void recorrerSchedules(LinkedList<Employee> linkedList){
		for (int i = 0; i < linkedList.size(); i++) {
			LinkedList<Schedule> scheduleByEmployee = linkedList.get(i).getSchedule();
			for (int y = 0; y < scheduleByEmployee.size(); y++) {
				Schedule schedule = scheduleByEmployee.get(y);
				if (schedule.getDay().equals("MO")) {
					//System.out.println(schedule.getTimeStart());
					//System.out.println(schedule.getTimeFinish());
				}
			}
			
			System.out.println(scheduleByEmployee);
        }		
	}
	
	
	
}
