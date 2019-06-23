package com.starfall.enumeration.test;

import com.starfall.enumeration.StatusEnum;
import org.junit.Test;

import java.util.Arrays;

/**
 * @project JavaProject
 * @package com.starfall.enumeration.test
 * @className StatusEnumTest
 * @author StarFall
 * @date 2019/3/27 21:54
 * @description 枚举对象StatusEnum的测试方法
 */
public class StatusEnumTest {

	/**
	 * 测试基本的API
	 */
	@Test
	public void testEnumAPI() {
		// 基本用法
		System.out.println(StatusEnum.LOGIN);
		System.out.println(StatusEnum.LOGIN.name());
		System.out.println(StatusEnum.LOGIN.getMsg());
		System.out.println(StatusEnum.LOGIN.ordinal());
		System.out.println(StatusEnum.LOGIN.toString());
		System.out.println(StatusEnum.LOGIN.getDeclaringClass());
		// 测试其他的Enum
		System.out.println(StatusEnum.LOGOUT);
		System.out.println(StatusEnum.UNKOWN);
		// 根据枚举名称获取枚举对象
		StatusEnum enum1 = StatusEnum.valueOf("LOGIN");
		StatusEnum enum2 = StatusEnum.valueOf("LOGOUT");
		// compareTo底层使用枚举的ordinal属性比较
		System.out.println(enum1.compareTo(enum2));
		// 使用Object的equals方法比较
		System.out.println(enum1.equals(enum2));
		// 获取枚举StatusEnum所有的对象
		StatusEnum[] values = StatusEnum.values();
		for (StatusEnum en : values) {
			System.out.print(en + "\t");
			System.out.print(en.name() + "\t");
			System.out.println(en.ordinal());
		}
	}

	/**
	 * 测试向上转型Enum，获取所以Enum对象
	 */
	@Test
	public void testValues() {
		// 向上转型Enum
		Enum<StatusEnum> e = StatusEnum.LOGIN;
		// 获取class对象引用
		Class<?> clasz = e.getDeclaringClass();
		// Class<?> clasz = StatusEnum.class;
		if (clasz.isEnum()) {
			// 返回该枚举类型的所有元素，如果Class对象不是枚举类型，则返回null。
			StatusEnum[] status = (StatusEnum[]) clasz.getEnumConstants();
			System.out.println(Arrays.toString(status));
		}
	}

	/**
	 * 测试自定义的抽象方法
	 */
	@Test
	public void testAbstract() {
		// 先获取所有枚举对象
		StatusEnum[] values = StatusEnum.values();
		// 遍历枚举对象
		for (StatusEnum en : values) {
			System.out.println(en.getStatusInfo());
		}
	}
}
