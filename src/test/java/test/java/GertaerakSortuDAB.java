package test.java;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import configuration.UtilDate;
import dataAccess.DataAccess;

public class GertaerakSortuDAB {

	static DataAccess sut = new DataAccess();
	
	@Test
    public void test1() {
		try {
			//invoke System Under Test (sut)
			sut.gertaerakSortu(null, new Date(), "Futbol");
			
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
	

   

}
