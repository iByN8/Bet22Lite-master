package iterator;

import java.util.Vector;

import domain.Event;

public class ExtendedIteratorEvents implements ExtendedIterator{
	private Vector<Event> events;
	private int pos;	
	public ExtendedIteratorEvents(Vector<Event> vector) {
		events = vector;
		pos = 0;
	}
	public Vector<Event> getEvents() {
		return events;
	}
	public void setEvents(Vector<Event> events) {
		this.events = events;
	}
	public Event previous() {
		Event event =events.get(pos);
		pos -=1;
		return event;
	}
	public boolean hasPrevious() {
		return (pos>0);
	}
	public void goFirst() {
		pos = 0;
	}
	public void goLast() {
		pos = events.size()-1;
	}
	@Override
	public boolean hasNext() {
		return pos < events.size();
	}
	@Override
	public Event next() {
		// TODO Auto-generated method stub
		Event event =events.get(pos);
		pos += 1;
		return event;
	}
}