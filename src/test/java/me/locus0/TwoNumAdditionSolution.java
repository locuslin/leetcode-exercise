package me.locus0;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2019/10/24.
 *
 * @author LingChuan
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">2. 两数相加</a>
 */
public class TwoNumAdditionSolution {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListNode {
        ListNode(ListNode other) {
            this.val = other.val;
            this.next = other.next;
        }

        private int val;
        ListNode next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return nodeAdd(l1, l2, 0);
    }

    private ListNode nodeAdd(ListNode node1, ListNode node2, int addition) {
        if (node1 != null && node2 != null) {
            ListNode sum = new ListNode();
            sum.val = node1.val + node2.val + addition;
            //进位操作
            int nextAddition = 0;
            if (sum.val >= 10) {
                sum.val -= 10;
                nextAddition = 1;
            }
            sum.next = nodeAdd(node1.next, node2.next, nextAddition);
            return sum;
        } else if (node1 == null && node2 == null) {
            return addition == 0 ? null : new ListNode(1, null);
        } else {
            ListNode sum = new ListNode(node1 == null ? node2 : node1);
            sum.val += addition;
            return sum;
        }
    }
}
