package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.ApustuAnitza;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Team;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;
import test.dataAccess.TestDataAccess;

public class GertaeraEzabatuDAB {

	// sut:system under test
	static DataAccess sut = new DataAccess();

	// additional operations needed to execute the test
	static TestDataAccess testDA = new TestDataAccess();

	private Event ev;

	@Test
	// sut.createQuestion: The event has NOT one question with a queryText.
	public void test1() {
		try {
		
			sut.gertaeraEzabatu(null);
			fail(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// if the program goes to this point fail
			assertTrue(true);
		}
	}

	@Test
	// sut.createQuestion: The event has NOT one question with a queryText.
	public void test2() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			;
			try {
				oneDate = sdf.parse("05/12/2021");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// configure the state of the system (create object in the dabatase)

			Event ev1 = new Event("a",oneDate,new Team("Barca"),new Team("Bai"));

			// invoke System Under Test (sut)
			sut.gertaeraEzabatu(ev1);
			fail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// if the program goes to this point fail
			assertTrue(true);
		}
	}

	@Test
	// sut.createQuestion: The event has NOT one question with a queryText.
	public void test3() {
		try {
			// define paramaters
			String eventText = "event1";
			;

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// configure the state of the system (create object in the dabatase)
			testDA.open();
			ev = testDA.addEvent(eventText, oneDate);
			testDA.close();
			// invoke System Under Test (sut)
			boolean b = sut.gertaeraEzabatu(ev);
			assertTrue(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// if the program goes to this point fail
			fail();
		}
	}

	@Test
	// sut.createQuestion: The event has NOT one question with a queryText.
	public void test4() {
		try {
			// define paramaters
			String eventText = "event1";
			String queryText = "query1";
			Float betMinimum = new Float(2);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			;
			try {
				oneDate = sdf.parse("05/10/2024");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// configure the state of the system (create object in the dabatase)
			testDA.open();
			ev = testDA.addEventWithQuestion(eventText, oneDate, "query2", betMinimum);
			testDA.close();

			// invoke System Under Test (sut)
			boolean b = sut.gertaeraEzabatu(ev);
			assertFalse(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// if the program goes to this point fail

			fail();
		}
	}

	@Test
	// sut.createQuestion: The event has NOT one question with a queryText.
	public void test5() {
		try {
			// define paramaters
			String eventText = "event1";
			String queryText = "query1";
			Float betMinimum = new Float(2);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			;
			try {
				oneDate = sdf.parse("05/10/2024");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// configure the state of the system (create object in the dabatase)
			testDA.open();
			ev = testDA.addEventWithQuestion(eventText, oneDate, "query2", betMinimum);
			ev = testDA.setQuestionResult(ev);
			Quote qu = testDA.setQuoteQuestions(ev);
			testDA.close();

			// invoke System Under Test (sut)
			boolean b = sut.gertaeraEzabatu(ev);
			assertTrue(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// if the program goes to this point fail

			fail();
		}
	}

	@Test
	// sut.createQuestion: The event has NOT one question with a queryText.
	public void test6() {
		try {
			// define paramaters
			String eventText = "event1";
			String queryText = "query1";
			Float betMinimum = new Float(2);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			;
			try {
				oneDate = sdf.parse("05/10/2024");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// configure the state of the system (create object in the dabatase)
			testDA.open();
			Event ev1 = testDA.addEventWithQuestion(eventText, oneDate, queryText, betMinimum);
			// Set the primary key (event number) to a unique value (e.g., a timestamp)
			ev = testDA.setQuestionResult(ev1);
			Quote qu = testDA.setQuoteQuestions(ev);
			testDA.setApustuaTest(ev);
			testDA.gehituApustua(qu);

			testDA.close();

			// invoke System Under Test (sut)
			boolean b = sut.gertaeraEzabatu(ev);
			assertTrue(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// if the program goes to this point fail

			fail();
		}
	}

}
