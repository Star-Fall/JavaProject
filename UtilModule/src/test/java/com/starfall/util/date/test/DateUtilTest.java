package com.starfall.util.date.test;

import com.starfall.util.date.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * @project： JavaProject
 * @package： com.starfall.util.date.test
 * @className： DateUtilTest
 * @author： StarFall
 * @date： 2019/4/1 23:53
 * @description： Date工具类测试类
 */
public class DateUtilTest {

    @Test
    public void getDateTest() {
        System.out.println(DateUtil.getYear(new Date()));
        System.out.println(DateUtil.getMonth(new Date()));
        System.out.println(DateUtil.getDay(new Date()));
        //System.out.println(DateUtil.getMonth(null));
        System.out.println(DateUtil.getWeekDay(new Date()));
        System.out.println(DateUtil.getWeekDay(new Date()).getDesc());
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
