package com.starfall.enumeration.test;

import com.starfall.enumeration.interfaces.Food;
import org.junit.Test;

/**
 * @project： JavaProject
 * @package： com.starfall.enumeration.test
 * @className: FoodTest
 * @author: StarFall
 * @date: 2019/3/31 22:17
 * @description: 食物菜单Food测试
 */
public class FoodTest {

    /**
     * 测试Food用法
     */
    @Test
    public void testFood() {
        Food food = Food.Appetizer.SALAD;
        System.out.println(food);
        food = Food.Coffee.BLACK_COFFEE;
        System.out.println(food);
    }
}
