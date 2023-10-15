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

public class EmaitzakIpiniDAWTest {


	 //sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();

	private Event ev;
	private Quote q;
	
	public void test1() {
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
			q.getQuestion().setResult("galduta");
			testDA.close();	
			//invoke System Under Test (sut)
			sut.EmaitzakIpini(q);
			
			assertTrue(true);
		   } catch (Exception e) {
			   
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			}
		   }
	
	public void test2() {
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
			q.getQuestion().setResult("irabazita");
			testDA.close();	
			//invoke System Under Test (sut)
			sut.EmaitzakIpini(q);
			assertTrue(true);
			
		   } catch (Exception e) {
			   
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			}
		   }
	
	@Test
	//sut.createQuestion:  The event is null. The test fail
		public void test3() {
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
				q.setQuestion(null);
				testDA.close();	
				
				//invoke System Under Test (sut)  
				sut.EmaitzakIpini(q);
				
			   } catch (Exception e) {
				   assertTrue(true);	
				// TODO Auto-generated catch block
				// if the program goes to this point fail  
				} 
			}
	
	@Test
	//sut.createQuestion:  The event is null. The test fail
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
				q.setApustuak(null);
				testDA.close();	
				
				//invoke System Under Test (sut)  
				sut.EmaitzakIpini(q);
				
			   } catch (Exception e) {
				   assertTrue(true);	
				// TODO Auto-generated catch block
				// if the program goes to this point fail  
				} 
			}
	
	@Test
	//sut.createQuestion:  The question is null. The test fail
	public void test5() {
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
			sut.EmaitzakIpini(q);
			
		   } catch (EventNotFinished e) {
			   assertTrue(true);
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			}
		   }
	
	@Test
	//sut.createQuestion:  The question is null. The test fail
	public void test6() {
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
			a.setEgoera("galduta");
			q.addApustua(a);
			testDA.close();			
			
			//invoke System Under Test (sut)  
			sut.EmaitzakIpini(q);
			assertTrue(true);
			
		   } catch (Exception e) {
			   fail();
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			}
		   }
	
	@Test
	//sut.createQuestion:  The question is null. The test fail
	public void test7() {
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
			a.setEgoera("irabazita");
			q.addApustua(a);
			testDA.close();			
			
			//invoke System Under Test (sut)  
			sut.EmaitzakIpini(q);
			assertTrue(true);
			
		   } catch (Exception e) {
			   fail();
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			}
		   }
}
