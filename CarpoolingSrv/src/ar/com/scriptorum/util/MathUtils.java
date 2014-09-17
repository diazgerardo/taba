package ar.com.scriptorum.util;

import java.math.BigDecimal;

public class MathUtils {

    public static boolean isPrime(Integer number) {

        if (number == 0) {
            return false;
        }

        for (int index = 2; index < number; index++) {
            if (number % index == 0) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    /**
     * 
     * Método internacional de redondeo
     * 
     * 
     * @param n
     * @param significant
     */
    public Number round(Number n, int scale) {
        BigDecimal original = new BigDecimal(""+n);
        BigDecimal scaled = original.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
        return scaled;
    }
}
