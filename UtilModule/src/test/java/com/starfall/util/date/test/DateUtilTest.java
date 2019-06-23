package com.starfall.util.date.test;

import com.starfall.util.date.DateUtil;
import org.junit.Test;

import java.util.Date;
import java.util.Objects;

/**
 * @author StarFall
 * @project JavaProject
 * @package com.starfall.util.date.test
 * @className DateUtilTest
 * @date 2019/4/1 23:53
 * @description Date工具类测试类
 */
public class DateUtilTest {

	@Test
	public void getDateTest() {
		Date date = new Date();
		// test getYear、getMonth、getDay
		System.out.println(DateUtil.getYear(date));
		System.out.println(DateUtil.getMonth(date));
		System.out.println(DateUtil.getDay(date));
		// test getWeekDay
		System.out.println(DateUtil.getWeekDay(date));
		System.out.println(Objects.requireNonNull(DateUtil.getWeekDay(date)).getDescCN());
		System.out.println(Objects.requireNonNull(DateUtil.getWeekDay(date)).getDescEN());
		// test getSeason
		System.out.println(DateUtil.getSeason(date));
		System.out.println(Objects.requireNonNull(DateUtil.getSeason(date)).getDescCN());
		System.out.println(Objects.requireNonNull(DateUtil.getSeason(date)).getDescEN());
		date = DateUtil.addMonths(date, 8);
		System.out.println(DateUtil.getSeason(date));
		// test getMonthEnum
		date = new Date();
		System.out.println(DateUtil.getMonthEnum(date));
		System.out.println(Objects.requireNonNull(DateUtil.getMonthEnum(date)).getDescCN());
		System.out.println(Objects.requireNonNull(DateUtil.getMonthEnum(date)).getDescEN());
		date = DateUtil.addMonths(date, 2);
		System.out.println(Objects.requireNonNull(DateUtil.getMonthEnum(date)).getDescCN());

	}

	@Test
	public void addHoursTest() {
		Date date = new Date();
		String pattern = "yyyyMMdd HH:mm:ss";
		System.out.println("nowDate: " + DateUtil.formatDateToString(date, pattern));
		// 测试addSeconds、addMinutes、addHours、addDays、addMonths、addYears
		Date second = DateUtil.addSeconds(date, 10);
		System.out.println("addSeconds: " + DateUtil.formatDateToString(second, pattern));
		Date minute = DateUtil.addMinutes(date, 20);
		System.out.println("addMinutes: " + DateUtil.formatDateToString(minute, pattern));
		Date hour = DateUtil.addHours(date, 8);
		System.out.println("addHours: " + DateUtil.formatDateToString(hour, pattern));
		Date day = DateUtil.addDays(date, -1);
		System.out.println("addDays: " + DateUtil.formatDateToString(day, pattern));
		Date month = DateUtil.addMonths(date, 2);
		System.out.println("addMonths: " + DateUtil.formatDateToString(month, pattern));
		Date year = DateUtil.addYears(date, 1);
		System.out.println("addYears: " + DateUtil.formatDateToString(year, pattern));
	}

	@Test
	public void formatDateTest() {
		System.out.println(DateUtil.formatDateToString(new Date(), "yyyy-MM-dd"));
		System.out.println(DateUtil.parseStringToDate("2019-03-01", "yy-MM-dd"));
		String str = "2019-03-02";
		Date date = DateUtil.parseStringToDate(str, "yyyyy-MM-dd");
		System.out.println(DateUtil.formatDateToString(date, "yyyy-MM-dd"));
	}

}
