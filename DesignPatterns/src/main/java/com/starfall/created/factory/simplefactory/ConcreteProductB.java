package com.starfall.created.factory.simplefactory;

/**
 * @project： JavaProject
 * @package： com.starfall.created.factory.simplefactory
 * @className： ConcreteProductB
 * @author： StarFall
 * @date： 2019/4/1 23:10
 * @description： 2.2、具体产品角色B
 */
public class ConcreteProductB implements Product {

    @Override
    public void productMethod() {
        System.out.println("具体的产品角色：" + this.getClass().getName());
    }
}
