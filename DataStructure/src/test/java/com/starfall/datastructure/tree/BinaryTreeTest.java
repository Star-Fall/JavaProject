package com.starfall.datastructure.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author StarFall
 * @project JavaProject
 * @package com.starfall.datastructure.tree
 * @className BinaryTreeTest
 * @date 2019/6/23 17:42
 * @description BinaryTreeTest 二叉树测试
 */
public class BinaryTreeTest {

	/**
	 * 添加子树创建二叉树
	 */
	@Test
	public void test01() {
		System.out.println("添加子树创建二叉树");
		// 层序遍历：ABCDEFG
		// 根节点
		BinaryTree<String> btree = new BinaryTree<>("A");
		// 根节点左右子树
		BinaryTree<String> bt1, bt2;
		bt1 = new BinaryTree<>("B");
		btree.setLeftTree(bt1);
		bt2 = new BinaryTree<>("C");
		btree.setRightTree(bt2);
		// B左右子树
		BinaryTree<String> bt11, bt12;
		bt11 = new BinaryTree<>("D");
		bt1.setLeftTree(bt11);
		bt12 = new BinaryTree<>("E");
		bt1.setRightTree(bt12);
		// C左右子树
		BinaryTree<String> bt21, bt22;
		bt21 = new BinaryTree<>("F");
		bt2.setLeftTree(bt21);
		bt22 = new BinaryTree<>("G");
		bt2.setRightTree(bt22);
		// 遍历
		btree.preOrder();
		btree.midOrder();
		btree.backOrder();
		btree.levelOrder();
		btree.releaseTree();
		System.out.println("**********添加子树创建二叉树**********end");
	}

	/**
	 * 前序遍历创建二叉树
	 */
	@Test
	public void test02() {
		System.out.println("前序遍历创建二叉树");
		// 补全空节点
		List<String> list = Arrays.asList("A", "B", "D", null, null, "F", "E", null, null, null, "C", "G", null, "H",
				null, null, "I", null, null);
		BinaryTree<String> bt = new BinaryTree<>();
		bt.preCreateTree(list);
		bt.preOrder();
		bt.midOrder();
		bt.backOrder();
		bt.levelOrder();
		bt.releaseTree();
		System.out.println("**********前序遍历创建二叉树**********end");
	}

	/**
	 * 层序遍历创建二叉树
	 */
	@Test
	public void test03() {
		System.out.println("层序遍历创建二叉树");
		// 补全空节点，转为完全二叉树
		List<String> list = Arrays.asList("A", "B", "C", "D", "F", "G", "I", null, null, "E", null, null, "H");
		BinaryTree<String> bt = new BinaryTree<>();
		bt.levelCreateTree(list);
		bt.preOrder();
		bt.midOrder();
		bt.backOrder();
		bt.levelOrder();
		bt.releaseTree();
		System.out.println("**********层序遍历创建二叉树**********end");
	}

	/**
	 * 二叉树其他用法1
	 */
	@Test
	public void test04() {
		System.out.println("二叉树其他用法1");
		// 前序遍历创建二叉树
		List<String> list = Arrays.asList("A", "B", "D", null, null, "F", "E", null, null, null, "C", "G", null, "H",
				null, null, "I", null, null);
		BinaryTree<String> bt = new BinaryTree<>();
		bt.preCreateTree(list);
		System.out.println(bt.getNodeNum());
		System.out.println(bt.getTreeDepth());
		System.out.println(bt.getLeafNum());
		bt.preOrder();
		bt.midOrder();
		bt.backOrder();
		bt.levelOrder();
		System.out.println("*******根据节点数据获取当前树*****");
		BinaryTree<String> tree = bt.getBTree("F");
		System.out.println(tree.getNodeNum());
		System.out.println(tree.getTreeDepth());
		System.out.println(tree.getLeafNum());
		System.out.println(tree.getRoot().getData());
		tree.levelOrder();
		bt.releaseTree();
		tree.releaseTree();
		System.out.println("**********二叉树其他用法1**********end");
	}

	/**
	 * 二叉树其他用法2
	 */
	@Test
	public void test05() {
		System.out.println("二叉树其他用法2");
		// 前序遍历创建二叉树
		List<String> list = Arrays.asList("A", "B", "D", null, null, "F", "E", null, null, null, "C", "G", null, "H",
				null, null, "I", null, null);
		BinaryTree<String> bt = new BinaryTree<>();
		bt.preCreateTree(list);
		System.out.println("*******根据节点数据获取左子树*****");
		BinaryTree<String> leftChildTree = bt.getLeftChildTree("D");
		leftChildTree.preOrder();
		leftChildTree.midOrder();
		leftChildTree.backOrder();
		leftChildTree.levelOrder();
		System.out.println("*******根据节点数据获取右子树*****");
		BinaryTree<String> rightChildTree = bt.getRightChildTree("A");
		rightChildTree.preOrder();
		rightChildTree.midOrder();
		rightChildTree.backOrder();
		rightChildTree.levelOrder();
		System.out.println("**********二叉树其他用法2**********end");
	}

	/**
	 * 非递归遍历
	 */
	@Test
	public void test06() {
		// 前序遍历创建二叉树
		List<String> list = Arrays.asList("A", "B", "D", null, null, "F", "E", null, null, null, "C", "G", null, "H",
				null, null, "I", null, null);
		BinaryTree<String> bt = new BinaryTree<>();
		bt.preCreateTree(list);
		System.out.println("*******前序遍历******");
		bt.preOrder();
		bt.preOrderNoRecursion();
		bt.preOrderNoRecursion2();
		System.out.println("*******中序遍历******");
		bt.midOrder();
		bt.midOrderNoRecursion();
		System.out.println("*******后序遍历******");
		bt.backOrder();
		bt.backOrderNoRecursion();
		bt.backOrderNoRecursion2();
	}
}