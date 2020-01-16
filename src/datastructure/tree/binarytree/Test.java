package datastructure.tree.binarytree;

/**
 * Created by Kim QQ.Cong on 2019-11-26 / 19:15
 *
 * @author: CongQingquan
 * @Description: 二叉树
 */
public class Test {

    public static void main(String[] args) {
        // 实例化一颗测试树
        Node rootNode = createTestTree();
        BinaryTree binaryTree = new LinkedBinaryTree(rootNode);
        // 1. 前序遍历 -> 1.4.5.2.3.6.7
        System.out.print("1. 前序遍历(递归) ->");
        binaryTree.preOrderTraverse();
        System.out.println();
        // 2. 中序遍历 -> 4.5.1.3.2.6.7
        System.out.print("2. 中序遍历(递归) ->");
        binaryTree.inOrderTraverse();
        System.out.println();
        // 3. 后序遍历 -> 5.4.3.7.6.2.1
        System.out.print("3. 后序遍历(递归) ->");
        binaryTree.postOrderTraverse();
        System.out.println();
        // 4. 是否为空
        System.out.println("4. 是否为空 -> " + binaryTree.isEmpty());
        // 5. 获取树的高度
        System.out.println("5. 获取树的高度 -> " + binaryTree.getHeight());
        // 6. 树结点数量
        System.out.println("6. 树结点数量 -> " + binaryTree.size());
        // 7. 查询元素
        System.out.println("7. 查询元素3结果 -> " + binaryTree.findKey(3));
        // 8. 根据层级打印 -> 1.4.2.5.3.6.7
        System.out.print("8. 根据层级打印 -> ");
        binaryTree.levelOrderByStack();
        System.out.println();
        // 9. 前序遍历(借助栈) -> 1.4.5.2.3.6.7
        System.out.print("9. 前序遍历(借助栈) -> ");
        binaryTree.preOrderByStack();
        System.out.println();
        // 10. 中序遍历(借助栈) ->
        System.out.print("10. 中序遍历(借助栈) -> ");
        System.out.println();
        // 11. 后序遍历(借助栈) ->
        System.out.print("11. 后序遍历(借助栈) -> ");
        System.out.println();
    }

    private static Node createTestTree() {
        // left children
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, null, node5);
        // right children
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, node7);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node3, node6);
        // root
        Node rootNode = new Node(1, node4, node2);
        return rootNode;
    }
}