package complexity.time_complexity;

/**
 * Created by Kim QQ.Cong on 2019-11-26 / 14:28
 *
 * @author: CongQingquan
 * @Description: 时间复杂度
 */
public class Test {

    public static void main(String[] args) {
        timeComplexity();
    }

    private static void timeComplexity() {
        /**
         * T: 时间
         * n: 问题规模
         *
         * Time Complexity: T(n) = O(f(n))
         */

        /**
         * 1. 常数阶: T(n) = O(1)
         *
         * Example code:
         * int count = 1;
         */

        /**
         * 2. 对数阶: T(n) = O(log n)
         *
         * Example code:
         * for (int i = 1, n = 10; i <= n; i *= 2) {}
         */

        /**
         * 3. 线性阶: T(n) = O(n)
         *
         * Example code:
         * for(int i = 0, n = 10; i < n; i++) {}
         */

        /**
         * 4. 线性对数阶: T(n) = O(n * log n)
         *
         * for (int j = 1, n = 10; j <= n; j *= 2) // 1 2 4 8 -> 2^1 2^2 2^3 -> log n
         *    for(int i = 1; i <= n; i++) // n
         */

        /**
         * 5. 平方阶: T(n) = O(n^2)
         *
         * Example Code1:
         * for (int j = 0, n = 10; j < n; j++)
         *    for (int i = 0; i < n; i++)
         *
         * Example Code2:
         * for (int j = 0, n = 10; j < n; j++)
         *    for (int i = 0; i < j; i++)
         *
         * 1 2 3 4 ... n = (1 + n) * n / 2 = n + n^2 / 2
         * 去除常数项、低阶项、首项常数, 即T(n) = O(n^2)
         */

        /**
         * 6. 指数阶: T(n) = O(2^n)
         */

        /**
         * 7. 阶乘阶: T(n) = 0(n!)
         */
    }
}