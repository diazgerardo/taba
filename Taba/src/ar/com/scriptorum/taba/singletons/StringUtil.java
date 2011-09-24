package ar.com.scriptorum.taba.singletons;

public class StringUtil {

	public static String strZero(long mm) {
		String result = "00".concat(String.valueOf(mm));
		return result.substring(result.length()-2, result.length());
	}

}
