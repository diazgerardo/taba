package ar.com.scriptorum.actions;

import ar.com.scriptorum.beans.Group;
import ar.com.scriptorum.dao.GroupDao;

import com.opensymphony.xwork2.ModelDriven;

public class GrupoActions extends SpringActionSupport implements ModelDriven<Group> {
     
    private static final long serialVersionUID = 1L;
     
    private Group model = new Group();
    
	@Override
    public String execute() throws Exception {
        try {
        	((GroupDao) context.getBean("groupDao")).save(getModel());         
        	return SUCCESS;
        }catch(Exception e) {
        	e.printStackTrace();
        	return ERROR;
        }
         
    }


	@Override
	public Group getModel() {
		return model;
	}
     
 
}