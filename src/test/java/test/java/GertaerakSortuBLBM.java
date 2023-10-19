package test.java;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
		   ArgumentCaptor<String> descCaptor =
				   ArgumentCaptor.forClass(String.class);
				   ArgumentCaptor<Date> dataCaptor =
				   ArgumentCaptor.forClass(Date.class);
				   ArgumentCaptor<String> kirolaCaptor =
				   ArgumentCaptor.forClass(String.class);
		   
		   String desc = "123-123";
		   Date data = UtilDate.newDate(year,month,17);
		   String kirola = "Futbol";
		try {
			Mockito.verify(dataAccess,Mockito.times(1))
			.gertaerakSortu(descCaptor.capture(), dataCaptor.capture(), kirolaCaptor.capture());
			Mockito.doReturn(true).when(dataAccess).gertaerakSortu(Mockito.anyString(), Mockito.any(Date.class), Mockito.anyString());
			boolean b = sut.gertaerakSortu(desc, data, kirola);
			assertTrue(b);
			assertEquals(desc, descCaptor.getValue());
			assertEquals(data, dataCaptor.getValue());
			assertEquals(kirola, kirolaCaptor.getValue());
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
		   ArgumentCaptor<String> descCaptor =
				   ArgumentCaptor.forClass(String.class);
				   ArgumentCaptor<Date> dataCaptor =
				   ArgumentCaptor.forClass(Date.class);
				   ArgumentCaptor<String> kirolaCaptor =
				   ArgumentCaptor.forClass(String.class);
		   
		   String desc = "Atletico-Athletic";
		   Date data = UtilDate.newDate(year,month,17);
		   String kirola = "Futbol";
		try {
			Mockito.verify(dataAccess,Mockito.times(1))
			.gertaerakSortu(descCaptor.capture(), dataCaptor.capture(), kirolaCaptor.capture());
			Mockito.doReturn(false).when(dataAccess).gertaerakSortu(Mockito.anyString(), Mockito.any(Date.class), Mockito.anyString());
			boolean b = sut.gertaerakSortu(desc, data, kirola);
			assertFalse(b);
			assertEquals(desc, descCaptor.getValue());
			assertEquals(data, dataCaptor.getValue());
			assertEquals(kirola, kirolaCaptor.getValue());
		} catch (Exception e) {
			fail();
		}
		
        // Assert
        
    }
	

}
