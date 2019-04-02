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
    public void getYearTest() {
        System.out.println(DateUtil.getYear(new Date()));
        System.out.println(DateUtil.getMonth(new Date()));
        System.out.println(DateUtil.getDay(new Date()));
        //System.out.println(DateUtil.getMonth(null));
    }

}
