package ar.com.scriptorum.dao;

import ar.com.scriptorum.beans.Group;

public class GroupDaoImpl extends GenericDaoImpl<Group, Long> implements GroupDao {

	@Override
	protected Class<Group> getEntityClass() {
		return Group.class;
	}

}
