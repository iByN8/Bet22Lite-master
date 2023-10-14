package test.dataAccess;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import configuration.ConfigXML;
import domain.ApustuAnitza;
import domain.Apustua;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Sport;
import domain.Team;

public class TestDataAccess {
	protected  EntityManager  db;
	protected  EntityManagerFactory emf;

	ConfigXML  c=ConfigXML.getInstance();


	public TestDataAccess()  {
		
		System.out.println("Creating TestDataAccess instance");

		open();
		
	}

	
	public void open(){
		
		System.out.println("Opening TestDataAccess instance ");

		String fileName=c.getDbFilename();
		
		if (c.isDatabaseLocal()) {
			  emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
			  db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			  properties.put("javax.persistence.jdbc.user", c.getUser());
			  properties.put("javax.persistence.jdbc.password", c.getPassword());

			  emf = Persistence.createEntityManagerFactory("objectdb://"+c.getDatabaseNode()+":"+c.getDatabasePort()+"/"+fileName, properties);

			  db = emf.createEntityManager();
    	   }
		
	}
	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}

	public boolean removeEvent(Event ev) {
		System.out.println(">> DataAccessTest: removeEvent");
		Event e = db.find(Event.class, ev.getEventNumber());
		if (e!=null) {
			db.getTransaction().begin();
			db.remove(e);
			db.getTransaction().commit();
			return true;
		} else 
		return false;
    }
		
		public Event addEventWithQuestion(String desc, Date d, String question, float qty) {
			System.out.println(">> DataAccessTest: addEvent");
			Event ev=null;
				db.getTransaction().begin();
				try {
				    ev=new Event(desc,d, new Team("Ibai"), new Team("Mugu"));
				    ev.addQuestion(question, qty);
					db.persist(ev);
					db.getTransaction().commit();
				}
				catch (Exception e){
					e.printStackTrace();
				}
				return ev;
	    }
		public boolean existQuestion(Event ev,Question q) {
			System.out.println(">> DataAccessTest: existQuestion");
			Event e = db.find(Event.class, ev.getEventNumber());
			if (e!=null) {
				return e.DoesQuestionExists(q.getQuestion());
			} else 
			return false;
			
		}
			
		public Event setQuestionResult(Event ev) {
			db.getTransaction().begin();
			Event a=db.find(Event.class, ev.getEventNumber());
			a.getQuestions().get(0).setResult("galduta");
			db.getTransaction().commit();
			return a;
			
		}
		public Quote setQuoteQuestions(Event ev) {
			db.getTransaction().begin();
			Event a=db.find(Event.class, ev.getEventNumber());
			Question q=a.getQuestions().get(0);
			Quote qu=q.addQuote(1.9, "Lokala", q);
			db.getTransaction().commit();
			return qu;
			
		}
		public ApustuAnitza setApustuaTest(Event ev) {
		    db.getTransaction().begin();

		    Quote q = db.find(Quote.class, ev.getQuestions().get(0).getQuotes().get(0).getQuoteNumber());
  
		    Registered r = db.find(Registered.class, "user");

		    ApustuAnitza aa = new ApustuAnitza(r, 3.0);
		
		    Apustua apustua = new Apustua(aa, q);
		    
		    aa.addApustua(apustua);
		    q.addApustua(apustua);
	
		    Sport s = db.find(Sport.class, "Futbol"); 
		    s.eguneratuApustuKantitatea();
		    s.addEvent(ev);
		    ev.setSport(s);

		    db.persist(q);
		    db.persist(aa);
		    db.persist(apustua);

		    db.getTransaction().commit();

		    return aa;
		}
		public void gehituApustua(Quote q) {
			db.getTransaction().begin();
			Quote qu=db.find(Quote.class, q.getQuoteNumber());
			
			ApustuAnitza aa=db.find(ApustuAnitza.class, qu.getApustuak().get(0).getApustuAnitza());
			
			Apustua apustua = new Apustua(aa,qu);
			aa.addApustua(apustua);
			
			db.persist(apustua);
			db.getTransaction().commit();
		}
}

