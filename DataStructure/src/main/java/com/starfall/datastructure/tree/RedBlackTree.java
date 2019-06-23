package com.starfall.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author StarFall
 * @project JavaProject
 * @package com.starfall.datastructure.tree
 * @className RedBlackTree
 * @date 2019/6/23 17:48
 * @description RedBlackTree 红黑树
 */
public class RedBlackTree<T extends Comparable<T>> {

	private TreeNode<T> root;
	private static final boolean RED = false;
	private static final boolean BLACK = true;

	/**
	 * 左旋
	 *
	 * @param x
	 *            旋转的节点
	 */
	private void leftRotate(TreeNode<T> x) {
		if (x == null) {
			return;
		}
		TreeNode<T> y = x.right;
		// y的左子树设置为x的右子树
		x.right = y.left;
		// y左子树的父节点设置为x
		if (y.left != null) {
			y.left.parent = x;
		}
		// x的父节点设置为y的父节点
		y.parent = x.parent;
		// 设置x的父节点的左右节点为y
		if (x.parent == null) {
			this.root = y;
		} else if (x.parent.left == x) {
			x.parent.left = y;
		} else if (x.parent.right == x) {
			x.parent.right = y;
		}
		// x设置为y的左节点
		y.left = x;
		// y设置为x的父节点
		x.parent = y;
	}

	/**
	 * 右旋
	 *
	 * @param y
	 *            旋转的节点
	 */
	private void rightRotate(TreeNode<T> y) {
		if (y == null) {
			return;
		}
		TreeNode<T> x = y.left;
		// x的右子树设置为y的左子树
		y.left = x.right;
		// y设置为x右子树的父节点
		if (x.right != null) {
			x.right.parent = y;
		}
		// y的父节点设置x的父节点
		x.parent = y.parent;
		// 设置y父节点的左右子树为x
		if (y.parent == null) {
			this.root = x;
		} else if (y.parent.right == y) {
			y.parent.right = x;
		} else if (y.parent.left == y) {
			y.parent.left = x;
		}
		// 设置x的右子树为y
		x.right = y;
		// 设置x为y的父节点
		y.parent = x;
	}

	/**
	 * 查找节点
	 *
	 * @param data
	 *            节点数据
	 * @return 节点
	 */
	public TreeNode<T> getNode(T data) {
		if (data != null) {
			return getNode(this.root, data);
		}
		return null;
	}

	/**
	 * 递归查找节点
	 *
	 * @param node
	 *            递归的节点
	 * @param data
	 *            查找的数据
	 * @return 查找结果
	 */
	private TreeNode<T> getNode(TreeNode<T> node, T data) {
		if (node == null || node.data == null || data == null) {
			// 条件不符，未找到相同节点，递归结束
			return null;
		} else if (node.data.compareTo(data) > 0) {
			// 递归遍历左子树
			return getNode(node.left, data);
		} else if (node.data.compareTo(data) < 0) {
			// 递归遍历右子树
			return getNode(node.right, data);
		} else {
			// 遍历到相同节点，递归结束
			return node;
		}
	}

	/**
	 * 插入节点
	 *
	 * @param data
	 *            插入数据
	 */
	public void insert(T data) {
		if (data != null) {
			insert(new TreeNode<>(data, BLACK));
		}
	}

	/**
	 * 插入节点（私有）
	 *
	 * @param node
	 *            需要插入的节点
	 */
	private void insert(TreeNode<T> node) {
		// 依据二叉排序树特效插入节点
		TreeNode<T> current = this.root;
		if (current == null) {
			this.root = node;
			return;
		}
		TreeNode<T> parent = null;
		while (current != null) {
			parent = current;
			if (current.data.compareTo(node.data) > 0)
				current = current.left;
			else if (current.data.compareTo(node.data) < 0)
				current = current.right;
			else
				return;
		}
		node.parent = parent;
		if (parent.data.compareTo(node.data) > 0) {
			parent.left = node;
		} else {
			parent.right = node;
		}
		// 着色
		node.color = RED;
		// 修正
		fixAfterInsertion(node);
	}

	/**
	 * 插入节点后修正红黑树
	 *
	 * @param node
	 *            需要修正的节点
	 */
	private void fixAfterInsertion(TreeNode<T> node) {
		// node的父节点为红色的时候进行调整
		while (node != null && node != this.root && node.parent.color == RED) {
			// node的父节点是node祖父节点的左子树
			if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
				// y为node的叔叔节点
				TreeNode<T> y = rightOf(parentOf(parentOf(node)));
				// @case1 父节点为red、叔叔节点为red
				if (colorOf(y) == RED) {
					// 设置父节点为black、叔叔节点为black、祖父节点为red
					// 设置祖父节点为node，循环上述步骤
					setColor(parentOf(node), BLACK);
					setColor(y, BLACK);
					setColor(parentOf(parentOf(node)), RED);
					node = parentOf(parentOf(node));
				} else {
					// @case2 父节点为red、叔叔节点为black
					// @case2.1 node为父节点的右子树
					if (node == rightOf(parentOf(node))) {
						// 设置父节点为当前节点
						node = parentOf(node);
						// 左旋父节点，继续case2.2的步骤
						leftRotate(node);
					}
					// @case2.2 node为父节点的左子树
					// 设置父节点为black、祖父节点为red、右旋祖父节点
					setColor(parentOf(node), BLACK);
					setColor(parentOf(parentOf(node)), RED);
					rightRotate(parentOf(parentOf(node)));
				}
			} else {
				// node的父节点是node祖父节点的右子树
				TreeNode<T> y = leftOf(parentOf(parentOf(node)));
				if (colorOf(y) == RED) {
					setColor(parentOf(node), BLACK);
					setColor(y, BLACK);
					setColor(parentOf(parentOf(node)), RED);
					node = parentOf(parentOf(node));
				} else {
					// @case2 父节点为red、叔叔节点为black
					// @case2.1 node为父节点的左子树
					if (node == leftOf(parentOf(node))) {
						// 右旋父节点
						node = parentOf(node);
						rightRotate(node);
					}
					// @case2.2 node为父节点的右子树
					// 设置父节点为black、祖父节点为red、左旋祖父节点
					setColor(parentOf(node), BLACK);
					setColor(parentOf(parentOf(node)), RED);
					leftRotate(parentOf(parentOf(node)));
				}
			}
		}
		// 最后设置根节点为black
		root.color = BLACK;
	}

	/**
	 * 删除节点
	 *
	 * @param data
	 *            节点数据
	 */
	public void remove(T data) {
		if (data != null) {
			TreeNode<T> node = getNode(this.root, data);
			if (node != null) {
				remove(node);
			}
		}
	}

	/**
	 * 删除节点算法
	 *
	 * @param p
	 *            要删除的节点
	 */
	private void remove(TreeNode<T> p) {
		// case1:删除的节点p左右子树不为空，
		// 使用后继节点代替P，之后删除后继节点
		if (p.left != null && p.right != null) {
			TreeNode<T> s = successor(p);
			p.data = s.data;
			// 赋值p为后继节点的引用，则删除p即删除后继节点
			p = s;
		}
		// case2、3：删除的节点P左右都为空或者有一个为空
		// 如果都不为空，此时p被后继节点代替
		TreeNode<T> replacement = (p.left != null ? p.left : p.right);

		// case2：节点p左右子树有一个不为空
		if (replacement != null) {
			// 使用替代节点replacement代替p，再删除p节点
			replacement.parent = p.parent;
			if (p.parent == null)
				root = replacement;
			else if (p == p.parent.left)
				p.parent.left = replacement;
			else
				p.parent.right = replacement;
			// 删除p节点
			p.left = p.right = p.parent = null;
			// 删除的节点为黑色，需要对替代节点进行修正
			// 删除的节点为红色，直接删除
			if (p.color == BLACK)
				fixAfterDeletion(replacement);
		} else if (p.parent == null) {
			root = null;
		} else {
			// case3：节点p左右子树都为空
			// 节点p为黑色，需要进行调整
			if (p.color == BLACK)
				fixAfterDeletion(p);

			// 修正完成，直接删除p
			if (p.parent != null) {
				if (p == p.parent.left)
					p.parent.left = null;
				else if (p == p.parent.right)
					p.parent.right = null;
				p.parent = null;
			}
		}
	}

	/**
	 * 删除节点后，修正红黑树
	 *
	 * @param x
	 *            需要修正的节点
	 */
	private void fixAfterDeletion(TreeNode<T> x) {
		// 节点x为黑色，并且不为根节点时候，进行修正流程
		while (x != root && colorOf(x) == BLACK) {
			// case1：节点X是其父节点的左孩子
			if (x == leftOf(parentOf(x))) {
				TreeNode<T> sib = rightOf(parentOf(x));
				// case1.1：x的兄弟节点是红色
				if (colorOf(sib) == RED) {
					setColor(sib, BLACK);
					setColor(parentOf(x), RED);
					leftRotate(parentOf(x));
					sib = rightOf(parentOf(x));
				}
				// case1.2：x的兄弟节点为黑色，并且兄弟节点的两个孩子都是黑色
				if (colorOf(leftOf(sib)) == BLACK && colorOf(rightOf(sib)) == BLACK) {
					setColor(sib, RED);
					x = parentOf(x);
					// 注意：此时重新设置了x节点，流程循环重新开始
				} else {
					// case1.3：x的兄弟节点是黑色，并且兄弟节点的右孩子是黑色，左孩子是红色
					if (colorOf(rightOf(sib)) == BLACK) {
						setColor(leftOf(sib), BLACK);
						setColor(sib, RED);
						rightRotate(sib);
						sib = rightOf(parentOf(x));
					}
					// case1.4：x的兄弟节点是黑色，并且兄弟节点的右孩子是红色，左孩子颜色任意
					setColor(sib, colorOf(parentOf(x)));
					setColor(parentOf(x), BLACK);
					setColor(rightOf(sib), BLACK);
					leftRotate(parentOf(x));
					x = root;
				}
			} else {
				// case2：节点X是其父节点的右孩子
				TreeNode<T> sib = leftOf(parentOf(x));

				if (colorOf(sib) == RED) {
					setColor(sib, BLACK);
					setColor(parentOf(x), RED);
					rightRotate(parentOf(x));
					sib = leftOf(parentOf(x));
				}

				if (colorOf(rightOf(sib)) == BLACK && colorOf(leftOf(sib)) == BLACK) {
					setColor(sib, RED);
					x = parentOf(x);
				} else {
					if (colorOf(leftOf(sib)) == BLACK) {
						setColor(rightOf(sib), BLACK);
						setColor(sib, RED);
						leftRotate(sib);
						sib = leftOf(parentOf(x));
					}
					setColor(sib, colorOf(parentOf(x)));
					setColor(parentOf(x), BLACK);
					setColor(leftOf(sib), BLACK);
					rightRotate(parentOf(x));
					x = root;
				}
			}
		}
		// 如果要修正的节点是红色，直接设置为黑色即可
		// 因为删除了黑色节点才需要进行调整，因此可以直接将红色设为黑色，补充删除的黑色。
		setColor(x, BLACK);
	}

	/**
	 * 获取节点t的后继节点<br>
	 * 该节点的右子树中的最小节点，即右子树中最左侧节点
	 *
	 * @param t
	 *            节点t
	 * @return 后继节点
	 */
	private TreeNode<T> successor(TreeNode<T> t) {
		if (t == null)
			return null;
		else if (t.right != null) {
			TreeNode<T> p = t.right;
			while (p.left != null)
				p = p.left;
			return p;
		} else {
			return null;
		}
	}

	/**
	 * 获取指定节点的父节点
	 *
	 * @param p
	 *            指定节点
	 * @return 父节点
	 */
	private TreeNode<T> parentOf(TreeNode<T> p) {
		return (p == null ? null : p.parent);
	}

	/**
	 * 获取指定节点的左节点
	 *
	 * @param p
	 *            指定节点
	 * @return 左节点
	 */
	private TreeNode<T> leftOf(TreeNode<T> p) {
		return (p == null ? null : p.left);
	}

	/**
	 * 获取指定节点的右节点
	 *
	 * @param p
	 *            指定节点
	 * @return 右节点
	 */
	private TreeNode<T> rightOf(TreeNode<T> p) {
		return (p == null ? null : p.right);
	}

	/**
	 * 获取指定节点的颜色
	 *
	 * @param p
	 *            指定节点
	 * @return 节点颜色
	 */
	private boolean colorOf(TreeNode<T> p) {
		return (p == null ? BLACK : p.color);
	}

	/**
	 * 设置指定节点颜色
	 *
	 * @param p
	 *            指定节点
	 * @param c
	 *            颜色
	 */
	private void setColor(TreeNode<T> p, boolean c) {
		if (p != null)
			p.color = c;
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
		System.out.print(node.data + "," + node.color + "  ");
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
		System.out.print(node.data + "," + node.color + "  ");
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
		System.out.print(node.data + "," + node.color + "  ");
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
			System.out.print(temp.data + "," + temp.color + "  ");
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
		private boolean color;
		private TreeNode<T> left;
		private TreeNode<T> right;
		private TreeNode<T> parent;

		TreeNode() {

		}

		TreeNode(T data) {
			this.data = data;
		}

		TreeNode(T data, boolean color) {
			this.data = data;
			this.color = color;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public boolean isColor() {
			return color;
		}

		public void setColor(boolean color) {
			this.color = color;
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

		public TreeNode<T> getParent() {
			return parent;
		}

		public void setParent(TreeNode<T> parent) {
			this.parent = parent;
		}
	}
}