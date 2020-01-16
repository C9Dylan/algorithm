package datastructure.tree.binarytree;

/**
 * Created by Kim QQ.Cong on 2019-11-27 / 11:42
 *
 * @author: CongQingquan
 * @Description: BTree的结点
 */
public class Node {

    /**
     * 结点值
     */
    private Integer value;
    /**
     * 左节点
     */
    private Node leftChild;
    /**
     * 右节点
     */
    private Node rightChild;

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Integer value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
            "value=" + value +
            ", leftChild=" + leftChild +
            ", rightChild=" + rightChild +
            '}';
    }
}