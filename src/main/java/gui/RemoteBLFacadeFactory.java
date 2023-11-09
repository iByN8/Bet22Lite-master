package gui;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import configuration.ConfigXML;

class RemoteBLFacadeFactory implements BLFacadeFactory {
    public BLFacade createBLFacade() {
        ConfigXML c = ConfigXML.getInstance();
        String serviceName = "http://" + c.getBusinessLogicNode() + ":" + c.getBusinessLogicPort() + "/ws/"
                + c.getBusinessLogicName() + "?wsdl";

        try {
            URL url = new URL(serviceName);
            QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
            Service service = Service.create(url, qname);
            return service.getPort(BLFacade.class);
        } catch (Exception e) {
            throw new RuntimeException("Error creating remote BLFacade: " + e.toString());
        }
    }
}