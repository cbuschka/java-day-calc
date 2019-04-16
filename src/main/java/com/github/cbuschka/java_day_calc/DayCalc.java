package com.github.cbuschka.java_day_calc;

import java.util.Calendar;
import java.util.Date;

public class DayCalc
{
	private static final double FACTOR = 8.64e7d;

	public static Date toDate(int day)
	{
		long millis = (long) (FACTOR * (double) day);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(millis);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static int toDay(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		long millis = date.getTime();
		return (int) ((double) millis / FACTOR) + 1;
	}
}
