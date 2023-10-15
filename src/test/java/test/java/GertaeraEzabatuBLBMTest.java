package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Team;
import exceptions.EventFinished;
import test.dataAccess.TestDataAccess;

@RunWith(MockitoJUnitRunner.class)
public class GertaeraEzabatuBLBMTest {
	
	DataAccess dataAccess = Mockito.mock(DataAccess.class);
	Event mockedEvent = Mockito.mock(Event.class);

	@InjectMocks
	BLFacade sut = new BLFacadeImplementation(dataAccess);

	private Event ev;
	
	@Test
	public void test1() {
		try {
			
			sut.gertaeraEzabatu(null);
			fail("Null event should throw an exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

//	@Test
//	public void test2() {
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			Date oneDate = sdf.parse("05/12/2021");
//
//			Event ev1 = new Event("a", oneDate, new Team("Barca"), new Team("Bai"));
//			Mockito.doReturn(null).when(dataAccess.findEvent(null));
//			sut.gertaeraEzabatu(ev1);
//			fail();
//		} catch (Exception e) {
//			assertTrue(true);
//		}
//	}
//
//	@Test
//	public void test3() {
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			Date oneDate = sdf.parse("05/10/2022");
//			String eventText = "event1";
//
//			testDA.open();
//			ev = testDA.addEvent(eventText, oneDate);
//			testDA.close();
//
//			boolean result = sut.gertaeraEzabatu(ev);
//			assertTrue(result);
//		} catch (Exception e) {
//			fail("Unexpected exception: " + e.getMessage());
//		}
//	}
//
//	@Test
//	public void test4() {
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			Date oneDate = sdf.parse("05/10/2024");
//			String eventText = "event1";
//			String queryText = "query1";
//			Float betMinimum = new Float(2);
//
//			testDA.open();
//			ev = testDA.addEventWithQuestion(eventText, oneDate, queryText, betMinimum);
//			testDA.close();
//
//			boolean result = sut.gertaeraEzabatu(ev);
//			assertFalse(result);
//		} catch (Exception e) {
//			fail("Unexpected exception: " + e.getMessage());
//		}
//	}
//
//	@Test
//	public void test5() {
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			Date oneDate = sdf.parse("05/10/2024");
//			String eventText = "event1";
//			String queryText = "query1";
//			Float betMinimum = new Float(2);
//
//			testDA.open();
//			ev = testDA.addEventWithQuestion(eventText, oneDate, queryText, betMinimum);
//			ev = testDA.setQuestionResult(ev);
//			testDA.close();
//
//			boolean result = sut.gertaeraEzabatu(ev);
//			assertTrue(result);
//		} catch (Exception e) {
//			fail("Unexpected exception: " + e.getMessage());
//		}
//	}
//
//	@Test
//	public void test6() {
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			Date oneDate = sdf.parse("05/10/2024");
//			String eventText = "event1";
//			String queryText = "query1";
//			Float betMinimum = new Float(2);
//
//			testDA.open();
//			Event ev1 = testDA.addEventWithQuestion(eventText, oneDate, queryText, betMinimum);
//			testDA.close();
//
//			boolean result = sut.gertaeraEzabatu(ev1);
//			assertTrue(result);
//		} catch (Exception e) {
//			fail("Unexpected exception: " + e.getMessage());
//		}
//	}
}