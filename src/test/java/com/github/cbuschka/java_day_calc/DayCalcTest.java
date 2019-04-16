package com.github.cbuschka.java_day_calc;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DayCalcTest
{
	@Test
	public void all()
	{
		final int DAYS = 366 * 1000;
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		for (int day = 1; day < DAYS; ++day)
		{
			cal.add(Calendar.DAY_OF_MONTH, 1);

			Date date = DayCalc.toDate(day);
			int calculatedDay = DayCalc.toDay(date);

			assertThat(cal.getTime(), is(date));
			assertThat(calculatedDay, is(day));
		}

	}
}
