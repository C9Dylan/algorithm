package algorithm.sort;

import static algorithm.sort.util.ArraySwapUtils.swap;

/**
 * Created by Kim QQ.Cong on 2020-01-16 / 16:32
 *
 * @author: CongQingquan
 * @Description: 冒泡排序 O(n^2)
 */
public class BubbleSort {

    public static void sort(int[] array) {
        // 交换标记
        boolean changeFlag = true;
        // 数据最后一次交换时的索引
        int k = array.length - 1;

        while (changeFlag) {
            changeFlag = false;
            // 对k存储一个临时变量, 方便比较循环结束后, 刷新k的值
            int tempK = k;
            for (int i = 0; i < k; i++) {
                if (array[i + 1] < array[i]) {
                    swap(i + 1, i, array);
                    changeFlag = true;
                    tempK = i;
                }
            }
            // 刷新k, 即存储最后一次交换时元素的位置
            k = tempK;
            // 如果没有改变则说明数组已经是有序的, 终止循环
            if (!changeFlag) {
                break;
            }
        }
    }
}