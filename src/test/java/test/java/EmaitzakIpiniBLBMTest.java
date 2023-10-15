package test.java;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dataAccess.DataAccess;
import domain.Apustua;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Team;
import exceptions.EventNotFinished;

public class EmaitzakIpiniBLBMTest {
	
	DataAccess MockDB = Mockito.mock(DataAccess.class);
	Quote q = Mockito.mock(Quote.class);


	@Test
	//sut.createQuestion:  The event has NOT one question with a queryText. 
	public void test1() {
		try {
			//invoke System Under Test (sut)
			Quote qu = null;
			MockDB.EmaitzakIpini(qu);
			
		   } catch (Exception e) {
			   assertTrue(true);
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			}
		   }
	@Test
	//sut.createQuestion:  The event is null. The test fail
		public void test2() {
			try {
					
				Quote qu = new Quote();
				//invoke System Under Test (sut)  
				MockDB.EmaitzakIpini(qu);
				
			   } catch (Exception e) {
				   assertTrue(true);	
				// TODO Auto-generated catch block
				// if the program goes to this point fail  
				} 
			}
	@Test
	//sut.createQuestion:  The question is null. The test fail
	public void test3() {
		try {
			
			//define paramaters
			String eventText="event1";
			String queryText=null;
			Float betMinimum=new Float(2);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2024");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//configure the state of the system (create object in the dabatase)
			Mockito.doReturn(oneDate).when(q.getQuestion().getEvent().getEventDate());
			
			//invoke System Under Test (sut)  
			MockDB.EmaitzakIpini(q);
			fail();
			
		   } catch (EventNotFinished e) {
			   assertTrue(true);
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			}
		   }
	
	@Test
	//sut.createQuestion:  The question is null. The test fail
	public void test4() {
		try {
			
			//define paramaters
			String eventText="event1";
			String queryText=null;
			Float betMinimum=new Float(2);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			Date d=null;;
			try {
				d = sdf.parse("04/10/2022");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Question qu = new Question(queryText, betMinimum, new Event(eventText, d, new Team(), new Team()));
			Apustua a = new Apustua();
			q.addApustua(a);
			a.setKuota(q);
			qu.setQuestion(queryText);
			
			//configure the state of the system (create object in the dabatase)
			Mockito.doReturn("irabazita").when(q.getForecast());
			Mockito.doReturn(oneDate).when(q.getQuestion().getEvent().getEventDate());
			Mockito.doReturn(qu).when(q.getQuestion());
			
			//invoke System Under Test (sut)  
			MockDB.EmaitzakIpini(q);
			assertTrue(true);
			
		   } catch (EventNotFinished e) {
			   fail();
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			}
		   }

}
