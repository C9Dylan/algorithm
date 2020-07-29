package datastructure.tree.bst;

import java.util.Map;

/**
 * Created by Kim QQ.Cong on 2020-07-06 / 17:56
 *
 * @author: CongQingquan
 * @Description: 树节点
 */

public class BSTEntry<K, V> implements Map.Entry<K, V> {

    K key;
    V value;
    BSTEntry<K, V> left;
    BSTEntry<K, V> right;
    BSTEntry<K, V> parent;

    public BSTEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    public BSTEntry<K, V> getLeft() {
        return left;
    }

    public void setLeft(BSTEntry<K, V> left) {
        this.left = left;
    }

    public BSTEntry<K, V> getRight() {
        return right;
    }

    public void setRight(BSTEntry<K, V> right) {
        this.right = right;
    }

    public BSTEntry<K, V> getParent() {
        return parent;
    }

    public void setParent(BSTEntry<K, V> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "AVLEntry{" +
            "key=" + key +
            ", value=" + value +
            '}';
    }
}