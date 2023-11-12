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
       

        switch (col) {
            case 0:
                return 0;
            case 1:
                return 1; 
            case 2:
            	return 2;
            case 3:
            	return 3;
            default:
                return null;
        }
    }

}
