package ar.com.scriptorum.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

public final class StringUtil {
	public static final String METHOD_ENTER = "<<<ENTER>>>";
	public static final String METHOD_EXIT = "<<<EXIT>>>";
	static Logger _logger = Logger.getLogger(StringUtil.class);
	private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();


	/**
	 * Obtains the class name and remove the package prefix from it
	 * Used with java versions previous to 1.5, then replaced by Class.getSimpleName()
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getSimpleClassName( Class<?> clazz ) {
		return clazz.getName().substring(clazz.getName().lastIndexOf('.') + 1);
	}

	public static String truncate( String str, int maxLen ) {
		return str != null && maxLen - 1 < str.length() ? 7 < maxLen ? str.substring(0, maxLen - 3) + "..." : str.substring(0, maxLen) : str;
	}

	public static boolean isSubstring( String sub, String main ) {
		return main.indexOf(sub) != -1;
	}

	/**
	 * returns 'true' when the string received is "empty" (let it be either null or a
	 * zero length string), otherwise returns 'false'
	 */
	public static boolean isEmpty( String str ) {
		return str == null || "".equals(str);
	}

	/**
	 * returns 'false' when the string received is empty, 'true' otherwise
	 * 
	 * (strings are considered 'empty' when they are either null or a zero length string )
	 */
	public static boolean isNotEmpty( String str ) {
		return !isEmpty(str);
	}

	public static String getString( Object[] args ) {
		StringBuffer result = new StringBuffer();
		for (Object arg : args) {
			result.append(arg.toString());
			result.append(" ; ");
		}
		return result.toString();
	}

	public static String getPseudoRandomString() {
		// genera una password pseudo aleatoria adecuada para utilizar en un Zip file protegido con password
		final String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		sb.append(abc.charAt((int) (Math.random() * 25)));
		sb.append("" + getLastnCharacters(String.valueOf(System.currentTimeMillis()), 6));
		sb.append(abc.toLowerCase().charAt((int) (Math.random() * 25)));
		return sb.toString();
	}

	public static String getLastnCharacters( String inputString, int n ) {
		// obtiene los últimos n caracteres de una cadena
		if (null == inputString)
			return null;
		int length = inputString.length();
		if (length <= n) {
			return inputString;
		}
		int startIndex = length - n;
		return inputString.substring(startIndex);
	}

	public static int length( String str ) {
		if (null == str)
			return -1;
		return str.length();
	}

	public static String getRandomDigits( long number ) {
		StringBuffer result = new StringBuffer();
		result.append(MathUtil.getRandomDigits(number));
		return result.toString();
	}

	/**
	 * 
	 * @param sourceString: target string where we will pick tokens from 
	 * @param delimiter: 		the character used to separate different tokens
	 * @param ocurrence:		ordinal number of the token we want to get
	 * @param requestedLenght: lenght of the token we want
	 * @return String: the token requested, or null if error happens
	 */
	public static String cherryPick( String sourceString, char delimiter, int ocurrence, int requestedLenght ) {
		String result = null;
		_logger.info(">");
		int startingPosition = 0;
		try {
			for (int i = 0; i < ocurrence; i++) {
				startingPosition = sourceString.indexOf(delimiter, startingPosition + i);
			}
			startingPosition ++; // skip delimiter!
			result = sourceString.substring(startingPosition, startingPosition + requestedLenght);
			_logger.debug("result="+result);
		}
		catch (Exception e) {
			_logger.debug(e.toString());
		}

		_logger.info("<");

		return result;

	}

	/**
	 * 
	 */
	public static String cherryPick(String sourceString, String quotationMark, int ocurrence ) {

		String result = null;
		StringTokenizer st = new StringTokenizer(sourceString, quotationMark, false);
		_logger.info(">");
		try {
			for(int i = 0; i<=ocurrence && st.hasMoreTokens(); i++) {
				result = st.nextToken();
			}

			if(result.length() < 10 || result.length()>12) {
				_logger.debug("**warning** result = \"" + result + "\" lenght = " + result.length() + ": is this ok?");
			} else {
				_logger.debug("result = \"" + result + "\" lenght = " + result.length() + ": seems ok.");
			}

		} catch(Exception e) {
			result = "";
			_logger.debug(e.getMessage());
		}
		_logger.info("<");
		return result;

	}

	/**
	 * converts an object to an string containing the object's properties in the form fieldName=fieldValue
	 * 
	 * useful for logging purposes
	 * 
	 * do *not* rely on this functionality to manage production data
	 * 
	 * @param o
	 * @return
	 */
	public synchronized static String stringify(Object o) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		Field [] attributes =  o.getClass().getDeclaredFields();
		for (Field field : attributes) {
			try {
				field.setAccessible(true);
				sb.append(" fieldName="+field.getName()+" fieldValue="+PropertyUtils.getSimpleProperty(o, field.getName()));
			} catch (Exception e) {
				// cant't access this field using reflection
				// meaningless in the context of logging purposes..            	
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * converts a collection to a string which contains a string built from calling 
	 * the .toString() method of all the collection contained objects
	 * 
	 * useful for logging purposes
	 * 
	 * @param o
	 * @return
	 */
	public synchronized static String stringify(Collection<?> collection) {
		StringBuilder sb = new StringBuilder();
		for(Object o : collection ) {
			sb.append(o.toString()+",");
		}
		return sb.toString();
	}

	/**
	 * converts a number to its currency string representation (avoids bogus 1E07 scientific notation representation) 
	 * 
	 */ 
	public static synchronized String asCurrency(Number n) {
		if( null == n)
			return "";
		return NumberFormat.getCurrencyInstance().format(n);
	}

	public static synchronized String asDecimal(Number n){
		if( null == n)
			return "";
		NumberFormat nf = new DecimalFormat("#0.00");
		return nf.format(n);
	}

	public static String toString(List<Long> orders) {
		StringBuilder sb = new StringBuilder();
		for(Long t:orders) {
			sb = sb.append(t+",");
		}
		sb.setLength(sb.length() > 0? sb.length()-1 :0);
		return sb.toString();
	}

	/**
	 * 
	 * @param hexString
	 * @return byte[]
	 */
	public byte[]hexToBytes(String hexString) {
		_logger.debug(">");
		if(null==hexString||"".equals(hexString)) {
			throw new RuntimeException("unexpected string received");
		}
		if(hexString.contains("}")){
			hexString = hexString.substring(hexString.indexOf("3c3f"),hexString.indexOf("}"));
			hexString = hexString.substring(0, hexString.length()-1);
		}
		int len = hexString.length();
		byte[] bytes = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
					+ Character.digit(hexString.charAt(i+1), 16));
		}
		return bytes;
	}

	/**
	 * 
	 * @param hexString
	 * @return character string
	 */
	public String hexToCharacters(String hexString) {
		_logger.debug(">");
		return new String(hexToBytes(hexString));
	}	

	/**
	 * 
	 * @param input string
	 * @param charsetName default = UTF-8 
	 * @return hexadecimal representation of the input string
	 * @throws UnsupportedEncodingException
	 */
	public String toHexadecimal(String input, String charsetName) throws UnsupportedEncodingException {
		_logger.debug(">");
		if(null==input||"".equals(input)) {
			throw new RuntimeException("unexpected input strubg received!");
		}
		if(null==charsetName||"".equals(charsetName)) {
			charsetName="UTF-8";
			_logger.debug("no charset received, defaulting to "+charsetName);
		}
		return toHex(input.getBytes(charsetName));
	}


	/**
	 * @param buf 
	 * @return hexadecimal representation of byte[] buf  
	 */
	public String toHex(byte[] buf) {
		_logger.debug(">");
		char[] chars = new char[2 * buf.length];
		for (int i = 0; i < buf.length; ++i)
		{
			chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
			chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
		}
		return new String(chars);
	}


	/**
	 * returns an String containing the character 'c' replicated n times
	 * @param c
	 * @param n
	 * @return String
	 */
	public static String replicate(Character c, int n) {
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; ++i)
		{
		    sb.append(c);
		}
		return sb.toString();	
	}

	public static String removeLastChar(String str) {
		if(isEmpty(str)) 
			return null;
		else
			return str.substring(0,str.length()-1);
    }
	
	/**
	 * returns 0 if parameters are equal (even if provided strings are null), +1 if a > b, -1 otherwise
	 * @param a
	 * @param b
	 * @return
	 */
	public static int compare(String a, String b) {
		_logger.debug(">");
		_logger.debug("comparing a="+a+" against b="+b);
		if(a == null && b == null) { 
			// their 'nullness' makes them equals 
			_logger.debug("test 1");
			return 0;
		}
		
		if(a == b) {
			// since they both refer to the same object they are equal too 
			_logger.debug("test 2");
			return 0;
		}

		if(b == null) { 
			// since a is not null it will be considered greather than b
			_logger.debug("test 3");
			return 1;
		}

		if(a == null) {
			// since b is not null it will be considered greather than a
			_logger.debug("test 4");
			return -1;
		}
	
		// since none of them is null we can delegate in equals to compare 
		// the strings and return 1/-1 according to the result.
		_logger.debug("test 5");
		return a.compareTo(b)>0 ? -1 :1;
		
	}

	
	public static String sciToString(Float floatNumber, int decimals) {
		
		String mask = "%-10."+decimals+"f";
		final String EXPONENT = "E";
		if(floatNumber==null)
			return null;
		String strNum = floatNumber.toString();
		if(!strNum.contains(EXPONENT))
			return String.format(mask, floatNumber);
		Double mant = Double.valueOf(strNum.substring(0,strNum.indexOf(EXPONENT)));
		int exp = Integer.valueOf(strNum.substring(strNum.indexOf(EXPONENT)+1));
		Double result = mant * Math.pow(10, exp);
		return String.format(mask, result);
	}

	public static int compareAsNumbers(String s1, String s2) {
		_logger.debug(">");
		try {
			long n1 = Long.valueOf(s1);
			long n2 = Long.valueOf(s2);
			return Long.valueOf((n1 - n2)).intValue();
		} catch(Exception e) {
			throw new RuntimeException("can't compare s1: "+ s1 + " to s2: "+ s2); 
		}
	}
	
	public String decode(String st, String fromCharset, String toCharset) {

		// <?xml version="1.0" encoding="utf-8"?><!DOCTYPE EDLDONLINE >
		// <?xml version="1.0" encoding="utf-8"?><!DOCTYPE EDLDONLINE 
		_logger.debug(">");

		// avoid nulls, etc
		if(isEmpty(st)||isEmpty(fromCharset)||isEmpty(toCharset))
			return st;

		try {
			
			String result = new String(st.getBytes(fromCharset),toCharset);
			
			// replace troublesome SYSTEM DECLARATION
			result = result.replace("SYSTEM \"./EDLDONLINE.DTD\"", "");
			// replace all ill-translated &nbsp; with spc
			result = result.replaceAll(" ", " ");
			
			
			return result;
		} catch (UnsupportedEncodingException e) {
			_logger.debug(e);
			throw new RuntimeException("unsupported encoding string for charsets:"+fromCharset+"/"+toCharset+" received!");
		}

	}


	/**
	 * counts occurrences of subStr in str
	 * @param str
	 * @param subStr
	 * @return
	 */
	public static int count(String str, String subStr) {
		int lastIndex = 0;
		int count = 0;
		while (lastIndex != -1) {

			lastIndex = str.indexOf(subStr, lastIndex);

			if (lastIndex != -1) {
				count++;
				lastIndex += subStr.length();
			}
		}
		return count;
	}
}
