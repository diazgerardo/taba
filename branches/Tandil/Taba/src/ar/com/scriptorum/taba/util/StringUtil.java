package ar.com.scriptorum.taba.util;

public class StringUtil {
	
	private StringUtil() {}
	
	public static String genPassword() {

		final String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		StringBuffer sb = new StringBuffer();
		sb.append(abc.charAt((int)(Math.random()*25)));
		sb.append(""+getLastnCharacters( String.valueOf(System.currentTimeMillis()), 6));
		sb.append(abc.toLowerCase().charAt((int)(Math.random()*25)));
		return sb.toString();
		
	}

	public static String getLastnCharacters(String inputString, int n) {
		
		if(null==inputString)
			return null;
		int length = inputString.length();
		if (length <= n) {
			return inputString;
		}
		int startIndex = length - n;
		return inputString.substring(startIndex);
		
	}

}
