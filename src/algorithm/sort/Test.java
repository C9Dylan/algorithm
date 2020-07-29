package algorithm.sort;

import java.util.Arrays;

/**
 * Created by Kim QQ.Cong on 2020-06-02 / 15:42
 *
 * @author: CongQingquan
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        // ======   Bubble  ======
        int[] array = new int[] {5, 1, 8, 10, 2, 2, 23};
        BubbleSort.sort(array);
        System.out.println("Bubble sort: " + Arrays.toString(array));

        // ======   Quick  ======
        array = new int[] {5, 1, 8, 10, 2, 2, 23};
        QuickSort.sort(array);
        System.out.println("Quick sort: " + Arrays.toString(array));

        // ======   Insertion  ======
        array = new int[] {5, 1, 8, 10, 2, 2, 23};
        InsertionSort.sort(array);
        System.out.println("Insertion sort: " + Arrays.toString(array));

        // ======   Selection  ======
        array = new int[] {5, 1, 8, 10, 2, 2, 23};
        SelectionSort.sort(array);
        System.out.println("Selection sort: " + Arrays.toString(array));

        // ======   Shell  ======
        array = new int[] {5, 1, 8, 10, 2, 2, 23};
        SelectionSort.sort(array);
        System.out.println("Selection sort: " + Arrays.toString(array));

    }
}