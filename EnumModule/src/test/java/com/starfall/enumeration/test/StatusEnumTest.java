package com.starfall.enumeration.test;

import com.starfall.enumeration.StatusEnum;
import org.junit.Test;

/**
 * @project： JavaProject
 * @package： com.starfall.enumeration.test
 * @className: StatusEnumTest
 * @author: StarFall
 * @date: 2019/3/27 21:54
 * @description: todo
 */
public class StatusEnumTest {

    @Test
    public void testEnumAPI() {
        // 基本用法
        System.out.println(StatusEnum.LOGIN);
        System.out.println(StatusEnum.LOGIN.name());
        System.out.println(StatusEnum.LOGIN.getMsg());
        System.out.println(StatusEnum.LOGIN.ordinal());
        System.out.println(StatusEnum.LOGIN.toString());
        System.out.println(StatusEnum.LOGIN.getClass());
    }

    @Test
    public void testEnumOther() {
        System.out.println("adsa");
    }
}
