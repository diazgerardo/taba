package ar.com.scriptorum.actions;

import ar.com.scriptorum.beans.Itinerario;
import ar.com.scriptorum.dao.ItinerarioDao;

import com.opensymphony.xwork2.ModelDriven;

public class ItinerarioActions extends SpringActionSupport implements ModelDriven<Itinerario> {
     
    private static final long serialVersionUID = 1L;
     
    private Itinerario model = new Itinerario();
    
	@Override
    public String execute() throws Exception {
        try {
        	((ItinerarioDao) context.getBean("itinerarioDao")).save(getModel());         
        	return SUCCESS;
        }catch(Exception e) {
        	e.printStackTrace();
        	return ERROR;
        }
         
    }


	@Override
	public Itinerario getModel() {
		return model;
	}
     
 
}