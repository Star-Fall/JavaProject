package com.starfall.enumeration.interfaces;

/**
 * @project JavaProject
 * @package com.starfall.enumeration.interfaces
 * @className Meal
 * @author StarFall
 * @date 2019/3/31 22:42
 * @description 对Food接口进一步的封装
 */
public enum Meal {

	/**
	 * appetizer(开胃菜)
	 */
	APPETIZER(Food.Appetizer.class),

	/**
	 * mainCourse(主菜)
	 */
	MAINCOURSE(Food.MainCourse.class),

	/**
	 * dessert(点心)
	 */
	DESSERT(Food.Dessert.class),

	/**
	 * coffee(咖啡)
	 */
	COFFEE(Food.Coffee.class);

	/**
	 * 声明Meal的属性，获取指定类型的Food实例
	 */
	private final Food[] foods;

	/**
	 * 自定义的构造方法，通过class对象获取枚举实例
	 *
	 * @param kind
	 *            Meal对象
	 */
	Meal(Class<? extends Food> kind) {
		// 通过class对象获取枚举实例
		foods = kind.getEnumConstants();
	}

	public Food[] getFoods() {
		return foods;
	}
}
