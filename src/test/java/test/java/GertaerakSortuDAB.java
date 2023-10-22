package test.java;

import static org.junit.Assert.*;


import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import org.junit.Test;

import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Event;
import test.dataAccess.TestDataAccess;

public class GertaerakSortuDAB {

	static DataAccess sut = new DataAccess();
	static TestDataAccess testDA = new TestDataAccess();
	
	private Event ev;
	private Vector<Event> evs;
	@Test
    public void test1() {
		try {
			//invoke System Under Test (sut)
			sut.gertaerakSortu(null, new Date(), "Futbol");
			fail();
		   } catch (Exception e) {
			   assertTrue(true);
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
		   }
	}
	@Test
    public void test2() {
		try {
			//invoke System Under Test (sut)
			sut.gertaerakSortu("ser-serr", new Date(), null);
			
		   } catch (Exception e) {
			   assertTrue(true);
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
		   }
	}
	@Test
    public void test3() {
		try {
			//invoke System Under Test (sut)
			sut.gertaerakSortu("ser-serr", null, "Futbol");
			
		   } catch (Exception e) {
			   assertTrue(true);
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
		   }
	}
	
	@Test
    public void test4() {
        // Lógica para crear un evento exitoso y verificar el retorno de true
		Calendar today = Calendar.getInstance();
		   
		   int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}
        // ...
		try {
			boolean b = sut.gertaerakSortu("muju5-muju7", UtilDate.newDate(year,month,17), "Futbol");
			evs = sut.getEvents(UtilDate.newDate(year,month,17));
			for (Event ev1: evs) {
				if (ev1.getDescription().equals("muju5-muju7")) {
					ev=ev1;
				}
			}
			sut.gertaeraEzabatu(ev);
			assertTrue(b);
		} catch (Exception e) {
			fail();
		}
		
        // Assert
        
    }
	
	@Test
    public void test5() {
        // Lógica para crear un evento con una descripción existente y verificar el retorno de false
    	Calendar today = Calendar.getInstance();
		   
		   int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}
        // ...

        // Assert
        assertTrue(sut.gertaerakSortu("Atletico-Athletic", UtilDate.newDate(year,month,17), "Futbol"));
    }
	

   

}
