package me.locus0;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 * Created on 2020/1/8.
 *
 * @author LingChuan
 */
public class Solution41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        int ans = 1;
        //标记是否包含1，若包含1，则需要动用从小往大的策略
        //否则的话,答案直接为1
        boolean hasOne = false;

        //当包含1 时，只要从小到大遍历第一个缺失的数字即可，
        //特别的，一个极限情况，答案的最大值就是长度为n的数组整个都是连续的，那么答案就是n+1
        //即，所有可能的答案都是在n范围以内，故而可以讲数值与数组下标联系起来，从小到大排列，当第一个不是联系的数值出现时，就可以判断为正确答案

        for (int num : nums) {
            if (num == 1) {
                hasOne = true;
                break;
            }
        }

        if (!hasOne) {
            return 1;
        }

        /*
        自己的算法实现有问题，杂糅了
        原来题解太过精妙，头大
        其实涉及到信息压缩的问题，用原来所在num[i]位的正负号来代表存在不存在，表达了两种信息，
        既保留了原来的数值，也表达了是否存在这个信息
         */
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num >= nums.length) {
                nums[i] = 1;
            } else {
                nums[num] = -Math.abs(nums[num]);
            }
        }

        return ans;
    }
}
