package com.homeaharaa.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

import org.apache.poi.util.SystemOutLogger;

public class Test {

	public static void main(String[] args) {
		String str ="? 185.40";
		//String str1 = str.replace('.', 's');
		String removechar = str.replace("?", " ").trim();
		String[] arr = removechar.split("s");
		//int val = Integer.parseInt(arr[0]);
		//System.out.println(arr[0]);
		/*
		 * double a = Double.parseDouble(removechar); System.out.println(a); double n =
		 * Math.floor(a * 100) / 100; System.out.println(n);
		 * System.out.println(truncateDecimal(a,2));
		 */
		
		double d = -88.1;
		System.out.println(Math.ceil(d));
		System.out.println(Math.floor(d));
		System.out.println(Math.abs(d));
		System.out.println(Math.max(5, 10));
		//System.out.println(selectval(d));
		//selectval(d);
		//System.out.println(roundToHalf(d));
		
		
	
	}
	
	public static double selectval(double a)
	{
	     DecimalFormat f = new DecimalFormat("##.00");
	     System.out.println(f.format(a));
	     return Double.parseDouble(f.format(a));
	}
	
	public static double roundToHalf(double x) {
	    return (double) (Math.ceil(x * 2) / 2);
	}
	private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
	    } else {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
	    }
	}

}
