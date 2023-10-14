package test.java;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import dataAccess.DataAccess;
import domain.ApustuAnitza;
import domain.Event;
import domain.Quote;
import domain.Team;
import exceptions.QuestionAlreadyExist;
import test.dataAccess.TestDataAccess;

public class GertaeraEzabatuDAW {

	static DataAccess sut = new DataAccess();
	static TestDataAccess testDA = new TestDataAccess();
	private Event ev;

	@Test
	public void test1() {
		try {

			// define paramaters

			String eventText = "test";
			String queryText = "query1";
			Float betMinimum = new Float(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// configure the state of the system (create object in the dabatase)
			testDA.open();
			ev = testDA.addEventWithQuestion(eventText, oneDate, queryText, betMinimum);
			testDA.close();
			// invoke System Under Test (sut)
			assertFalse(sut.gertaeraEzabatu(ev));
			// if the program continues fail
		} catch (Exception e) {
			// if the program goes to this point OK
			// fail();
			fail();
		} finally {
			// Remove the created objects in the database (cascade removing)
			testDA.open();
			boolean b = testDA.removeEvent(ev);
			testDA.close();
			// System.out.println("Finally "+b);
		}
	}

	@Test
	public void test2() {
		try {

			// define paramaters

			String eventText = "test";
			String queryText = "query1";
			Float betMinimum = new Float(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			try {
				oneDate = sdf.parse("05/10/202s");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// configure the state of the system (create object in the dabatase)
			testDA.open();
			Event ev1 = testDA.addEventWithQuestion(eventText, oneDate, queryText, betMinimum);
			ev = testDA.setQuestionResult(ev1);
			testDA.close();
			// invoke System Under Test (sut)
			assertTrue(sut.gertaeraEzabatu(ev));
			// if the program continues fail
		} catch (Exception e) {
			// if the program goes to this point OK
			// fail();
			fail();
		} finally {
			// Remove the created objects in the database (cascade removing)
			testDA.open();
			boolean b = testDA.removeEvent(ev);
			assertFalse(b);
			testDA.close();
			// System.out.println("Finally "+b);
		}
	}

	@Test
	public void test3() {
		try {

			// define paramaters
			String eventText = "test";
			String queryText = "query1";
			Float betMinimum = new Float(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			try {
				oneDate = sdf.parse("05/11/2023");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// configure the state of the system (create object in the dabatase)
			testDA.open();
			Event ev1 = testDA.addEventWithQuestion(eventText, oneDate, queryText, betMinimum);
			ev = testDA.setQuestionResult(ev1);
			testDA.close();
			// invoke System Under Test (sut)
			assertTrue(sut.gertaeraEzabatu(ev));
			// if the program continues fail
		} catch (Exception e) {
			// if the program goes to this point OK
			// fail();
			fail();
		} finally {
			// Remove the created objects in the database (cascade removing)
			testDA.open();
			boolean b = testDA.removeEvent(ev);
			assertFalse(b);
			testDA.close();
			// System.out.println("Finally "+b);
		}
	}

	@Test
	public void test4() {
		try {
			// define paramaters
			String eventText = "test";
			String queryText = "query1";
			Float betMinimum = new Float(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			try {
				oneDate = sdf.parse("05/11/2023");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// configure the state of the system (create object in the dabatase)
			testDA.open();
			Event ev1 = testDA.addEventWithQuestion(eventText, oneDate, queryText, betMinimum);
			ev = testDA.setQuestionResult(ev1);
			testDA.setQuoteQuestions(ev);
			testDA.close();
			// invoke System Under Test (sut)
			assertTrue(sut.gertaeraEzabatu(ev));
			// if the program continues fail
		} catch (Exception e) {
			// if the program goes to this point OK
			// fail();
			fail();
		} finally {
			// Remove the created objects in the database (cascade removing)
			testDA.open();
			boolean b = testDA.removeEvent(ev);
			assertFalse(b);
			testDA.close();
			// System.out.println("Finally "+b);
		}
	}

	@Test
	public void test5() {
		try {
			// define paramaters
			String eventText = "test";
			String queryText = "query1";
			Float betMinimum = new Float(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate = null;
			try {
				oneDate = sdf.parse("05/11/2023");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// configure the state of the system (create object in the dabatase)
			testDA.open();
			Event ev1 = testDA.addEventWithQuestion(eventText, oneDate, queryText, betMinimum);
			ev = testDA.setQuestionResult(ev1);
			Quote qu = testDA.setQuoteQuestions(ev);
			ApustuAnitza aa = testDA.setApustuaTest(ev);
			testDA.close();
			assertTrue(!aa.getEgoera().equals("galduta"));
			assertTrue(sut.gertaeraEzabatu(ev));
			// if the program continues fail
		} catch (Exception e) {
			// if the program goes to this point OK
			// fail();
			fail();
		} finally {
			// Remove the created objects in the database (cascade removing)
			testDA.open();
			boolean b = testDA.removeEvent(ev);
			assertFalse(b);
			testDA.close();
			// System.out.println("Finally "+b);
		}
	}

}
