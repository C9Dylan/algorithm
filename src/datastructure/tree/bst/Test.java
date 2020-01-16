package datastructure.tree.bst;

/**
 * Created by Kim QQ.Cong on 2019-11-28 / 21:08
 *
 * @author: CongQingquan
 * @Description: Binary search/sort tree 二分查找/排序树
 */
public class Test {
    /**
     * 二叉搜索/排序树(Binary search/sort tree):
     *
     *      有顺序的存储. 若中序遍历则是一个有序列表. 且因为这种存储规则, 大大提高了查询速度. 因为每次对某个结点比较后,
     *      与比较结点的值不等于的情况下, 要么继续和该节点的左子树继续比较, 要么和右子树比较. 每次比较后都会过滤一半
     *      的比较结点, 与二分查找相似. 查询速度为0(log2n)
     *
     *      但是如果结点数据的分布是不均衡的, 比如添加一组数据: 1, 2, 3, 4, 5. 会造成没有左子树, 反而是以一条斜线
     *      的形式存储, 元素都存储在右子树上. 那么只考虑最极端的情况下, 查询5. 那么就需要查询5次.
     *      查询速度从O(log2n)降低到了O(n).
     */
}