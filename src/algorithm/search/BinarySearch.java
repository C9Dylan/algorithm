package algorithm.search;

/**
 * Created by Kim QQ.Cong on 2019-11-28 / 19:48
 *
 * @author: CongQingquan
 * @Description: 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        // 二分查找(非递归)
        int len = 100;
        int[] array = new int[len];
        for(int i = 0; i < len; i++) {
            array[i] = i + 1;
        }
        int index = binarySearch(100, array);
        System.out.println(index);
        // 二分查找(递归)
        int low = 0;
        int high = array.length - 1;
        int index2 = binarySearch(low, high, 100, array);
        System.out.println(index2);
    }

    /**
     * 二分查找(非递归)
     * 时间复杂度 -> T(n) = O(log2n)
     * 空间复杂度 -> S(n) = O(1)
     * @param key 查找关键字
     * @param array 数据源
     * @return 关键字所在索引
     */
    public static int binarySearch(int key, int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = high >> 1;
        for (int temp; (temp = array[mid]) != key;) {
            if (key < temp) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (high + low) >> 1;
            if (low > high) {
                return -1;
            }
        }
        return mid;
    }

    /**
     * 二分查找(递归)
     * 时间复杂度 -> T(n) = O(log2n)
     * 空间复杂度 -> S(n) = O(log2n)
     * @param low 最低索引
     * @param high 最高索引
     * @param key 查找关键字
     * @param array 数据源
     * @return 关键字所在索引
     */
    public static int binarySearch(int low, int high, int key, int[] array) {
        if (low > high) {
            return -1;
        }
        int mid = (high + low) >> 1;
        if (array[mid] == key) {
            return mid;
        }
        if (key < array[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
        return binarySearch(low, high, key, array);
    }
}