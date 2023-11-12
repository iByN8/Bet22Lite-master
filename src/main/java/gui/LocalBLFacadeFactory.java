package gui;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;

public class LocalBLFacadeFactory implements BLFacadeFactory {
    public BLFacade createBLFacade() {
        DataAccess da = new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));
        return new BLFacadeImplementation(da);
    }
}
