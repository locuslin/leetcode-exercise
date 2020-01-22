package me.locus0;

import java.util.Arrays;

/**
 * Created on 2020/1/15.
 *
 * @author LingChuan
 */
public class Solution300LIS {

    int[] max;

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        max = new int[nums.length];
        try {
            return length(nums, nums.length - 1);
        } finally {
            System.out.println(Arrays.toString(max));
        }
    }

    public int length(int[] nums, int index) {
        if (index == 0) {
            return 1;
        } else {
            if (max[index] != 0) {
                return max[index];
            }
            int length = 1;
            int num = nums[index];
            for (int i = 0; i < index; i++) {
                int preLength = length(nums, i);
                if (num > nums[i]) {
                    length = Math.max(length, preLength + 1);
                }
            }
            max[index] = length;
            System.out.println("cached [" + index + "]," + max[index]);
            return length;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution300LIS().lengthOfLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
    }
}
