package com.starfall.enumeration.test;

import com.starfall.enumeration.StatusEnum;
import org.junit.Test;

import java.util.*;

/**
 * @project： JavaProject
 * @package： com.starfall.enumeration.test
 * @className： EnumPlusTest
 * @author： StarFall
 * @date： 2019/3/31 23:00
 * @description： EnumSet&EnumMap的用法测试
 */
public class EnumPlusTest {

    @Test
    public void testEnumSet() {
        /**
         * 创建一个具有指定元素类型的空EnumSet。 <br>
         * EnumSet<E> noneOf(Class<E> elementType)
         */
        EnumSet<StatusEnum> enumSet = EnumSet.noneOf(StatusEnum.class);
        enumSet.add(StatusEnum.LOGIN);
        enumSet.add(StatusEnum.LOGOUT);
        for (StatusEnum statusEnum : enumSet) {
            System.out.println(statusEnum);
        }
        System.out.println("****************EnumSet.noneOf**************");
        /**
         * 创建一个指定元素类型并包含所有枚举值的EnumSet<br>
         * <E extends Enum<E>> EnumSet<E> allOf(Class <E> elementType)
         */
        EnumSet<StatusEnum> enumSet1 = EnumSet.allOf(StatusEnum.class);
        for (StatusEnum statusEnum : enumSet1) {
            System.out.println(statusEnum);
        }
        System.out.println("****************EnumSet.allOf:**************");
        /**
         * 创建一个包括枚举值中指定范围元素的EnumSet<br>
         * <E extends Enum<E>> EnumSet<E> range(E from, E to)
         */
        EnumSet<StatusEnum> enumSet2 = EnumSet.range(StatusEnum.LOGOUT, StatusEnum.LOGOUT);
        for (StatusEnum statusEnum : enumSet2) {
            System.out.println(statusEnum);
        }
        System.out.println("****************EnumSet.range:**************");
        /**
         * 初始集合包括指定集合的补集,也就是从全部枚举类型中去除参数集合中的元素，如下去掉enumSet2的元素<br>
         * <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> s)
         */
        EnumSet<StatusEnum> enumSet3 = EnumSet.complementOf(enumSet2);
        for (StatusEnum statusEnum : enumSet3) {
            System.out.println(statusEnum);
        }
        System.out.println("****************EnumSet.complementOf:**************");
        /**
         * 创建一个包括参数中所有元素的EnumSet<br>
         * <E extends Enum<E>> EnumSet<E> of(E e1, E e2,...)
         */
        EnumSet<StatusEnum> enumSet4 = EnumSet.of(StatusEnum.LOGIN, StatusEnum.LOGOUT);
        for (StatusEnum statusEnum : enumSet4) {
            System.out.println(statusEnum);
        }
        System.out.println("****************EnumSet.of:**************");
        /**
         * 创建一个包含参数容器中的所有元素的EnumSet<br>
         * <E extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> s)<br>
         * <E extends Enum<E>> EnumSet<E> copyOf(Collection<E> c)
         */
        EnumSet<StatusEnum> enumSet5 = EnumSet.copyOf(enumSet4);
        for (StatusEnum statusEnum : enumSet5) {
            System.out.println(statusEnum);
        }
        System.out.println("*************");
        List<StatusEnum> list = new ArrayList<>();
        list.add(StatusEnum.UNKOWN);
        list.add(StatusEnum.LOGOUT);
        EnumSet<StatusEnum> enumSet6 = EnumSet.copyOf(list);
        for (StatusEnum statusEnum : enumSet6) {
            System.out.println(statusEnum);
        }
        System.out.println("****************EnumSet.copyOf:**************");
    }

    @Test
    public void testEnumMap() {
        /**
         * 创建一个具有指定键类型的空枚举映射。<br>
         * EnumMap(Class<K> keyType)
         */
        Map<StatusEnum, String> enumMap = new EnumMap<>(StatusEnum.class);
        enumMap.put(StatusEnum.LOGIN, "101");
        enumMap.put(StatusEnum.UNKOWN, "301");
        for (Map.Entry<StatusEnum, String> entry : enumMap.entrySet()) {
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
        System.out.println("***************enumMap*******************");

        /**
         * 创建一个其键类型与指定枚举映射相同的枚举映射，最初包含相同的映射关系（如果有的话）。<br>
         * EnumMap(EnumMap<K,? extends V> m)
         */
        Map<StatusEnum, String> enumMap2 = new EnumMap<>(enumMap);
        for (Map.Entry<StatusEnum, String> entry : enumMap2.entrySet()) {
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
        System.out.println("***************enumMap2*******************");
        /**
         * 创建一个枚举映射，从指定映射对其初始化。<br>
         * EnumMap(Map<K,? extends V> m)
         */
        Map<StatusEnum, String> hashMap = new HashMap<>();
        hashMap.put(StatusEnum.LOGIN, "111");
        hashMap.put(StatusEnum.LOGOUT, "222");
        Map<StatusEnum, String> enumMap3 = new EnumMap<>(hashMap);
        for (Map.Entry<StatusEnum, String> entry : enumMap3.entrySet()) {
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
        System.out.println("***************enumMap3*******************");

    }
}



