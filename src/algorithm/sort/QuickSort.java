package algorithm.sort;

/**
 * Created by Kim QQ.Cong on 2020-01-16 / 16:32
 *
 * @author: CongQingquan
 * @Description: 快速排序 O(N logN)
 */
public class QuickSort {

    /**
     * 快速排序
     * @param array
     */
    public static void sort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSortProcedure(low, high, array);
    }

    /**
     * 快速排序过程
     * @param low
     * @param high
     * @param array
     */
    private static void quickSortProcedure(int low, int high, int[] array) {

        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int value = array[low];

        while (i < j) {
            // 从右开始, 寻找一个小于value的数
            while (i < j && array[j] >= value) {
                j--;
            }
            array[i] = array[j];
            // 从左开始, 寻找一个大于value的数
            while (i < j && array[i] <= value) {
                i++;
            }
            array[j] = array[i];
        }

        array[i] = value;
        // 分治
        quickSortProcedure(low, i - 1, array);
        quickSortProcedure(low + 1, high, array);
    }
}