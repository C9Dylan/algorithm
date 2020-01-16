package complexity.space_complexity;

/**
 * Created by Kim QQ.Cong on 2019-11-26 / 16:16
 *
 * @author: CongQingquan
 * @Description: 空间复杂度
 */
public class Test {

    public static void main(String[] args) {
        /**
         * S(n) = O(g(n))
         *
         * ExampleCode1: 与执行语句无关, 临时变量为5即常数级, 继而S(n) = O(1)
         */
        spaceComplexity1();

        /**
         * ExampleCode2: 每次递归执行都会创建一个局部变量n, 且递归深度为n, 则S(n) = O(n)
         */
        recursion(10);
    }

    private static int spaceComplexity1() {
        int n = 10;
        int i = 0, j = 0, k = 0;
        int count = 0;
        for (; i < n; i++) {
            for (; j < i; i++) {
                for (; k < j; i++) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int recursion(int n) {
        if (n == 1) {
            return n;
        }
        return recursion(n - 1) + n;
    }
}