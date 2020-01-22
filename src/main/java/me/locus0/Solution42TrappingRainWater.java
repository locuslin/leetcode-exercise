package me.locus0;

/**
 * Created on 2020/1/8.
 *
 * @author LingChuan
 */
public class Solution42TrappingRainWater {

    public int trap(int[] height) {
        //只有两个局部极大值之间才能接住雨水
        //故题目简化为寻找局部极大值以及计算两者之间各列高度与较低的极大值差的和，即为雨水的量

        int firstPeak = -1;

        int firstPeakIndex = -1;

        //走势 是否下降 ，数学上通常意义上来，就是导数的符号
        // 两个极大值之间
        boolean isDescend = false;

        //导数
        int derivative = 0;

        int pre = 0;
        int secondPeak = 0;
        int secondPeakIndex = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if (h == pre) {
                derivative = 0;
            } else if (h > pre) {
                derivative = 1;
            } else {
                derivative = -1;
            }

            //导数小于等于0时，出现极大值
            if (derivative <= 0) {

            }

            pre = h;
        }

        return 0;
    }
}
