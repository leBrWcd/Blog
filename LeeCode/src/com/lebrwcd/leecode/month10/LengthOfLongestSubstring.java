package com.lebrwcd.leecode.month10;


import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 */
public class LengthOfLongestSubstring {

    /**
     * 因为我们已经保证了当前区间没有重复值，当右指针右移一个位置，只需要遍历区间，找出其中与右指针当前元素相同的元素即可(最多1个）。
     * 如果存在，这个元素以及其左侧的元素都可以舍弃掉， 左指针 = 相同元素位置+1。
     *
     * 时间复杂度O(N*∣Σ∣)。因为不重复子串区间长度不会超过ASCII 码字符集的长度∣Σ∣=128，当N足够大时，时间复杂度接近O(N)。
     *
     * 空间复杂度O(1)。跟官方解法相比，这个解法省去了哈希表占用的空间。
     * @param str
     * @return
     */
    private static int getLengthOfLongestSubStr2(String str) {
        int left = 0,result = 0,max = 0;
        for (int right = 0; right < str.length(); right++) {
            for (int k = left; k < right; k++) {
                if (str.charAt(k) == str.charAt(right)) {
                    left = k + 1;
                    result = right - left;
                    break;
                }
            }
            result++;
            if (max < result) max = result;
        }
        return max;
    }

    /**
     * 滑动窗口做法：哈希表，双指针，官方运行时间：6ms
     *
     * @param str 字符串
     * @return 无重复子串长度
     */
    private static int getLengthOfLongestSubStr(String str) {
        int result = 0;
        char[] charArray = str.toCharArray();
        Set<Character> set = new HashSet<>();
        int length = str.length();
        for (int l = 0, r = 0; r < length; r++) { // l负责扩展左边界，r负责扩展右边界
            char rIndex = charArray[r];
            while (set.contains(rIndex)) {
                set.remove(charArray[l]); //set中有重复元素，则缩短左边界，同时从set集合删除元素
                l++;  // 左指针偏移
            }
            set.add(rIndex);  // 没有重复元素的话，需要添加到Set
            result = Math.max(result, r - l + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        String str = "abcabcbb";
        long start = System.currentTimeMillis();
        int length = getLengthOfLongestSubStr(str);
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
        System.out.println("无重复字符的最长字串的长度：" + length);
    }

    /**
     *  * 以 (a)bcabcbb 开始的最长字符串为 (abc)abcbb；
     *  * 以 a(b)cabcbb 开始的最长字符串为 a(bca)bcbb；
     *  * 以 ab(c)abcbb 开始的最长字符串为 ab(cab)cbb；
     *  * 以 abc(a)bcbb 开始的最长字符串为 abc(abc)bb；
     *  * 以 abca(b)cbb 开始的最长字符串为 abca(bc)bb；
     *  * 以 abcab(c)bb 开始的最长字符串为 abcab(cb)b；
     *  * 以 abcabc(b)b 开始的最长字符串为 abcabc(b)b；
     *  * 以 abcabcb(b) 开始的最长字符串为 abcabcb(b)
     *
     *  滑动窗口：
     *  双层循环，外层循环左指针，负责扩展左边界，内层循环右指针，负责扩展右边界
     *  for r=0  l=0
     *   lr
     *  (a)bcabcbb         set:[a]
     *
     *  for r=1  l=0
     *  l  r
     *  (a)bcabcbb         set:[a,b]
     *
     *  for r=2  l=0
     *  l   r
     *  (a)bcabcbb         set:[a,b,c]    max = 3
     *
     *  for r=3  l=0
     *   l   r
     *  (a)bcabcbb  r上的值存在于set  set:[a,b,c] l向右偏移，去除l上的值 [b,c],增加新的 -->set : [b,c,a]
     *
     *  for r=4  l=1
     *    l   r
     *  a(b)cabcbb  r上的值存在于set  set:[b,c,a] l向右偏移,去除l上的值 [c,a] 增加新的 -->set : [c,a,b]
     *
     *  for r=5  l=2
     *     l   r
     *  ab(c)abcbb  r上的值存在于set  set:[c,a,b] l向右偏移,去除l上的值 [a,b] 增加新的-->set : [a,b,c]
     *
     *  for r=6  l=3
     *      l   r
     *  abc(a)bcbb  r上的值存在于set  set:[a,b,c] l向右偏移,去除l上的值 [b,c]
     *  for r=6  l=4
     *       l  r
     *  abca(b)cbb  r上的值存在于set  set:[b,c] l向右偏移，去除l上的值 [c],增加新的-->set : [c,b]
     *
     *  for r=7  l=5
     *        l  r
     *  abcab(c)bb  r上的值存在于set  set:[c,b] l向右偏移,去除l上的值 [b],
     *  for r=7  l=6
     *         l r
     *  abcabc(b)b  r上的值存在于set  set:[b] l向右偏移,去除l上的值 []，增加新的 -->set :[b]
     *
     *  for r=7  l=7
     *          lr
     *  abcabcb(b)  r上的值存在于set  set:[b] 去除l上的值 [],增加新-->set:[b]
     *
     *  循环结束
     */
}
