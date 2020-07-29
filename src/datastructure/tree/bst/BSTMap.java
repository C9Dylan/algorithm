package datastructure.tree.bst;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Kim QQ.Cong on 2020-07-06 / 17:58
 *
 * @author: CongQingquan
 * @Description: BST Map
 */
public class BSTMap<K, V> implements Iterable<BSTEntry<K, V>> {

    /**
     * 根节点
     */
    private BSTEntry<K, V> root;

    /**
     * 元素比较器
     */
    private Comparator<K> comparator;

    /**
     * 元素数量
     */
    private int size;

    public BSTMap() {
    }

    public BSTMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    /**
     * 比较key的大小
     * @param k1
     * @param k2
     * @return
     */
    private int compare(K k1, K k2) {
        return comparator == null ? ((Comparable<K>) k1).compareTo(k2) :
            comparator.compare(k1, k2);
    }

    /**
     * 获取元素数量
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断容器是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取迭代器
     * @return
     */
    @Override
    public Iterator<BSTEntry<K, V>> iterator() {
        return new BSTIterator<>(this.root);
    }

    // ====================== Function ======================

    /**
     * 添加节点
     * @param k
     * @param v
     * @return
     */
    public V put(K k, V v) {
        BSTEntry putVal = new BSTEntry<>(k, v);
        // 1. 如果根节点没有元素
        if (root == null) {
            root = putVal;
            size++;
            return null;
        }
        // 2. 根节点不为空
        BSTEntry<K, V> t = this.root;
        V retVal = null;
        do {
            // 2.1 先比较Key
            int c = compare(k, t.getKey());
            // 1) 等于的时候直接覆盖
            if (c == 0) {
                t.setValue(v);
                retVal = t.getValue();
                size++;
                break;
            }
            // 2) 小于
            else if (c < 0) {
                // 2.1 如果没有左子树
                BSTEntry<K, V> left = t.left;
                if (null == left) {
                    putVal.parent = t;
                    t.left = putVal;
                    size++;
                    break;
                }
                // 2.1 如果含有左子树继续下次循环
                t = left;
            }
            // 3) 大于
            else if (c > 0) {
                // 3.1 如果没有右子树
                BSTEntry<K, V> right = t.right;
                if (null == right) {
                    putVal.parent = t;
                    t.right = putVal;
                    size++;
                    break;
                }
                // 3.2 如果含有右子树继续下次循环
                t = right;
            }
        } while (t != null);
        return retVal;
    }

    /**
     * 检查是否包含Key
     * @param k
     * @return
     */
    public boolean containsKey(K k) {
        return getEntry(k) != null;
    }

    /**
     * 获取值
     * @param k
     * @return
     */
    public V get(K k) {
        BSTEntry<K, V> entry = getEntry(k);
        return null == entry ? null : entry.getValue();
    }

    /**
     * 获取节点根据Key
     * @param k
     * @return
     */
    private BSTEntry<K, V> getEntry(K k) {
        if (k == null) {
            return null;
        }
        BSTEntry<K, V> t = this.root;
        BSTEntry<K, V> retEntry = null;
        do {
            int c = compare(k, t.getKey());
            if (c == 0) {
                retEntry = t;
                break;
            } else if (c < 0) {
                t = t.left;
            } else if (c > 0) {
                t = t.right;
            }
        } while (t != null);
        return retEntry;
    }

    /**
     * 检查是否包含指定值
     * @param v
     * @return
     */
    public boolean containsValue(V v) {
        return getEntryByValue(v) == null;
    }

    /**
     * 获取结点根据值
     * @param v
     * @return
     */
    public K getKey(V v) {
        BSTEntry<K, V> entry = getEntryByValue(v);
        return entry == null ? null : entry.getKey();
    }

    /**
     * 获取节点根据Value
     * @param v
     * @return
     */
    private BSTEntry<K, V> getEntryByValue(V v) {
        BSTEntry<K, V> retEntry = null;
        Iterator<BSTEntry<K, V>> iterator = iterator();
        while (iterator.hasNext()) {
            BSTEntry<K, V> next = iterator.next();
            if (next.getValue().equals(v)) {
                retEntry = next;
                break;
            }
        }
        return retEntry;
    }

    /**
     * 获取第一个结点
     * @return
     */
    public BSTEntry<K, V> getFirstEntry() {
        return getFirstEntry(this.root);
    }

    /**
     * 获取目标结点下的第一个结点
     * @param targetEntry
     * @return
     */
    private BSTEntry<K, V> getFirstEntry(BSTEntry<K, V> targetEntry) {
        BSTEntry<K, V> retEntry = targetEntry;
        for (BSTEntry<K, V> entry = targetEntry.left; entry != null; entry = entry.left) {
            retEntry = entry;
        }
        return retEntry;
    }

    public BSTEntry<K, V> getLastEntry() {
        return getLastEntry(this.root);
    }

    /**
     * 获取目标节点后的最后一个节点
     * @return
     */
    public BSTEntry<K, V> getLastEntry(BSTEntry<K, V> targetEntry) {
        BSTEntry<K, V> retEntry = targetEntry;
        for (BSTEntry<K, V> entry = targetEntry.right; entry != null; entry = entry.right) {
            retEntry = entry;
        }
        return retEntry;
    }

    /**
     * 删除结点
     * @param k
     * @return
     */
    public V remove(K k) {
        BSTEntry<K, V> entry = getEntry(k);
        if (entry == null) {
            return null;
        }
        V oldVal = entry.value;
        BSTEntry<K, V> rootEntry = deleteEntry(this.root, k);
        this.root = rootEntry;
        size--;
        return oldVal;
    }

    /**
     * 删除结点
     * @param entry
     * @param k
     * @return
     */
    private BSTEntry<K, V> deleteEntry(BSTEntry<K, V> entry, K k) {
        if (entry == null) {
            return null;
        }
        int c = compare(k, entry.key);
        // 1. 相等的情况
        if (c == 0) {
            // 1) 叶子节点
            if (entry.left == null && entry.right == null) {
                entry = null;
            }
            // 2) 只有左子节点
            else if (entry.right == null) {
                entry = entry.left;
                // 子节点提升为父节点后, 删除依旧持有的要被删除的父节点引用
                entry.parent = null;
            }
            // 2) 只有右子节点
            else if (entry.left == null) {
                entry = entry.right;
                // 子节点提升为父节点后, 删除依旧持有的要被删除的父节点引用
                entry.parent = null;
            }
            // 3) 含有左/右子结点: 以当前删除节点为根, 拿取左子树的最大节点或者右子树的最小节点替换当前删除节点.
            //                   然后在删除该替换了删除结点的结点.
            else {
                // 3.1) 替换
                BSTEntry<K, V> rightMin = getFirstEntry(entry.right);
                entry.key = rightMin.key;
                entry.value = rightMin.value;
                // 3.2) 递归删除
                BSTEntry<K, V> newRight = deleteEntry(entry.right, entry.key);
                entry.right = newRight;
            }
        }
        // 2. 删除元素在左子树的情况
        else if (c < 0) {
            BSTEntry<K, V> newLeft = deleteEntry(entry.left, k);
            entry.left = newLeft;
        }

        // 3. 删除元素在右子树的情况
        else if (c > 0) {
            BSTEntry<K, V> newRight = deleteEntry(entry.right, k);
            entry.right = newRight;
        }
        return entry;
    }

    public static void main(String[] args) {
//        baseFuncTest();
        removeTest();
    }

    static void removeTest() {
        BSTMap<Integer, Integer> map = new BSTMap<>();
        int[] array = new int[] {5, 2, 6, 1, 4, 7, 3};
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], array[i]);
        }
        // 情况一: 删除没有子节点的节点, 如删除1
        /**
         *           5
         *         /  \
         *        2    6
         *       / \    \
         *      1  4    7
         *        /
         *       3
         */
        map.remove(1);
        map.put(1, 1);

        // 情况二: 删除只有一个子节点的节点, 如删除4
        /**
         *           5
         *         /  \
         *        2    6
         *       / \    \
         *      1  4    7
         *        /
         *       3
         */
        map.remove(4);
        map.put(4, 4);
        // 情况三: 删除有左右节点的节点, 如删除2
        /**
         *           5
         *         /  \
         *        2    6
         *       / \    \
         *      1  4    7
         *        /
         *       3
         */
        map.remove(2);
    }


    static void baseFuncTest() {
        BSTMap<Integer, Integer> map = new BSTMap<>();

        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        map.put(4, 400);

        for (BSTEntry<Integer, Integer> entry : map) {
            System.out.print(entry.getKey() + "  ");
        }

        System.out.println();

        Integer value = map.get(2);
        Integer value2 = map.get(200);
        System.out.println(value);
        System.out.println(value2);

        Integer key = map.getKey(400);
        Integer key2 = map.getKey(500);
        System.out.println(key);
        System.out.println(key2);

        System.out.println(map.containsKey(3));
        System.out.println(map.containsValue(5));

        System.out.println(map.getFirstEntry());
        System.out.println(map.getLastEntry());
    }
}