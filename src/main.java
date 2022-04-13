import java.time.Duration;
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
		compareSchedules(schedulesByEmployees,0);
	}
	
	public static void compareSchedules(LinkedList<Employee> schedulesByEmployees, int i){
		if(schedulesByEmployees.size()==2) {
			
			Employee employee1 = schedulesByEmployees.get(i);
			Employee employee2 = schedulesByEmployees.get(i+1);
			String tupla = employee1.getName() +  "-" +  employee2.getName();
			//System.out.println(tupla);
			
			LinkedList<Schedule> horario1 = schedulesByEmployees.get(i).getSchedule();
			LinkedList<Schedule> horario2 = schedulesByEmployees.get(i+1).getSchedule();
			System.out.println("horario1 " + horario1);
			System.out.println("horario2 " + horario2);
			int contador =0;
			for (int x = 0; x < horario1.size(); x++) {
				Schedule h1 = horario1.get(x);
				Schedule h2 = horario2.get(x);
				contador = tiempo( h1,  h2,contador);
			}
			System.out.println(tupla+ "-" + contador);
		}
		
	}
	public static int tiempo(Schedule h1, Schedule h2, int contador) {
		//System.out.println(h1.getDay());
		//System.out.println(h2.getDay());
		if(h1.getDay().equals(h2.getDay())) {
			System.out.print(h1.getTimeStart());
			System.out.println(h1.getTimeFinish());

			System.out.print(h2.getTimeStart());
			System.out.println(h2.getTimeFinish());
			Duration duration = Duration.between(h2.getTimeStart(), h2.getTimeFinish());
			//TimeStartA==TimeStartB and TimeFinishA==TimeFinishB
			if (h1.getTimeStart().equals(h2.getTimeStart()) && h1.getTimeFinish().equals(h2.getTimeFinish())){
				contador ++;
				System.out.println("equals");
			
			}//TimeStartA<TimeStartB and TimeFinishA>TimeFinishB
			else if(h1.getTimeStart().isBefore(h2.getTimeStart()) && h1.getTimeFinish().isAfter(h2.getTimeFinish())) {
				contador ++;
				System.out.println("A contiene a B");
			}//TimeStartA<=TimeStartB and TimeFinishA<=TimeFinishB and TimeFinishA>TimeStartB
			else if((h1.getTimeStart().isBefore(h2.getTimeStart() )|| h1.getTimeStart().equals(h2.getTimeStart()))&& (h1.getTimeFinish().isBefore(h2.getTimeFinish())||h1.getTimeFinish().equals(h2.getTimeFinish())) && h1.getTimeFinish().isAfter(h2.getTimeStart())) {
				contador ++;
				System.out.println("2");
			}//TimeStartA>=TimeStartB and TimeFinishA>TimeFinishB and TimeFinishA<TimeStartB
			else if((h1.getTimeStart().isAfter(h2.getTimeStart()) ||h1.getTimeStart().equals(h2.getTimeStart())) && h1.getTimeFinish().isAfter(h2.getTimeFinish()) && h1.getTimeStart().isBefore(h2.getTimeFinish())) {
				contador ++;
				System.out.println("3");
			}//TimeStartB<TimeStartA and TimeFinishB>TimeFinishA
			else if (h2.getTimeStart().isBefore(h1.getTimeStart()) && h2.getTimeFinish().isAfter(h1.getTimeFinish())){
				contador ++;
				System.out.println("B contiene a A");
			}
		}
		
		return contador;
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
					//System.out.println(schedule.getTimeStart());
					//System.out.println(schedule.getTimeFinish());
				}
			}
			
			System.out.println(scheduleByEmployee);
        }		
	}
	
	
	
}
