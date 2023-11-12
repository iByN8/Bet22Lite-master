package iterator;

import java.util.Calendar;
import businessLogic.BLFacade;
import gui.BLFacadeFactory;
import gui.LocalBLFacadeFactory;
import configuration.UtilDate;
import domain.Event;

public class MainIterator {

    public static void main(String[] args) {
        BLFacadeFactory factory;
        factory = new LocalBLFacadeFactory();

        BLFacade facadeInterface = factory.createBLFacade();

        Calendar today = Calendar.getInstance();//

        int month = today.get(Calendar.MONTH);
        month += 1;
        int year = today.get(Calendar.YEAR);
        if (month == 12) {
            month = 0;
            year += 1;
        }
        ExtendedIterator i = facadeInterface.getEvents(UtilDate.newDate(year, month, 17));
        Event ev;
        i.goLast();
        while (i.hasPrevious()) {
            ev = (Event) i.previous();
            System.out.println(ev.toString());
        }
        i.goFirst();
        while (i.hasNext()) {
            ev = (Event) i.next();
            System.out.println(ev.toString());
        }
    }
}
