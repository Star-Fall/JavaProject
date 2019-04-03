package com.starfall.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @project： JavaProject
 * @package： com.starfall.util.date
 * @className： DateUtil
 * @author： StarFall
 * @date： 2019/4/1 23:52
 * @description： Date工具类
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
