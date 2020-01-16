package datastructure.hashtable;

/**
 * Created by Kim QQ.Cong on 2019-11-29 / 20:41
 *
 * @author: CongQingquan
 * @Description: Java中的Map
 */
public class Test {

    /**
     * 注: 不涵括一些特殊的Map, 如WeakHashMap, IdentityHashMap
     *
     * 1. HashMap: 哈希表数据结构百度复习. 只是记录一下源码中的逻辑, 以供快速复习.
     *
     *      hashCode(): 避免hash膨胀导致冲突元素过多. 查询速度从O(1)增为O(n).
     *      equals(): 元素比较时用到, 保证元素唯一.
     *
     *      1) put: hash(key) % bucket, 桶位没有元素直接作为一个Entry(Key, Val)添加.
     *      有则通过equals比较该桶位的Entry链, 如果有相同的则替换, 无则追加到尾部.
     *
     *      2) get / del: hash(key) % bucket, 迭代Entry链, 找到返回. 最好情况查询速度为O(1), 最坏为O(n).
     *      删除则修改Entry的上的指针指向即可.
     *
     * 2) TreeMap: 底层数据结构为红黑树. 即自平衡的二叉排序树. 有序且唯一. 查询速度为0(log2n).
     */
}