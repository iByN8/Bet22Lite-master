package test.java;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataAccess.DataAccess;
import domain.Apustua;
import domain.Event;
import domain.Question;
import domain.Quote;
import exceptions.EventNotFinished;
import exceptions.QuestionAlreadyExist;
import test.dataAccess.TestDataAccess;

public class EmaitzakIpiniDABTest {

	 //sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();

	private Quote q;
	
	
	@Test
	//sut.createQuestion:  The event has NOT one question with a queryText. 
	public void test1() {
		try {
			//invoke System Under Test (sut)
			Quote qu = null;
			sut.EmaitzakIpini(qu, new Date());
			
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
				sut.EmaitzakIpini(qu, new Date());
				
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
			testDA.open();
			Event ev = testDA.addEventWithQuestion(eventText,oneDate,"query2", betMinimum);
			q = testDA.setQuoteQuestions(ev);
			Apustua a = new Apustua();
			q.addApustua(a);
			a.setKuota(q);
			testDA.close();			
			
			//invoke System Under Test (sut)  
			sut.EmaitzakIpini(q, new Date());
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//configure the state of the system (create object in the dabatase)
			testDA.open();
			Event ev = testDA.addEventWithQuestion(eventText,oneDate,"query2", betMinimum);
			q = testDA.setQuoteQuestions(ev);
			Apustua a = new Apustua();
			a.setKuota(q);
			q.addApustua(a);
			testDA.close();			
			
			//invoke System Under Test (sut)  
			sut.EmaitzakIpini(q, new Date());
			assertTrue(true);
			
		   } catch (EventNotFinished e) {
			   fail();
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			}
		   }

}
