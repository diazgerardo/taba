package ar.com.scriptorum.dao;



import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import ar.com.scriptorum.interfaces.PersistentEntity;
import ar.com.scriptorum.stringutils.StringUtilsExample;

public class GenericDaoImpl {
    
    private static final Object DUMMY_TRUE_WHERE_CLAUSE = null;
	private static GenericDaoImpl _instance = null;
    private static Logger _logger = Logger.getLogger(GenericDaoImpl.class);


    protected GenericDaoImpl()
    {
    }

    static synchronized GenericDaoImpl getInstance()
    {
        if ( _instance == null )
        {
            _instance = new GenericDaoImpl();
        }
        return _instance;
    }
    public boolean create( Object obj, boolean bFlush )
    {
    	_logger.debug(obj.getClass());
    	boolean outcome = true;
        Session session = getSession();
        try
        {
            session.save( obj );
            if(bFlush)
            	session.flush();
            _logger.debug( "Insertion - Entity: " + obj.getClass().getSimpleName() + " NewId: "
                          + ( ( PersistentEntity ) obj ).getId() );
        }
        catch ( HibernateException ex )
        {
        	_logger.debug("got HibernateException");
            _logger.debug( "Failed insertion - Entity: " + StringUtilsExample.getSimpleClassName( obj.getClass() ) + " Id: "
                           + ( ( PersistentEntity ) obj ).getId());
            outcome = false;
        }
        return outcome;
    }

    /*
     * (non-Javadoc)
     * @see com.citigroup.ebo.mappers.GenericMapper#update(java.lang.Object)
     */
    public boolean update( Object obj, boolean bFlush )
    {
    	_logger.debug(obj.getClass());
        boolean outcome = true;
        Session session = getSession();
        try
        {
            session.update( obj );
            if(bFlush)
            	session.flush();
            _logger.debug( "Updated - Entity: " + obj.getClass().getSimpleName() + " Id: "
                    + ( ( PersistentEntity ) obj ).getId() );
        }
        catch ( HibernateException ex )
        {
        	_logger.debug("got HibernateException");
            _logger.debug( "Failed update - Entity: " + obj.getClass().getSimpleName() + " Id: "
                           + ( ( PersistentEntity ) obj ).getId());
            outcome = false;
        }
        return outcome;
    }

    /*
     * (non-Javadoc)
     * @see com.citigroup.ebo.mappers.GenericMapper#createOrUpdate(java.lang.Object)
     */
    public boolean createOrUpdate( Object obj, boolean bFlush )
    {
    	_logger.debug(obj.getClass());
        boolean outcome = true;
        Session session = getSession();
        try
        {
            session.saveOrUpdate( obj );
            if(bFlush)
            	session.flush();
            _logger.debug( "savedOrUpdated - Entity: " + obj.getClass().getSimpleName() + " Id: "
                    + ( ( PersistentEntity ) obj ).getId() );
        }
        catch ( HibernateException ex )
        {
        	
        	_logger.debug("got HibernateException");
            _logger.debug( "Failed create/update - Entity: " + obj.getClass().getSimpleName()
                           + " Id: " + ( ( PersistentEntity ) obj ).getId()  );
            outcome = false;
        }
        return outcome;
    }

    /*
     * (non-Javadoc)
     * @see com.citigroup.ebo.mappers.GenericMapper#delete(java.lang.Object)
     */
    public boolean delete( Object obj, boolean bFlush )
    {
    	_logger.debug(obj.getClass());
        boolean outcome = true;
        Session session = getSession();
        try
        {
            session.delete( obj );
            if(bFlush)
            	session.flush();
            _logger.debug( "deleted - Entity: " + obj.getClass().getSimpleName() + " Id: "
                    + ( ( PersistentEntity ) obj ).getId() );
        }
        catch ( HibernateException ex )
        {
        	_logger.debug("got HibernateException");
            _logger.error( "Failed delete - Entity: " + obj.getClass().getSimpleName() + " Id: "
                           + ( ( PersistentEntity ) obj ).getId() );
            outcome = false;
        }
        return outcome;
    }

    /*
     * (non-Javadoc)
     * @see com.citigroup.ebo.mappers.GenericMapper#findById(java.lang.Class, java.io.Serializable)
     */
    public Object getEntity( Class clazz, Serializable id )
    {
       	_logger.debug("id" + id);
               Object result = getSession().get( clazz, id );
        _logger.debug( "Entity Id found: "
                      + ( result != null ? ( ( PersistentEntity ) result ).getId().toString() : "NONE" ) );
        return result;
    }

    /*
     * (non-Javadoc)
     * @see com.citigroup.ebo.mappers.GenericMapper#getUniqueEntity(java.lang.Class, java.util.Map)
     */
    public Object getUniqueEntity( Class clazz, Map equalProps )
    {
       	_logger.debug(clazz);
        
        Query query = createQuery( clazz, equalProps, null );

        Object result = query.uniqueResult();
        _logger.debug( "Entity Id found: "
                      + ( result != null ? ( ( PersistentEntity ) result ).getId().toString() : "NONE" ) );
        return result;
    }

    /*
     * (non-Javadoc)
     * @see com.citigroup.ebo.mappers.GenericMapper#getEntities(java.lang.Class)
     */
    public List getEntities( Class clazz, Map equalProps, List orderBy )
    {
       	_logger.debug(clazz);
        
        Query query = createQuery( clazz, equalProps, orderBy );

        List result = query.list();
        _logger.debug( "Result size: " + result.size() );
        return result;
    }

    /**
     * Create a Hibernate Query using HQL with a Bean equality filter. The query will select instances of the specific
     * clazz matching all (AND) the non-null property values in the Map
     * @param clazz
     * @param equalProps
     * @param orderBy
     * @return
     */
    private Query createQuery( Class clazz, Map equalProps, List orderBy )
    {
       	_logger.debug(clazz);
        
        /* Uses HQL with a Bean equality filter */
        Session session = getSession();

        String className = clazz.getSimpleName();
        // String className = clazz.getSimpleName(); java 1.5

        // HQL building
        StringBuffer fromClause = new StringBuffer( "FROM " );
        fromClause.append( className + " " );
        StringBuffer whereClause = new StringBuffer();
        addToWhereClause( null, whereClause, equalProps );
        StringBuffer orderByClause = new StringBuffer();
        addToOrderByClause( orderBy, orderByClause );

        String hql = fromClause.append( whereClause )
                               .append( orderByClause )
                               .toString();
        _logger.debug( "HQL String: " + hql );
        Query query = session.createQuery( hql );

        // PARAMETERS setting
        query.setProperties( equalProps );
        _logger.debug( "PARAMETERS: " );
        logPropParams( equalProps );
        return query;
    }

    /**
     * @param orderBy
     * @param orderByClause
     */
    private void addToOrderByClause( List orderBy, StringBuffer orderByClause )
    {
       	_logger.debug(orderByClause);
        
        if ( orderBy != null && !orderBy.isEmpty() )
        {
            orderByClause.append( " ORDER BY " );
            String currProp;
            String propName;
            for ( Iterator props = orderBy.iterator(); props.hasNext(); )
            {
                currProp = ( String ) props.next();
                propName = currProp.substring( currProp.indexOf( "_" ) + 1 );
                orderByClause.append( propName + ", " );
            }
            orderByClause.delete( orderByClause.length() - 2, orderByClause.length() - 1 ); // removes last ", "
        }
    }

    /**
     * Adds to the whereClause the equality expressions according to the properties included in the map. <br />
     * Precondition: the whereClause must previously contain a logical expression (see FIRST 'AND') It could be invoked repeteadly
     * from the same method for equality conditions on JOINED tables.<br/>
     * <b>Note:</b> properties with null values are ignored
     * @param alias
     * @param whereClause
     * @param equalProps
     */
    protected void addToWhereClause( String alias, StringBuffer whereClause, Map equalProps )
    {
       	_logger.debug(alias);
        
        if ( equalProps != null && !equalProps.isEmpty() )
        {
            whereClause.append( DUMMY_TRUE_WHERE_CLAUSE );
            String tablePrefix = "";
            if ( alias != null && !"".equals( alias ) )
            {
                tablePrefix = alias + ".";
            }
    
            String currPropKey;
            String propName;
            for ( Iterator propKeys = equalProps.keySet().iterator(); propKeys.hasNext(); )
            {
                currPropKey = ( String ) propKeys.next();
                if ( equalProps.get( currPropKey ) != null )
                {
                    propName = currPropKey.substring( currPropKey.indexOf( "_" ) + 1 );
                    whereClause.append( " AND (" + tablePrefix + propName + " = :" + currPropKey + ") " );
                    _logger.debug("whereClause.append( \" AND (" + tablePrefix + propName + " = :\" + currPropKey + \") \" );");
                }
                else
                {
                    _logger.warn( "Ignoring property '" + currPropKey + "' due to a NULL value found to compare by equality.");
                }
            }
        }
    }

    /**
     * Logs the parameters present in the Map with their values
     * @param equalProps
     */
    protected static void logPropParams( Map equalProps )
    {
        if ( equalProps != null && !equalProps.isEmpty() )
        {
            String currPropKey;
            Object currPropValue;
            for ( Iterator propKeys = equalProps.keySet().iterator(); propKeys.hasNext(); )
            {
                currPropKey = ( String ) propKeys.next();
                currPropValue = equalProps.get( currPropKey );
                if ( currPropValue != null )
                {
                    _logger.debug( " :" + currPropKey + "->" + currPropValue.toString() );
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see com.citigroup.ebo.mappers.GenericMapper#getEntitiesLike(java.lang.Class, java.lang.Object)
     */
    public List getEntitiesLike( Class clazz, Object exampleEntity )
    {
        /* Uses Query By Example (QBE) : Criteria + Example Criterion */
        // TODO: could add ignoreCase and MatchMode to the parameter set
        Session session = getSession();
        Example example = getExampleForStringProps( clazz, exampleEntity, true, null );
        Criteria criteria = session.createCriteria( clazz );
        criteria.add( example );

        List result = criteria.list();
        _logger.debug( "Result size: " + result.size() );
        return result;
    }


    /**
     * @param clazz
     * @param exampleEntity
     * @param ignoreCase
     * @param mode
     * @return an Example Criterion
     */
    private Example getExampleForStringProps( Class clazz, Object exampleEntity, boolean ignoreCase, MatchMode mode )
    {
        Example example = Example.create( exampleEntity ).excludeZeroes(); // exclude zero valued or null properties, null is enough ...
        if ( ignoreCase )
        {
            example.ignoreCase();// perform case insensitive string comparisons
        }
        if ( mode == null )
        {
            mode = MatchMode.ANYWHERE; // default MATCH MODE
        }
        example.enableLike( mode )// use like for string comparisons with the indicated mode
               .setEscapeCharacter( new Character( '/' ) );

        _logger.debug( "PARAMETERS: " );

        // Exclude NON-String properties (traverses all fields declared in the clazz PLUS those inherited)
        Class currClass = clazz;
        Field currField;
        while ( currClass != null )
        {
            Field[] fields = currClass.getDeclaredFields();
            for ( int i = 0; i < fields.length; i++ )
            {
                currField = fields[ i ];
                currField.setAccessible( true );
                if ( !Modifier.isStatic( currField.getModifiers() ) )
                {
                    excludeNonStringField( exampleEntity, example, currClass, currField );
                }
            }
            currClass = currClass.getSuperclass();
        }
        _logger.debug( "example Criterion: " + example.toString() );
        return example;
    }

    /**
     * Excludes from the Example Criterion the field if it's not of the String type A warning is issued for excluded
     * fields unless they are Primitive-type fields (they will have a non-null currValues just because of automatic
     * initialization and wrapping)
     * @param exampleEntity
     * @param example
     * @param currClass
     * @param currField
     */
    private void excludeNonStringField( Object exampleEntity, Example example, Class currClass, Field currField )
    {
        try
        {
            Object currValue = currField.get( exampleEntity );
            if ( currValue instanceof String )
            {
                _logger.debug( "          :" + currField.getName() + " --> " + currValue.toString() );
            }
            else
            {
                example.excludeProperty( currField.getName() );
                if ( currValue != null && !currField.getType().isPrimitive() )
                {
                    _logger
                           .warn( currClass.getSimpleName()
                                  + " example entity is not supposed to include a NON-String property (it will be ignored): "
                                  + currField.getName() + " --> " + currValue.toString() );
                }
            }
        }
        catch ( IllegalArgumentException e ) // should not happen
        {
            _logger.error( e );
        }
        catch ( IllegalAccessException e ) // should not happen
        {
            _logger.error( e );
        }
    }

    protected Session getSession()
    {
        Session session = null;//HibernateUtil.getSessionFactory().getCurrentSession();

        // // clears first-level cache if it reachs the max number of cached entities allowed
        // SessionStatistics stats = session.getStatistics();
        // if ( stats.getEntityCount() >= HibernateUtil.MAX_ENTITIES_BY_SESSION )
        // {
        // if ( session.isDirty() )
        // {
        // _logger.debug( "Session is dirty and the max size has been reached, forcing to flush ..." );
        // session.flush();
        // }
        // _logger.debug( "The max size of session's cache has been reached, forcing to clear..." );
        // session.clear();
        // }
        //
        return session;
    }

}
