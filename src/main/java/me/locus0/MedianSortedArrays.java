package me.locus0;

/**
 * Created on 2019/11/13.
 *
 * @author LingChuan
 * @see <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/>4.寻找两个有序数组的中位数</a>
 */
public class MedianSortedArrays {
    /**
     * 分为几种情况处理
     * 1. 两个数组数据没有交叉，则直接将两数组合并，直接处理
     * 2.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double medianOfA = 0;
        double medianOfB = 0;

        return (medianOfA + medianOfB) / 2.0;
    }

    private double median(int[] numsLow, int[] numsHigh) {
        int lowIndex = 0;
        int highIndex = numsHigh.length - 1;

        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;

        }

        return 0;
    }
}