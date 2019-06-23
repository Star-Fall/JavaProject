package com.starfall.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author StarFall
 * @project JavaProject
 * @package com.starfall.datastructure.tree
 * @className BalanceBinaryTree
 * @date 2019/6/23 17:47
 * @description BalanceBinaryTree 平衡二叉树/AVL树
 */
public class BalanceBinaryTree<T extends Comparable<T>> {

	private TreeNode<T> root;

	/**
	 * 节点的高度
	 *
	 * @param node
	 *            节点
	 * @return 高度
	 */
	private int height(TreeNode<T> node) {
		if (node != null) {
			return node.height;
		}
		return 0;
	}

	/**
	 * 获取两数最大值
	 *
	 * @param a
	 *            数值1
	 * @param b
	 *            数值2
	 * @return 最大值
	 */
	private int max(int a, int b) {
		return a > b ? a : b;
	}

	/**
	 * LL旋转
	 *
	 * @param k2
	 *            k2节点
	 * @return 旋转后的根节点
	 */
	private TreeNode<T> leftLeftRotation(TreeNode<T> k2) {
		TreeNode<T> k1;
		// 初始化K2节点
		k1 = k2.left;

		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;
		return k1;
	}

	/**
	 * RR旋转
	 *
	 * @param k1
	 *            k1节点
	 * @return 旋转后的根节点
	 */
	private TreeNode<T> rightRightRotation(TreeNode<T> k1) {
		TreeNode<T> k2;
		// 初始化K2节点
		k2 = k1.right;

		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.right), k1.height) + 1;
		return k2;
	}

	/**
	 * LR旋转
	 *
	 * @param k3
	 *            k3旋转
	 * @return 旋转后的根节点
	 */
	private TreeNode<T> leftRightRotation(TreeNode<T> k3) {
		// 第一步：RR旋转
		k3.left = rightRightRotation(k3.left);
		// 第二步：LL旋转
		return leftLeftRotation(k3);
	}

	/**
	 * RL旋转
	 *
	 * @param k1
	 *            k1节点
	 * @return 旋转后的根节点
	 */
	private TreeNode<T> rightLeftRotation(TreeNode<T> k1) {
		// 第一步：LL旋转
		k1.right = leftLeftRotation(k1.right);
		// 第二步：RR旋转
		return rightRightRotation(k1);
	}

	/**
	 * 插入节点
	 *
	 * @param key
	 *            插入数据
	 */
	public void insert(T key) {
		this.root = insertNode(this.root, key);
	}

	/**
	 * 插入
	 *
	 * @param node
	 *            节点
	 * @param data
	 *            数据
	 * @return 插入后的节点
	 */
	private TreeNode<T> insertNode(TreeNode<T> node, T data) {
		if (node == null) {
			node = new TreeNode<>(data);
			node.height = max(height(node.left), height(node.right)) + 1;
			return node;
		}
		// 插入到node的左子树
		if (node.data.compareTo(data) > 0) {
			node.left = insertNode(node.left, data);
			// 重新设置node的高度
			node.height = max(height(node.left), height(node.right)) + 1;
			// 判断是否平衡
			if (height(node.left) - height(node.right) == 2) {
				if (data.compareTo(node.left.data) < 0)
					node = leftLeftRotation(node);
				else
					node = leftRightRotation(node);
			}
		}
		// 插入到node的右子树
		else if (node.data.compareTo(data) < 0) {
			node.right = insertNode(node.right, data);
			// 重新设置node的高度
			node.height = max(height(node.left), height(node.right)) + 1;
			// 判断是否平衡
			if (height(node.right) - height(node.left) == 2) {
				if (data.compareTo(node.right.data) > 0)
					node = rightRightRotation(node);
				else
					node = rightLeftRotation(node);
			}
		}
		return node;
	}

	/**
	 * 搜索节点数据
	 *
	 * @param data
	 *            节点数据
	 * @return 节点
	 */
	public TreeNode<T> searchTree(T data) {
		return searchTree(this.root, data);
	}

	private TreeNode<T> searchTree(TreeNode<T> node, T data) {
		if (node == null || node.data == null || data == null) {
			// 条件不符，未找到相同节点，递归结束
			return null;
		} else if (node.data.compareTo(data) > 0) {
			// 递归遍历左子树
			return searchTree(node.left, data);
		} else if (node.data.compareTo(data) < 0) {
			// 递归遍历右子树
			return searchTree(node.right, data);
		} else {
			// 遍历到相同节点，递归结束
			return node;
		}
	}

	/**
	 * 删除节点
	 *
	 * @param data 节点数据
	 */
	public void deleteNode(T data) {
		if (searchTree(data) != null) {
			this.root = deleteNode(this.root, data);
		}
	}

	private TreeNode<T> deleteNode(TreeNode<T> node, T data) {
		if (node == null || node.data == null || data == null) {
			return node;
		}
		if (node.data.compareTo(data) > 0) {
			node.left = deleteNode(node.left, data);
			// 重新设置node的高度
			node.height = max(height(node.left), height(node.right)) + 1;
			// 判断是否平衡
			if (height(node.right) - height(node.left) == 2) {
				TreeNode<T> temp = node.right;
				if (height(temp.left) > height(temp.right)) {
					node = rightLeftRotation(node);
				} else {
					node = rightRightRotation(node);
				}
			}
		} else if (node.data.compareTo(data) < 0) {
			node.right = deleteNode(node.right, data);
			// 重新设置node的高度
			node.height = max(height(node.left), height(node.right)) + 1;
			// 判断是否平衡
			if (height(node.left) - height(node.right) == 2) {
				TreeNode<T> temp = node.left;
				if (height(temp.right) > height(temp.left)) {
					node = leftRightRotation(node);
				} else {
					node = leftLeftRotation(node);
				}
			}
		} else {
			// 左右子树都不为空
			if (node.left != null && node.right != null) {
				// node左子树高于右子树
				if (height(node.left) > height(node.right)) {
					// (01)找出node的左子树中的最大节点
					// (02)将该最大节点的值赋值给node
					// (03)删除该最大节点
					TreeNode<T> max = node.left;
					while (max.right != null) {
						max = max.right;
					}
					node.left = deleteNode(node.left, max.data);
					node.data = max.data;
				}
				// node的左子树不比右子树高(即它们相等，或右子树比左子树高1)
				else {
					// (01)找出node的右子树中的最小节点
					// (02)将该最小节点的值赋值给node
					// (03)删除该最小节点
					TreeNode<T> min = node.right;
					while (min.left != null) {
						min = min.left;
					}
					node.right = deleteNode(node.right, min.data);
					node.data = min.data;
				}
			} else {
				node = node.left != null ? node.left : node.right;
			}
		}
		return node;
	}

	/**
	 * 前序遍历
	 */
	public void preOrder() {
		System.out.print("前序遍历： [  ");
		preOrder(this.root);
		System.out.println("]");
	}

	private void preOrder(TreeNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + "  ");
		preOrder(node.left);
		preOrder(node.right);
	}

	/**
	 * 中序遍历
	 */
	public void midOrder() {
		System.out.print("中序遍历： [  ");
		midOrder(this.root);
		System.out.println("]");
	}

	private void midOrder(TreeNode<T> node) {
		if (node == null) {
			return;
		}
		midOrder(node.left);
		System.out.print(node.data + "  ");
		midOrder(node.right);
	}

	/**
	 * 后序遍历
	 */
	public void backOrder() {
		System.out.print("后序遍历： [  ");
		backOrder(this.root);
		System.out.println("]");
	}

	private void backOrder(TreeNode<T> node) {
		if (node == null) {
			return;
		}
		backOrder(node.left);
		backOrder(node.right);
		System.out.print(node.data + "  ");
	}

	/**
	 * 层序遍历二叉树
	 */
	public void levelOrder() {
		System.out.print("层序遍历： [  ");
		levelOrder(this.root);
		System.out.println("]");
	}

	private void levelOrder(TreeNode<T> node) {
		Queue<TreeNode<T>> q = new LinkedList<>();
		q.offer(node);
		while (!q.isEmpty()) {
			TreeNode<T> temp = q.poll();
			if (temp == null) {
				return;
			}
			System.out.print(temp.data + "  ");
			if (temp.left != null) {
				q.offer(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}
		}
	}

	static class TreeNode<T> {
		private T data;
		private int height;
		private TreeNode<T> left;
		private TreeNode<T> right;

		TreeNode() {

		}

		TreeNode(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public TreeNode<T> getLeft() {
			return left;
		}

		public void setLeft(TreeNode<T> left) {
			this.left = left;
		}

		public TreeNode<T> getRight() {
			return right;
		}

		public void setRight(TreeNode<T> right) {
			this.right = right;
		}
	}
}
