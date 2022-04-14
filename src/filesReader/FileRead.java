package filesReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import acme.Employee;
import acme.Schedule;

public final class FileRead {	
		
	public static LinkedList<Employee> readFiles(){		
		
		LinkedList<Employee> employees = new LinkedList<>();	
		
	    String txtFile = "files/schedule.txt";
	    BufferedReader buffer = null;
	    String line = "";
	    String splitBy = "=";
	    
	    try {
	    	buffer = new BufferedReader(new FileReader(txtFile));	       
	        while ((line = buffer.readLine()) != null) {
	            if (! (line.trim().equals("") || line.trim().equals("\n"))){
	            	
	                String[] data = line.split(splitBy);	           
	                LinkedList<Schedule> scheduleList = new LinkedList<>();	                
	                String[] timeList = data[1].split(",");
	                
	                for (int i =0; i<timeList.length; i++) {
	                	String day = timeList[i].substring(0,2);
	 	                String hour = timeList[i].substring(2);
	 	                String[] hourBySplit= hour.split("-");
	 	                LocalTime timestart = LocalTime.parse(hourBySplit[0], DateTimeFormatter.ISO_TIME);
	 	                LocalTime timeFinish = LocalTime.parse(hourBySplit[1], DateTimeFormatter.ISO_TIME);
	 	                
	 	                Schedule schedule = new Schedule(day, timestart,timeFinish);
	 	               scheduleList.add(schedule);
	                }

	                Employee employee = new Employee(data[0],scheduleList);
	                employees.add(employee);
	            }
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
	
	     return employees;
	}
}
