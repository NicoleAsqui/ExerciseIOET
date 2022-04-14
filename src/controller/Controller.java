package controller;

import java.time.LocalTime;
import java.util.LinkedList;

import acme.Employee;
import acme.Schedule;

public class Controller {
	
	public static void calculateSamePeriod(LinkedList<Employee> employees){

		int indexBegin= 0;
		int moveBegin= 1;
		iterateEmployees(employees,indexBegin,moveBegin);
	}
	
	private static void iterateEmployees(LinkedList<Employee> employees, int index, int move){
		
		int limit = index+move;
		if(limit < employees.size()) {
			
			Employee employee = employees.get(index);
			Employee employeeNext = employees.get(index+move);
			String tupleNames = employee.getName() +  "-" +  employeeNext.getName();
			
			LinkedList<Schedule> scheduleList = employees.get(index).getSchedule();
			LinkedList<Schedule> scheduleListNext = employees.get(index+move).getSchedule();
					
			int counter = iterateSchedule(scheduleList,scheduleListNext);
			System.out.println(tupleNames+ " " + counter);			
			iterateEmployees(employees,index,move+1);
		}
		if(limit==employees.size()) {
			iterateEmployees(employees,index+1,1);
		}
	}
	
	public static int iterateSchedule(LinkedList<Schedule> scheduleList,LinkedList<Schedule> scheduleListNext ){
		int counter =0;
		for (int x = 0; x < scheduleList.size(); x++) {
			Schedule schedule = scheduleList.get(x);
			for (int y = 0; y < scheduleListNext.size(); y++) {
				Schedule scheduleNext = scheduleListNext.get(y);
				counter = compareTime(schedule, scheduleNext,counter);
			}		
		}
		return counter;
	}
	
	public static int compareTime(Schedule schedule, Schedule scheduleNext, int contador) {
		
		LocalTime timeStartA= schedule.getTimeStart();
		LocalTime timeFinishA= schedule.getTimeFinish();
		LocalTime timeStartB = scheduleNext.getTimeStart();
		LocalTime timeFinishB = scheduleNext.getTimeFinish();
		
		if(schedule.getDay().equals(scheduleNext.getDay())) {
	
			//TimeStartA<TimeStartB and TimeFinishA>TimeFinishB
			Boolean aContainsB = timeStartA.isBefore(timeStartB) && timeFinishA.isAfter(timeFinishB);
			
			//TimeStartA==TimeStartB and TimeFinishA==TimeFinishB
			Boolean aEqualsB = timeStartA.equals(timeStartB) && timeFinishA.equals(timeFinishB);
			
			//TimeStartB<TimeStartA and TimeFinishB>TimeFinishA
			Boolean bContainsA=timeStartB.isBefore(timeStartA) && timeFinishB.isAfter(timeFinishA);
			
			//TimeStartA>=TimeStartB and TimeFinishA>=TimeFinishB and TimeStartA<TimeFinishB
			Boolean aAfterB= (timeStartA.isAfter(timeStartB) ||timeStartA.equals(timeStartB)) && (timeFinishA.isAfter(timeFinishB)||timeFinishA.equals(timeFinishB)) && timeStartA.isBefore(timeFinishB);
			
			//TimeStartA<=TimeStartB and TimeFinishA<=TimeFinishB and TimeStartB<TimeFinishA
			Boolean aBeforeB=(timeStartA.isBefore(timeStartB)|| timeStartA.equals(timeStartB)) && (timeFinishA.isBefore(timeFinishB)||timeFinishA.equals(timeFinishB)) && timeStartB.isBefore(timeFinishA);
			
			if (aContainsB || aEqualsB || bContainsA|| aAfterB|| aBeforeB ){
				contador ++;		
			}
		}		
		return contador;
	}
}
