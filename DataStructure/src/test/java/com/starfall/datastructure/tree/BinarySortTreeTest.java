package com.starfall.datastructure.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author StarFall
 * @project JavaProject
 * @package com.starfall.datastructure.tree
 * @className BinarySortTreeTest
 * @date 2019/6/23 17:45
 * @description BinarySortTreeTest 二叉排序树测试
 */
public class BinarySortTreeTest {

	@Test
	public void test01() {
		// List<Integer> list = Arrays.asList(63, 55, 90, 42, 58, 70, 10, 45, 67, 83);
		List<Integer> list = Arrays.asList(61, 87, 59, 47, 35, 60, 73, 51, 98, 37, 93);
		BinarySortTree<Integer> bst = new BinarySortTree<>();
		System.out.println("递归插入节点创建BST");
		bst.createBSTRecursive(list);
		bst.preOrder();
		bst.midOrder();
		bst.backOrder();
		bst.levelOrder();
		bst.releaseTree();
	}

	@Test
	public void test02() {
		List<Integer> list = Arrays.asList(61, 87, 59, 47, 35, 60, 73, 51, 98, 37, 93);
		BinarySortTree<Integer> bst = new BinarySortTree<>();
		System.out.println("非递归插入节点创建BST");
		bst.createBSTNoRecursive(list);
		bst.preOrder();
		bst.midOrder();
		bst.backOrder();
		bst.levelOrder();
		bst.releaseTree();
	}

	@Test
	public void test03() {
		List<Integer> list = Arrays.asList(61, 87, 59, 47, 35, 60, 73, 51, 98, 37, 93);
		BinarySortTree<Integer> bst = new BinarySortTree<>();
		System.out.println("非递归插入节点创建BST2");
		bst.createBSTNoRecursive2(list);
		bst.preOrder();
		bst.midOrder();
		bst.backOrder();
		bst.levelOrder();
		bst.releaseTree();
	}

	@Test
	public void test04() {
		List<Integer> list = Arrays.asList(61, 87, 59, 47, 35, 60, 73, 51, 98, 37);
		BinarySortTree<Integer> bst = new BinarySortTree<>();
		bst.createBSTRecursive(list);
		bst.preOrder();
		bst.midOrder();
		bst.backOrder();
		bst.levelOrder();
		System.out.println("插入节点");
		bst.insertBST(1, true);
		bst.preOrder();
		bst.midOrder();
		bst.backOrder();
		bst.levelOrder();
		BinarySortTree.TreeNode<Integer> node = bst.searchBSTNoRecursive(37);
		if (node != null) {
			System.out.println(node.getData());
		}
		BinarySortTree.TreeNode<Integer> node2 = bst.searchBSTRecursive(35);
		if (node2 != null) {
			System.out.println(node2.getData());
		}
	}

	@Test
	public void test05() {
		List<Integer> list = Arrays.asList(61, 87, 59, 47, 35, 60, 73, 51, 98, 37);
		BinarySortTree<Integer> bst = new BinarySortTree<>();
		bst.createBSTRecursive(list);
		bst.preOrder();
		bst.midOrder();
		bst.backOrder();
		bst.levelOrder();
		System.out.println("最大值：" + bst.getMaxValue());
		System.out.println("最小值：" + bst.getMinValue());
	}

	@Test
	public void test06() {
		List<Integer> list = Arrays.asList(61, 87, 59, 47, 35, 60, 73, 51, 98, 37);
		BinarySortTree<Integer> bst = new BinarySortTree<>();
		bst.createBSTRecursive(list);
		bst.preOrder();
		bst.midOrder();
		bst.backOrder();
		bst.levelOrder();
		System.out.println("删除节点");
		bst.deleteSingleNode(47);
		bst.preOrder();
		bst.levelOrder();
	}

	@Test
	public void test07() {
		List<Integer> list = Arrays.asList(61, 87, 59, 47, 35, 60, 73, 51, 98, 37, 93, 94, 100);
		BinarySortTree<Integer> bst = new BinarySortTree<>();
		bst.createBSTRecursive(list);
		bst.preOrder();
		bst.midOrder();
		bst.backOrder();
		bst.levelOrder();
		System.out.println("删除节点");
		bst.deleteSingleNode(59);
		bst.preOrder();
		bst.levelOrder();
	}
}