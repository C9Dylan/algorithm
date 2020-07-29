package algorithm.sort.util;

/**
 * Created by Kim QQ.Cong on 2020-06-02 / 15:46
 *
 * @author: CongQingquan
 * @Description:
 */
public class ArraySwapUtils {

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}