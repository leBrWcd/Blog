package com.lebrwcd.leecode.month10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2. 两数相加
 * <p></p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * <p>
 * 提示：
 * 1、每个链表中的节点数在范围 [1, 100] 内
 * 2、0 <= Node.val <= 9
 * 3、题目数据保证列表表示的数字不含前导零
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class addTwoNumbers {

    /**
     * 官方题解思路：
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     *
     * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。具体而言，如果当前两个链表处相应位置的数字为 n1,n2，进位值为 carry，则它们的和为 n1+n2+carry；其中，答案链表处相应位置的数字为 (n1+n2+carry)mod10，而新的进位值为 ⌊(n1+n2+carry)/10⌋
     *          3 4 2
     *          4 6 5
     *进位     0 1 0 0
     * -----------------
     *          8 0 7
     *
     *  1. 2 + 5 + 0 = 7，不需进1，视为进0
     *  2. 7%10得到新节点元素为7
     *  3. 7/10 得到下一个进位为0
     *  4. 4 + 6 + 0 = 10，进1
     *  5. 10%10 得到新节点元素为0
     *  6. 10/10 得到下一个进位为1
     *  7. 3 + 4 + 1 = 8,不需进1，视为进0
     *  8. 8%10 得到下一个元素为8
     *  9. 8/10 得到下一个进位为0
     *
     *
     *          3 4 2
     *        9 8 6 5
     *      1 1 1 0 0       多出来1个进位，要放到最后1个节点
     * -----------------
     *      1 0 2 0 7
     */

    /**
     * 官方题解 - 进位
     * @param l1
     * @param l2
     * @return ListNode
     */
    private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        return addTwo(l1,l2,0);
    }

    /**
     * 递归调用
     * @param l1 链表1
     * @param l2 链表2
     * @param bit 进位
     * @return ListNode
     */
    private static ListNode addTwo(ListNode l1, ListNode l2, int bit) {
        if (l1 == null && l2 == null && bit == 0) { // 递归结束条件，bit=1的情况即为多计算出的进位1，需要加到最后的节点
            return null;
        }
        int val = bit;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;  // l1的值+l2的值+进位
            l2 = l2.next;   // 指向下一个节点，准备递归
        }
        ListNode node = new ListNode(val % 10);  // val%10的值作为当前节点的计算值
        node.next = addTwo(l1,l2,val/10);        //  val/10 的值为下一个进位，递归调用
        return node;
    }

    /**
     * 自己写的，思路是将链表中的值放到list，再将list求和，但是最终只通过789条测试用例
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = null;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ListNode tempNode = null;
        // 逆序的
        tempNode = l1;
        while (tempNode != null) {
            list1.add(tempNode.val);
            tempNode = tempNode.next;
        }
        Collections.reverse(list1);
        System.out.println(list1);

        tempNode = l2;
        while (tempNode != null) {
            list2.add(tempNode.val);
            tempNode = tempNode.next;
        }
        tempNode = null;
        Collections.reverse(list2);

        int l1Num = 0;
        // 将list转化为数字
        for (int i = 0; i < list1.size(); i++) {
            double pow = Math.pow(10, list1.size() - i - 1);
            double v = list1.get(i) * pow;
            l1Num += (int) v;
        }
        int l2Num = 0;
        for (int i = 0; i < list2.size(); i++) {
            double pow = Math.pow(10, list2.size() - i - 1);
            double v = list2.get(i) * pow;
            l2Num += (int) v;
        }

        Integer result = l1Num + l2Num;

        String strNum = Integer.toString(result);

        // 创建列表以存放转换后的数字
        List<Integer> res = new ArrayList<>();

        // 遍历字符串并将字符转换为整数
        for (int i = 0; i < strNum.length(); i++) {
            res.add(Character.getNumericValue(strNum.charAt(i)));
        }

        // 遍历集合并将数字添加到链表中
        Collections.reverse(res);
        ListNode head = null;
        ListNode current = null;
        for (Integer number : res) {
            ListNode newNode = new ListNode(number); // 创建新节点
            if (head == null) {
                head = newNode; // 如果链表为空，则将新节点作为头节点
                current = head; // 当前节点指向头节点
            } else {
                current.next = newNode; // 将当前节点的下一个节点指向新节点
                current = newNode; // 当前节点移动到新节点
            }
        }
        return head;
    }

    public static void printLinkedList(ListNode listNode) {
        ListNode current = listNode;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        //l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]


        ListNode listNode = addTwoNumbers1(l1, l2);
        printLinkedList(listNode);

    }
}

