package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import acme.Schedule;

import controller.Controller;
class ControllerTest {
	
	@Test
	void testCompareTime() {
		LocalTime timeStartA = LocalTime.parse("10:32",DateTimeFormatter.ISO_TIME);
		LocalTime timeFinishA= LocalTime.parse("12:30",DateTimeFormatter.ISO_TIME);
		Schedule schedule = new Schedule("MO", timeStartA , timeFinishA);
		
		LocalTime timeStartB = LocalTime.parse("11:30",DateTimeFormatter.ISO_TIME);
		LocalTime timeFinishB = LocalTime.parse("12:20",DateTimeFormatter.ISO_TIME);
		Schedule scheduleNext = new Schedule("MO", timeStartB , timeFinishB );
		int counter = 0;
		int expected = 1;
		int actual = Controller.compareTime(schedule, scheduleNext, counter);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCompareTime2() {
		LocalTime timeStartA = LocalTime.parse("09:00",DateTimeFormatter.ISO_TIME);
		LocalTime timeFinishA= LocalTime.parse("10:30",DateTimeFormatter.ISO_TIME);
		Schedule schedule = new Schedule("MO", timeStartA , timeFinishA);
		
		LocalTime timeStartB = LocalTime.parse("12:30",DateTimeFormatter.ISO_TIME);
		LocalTime timeFinishB = LocalTime.parse("14:30",DateTimeFormatter.ISO_TIME);
		Schedule scheduleNext = new Schedule("MO", timeStartB , timeFinishB );
		int counter = 0;
		int expected = 0;
		int actual = Controller.compareTime(schedule, scheduleNext, counter);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCompareTime3() {
		LocalTime timeStartA = LocalTime.parse("09:45",DateTimeFormatter.ISO_TIME);
		LocalTime timeFinishA= LocalTime.parse("11:50",DateTimeFormatter.ISO_TIME);
		Schedule schedule = new Schedule("MO", timeStartA , timeFinishA);
		
		LocalTime timeStartB = LocalTime.parse("11:45",DateTimeFormatter.ISO_TIME);
		LocalTime timeFinishB = LocalTime.parse("14:30",DateTimeFormatter.ISO_TIME);
		Schedule scheduleNext = new Schedule("MO", timeStartB , timeFinishB );
		int counter = 0;
		int expected = 1;
		int actual = Controller.compareTime(schedule, scheduleNext, counter);
		
		assertEquals(expected, actual);
	}
	@Test
	void testCompareTime4() {
		LocalTime timeStartA = LocalTime.parse("09:45",DateTimeFormatter.ISO_TIME);
		LocalTime timeFinishA= LocalTime.parse("11:50",DateTimeFormatter.ISO_TIME);
		Schedule schedule = new Schedule("TH", timeStartA , timeFinishA);
		
		LocalTime timeStartB = LocalTime.parse("11:45",DateTimeFormatter.ISO_TIME);
		LocalTime timeFinishB = LocalTime.parse("14:30",DateTimeFormatter.ISO_TIME);
		Schedule scheduleNext = new Schedule("MO", timeStartB , timeFinishB );
		int counter = 0;
		int expected = 0;
		int actual = Controller.compareTime(schedule, scheduleNext, counter);
		
		assertEquals(expected, actual);
	}
}
