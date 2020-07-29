package algorithm.sort;

import static algorithm.sort.util.ArraySwapUtils.swap;

/**
 * Created by Kim QQ.Cong on 2020-06-02 / 19:08
 *
 * @author: CongQingquan
 * @Description: 选择排序
 */
public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 最小值索引, 默认为i
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                // 后继元素有小于比较元素的元素, 则更新minIndex. 直到循环结束不再更新.
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 如果i就是最小的元素, 则不进行swap
            if (minIndex != i) {
                swap(i, minIndex, array);
            }
        }
    }
}