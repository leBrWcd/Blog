package com.lebrwcd.leecode.month10;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 3164. 优质数对的总数 II
 * <p></p>
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 * 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
 * 返回 优质数对 的总数。
 */
public class NumberOfPairsII {


    /**
     *  作者：灵茶山艾府
     *         链接：https://leetcode.cn/problems/find-the-number-of-good-pairs-ii/solutions/2790631/tong-ji-yin-zi-ge-shu-pythonjavacgo-by-e-bl3o/
     *         来源：力扣（LeetCode）
     *         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @param k
     * @return
     *     4    2*2
     *    a[0]  b[0]*k
     *    a[0]/k  b[0]
     *
     *
     *
     * 为方便描述，把 nums1和 nums2 记作 a 和 b。
     * a[i] 能被 b[j]⋅k 整除，等价于 a[i] 是 k 的倍数且a[i]/k能被 b[j] 整除,也就是说，a[i]/k有一个因子 d 等于 b[j]。
     * 算法
     * 1.遍历 a，枚举a[i]/k的所有因子，统计到哈希表 cnt 中。比如遍历完后 cnt[3]=5，说明有 5 个a[i]/k可以被 3 整除，等价于有 5 个 a[i] 可以被 3⋅k 整除。
     * 2.遍历 b，把 cnt[b[j]] 加入答案。例如 b[j]=3，那么就找到了 cnt[3] 个优质数对。
     */
    private static int numberOfParis(int[] nums1,int[] nums2,int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums1) {
            if (x % k != 0) { // 检查 x 是否可以被 k 整除。如果不能整除，则跳过这个元素。
                continue;
            }
            // 因数分解
            x /= k;       // 因子
            for (int d = 1; d * d <= x; d++) { // 枚举因子
                if (x % d > 0) {
                    continue;
                }
                // 如果d是x的因子，则添加到哈希表中
                cnt.merge(d, 1, Integer::sum); // cnt[d]++  添加枚举因子
                if (d * d < x) {    //确保不重复添加平方因子
                    cnt.merge(x / d, 1, Integer::sum); // cnt[x/d]++
                }
            }
        }

        int ans = 0;
        // 遍历 nums2 中的每个元素，使用 cnt.getOrDefault(x, 0) 来获取对应因子 x 在哈希表中的出现次数并累加到 ans 中。
        for (int x : nums2) {
            ans += cnt.getOrDefault(x, 0);
        }
        return ans; // 最终结果即为优质对数的数量
    }

    public static void main(String[] args) {

        int[] nums1 = new int[] {1,3,4};
        int[] nums2 = new int[] {1,3,4};
        int k = 1;
        int paris = numberOfParis(nums1, nums2, k);
        System.out.println("优质数对数量:" + paris);

    }

}
