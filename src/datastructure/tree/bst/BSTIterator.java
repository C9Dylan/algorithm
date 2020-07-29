package datastructure.tree.bst;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * Created by Kim QQ.Cong on 2020-07-06 / 19:09
 *
 * @author: CongQingquan
 * @Description:
 */
public class BSTIterator<K, V> implements Iterator<BSTEntry<K, V>> {

    private Stack<BSTEntry<K, V>> stack;

    public BSTIterator(BSTEntry<K, V> entry) {
        stack = new Stack<>();
        pushLeft(entry);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * 获取下一个元素(因为是借助栈实现, 故复杂度O(1). 递归的实际上每次搜索都需要迭代整棵树, 故复杂度O(logN))
     * @return
     */
    @Override
    public BSTEntry<K, V> next() {
        BSTEntry<K, V> entry = stack.pop();
        pushLeft(entry.getRight());
        return entry;
    }

    @Override
    public void remove() {
        // TODO
    }

    @Override
    public void forEachRemaining(Consumer<? super BSTEntry<K, V>> action) {
        // TODO
    }

    /**
     * 左子节点入栈
     * @param entry
     */
    private void pushLeft(BSTEntry<K, V> entry) {
        while(null != entry) {
            stack.push(entry);
            entry = entry.getLeft();
        }
    }
}