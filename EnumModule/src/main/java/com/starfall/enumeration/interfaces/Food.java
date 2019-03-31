package com.starfall.enumeration.interfaces;

/**
 * @project： JavaProject
 * @package： com.starfall.enumeration.interfaces
 * @className： Food
 * @author： StarFall
 * @date： 2019/3/31 22:15
 * @description： 食物菜单Food, 枚举中的对象就是声明在接口中，各个枚举只是起到了分组的作用。
 */
public interface Food {

    /**
     * appetizer(开胃菜)
     */
    enum Appetizer implements Food {
        /**
         * 沙拉，汤，春卷
         */
        SALAD, SOUP, SPRING_ROLLS
    }

    /**
     * mainCourse(主菜)
     */
    enum MainCourse implements Food {
        /**
         * 千层面，墨西哥卷饼，泰式炒河粉，小扁豆，hummous，咖喱肉
         */
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO
    }

    /**
     * dessert(点心)
     */
    enum Dessert implements Food {
        /**
         * 提拉米苏，冰淇淋，黑森林蛋糕，水果，焦糖布丁
         */
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL
    }

    /**
     * coffee(咖啡)
     */
    enum Coffee implements Food {
        /**
         * 黑咖啡，无咖啡因咖啡，浓咖啡，拿铁咖啡，卡布奇诺咖啡，茶，香草茶
         */
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA
    }
}
