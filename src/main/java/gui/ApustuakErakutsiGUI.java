package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.BLFacadeImplementation;
import domain.Registered;
import domain.UserAdapter;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

public class ApustuakErakutsiGUI extends JFrame {
	  private JTable userTable;
	    private UserAdapter userAdapter;

	    public ApustuakErakutsiGUI(List<Registered> listaUsuarios) {
	        // Configurar la ventana
	        setTitle("Egindako apustuak:");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(500, 300);

	        userAdapter = new UserAdapter(listaUsuarios);
	        userTable = new JTable(userAdapter);
	        JScrollPane scrollPane = new JScrollPane(userTable);
	        getContentPane().add(scrollPane);
	        setVisible(true);
	    }

	  
	    public static void main(String[] args) {
	    	try {
	    	blFacade= new BLFacadeImplementation(); //
	    	Registered user = blFacade.getUser("MaiteUrreta");
	    	WindowTable vt = new WindowTable(user);
	    	vt.setVisible(true);
	    	} catch (Exception e) {
	    	e.printStackTrace();
	    	}
	    	}
	   

}
