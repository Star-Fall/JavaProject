package com.starfall.enumeration.test;

import com.starfall.enumeration.interfaces.Food;
import com.starfall.enumeration.interfaces.Meal;
import org.junit.Test;

/**
 * @project： JavaProject
 * @package： com.starfall.enumeration.test
 * @className： MealTest
 * @author： StarFall
 * @date： 2019/3/31 22:46
 * @description： Meal对象测试
 */
public class MealTest {

    @Test
    public void testMeal() {
        // 根据Meal的枚举对象获取对应的Food的所有枚举
        System.out.println("**********遍历Meal.APPETIZER内容*******");
        Meal m = Meal.APPETIZER;
        Food[] values = m.getFoods();
        for (Food food : values) {
            System.out.println(food);
        }

        // 获取所有Meal的枚举对象
        System.out.println("**********遍历Meal所有内容*******");
        Meal[] ms = Meal.values();
        for (Meal meal : ms) {
            System.out.println(meal);
            for (Food f : meal.getFoods()) {
                System.out.print("\t" + f);
            }
            System.out.println();
        }

    }
}
