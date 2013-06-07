package ar.com.scriptorum.workflow.dao.impl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.scriptorum.workflow.State;
import ar.com.scriptorum.workflow.Workflow;
import ar.com.scriptorum.workflow.WorkflowAble;
import ar.com.scriptorum.workflow.dao.WorkflowDao;


@SuppressWarnings("unchecked")
public class WorkflowDaoImpl extends HibernateDaoSupport implements WorkflowDao{

	
	public ArrayList<State> getStates (){
		ArrayList<State> list = (ArrayList<State>) getHibernateTemplate().find("from State order by id asc");
		return list;
	}

	@Override
	public Workflow findWorkflow(WorkflowAble e) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Workflow.class);
		criteria.add(Restrictions.eq("target", e));
		return (Workflow) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
		
	}
}
