package datastructure.stack_deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Kim QQ.Cong on 2019-11-26 / 19:35
 *
 * @author: CongQingquan
 * @Description: Stack / Deque / Queue
 */
public class Test {

    /**
     * 栈与队列的概念: 无路是队列还是栈, 本质上都是线性表. 只是操作不一样.
     *
     * 队列: 先进先出 -> FIFO(First in, first out)
     * 栈: 先进后出 -> FILO(First in, last out)
     */

    /**
     * Queue
     *
     * 增
     * push == addFirst
     * offer == offerLast == add == addLast
     *
     * 查
     * poll == pollFirst -> 队列首部出(默认移除元素)
     * pollLast -> 队列尾部出(默认移除元素)
     *
     * peek == peekFirst -> 队列首部出, 但是不移除元素
     * peekLast == peekFirst -> 队列尾部出, 但是不移除元素
     */

    /**
     * Stack | Deque(双端队列在使用中一般作为栈使用)
     *
     * push: 头加
     * pop: 头出
     */

    public static void main(String[] args) {
        toBinary(10);
    }

    /**
     * 计算二进制
     * @param n
     * @return
     */
    private static Deque toBinary(int n) {
        Deque<Integer> deque = new LinkedList<>();
        do {
            deque.push(n % 2);
            n /= 2;
        } while (n > 0);
        return deque;
    }
}