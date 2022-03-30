package me.locus0;

/**
 * Created on 2022/3/25/025.
 *
 * @author LingChuan
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        LinkedList<Integer> target = new LinkedList<>();
        for (int i : nums1) {
            target.add(i);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(nums2.length, (a, b) -> {
            if (b[1] == a[1]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });
        for (int i = 0; i < nums2.length; i++) {
            q.offer(new int[] { i, nums2[i] });
        }
        while (!q.isEmpty()) {
            int[] num2 = q.poll();
            if (target.getLast() > num2[1]) {
                nums1[num2[0]] = target.pollLast();
            } else {
                nums1[num2[0]] = target.pollFirst();
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] ret = new Solution870().advantageCount(new int[] { 12, 24, 8, 32 }, new int[] { 13, 25, 32, 11 });
        System.out.println(Arrays.toString(ret));
    }
}

//leetcode submit region end(Prohibit modification and deletion)