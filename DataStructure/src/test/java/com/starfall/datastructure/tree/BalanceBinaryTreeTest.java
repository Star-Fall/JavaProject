package com.starfall.datastructure.tree;

import org.junit.Test;

/**
 * @author StarFall
 * @project JavaProject
 * @package com.starfall.datastructure.tree
 * @className BalanceBinaryTreeTest
 * @date 2019/6/23 17:47
 * @description BalanceBinaryTreeTest 平衡二叉树测试
 */
public class BalanceBinaryTreeTest {
    @Test
    public void test01() {
        BalanceBinaryTree<Integer> bbt = new BalanceBinaryTree<>();
        // int arr[] = { 3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9 };
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        for (int i = 0; i < arr.length; i++) {
            bbt.insert(arr[i]);
        }
        bbt.preOrder();
        bbt.midOrder();
        bbt.backOrder();
        bbt.levelOrder();
    }

    @Test
    public void test02() {
        BalanceBinaryTree<Integer> bbt = new BalanceBinaryTree<>();
        int arr[] = { 8, 4, 12, 2, 6, 1 };
        for (int i = 0; i < arr.length; i++) {
            bbt.insert(arr[i]);
        }
        bbt.preOrder();
        bbt.midOrder();
        bbt.backOrder();
        bbt.levelOrder();
        System.out.println("***********搜索节点数据***********");
        System.out.println(bbt.searchTree(4).getHeight());
    }

    @Test
    public void test03() {
        BalanceBinaryTree<Integer> bbt = new BalanceBinaryTree<>();
        int arr[] = { 3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9, 17 };
        for (int i = 0; i < arr.length; i++) {
            bbt.insert(arr[i]);
        }
        bbt.preOrder();
        bbt.midOrder();
        bbt.backOrder();
        bbt.levelOrder();
        System.out.println("***********删除节点数据***********");
        bbt.deleteNode(14);
        bbt.preOrder();
        bbt.midOrder();
        bbt.backOrder();
        bbt.levelOrder();
    }

}