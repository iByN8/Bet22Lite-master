package test.java;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Event;

@RunWith(MockitoJUnitRunner.class)
public class GertaerakSortuBLBM {
	@Mock
	DataAccess dataAccess;
	
	@InjectMocks
	BLFacadeImplementation sut;
	
	
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
			Mockito.doReturn(true).when(dataAccess).gertaerakSortu(Mockito.anyString(), Mockito.any(Date.class), Mockito.anyString());
			boolean b = sut.gertaerakSortu("muju5-muju7", UtilDate.newDate(year,month,17), "Futbol");
			assertTrue(b);
		} catch (Exception e) {
			fail();
		}
		
        // Assert
        
    }
	@Test
    public void test5() {
        // Lógica para crear un evento exitoso y verificar el retorno de true
		Calendar today = Calendar.getInstance();
		   
		   int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}
        // ...
		try {
			Mockito.doReturn(false).when(dataAccess).gertaerakSortu(Mockito.anyString(), Mockito.any(Date.class), Mockito.anyString());
			boolean b = sut.gertaerakSortu("muju5-muju7", UtilDate.newDate(year,month,17), "Futbol");
			assertFalse(b);
		} catch (Exception e) {
			fail();
		}
		
        // Assert
        
    }
	

}
