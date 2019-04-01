package com.starfall.created.factory.simplefactory;

/**
 * @project： JavaProject
 * @package： com.starfall.created.factory.simplefactory
 * @className： ProductFactory
 * @author： StarFall
 * @date： 2019/4/1 23:12
 * @description： 3、工厂角色
 */
public class ProductFactory {

    private static final String PRODUCT_A = "A";
    private static final String PRODUCT_B = "B";

    /**
     * 工厂生产产品方法
     *
     * @param category 产品品类
     * @return 产品
     */
    public Product produceProduct(String category) {
        //根据传入产品品类生产产品对象
        System.out.println("根据传入产品品类生产产品对象: " + category);
        if (PRODUCT_A.equals(category)) {
            return new ConcreteProductA();
        } else if (PRODUCT_B.equals(category)) {
            return new ConcreteProductB();
        }
        return null;
    }
}
