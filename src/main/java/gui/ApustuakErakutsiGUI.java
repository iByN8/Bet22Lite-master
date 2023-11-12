package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.BLFacadeImplementation;
import domain.Registered;
import domain.UserAdapter;
import domain.ApustuAnitza;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

public class ApustuakErakutsiGUI extends JFrame {
	  private JTable userTable;
	    private UserAdapter userAdapter;

	    public ApustuakErakutsiGUI(List<ApustuAnitza> listaUsuarios) {
	    	
	        setTitle("Egindako apustuak:");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(500, 300);

	        userAdapter = new UserAdapter(listaUsuarios);
	        userTable = new JTable(userAdapter);
	        JScrollPane scrollPane = new JScrollPane(userTable);
	        getContentPane().add(scrollPane);
	        setVisible(true);
	    }



}
