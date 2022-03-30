package me.locus0;

import java.util.Arrays;
import java.util.Random;

/**
 * Created on 2022/3/30/030.
 *
 * @author LingChuan
 */
public class Solution710 {

    private int num;
    private int[] blacklist;

    private Random random;

    public Solution710(int n, int[] blacklist) {
        this.blacklist = blacklist;
        Arrays.sort(blacklist);
        this.num = n - blacklist.length;
        this.random = new Random();
    }

    public int pick() {
        int index = random.nextInt(num);
        //查找最接近index的黑名单中的数字，判断其删除了k个数，结果就为 index+k
        int left = 0;
        int right = blacklist.length;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (blacklist[mid] == index) {
                right = mid;
            } else if (blacklist[mid] < index) {
                left = mid + 1;
            } else if (blacklist[mid] > index) {
                right = mid;
            }
        }
        return index + mid + 1;
    }

    // 搜索左侧边界的二分搜索
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var s = new Solution710(7, new int[] { 2, 3, 5 });

        for (int i = 0; i < 12; i++) {
            System.out.println(s.pick());
        }
    }
}
