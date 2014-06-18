package ar.com.scriptorum.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import ar.com.scriptorum.beans.Vehiculo;
import ar.com.scriptorum.dao.VehiculoDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class VehiculoActions extends SpringActionSupport implements ModelDriven<Vehiculo> {
     
	/**
	 * backing beans
	 */
	private Vehiculo vehiculo = new Vehiculo();
	private List<Vehiculo> vehiculoList = new ArrayList<Vehiculo>();
	
	/**
	 * dao reference taken from spring's inherited context
	 */
	private VehiculoDao vehiculoDao = (VehiculoDao) context.getBean("vehiculoDao");

	public String saveOrUpdate() {	
		vehiculoDao.saveOrUpdate(vehiculo);
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		vehiculo = vehiculoDao.findById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String delete(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Vehiculo toBeDeleted = vehiculoDao.findById(Long.parseLong(request.getParameter("id")));
		vehiculoDao.delete(toBeDeleted);
		return SUCCESS;
	}

	@Override
	public Vehiculo getModel() {
		return vehiculo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<Vehiculo> getVehiculoList() {
		return vehiculoList;
	}

	public void setVehiculoList(List<Vehiculo> vehiculoList) {
		this.vehiculoList = vehiculoList;
	}

	public String list() {
		vehiculoList = vehiculoDao.findAll();
		return SUCCESS;
	}
}