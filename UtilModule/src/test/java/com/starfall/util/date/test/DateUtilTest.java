package com.starfall.util.date.test;

import com.starfall.util.date.DateUtil;
import org.junit.Test;

import java.util.Date;

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
        System.out.println(DateUtil.getYear(new Date()));
        System.out.println(DateUtil.getMonth(new Date()));
        System.out.println(DateUtil.getDay(new Date()));
        //System.out.println(DateUtil.getMonth(null));
        System.out.println(DateUtil.getWeekDay(new Date()));
        System.out.println(DateUtil.getWeekDay(new Date()).getDescCN());
        System.out.println(DateUtil.getWeekDay(new Date()).getDescEN());
    }

    @Test
    public void addHoursTest() {
        Date date = new Date();
        String pattern = "yyyyMMdd HH:mm:ss";
        System.out.println("nowDate: " + DateUtil.formatDateToString(date, pattern));
        //测试addSeconds、addMinutes、addHours、addDays、addMonths、addYears
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
