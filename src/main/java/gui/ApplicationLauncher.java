package gui;

import java.awt.Color;

import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;

public class ApplicationLauncher {

    public static void main(String[] args) {
        ConfigXML c = ConfigXML.getInstance();

        System.out.println(c.getLocale());

        Locale.setDefault(new Locale(c.getLocale()));

        System.out.println("Locale: " + Locale.getDefault());

        MainGUI a = new MainGUI();
        a.setVisible(false);

        MainUserGUI b = new MainUserGUI();
        b.setVisible(true);

        try {
            BLFacadeFactory factory;
            if (c.isBusinessLogicLocal()) {
                factory = new LocalBLFacadeFactory();
            } else {
                factory = new RemoteBLFacadeFactory();
            }

            BLFacade appFacadeInterface = factory.createBLFacade();
            MainGUI.setBussinessLogic(appFacadeInterface);

            // Set look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            a.jLabelSelectOption.setText("Error: " + e.toString());
            a.jLabelSelectOption.setForeground(Color.RED);

            System.out.println("Error in ApplicationLauncher: " + e.toString());
        }
    }
}
