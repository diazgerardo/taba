package ar.com.scriptorum.dao;

import ar.com.scriptorum.beans.Keywords;

public class KeywordsDaoImpl extends GenericDaoImpl<Keywords, Long> implements KeywordsDao {

	@Override
	protected Class<Keywords> getEntityClass() {
		return Keywords.class;
	}

}
