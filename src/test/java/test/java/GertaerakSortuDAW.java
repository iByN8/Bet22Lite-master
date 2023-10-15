package test.java;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import configuration.UtilDate;
import dataAccess.DataAccess;
import test.dataAccess.TestDataAccess;

public class GertaerakSortuDAW {

	static DataAccess sut = new DataAccess();
	static TestDataAccess testDA = new TestDataAccess();
	
	//Dagoeneko datubasean dauden gertaerak
	//Event ev1=new Event(1, "Atletico-Athletic", UtilDate.newDate(year,month,17), team1, team2);
	//Event ev2=new Event(2, "Eibar-Barcelona", UtilDate.newDate(year,month,17), team3, team4);
	
	@Test
    public void test1() {
        // Lógica para crear un evento con un deporte no válido y verificar el retorno de false
        // ...

        // Assert
        assertFalse(sut.gertaerakSortu("Talde1-Talde2", new Date(), "DB-an ez dagoen kirola"));
    }
	
	@Test
    public void test2() {
        // Lógica para crear un evento exitoso y verificar el retorno de true
		Calendar today = Calendar.getInstance();
		   
		   int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}
        // ...

        // Assert
        assertTrue(sut.gertaerakSortu("Athletic-Eibar", UtilDate.newDate(year,month,17), "Futbol"));
    }

    @Test
    public void test3() {
        // Lógica para crear un evento con una descripción existente y verificar el retorno de false
    	Calendar today = Calendar.getInstance();
		   
		   int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}
        // ...

        // Assert
        assertFalse(sut.gertaerakSortu("Atletico-Athletic", UtilDate.newDate(year,month,17), "Futbol"));
    }

}
