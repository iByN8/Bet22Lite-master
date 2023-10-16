package test.java;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.ApustuAnitza;
import domain.Apustua;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Team;
import exceptions.EventFinished;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import org.junit.Test;

import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Event;
import test.dataAccess.TestDataAccess;

@RunWith(MockitoJUnitRunner.class)
public class GertaeraEzabatuBLBMTest {
	@Mock
	DataAccess dataAccess;

	@InjectMocks
	BLFacadeImplementation sut;

	private Event ev;

	@Test
	public void test1() {
		try {
			boolean b = sut.gertaeraEzabatu(null);
			assertTrue(!b);
		} catch (Exception e) {
			fail("");
		}
	}

	@Test  
	public void test2() {
		Team t1 = new Team("Barca");
		Team t2 = new Team("Bai");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate = null;
		try {
			oneDate = sdf.parse("05/10/2023");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			boolean emaitza = true;
			Event ev = new Event("a", oneDate, t1, t2);
			Mockito.doReturn(false).when(dataAccess).gertaeraEzabatu(ev);
			emaitza = (sut.gertaeraEzabatu(ev));
			assertFalse(emaitza);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test3() {
		Registered u = new Registered("user", "w", 10);
		Team t1 = new Team("Barca");
		Team t2 = new Team("Bai");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate = null;
		try {
			oneDate = sdf.parse("05/10/2023");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Event ev = new Event("a", oneDate, t1, t2);

			ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
			Mockito.doReturn(true).when(dataAccess).gertaeraEzabatu(ev);

			boolean emaitza = sut.gertaeraEzabatu(ev);
			assertTrue(emaitza);
			Mockito.verify(dataAccess, Mockito.times(1)).gertaeraEzabatu(eventCaptor.capture());
			assertEquals(ev, eventCaptor.getValue());

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test4() {
		Registered u = new Registered("user", "w", 10);
		Team t1 = new Team("Barca");
		Team t2 = new Team("Bai");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate = null;
		try {
			oneDate = sdf.parse("05/11/2023");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Event ev = new Event("a", oneDate, t1, t2);
			Question quest = ev.addQuestion("question", 1.8);

			ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
			Mockito.doReturn(true).when(dataAccess).gertaeraEzabatu(ev);

			boolean emaitza = sut.gertaeraEzabatu(ev);

			assertTrue(emaitza);

			// verify arguments
			Mockito.verify(dataAccess, Mockito.times(1)).gertaeraEzabatu(eventCaptor.capture());
			assertEquals(ev, eventCaptor.getValue());

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test5() {
		Registered u = new Registered("user", "w", 10);
		Team t1 = new Team("Barca");
		Team t2 = new Team("Bai");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate = null;
		try {
			oneDate = sdf.parse("05/11/2023");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Event ev = new Event("a", oneDate, t1, t2);
			Question qu = ev.addQuestion("a", 1.8);
			qu.addQuote(2.9, "Bai", qu);

			ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
			Mockito.doReturn(true).when(dataAccess).gertaeraEzabatu(ev);

			boolean emaitza = sut.gertaeraEzabatu(ev);
			assertTrue(emaitza);

			Mockito.verify(dataAccess, Mockito.times(1)).gertaeraEzabatu(eventCaptor.capture());
			assertEquals(ev, eventCaptor.getValue());

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test6() {
		Registered u = new Registered("user", "w", 10);
		Team t1 = new Team("Barca");
		Team t2 = new Team("Bai");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate = null;
		try {
			oneDate = sdf.parse("05/11/2023");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Event ev = new Event("a", oneDate, t1, t2);
			Question qu = ev.addQuestion("a", 1.8);
			Quote q = qu.addQuote(2.5, "Bai", qu);
			Quote kuota = qu.addQuote(2.9, "Barca", qu);
			ApustuAnitza aa = new ApustuAnitza(u, 4.8);
			Apustua apustuak = new Apustua(aa, q);
			Apustua apustuak1 = new Apustua(aa, kuota);
			q.addApustua(apustuak);
			q.addApustua(apustuak1);

			ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
			Mockito.doReturn(true).when(dataAccess).gertaeraEzabatu(ev);

			boolean emaitza = sut.gertaeraEzabatu(ev);
			assertTrue(emaitza);

			// verify arguments
			Mockito.verify(dataAccess, Mockito.times(1)).gertaeraEzabatu(eventCaptor.capture());
			assertEquals(ev, eventCaptor.getValue());

		} catch (Exception e) {
			fail();
		}
	}
}