import java.time.LocalTime;
import java.util.LinkedList;

import acme.Employee;
import acme.Schedule;
import filesReader.FileRead;

public class main {

	public static void main(String[] args) {
		
		LinkedList<Employee> scheduleByEmployees = FileRead.leerArchivo();
		//iterateList(scheduleByEmployees);
		recorrerSchedules(scheduleByEmployees);
	}
	/*public static void iterateList(LinkedList<Employee> linkedList){	
		
		linkedList.forEach( (element) -> System.out.print(element + " "));
		
	}*/
	public static void recorrerSchedules(LinkedList<Employee> linkedList){
		for (int i = 0; i < linkedList.size(); i++) {
			LinkedList<Schedule> scheduleByEmployee = linkedList.get(i).getSchedule();
			for (int y = 0; y < scheduleByEmployee.size(); y++) {
				Schedule schedule = scheduleByEmployee.get(y);
				if (schedule.getDay().equals("MO")) {
					System.out.println(schedule.getTimeStart());
					System.out.println(schedule.getTimeFinish());
				}
				
				
			}
			
			System.out.println(scheduleByEmployee);
        }
		
		
		
	}
	
	
}
