package algorithm.sort;

import static algorithm.sort.util.ArraySwapUtils.swap;

/**
 * Created by Kim QQ.Cong on 2020-06-02 / 15:41
 *
 * @author: CongQingquan
 * @Description: 插入排序 O(n^2)
 */
public class InsertionSort {

    public static void sort(int[] array) {
        // i索引上的值即插入元素
        for (int i = 1; i < array.length; i++) {
            // 迭代i索引前的已经有序区间
            // i = j: 对插入元素的索引存储一个临时变量
            // j > 0 & j--: 对有序区间逐一比较
            for (int j = i; j > 0; j--) {
                // 如果插入元素小于有序区间的尾元素, 则替换二者的位置. 但替换后, 并不是插入元素的最终位置.
                // 可能之前还有比插入元素大的元素, 则进入下一次循环, 对于刚刚交换完毕位置的元素再次与有序区间的尾元素比较
                if (array[j] < array[j - 1]) {
                    swap(j, j - 1, array);
                }
                // 如果插入元素大于有序区间的尾元素, 则不需要swap, 终止循环匹配.
                else {
                    break;
                }
            }
        }
    }
}