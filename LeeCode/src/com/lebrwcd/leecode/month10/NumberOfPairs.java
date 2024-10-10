package com.lebrwcd.leecode.month10;

import java.util.HashMap;

/**
 *  3162. 优质数对的总数 I
 *
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 * 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
 * 返回 优质数对 的总数。
 *
 *
 * 示例 1：
 * 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1
 * 输出：5
 * 解释：
 * 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。
 *
 * 示例 2：
 * 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
 * 输出：2
 * 解释：
 * 2个优质数对分别是 (3, 0) 和 (3, 1)。
 *
 *提示：
 *
 * 1 <= n, m <= 50
 * 1 <= nums1[i], nums2[j] <= 50
 * 1 <= k <= 50
 */
public class NumberOfPairs {

    /**
     * 获取优质数对数量 -- 自己写的 耗时21ms，不太行
     * @param nums1
     * @param nums2
     * @param k
     * @return
     * @throws Exception
     */
    public static int getHighQualityPairs(int[] nums1,int[] nums2,int k) throws Exception {
        int result = 0; // 记录优质数对的数量
        int nLength = nums1.length;
        int mLength = nums2.length;
        if (nLength < 1 || mLength > 50) {
            System.out.println("请检查输入的参数");
            throw new Exception("nums1的长度必须大于1，nums2的长度必须小于等于50");
        }
        if (k < 1 || k > 50) {
            throw new Exception("k的范围为[1,50]");
        }
        // 处理逻辑 -- 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）
        for (int i = 0; i < nLength; i++) {
            for (int j = 0; j < mLength; j++) {
                if (nums1[i] % (nums2[j]*k) == 0) {
                    result++;
                    // 记录优质数对
                    System.out.println("优质数对---->" + "(" + i + "," + j + ")");
                }
            }
        }
        return result;
    }

    /**
     * 采用哈希，耗时7ms,牛
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        // 统计 nums2 中每个元素出现的频率
        for (int num2 : nums2) {
            hash2.put(num2, hash2.getOrDefault(num2, 0) + 1);
        }
        int ans = 0;

        // 遍历 nums1 中的每个元素
        for (int num1 : nums1) {
            // 只有当 num1 可以被 k 整除时，才有可能找到合适的配对
            if (num1 % k == 0) {
                int num = num1 / k; // 计算 num1 除以 k 的结果
                // 遍历 num 的所有因数，只需遍历到 sqrt(num)
                for (int divisor = 1; divisor * divisor <= num; ++divisor) {
                    // 如果 divisor 是 num 的因数
                    if (num % divisor == 0) {
                        // 检查 hash2 中是否有 divisor 出现的次数
                        if (hash2.containsKey(divisor)) {
                            ans += hash2.get(divisor);
                        }
                        // 如果 divisor 不是 num 的平方根，则检查 num / divisor
                        if (divisor != num / divisor && hash2.containsKey(num / divisor)) {
                            ans += hash2.get(num / divisor);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2,4,12,24,48};
        int[] nums2 = new int[]{2,4,6,7,8};
        int k = 1;
        int highQualityPairs = 0;
        try {
            long start = System.currentTimeMillis();
            System.out.println("方法开始执行----start" + start);
            highQualityPairs = getHighQualityPairs(nums1, nums2, k);
            //highQualityPairs = numberOfPairs(nums1,nums2,k);
            System.out.println("优质数对的数量--->" + highQualityPairs);
            long end = System.currentTimeMillis();
            System.out.println("方法结束执行----end" + end);
            System.out.println("耗时:" + (end-start) + "ms");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
