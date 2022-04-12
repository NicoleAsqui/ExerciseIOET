package filesReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

import acme.Employee;
import acme.Schedule;

public class FileRead {	
		
	public static LinkedList<Employee> leerArchivo(){		
		LinkedList<Employee> scheduleByEmployees = new LinkedList<>();	
		
	    String txtFile = "files/schedule.txt";
	    BufferedReader buffer = null;
	    String line = "";
	    String splitBy = "=";
	    int count =0; 
	    
	    try {
	    	buffer = new BufferedReader(new FileReader(txtFile));	       
	        while ((line = buffer.readLine()) != null) {
	            if (! (line.trim().equals("") || line.trim().equals("\n"))){
	            	
	                String[] datos = line.split(splitBy);	                
	                //System.out.println(Arrays.asList(datos));
	                
	                
	                LinkedList<Schedule> arraySchedule = new LinkedList<Schedule>();
	                
	                String[] timetable = datos[1].split(",");
	                
	                for (int i =0; i<timetable.length; i++) {
	                	String day = timetable[i].substring(0,2);
	 	                String hour = timetable[i].substring(2);
	 	                String[] hourBySplit= hour.split("-");
	 	                String timestart = hourBySplit[0];
	 	                String timeFinish =hourBySplit[1];
	 	                Schedule schedule = new Schedule(day, timestart,timeFinish);
	 	               arraySchedule.add(schedule);
	                }

	                Employee employee = new Employee(datos[0],arraySchedule);	 
	                //System.out.println(employee.getName());
	                //System.out.println(employee.toString());
	                //scheduleByEmployees.put(employee, arraySchedule);
	                //System.out.println(employee);
	                //System.out.println(arraySchedule);
	                scheduleByEmployees.add(employee);
	            }
	            count++;
	        }
	        
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }  finally {
            if (buffer != null) {
                try {
                	buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	
	     return scheduleByEmployees;
	}
}
