package datastructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Kim QQ.Cong on 2019-11-27 / 11:48
 *
 * @author: CongQingquan
 * @Description: 基于链表的二叉树
 */
public class LinkedBinaryTree implements BinaryTree {

    private Node root;

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    /**
     * 树是否为空
     */
    @Override
    public boolean isEmpty() {
        return null == root;
    }

    /**
     * 获取数据结点的数量(递归)
     */
    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        return size(root);
    }

    private int size(Node node) {
        // 递归边界
        if (node == null) {
            return 0;
        }
        // 左子树的结点数量
        int leftTreeSize = size(node.getLeftChild());
        // 右子树的结点数量
        int rightTreeSize = size(node.getRightChild());
        // 左右子树相加再加上根节点后返回
        return leftTreeSize + rightTreeSize + 1;
    }

    /**
     * 获取树的高度(递归)
     */
    @Override
    public int getHeight() {
        if (root == null) {
            return 0;
        }
        return getHeight(root);
    }

    private int getHeight(Node node) {
        // 递归边界
        if (node == null) {
            return 0;
        }
        // 左子树的高度
        int leftHeight = getHeight(node.getLeftChild());
        // 右子树的高度
        int rightHeight = getHeight(node.getRightChild());
        // 比较后加上根节点高度返回
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 查找元素
     */
    @Override
    public Node findKey(int value) {

        if (root == null) {
            return null;
        } else if (root.getValue() == value) {
            return root;
        }

        return findKey(value, root);
    }

    private Node findKey(int value, Node node) {
        // 递归边界1: 未查询到节点时
        if (node == null) {
            return null;
        }
        // 递归边界2: 查询到结点时
        if (node.getValue() == value) {
            return node;
        }
        // 左右结点依次查询
        Node v1 = findKey(value, node.getLeftChild());
        Node v2 = findKey(value, node.getRightChild());
        // 判断是否查询到结点后返回
        return v1 != null ? v1 : v2 != null ? v2 : null;
    }

    /**
     * 前序遍历(递归): 根 -> 左 -> 右
     */
    @Override
    public void preOrderTraverse() {
        if (root == null) {
            return;
        }
        // 1. 根
        if (root.getValue() != null) {
            System.out.print(root.getValue());
        }
        // 2. 左
        Node leftChild = root.getLeftChild();
        if (leftChild != null) {
            LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree(leftChild);
            linkedBinaryTree.preOrderTraverse();
        }
        // 3. 右
        Node rightChild = root.getRightChild();
        if (rightChild != null) {
            LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree(rightChild);
            linkedBinaryTree.preOrderTraverse();
        }
    }

    /**
     * 中序迭代(递归): 左 -> 根 -> 右
     */
    @Override
    public void inOrderTraverse() {
        if (root == null) {
            return;
        }
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node node) {
        if (node != null) {
            // 1. 左
            inOrderTraverse(node.getLeftChild());
            // 2. 根
            System.out.print(node.getValue());
            // 3. 右
            inOrderTraverse(node.getRightChild());
        }
    }

    /**
     * 后序迭代(递归): 左 -> 右 -> 根
     */
    @Override
    public void postOrderTraverse() {
        if (root == null) {
            return;
        }
        postOrderTraverse(root);
    }

    @Override
    public void postOrderTraverse(Node node) {
        if (node != null) {
            // 1. 左
            postOrderTraverse(node.getLeftChild());
            // 2. 右
            postOrderTraverse(node.getRightChild());
            // 3. 根
            System.out.print(node.getValue());
        }
    }

    /**
     * 按照层级遍历(借助栈)
     */
    @Override
    public void levelOrderByStack() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node pollNode = queue.poll();
                System.out.print(pollNode.getValue());
                Node leftChild = pollNode.getLeftChild();
                Node rightChild = pollNode.getRightChild();
                if (leftChild != null) {
                    queue.offer(leftChild);
                }
                if (rightChild != null) {
                    queue.offer(rightChild);
                }
            }
        }
    }

    /**
     * 前序迭代(借助栈)
     */
    @Override
    public void preOrderByStack() {

    }

    /**
     * 中序迭代(借助栈)
     */
    @Override
    public void inOrderByStack() {

    }

    /**
     * 后序迭代(借助栈)
     */
    @Override
    public void postOrderByStack() {

    }
}