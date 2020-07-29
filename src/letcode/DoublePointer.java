package letcode;

import java.util.Arrays;

/**
 * Created by Kim QQ.Cong on 2020-05-29 / 19:28
 *
 * @author: CongQingquan
 * @Description:
 */
public class DoublePointer {

    public static void main(String[] args) {
        // 对碰指针
        test();
        // 救生艇问题
        int[] weightArray = new int[]{3, 5, 3, 4};
        int limit = 5;
        int count = doublePointerPractice(weightArray, limit);
        System.out.println(count);
        // 两数之和
        int[] index = twoSum(new int[]{1, 2, 4, 7, 15}, 9);
        System.out.println(index[0] + "\t" + index[1]);
        // 判断一数是否为另外两个数的平方和
        int[] index2 = judgeSquareSum(17);
        System.out.println(index2[0] + "\t" + index2[1]);

    }

    /**
     * 对碰指针
     */
    static void test() {

        int[] array = new int[5];
        int i = 0;
        int j = array.length - 1;
        // odd = length / 2 + 1  &  even = length / 2
        int c = 0;

        /**
         *  Why: 1 <= j
         *
         *  假设:
         *      1) [0 - 2]: 0/2 - 1/1 (if i<j, 那么1索引上的数据不会被执行到)
         *      2) [0 - 3]: 0/3 - 1/2
         */
        for (; i <= j; ) {
            i++;

            c++;

            j--;
        }
        System.out.println(c);
    }

    /**
     * 救生艇问题
     * @param weightArray
     * @param limit
     */
    static int doublePointerPractice(int[] weightArray, int limit) {
        Arrays.sort(weightArray);
        int i = 0;
        int j = weightArray.length - 1;
        int count = 0;
        while (i <= j) {
            if (weightArray[i] + weightArray[j] <= limit) {
                i++;
                j--;
            } else {
                // 必须保证最大的通过. 为什么不是最小的? 因最小的可能与其他不是最大组成一对通过.
                j--;
            }
            count++;
        }
        return count;
    }

    /**
     * 求两个加数的索引
     * @param numbers
     * @param target
     * @return
     */
    static int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        // 加数必须为两个, 所以当i == j时的情况是不考虑的
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                index[0] = i;
                index[1] = j;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return index;
    }

    /**
     * 判断一数是否为另外两个数的平方和
     * @param n
     * @return
     */
    static int[] judgeSquareSum(int n) {
        int[] number = new int[2];
        int i = 0;
        int squareRoot = (int) Math.sqrt(n);
        while (i < squareRoot) {
            int t = i * i + squareRoot * squareRoot;
            if (t == n) {
                number[0] = i;
                number[1] = squareRoot;
                break;
            } else if (t > n) {
                squareRoot--;
            } else {
                i++;
            }
        }
        return number;
    }

}