package ar.com.scriptorum.util;

public class StringUtil {

    /**
     * counts occurrences of subStr in str
     * 
     * @param str
     * @param subStr
     * @return
     */
    public static int count(String str, String subStr) {

        if(isEmpty(str))
            return 0;
        
        if(isEmpty(subStr))
            return 0;
        
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

    public static boolean isEmpty(String str) {
        return str == null?Boolean.TRUE:"".equals(str)?Boolean.TRUE:Boolean.FALSE;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
