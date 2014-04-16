package ar.com.scriptorum.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import ar.com.scriptorum.beans.Carpooler;
import ar.com.scriptorum.dao.CarpoolerDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class CarpoolerActions extends SpringActionSupport implements ModelDriven<Carpooler> {

	/**
	 * backing beans
	 */
	private Carpooler carpooler = new Carpooler();
	private List<Carpooler> carpoolerList = new ArrayList<Carpooler>();
	
	/**
	 * dao reference taken from spring's inherited context
	 */
	private CarpoolerDao carpoolerDao = (CarpoolerDao) context.getBean("carpoolerDao");

	public String saveOrUpdate() {	
		carpoolerDao.saveOrUpdate(carpooler);
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		carpooler = carpoolerDao.findById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String delete(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		Carpooler toBeDeleted = carpoolerDao.findById(Long.parseLong(request.getParameter("id")));
		carpoolerDao.delete(toBeDeleted);
		return SUCCESS;
	}

	@Override
	public Carpooler getModel() {
		return carpooler;
	}

	public Carpooler getCarpooler() {
		return carpooler;
	}

	public void setCarpooler(Carpooler carpooler) {
		this.carpooler = carpooler;
	}

	public List<Carpooler> getCarpoolerList() {
		return carpoolerList;
	}

	public void setCarpoolerList(List<Carpooler> carpoolerList) {
		this.carpoolerList = carpoolerList;
	}

	public String list() {
		carpoolerList = carpoolerDao.findAll();
		return SUCCESS;
	}
}