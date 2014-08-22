package ar.com.scriptorum.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;

import org.apache.log4j.Logger;

import sun.misc.FloatingDecimal;

public final class MathUtil {
	private static Logger _logger = Logger.getLogger(MathUtil.class);

	private double nominalFactor;
	private long nominalPow;


	public double getNominal(double calcNominal) {
		return round(calcNominal, nominalFactor);
	}

	public double getNominalPrecision() {
		return round(1 / nominalFactor, nominalFactor * 10);
	}

	public double getNominalPow() {
		return nominalPow;
	}

	public double getNominalFactor() {
		return nominalFactor;
	}

	public static Double round(Double value, Double factor) {
		return Math.round(value * factor) / factor;
	}
	
	public static Double round (Double value, int scale, boolean roundUp){
		return round(new BigDecimal(value), scale, roundUp).doubleValue();
	}


	public static Object getRandomDigits(long number) {
		return (long) (Math.random()*number);
	}
	
	public static int randomAorB(int a, int b){
		if(getRandomBoolean()){
			return a;
		}else{
			return b;
		}
	}

	/**
	 * @param a Number n where n is meant to be *any* Number (Long, Float, Double, etc
	 * @return true if 0/false otherwise
	 */
	public static boolean isEmpty(Number n) {
		//_logger.debug("n="+n);
		if(n != null && abs((n.doubleValue()+n.floatValue()+n.intValue()+n.longValue()+n.shortValue())) > 0.0) {
			//_logger.debug("n="+n+" is not empty.");
			return false;
		}
		//_logger.debug("n="+n+" is empty.");
		return true;
	}
	


	public static Double abs(Double b) {
		return Math.abs(b);
	}

	/**
	 * @param a Number n where n is meant to be *any* Number (Long, Float, Double, etc
	 * @return true if not 0/false otherwise
	 */
	public static boolean isNotEmpty(Number n) {
		_logger.debug("n="+n);
		return !isEmpty(n);
	}

	public static Number avoidNullValues(Number number) {
		return isEmpty(number) ? 0 : number;
	}

	public static BigDecimal round(BigDecimal d, int scale, boolean roundUp) {
		int mode = (roundUp) ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
		return d.setScale(scale, mode);
	}

	public static Double toDouble(String number) {
		if(number.contains(","))
			number = number.replace(',', '.');
		try {
			return Double.valueOf(number);
		}catch(NumberFormatException e) {
			_logger.debug("bad number format: "+number);
			return 0D;
		}
	}
	
	public static Integer toInteger(String number){
		return Integer.valueOf(number);
	}

	public static Long toLong(String number) {
		try {
			if(number.contains(",")) {
				number = number.replace(',', '.');
				return new Double(number).longValue();
			}
			return Long.valueOf(number);
		}catch(NumberFormatException e) {
			_logger.debug("bad number format: "+number);
			return 0L;
		}
	}

	public static String valueOf(Number couponPeriodQuantity) {
		try {
			return String.valueOf(couponPeriodQuantity);
		}catch(Exception e) {
			return "1";
		}
	}
	
	public static boolean getRandomBoolean() {
	    Random random = new Random();
	    return random.nextBoolean();
	}
	
	public static boolean areCloseEnough(Number firstNumber, Number secondNumber, Number maxDifference ) {
		_logger.debug(">");
		if(firstNumber.equals(secondNumber)) {
			_logger.debug("the numbers firstNumber="+firstNumber+" and secondNumber="+secondNumber+" found to be equal.");
			return true;
		}
		Double difference = Math.abs(firstNumber.doubleValue()-secondNumber.doubleValue());
		String differenceStr = new DecimalFormat("#0.00000000000000000").format(difference);
		if(maxDifference.doubleValue()> difference) {
			_logger.debug("the difference="+differenceStr+" between firstNumber="+firstNumber+" and secondNumber="+secondNumber+" is less than maxDifference="+maxDifference);
			return true;
		}
		_logger.debug("the numbers firstNumber="+firstNumber+" and secondNumber"+secondNumber+" were found not close enough because the difference="+differenceStr+" exceeds maxDifference="+maxDifference);
		return false;
	}

	/**
	 * returns an string containing the number aligned to the right and as many zeroes as needed to
	 * match length 
	 * @param number
	 * @param zeroes
	 * @return
	 */
	public static String leftZeroFill(long number, int length) {
		return length>0 ? String.format("%0"+length+"d", number):"";
	}

	/**
	 * returns an amount formatted as required by handoff trailers
	 * @param number
	 * @param zeroes
	 * @return
	 */
	public static String handOffFormat(Number number) {
		String positiveMask = " "+StringUtil.replicate('0', 16)+".00";
		String negativeMask = ";-"+StringUtil.replicate('0', 16)+".00";
		String mask = positiveMask+negativeMask;
		DecimalFormat df = new DecimalFormat(mask);
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(dfs);
		return df.format(number);
	}

	public static Double floatToDouble(Float result) {
		return new FloatingDecimal(result.floatValue()).doubleValue();
	}

	public static Float doubleToFloat(Double doubleResult) {
		return new FloatingDecimal(doubleResult.doubleValue()).floatValue();
	}



    /**
     * Implements international rounding method
     * @param n: number to round
     * @param scale: significant digits
     */
    public static synchronized Double round(Double n, int scale) {
        BigDecimal original = new BigDecimal(""+n);
        BigDecimal scaled = original.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
        return scaled.doubleValue();
    }

}
