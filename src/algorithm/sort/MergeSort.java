package algorithm.sort;

/**
 * Created by Kim QQ.Cong on 2020-01-16 / 16:27
 *
 * @author: CongQingquan
 * @Description: 归并排序
 */
public class MergeSort {

    public static void sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int[] tempSpace = new int[array.length];
        sort(left, right, tempSpace);
    }

    private static void sort(int left, int right, int[] tempSpace) {
        if (left < right) {

        }
    }

    private static void merge() {}
}