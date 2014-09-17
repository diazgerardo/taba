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
