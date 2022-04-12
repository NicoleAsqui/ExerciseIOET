import java.util.LinkedList;

import acme.Employee;
import acme.Schedule;
import filesReader.FileRead;

public class main {

	public static void main(String[] args) {
		
		LinkedList<Employee> scheduleByEmployees = FileRead.leerArchivo();
		iterateList(scheduleByEmployees);
	}
	public static void iterateList(LinkedList<Employee> linkedList){		
		linkedList.forEach( (element) -> System.out.print(element + " "));
	}
}
