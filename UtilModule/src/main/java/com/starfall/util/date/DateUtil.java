package com.starfall.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author StarFall
 * @project JavaProject
 * @package com.starfall.util.date
 * @className DateUtil
 * @date 2019/4/1 23:52
 * @description Date工具类
 */
public class DateUtil {

    /**
     * 获取指定时间的年份
     *
     * @param date 指定时间
     * @return 年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取指定时间的月份
     *
     * @param date 指定时间
     * @return 月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取指定时间的日期
     *
     * @param date 指定时间
     * @return 日期
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定时间的WeekDay
     *
     * @param date 指定时间
     * @return WeekDay枚举
     * @see com.starfall.util.date.WeekDay
     */
    public static WeekDay getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        for (WeekDay day : WeekDay.values()) {
            if (day.ordinal() == (dayOfWeek - 1)) {
                return day;
            }
        }
        return null;
    }

    /**
     * 指定时间加/减 N 秒后的日期
     *
     * @param date    指定时间
     * @param seconds 秒
     * @return 结果日期
     */
    public static Date addSeconds(Date date, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    /**
     * 指定时间加/减 N 分钟后的日期
     *
     * @param date    指定时间
     * @param minutes 分钟
     * @return 结果日期
     */
    public static Date addMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * 指定时间加/减 N 小时后的日期
     *
     * @param date  指定时间
     * @param hours 小时数
     * @return 结果日期
     */
    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }

    /**
     * 指定时间加/减 N 天后的日期
     *
     * @param date 指定时间
     * @param days 天数
     * @return 结果日期
     */
    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 指定时间加/减 N 月后的日期
     *
     * @param date   指定时间
     * @param months 月数
     * @return 结果日期
     */
    public static Date addMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    /**
     * 指定时间加/减 N 年后的日期
     *
     * @param date  指定时间
     * @param years 年数
     * @return 结果日期
     */
    public static Date addYears(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    /**
     * 格式化日期，输出字符串
     *
     * @param date    日期
     * @param pattern 格式
     * @return 日期字符串
     */
    public static String formatDateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 日期字符串转换成日期类型
     *
     * @param text    字符串
     * @param pattern 日期格式
     * @return 日期类型
     */
    public static Date parseStringToDate(String text, String pattern) {
        SimpleDateFormat dateFormattor = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFormattor.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
