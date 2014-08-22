package ar.com.scriptorum.util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import ar.com.scriptorum.taba.beans.Country;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

public final class DateUtil {

	private static final String DATE_FORMAT = "yyyyMMdd"; 
	public final static long MILLIS_PER_SECOND = 1000;
	public final static long MILLIS_PER_MINUTE = MILLIS_PER_SECOND * 60;
	public final static long MILLIS_PER_HOUR = MILLIS_PER_MINUTE * 60;
	public final static long MILLIS_PER_DAY = MILLIS_PER_HOUR * 24;
	public final static long MILLIS_PER_WEEK = MILLIS_PER_DAY * 7;

	private SimpleDateFormat sdf;
	private Date date;
	private static Logger _logger = Logger.getLogger(DateUtil.class);

	public DateUtil() {
		sdf = new SimpleDateFormat();		
	}
	
	public DateUtil useFormat(String f) {
		_logger.debug(">");
		if(f != null && !"".equals(f)){
			_logger.debug("changed format to "+f);
			sdf = new SimpleDateFormat(f);
		}else{
			_logger.debug("changed format to "+DATE_FORMAT);
			sdf = new SimpleDateFormat(DATE_FORMAT);	
		}
		return this;
	}

	public Date toDate(String s) {
		if(s !=null && !"".equals(s)){
			if(sdf == null) 
				sdf = new SimpleDateFormat(DATE_FORMAT);
			try {
				return sdf.parse(s);
			} catch (ParseException e) {
				_logger.info("bad date received:"+s);
				throw new RuntimeException("bad date received:"+s);
			}
		}else{
			return null;
		}

	}

	public Timestamp toTimestamp(String s) {
		Date date = this.toDate(s);
		return new Timestamp(date.getTime());
	}

	public java.sql.Date toSqlDate(String s) {
		return new java.sql.Date( this.toDate(s).getTime());
	}

	public boolean isEmpty(String aDate) {
		if( StringUtil.isEmpty(aDate))
			return true;
		if(toDate(aDate)!= null)
			return false;
		return true;
	}

	public boolean isNotEmpty(String aDate) {
		return !isEmpty(aDate);
	}

	public Date getCurrent() {
		return new Date(new GregorianCalendar().getTimeInMillis());
	}

	/**
	 * try to convert a string to a date by iterating provided formats
	 * @param string
	 * @return
	 */
	public Date toDate(String string, String[] availableFormats) {
		Date date = null;
		for(String dateFormat:availableFormats) {
			sdf = new SimpleDateFormat(dateFormat);
			try { 
				date = toDate(string);
			}catch(RuntimeException e) {
				if(!e.getMessage().contains("bad date received")) {
					// 
					throw e;
				}
			}
		}
		return date;
	}

	public Timestamp getTimestamp() {
		return new Timestamp(getCurrent().getTime());
	}

	public Timestamp getTimestamp(Timestamp start, int seconds) {
		return new Timestamp(start.getTime()+(seconds*1000));
	}

	public String getYYYYMMDD(Date date) {
		if(date!=null)
			return sdf.format(date);
		return "";
	}

	public XMLGregorianCalendar convertFromDateToXmlGregorianCalendar(Date date){

		if(date != null){
			Calendar calendar = new GregorianCalendar();
			calendar.setTimeInMillis(date.getTime());
			XMLGregorianCalendar xmlGregorianCalendar = new XMLGregorianCalendarImpl();
			xmlGregorianCalendar.clear();
			xmlGregorianCalendar.setDay(calendar.get(Calendar.DAY_OF_MONTH));
			xmlGregorianCalendar.setMonth(calendar.get(Calendar.MONTH)+1);
			xmlGregorianCalendar.setYear(calendar.get(Calendar.YEAR));
			return xmlGregorianCalendar;
		}else{
			return null;
		}
	}

	public Date convertFromXmlGregorianCalendarToDate(XMLGregorianCalendar xmlGregorianCalendar){
		if(xmlGregorianCalendar != null){
			Calendar calendar = new GregorianCalendar();
			calendar.clear();
			calendar.set(xmlGregorianCalendar.getYear(), xmlGregorianCalendar.getMonth() - 1, xmlGregorianCalendar.getDay());
			return calendar.getTime();
		}else{
			return null;
		}

	}

	public String toString(Date date) {
		_logger.debug(">");
		return sdf.format(date);
	}

	/**
	 * to convert dates from country to country
	 * @param inputDate
	 * @param from
	 * @param to
	 * @return
	 * @throws AMTBusinessException
	 */
	public Date gftConvert(Date inputDate, Country from, Country to) {
		_logger.debug(">");
		return fromGreenwich(toGreenwich(inputDate, from.getTimeZone()), to.getTimeZone());
	}


	/**
	 * to convert dates from timezone to timezone
	 * @param inputDate
	 * @param fromTz
	 * @param toTz
	 * @return
	 * @throws AMTBusinessException
	 */
	public Date convertToCountryTz(Date inputDate, long fromTz, long toTz) {
		_logger.debug(">");
		_logger.debug("inputDate="+inputDate+" fromTz="+ fromTz+" toTz="+ toTz);
		Date toGreenwich=toGreenwich(inputDate, fromTz);
		_logger.debug("toGreenwich="+toGreenwich);
		Date fromGreenwich=fromGreenwich(toGreenwich, toTz);
		_logger.debug("fromGreenwich="+fromGreenwich);
		return fromGreenwich;
	}

	public Date toGreenwich(Date anyLocalDate, long TZ) {
		_logger.debug(">");
		long offsetInMillis = TZ *MILLIS_PER_HOUR;
		if(offsetInMillis<0) {
			return new Date(anyLocalDate.getTime()+Math.abs(offsetInMillis));	
		} else {
			return new Date(anyLocalDate.getTime()-Math.abs(offsetInMillis));
		}
	}

	public Date fromGreenwich(Date greenwichDate, long TZ) {
		_logger.debug(">");
		long offsetInMillis = TZ * MILLIS_PER_HOUR;
		if(offsetInMillis<0) {
			return new Date(greenwichDate.getTime()-Math.abs(offsetInMillis));	
		} else {
			return new Date(greenwichDate.getTime()+Math.abs(offsetInMillis));
		}
	}

	/**
	 * returns a new date object whose time matches the current time of the received time zone
	 * @param tz
	 * @return
	 */
	public Date getCurrentAt(long tz) {

		/*
		_logger.debug("Locale.getDefault()="+Locale.getDefault());
		_logger.debug("TimeZone.getDefault()="+TimeZone.getDefault());
		 */

		Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"+tz));
		Date date = calendar.getTime();
		_logger.debug("calendar's date:"+date);
		// even when calendar has been settled to the received time zone, it returns bare date objects
		// settled to the default time zone. as a workaround, we will determine the offset and transform
		// the object to get the right date object

		// step 1: calculate offset
		long offset = TimeZone.getDefault().getOffset(date.getTime())/MILLIS_PER_HOUR;
		_logger.debug("offset:"+offset);
		// step 2: transform to time zone 0 (Greenwich's time)
		Date toGreenwich = toGreenwich(date, offset);
		// step 3: transform to desired time zone
		Date currentAtTz = fromGreenwich(toGreenwich, tz);
		_logger.debug("currentAt("+tz+")="+currentAtTz);
		return currentAtTz;
	}

	public DateUtil date(Date from) {
		this.date = from;
		return this;
	}

	public boolean beforeOrEqual(Date aDate) {
		return date.compareTo(aDate)==0||date.compareTo(aDate)<0;
	}

	public boolean before(Date aDate) {
		return date.compareTo(aDate)<0;
	}

	public boolean afterOrEqual(Date aDate) {
		return date.compareTo(aDate)==0||date.compareTo(aDate)>0;
	}

	public boolean after(Date aDate) {
		return date.compareTo(aDate)>0;
	}

	public Date thirtheenDaysAgo() {
		return new Date(getCurrent().getTime()-30*MILLIS_PER_DAY);
	}

}
