package domain;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserAdapter extends AbstractTableModel{
    
	private List<ApustuAnitza> apustuList;

    // Constructor to initialize the list of Registered users
    public UserAdapter(List<ApustuAnitza> userList) {
        this.apustuList = apustuList;
    }

    public int getRowCount() {
        return apustuList.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int row, int col) {
        ApustuAnitza ap = apustuList.get(row);
      
        for (Apustua a : ap.getApustuak()) {
        switch (col) {
            case 0:
                return a.getKuota().getQuestion().getEvent();
            case 1:
                return a.getKuota().getQuestion(); 
            case 2:
            	return a.getKuota().getQuestion().getEvent().getEventDate();
            case 3:
            	return a.getKuota();
            default:
                return null;
        }
    }
        return null;
   }
}
