package com.starfall.util.date;

import java.util.Calendar;
import java.util.Date;

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
     * @param date 指定日期
     * @return 年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取指定时间的月份
     *
     * @param date 指定日期
     * @return 月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
