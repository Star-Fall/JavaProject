package com.starfall.created.factory.simplefactory;

/**
 * @project JavaProject
 * @package com.starfall.created.factory.simplefactory
 * @className ConcreteProductA
 * @author StarFall
 * @date 2019/4/1 23:09
 * @description 2.1、具体产品角色A
 */
public class ConcreteProductA implements Product {

    @Override
    public void productMethod() {
        System.out.println("具体的产品角色：" + this.getClass().getName());
    }
}
