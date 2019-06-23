package com.starfall.created.factory.test;

import com.starfall.created.factory.simplefactory.Product;
import com.starfall.created.factory.simplefactory.ProductFactory;
import org.junit.Test;

/**
 * @project JavaProject
 * @package com.starfall.created.factory.test
 * @className SimpleFactoryTest
 * @author StarFall
 * @date 2019/4/1 23:21
 * @description 简单工厂测试端
 */
public class SimpleFactoryTest {
	/**
	 * 测试抽象产品简单工厂
	 */
	@Test
	public void testProduct() {
		// 1、创建工厂
		ProductFactory factory = new ProductFactory();
		// 2、调用工厂方法生产产品
		Product product = factory.produceProduct("A");
		// 3、产品对象执行方法
		product.productMethod();
		product = factory.produceProduct("B");
		product.productMethod();
	}
}
