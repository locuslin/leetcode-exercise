package me.locus0;

import java.util.Random;

/**
 * Created on 2022/3/25/025.
 *
 * @author LingChuan
 */
public class WeightedRandom {

    static class Solution {
        int[] preSum;

        public Solution(int[] w) {
            preSum = new int[w.length];
            preSum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                preSum[i] = preSum[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            int max = preSum[preSum.length - 1];
            //TODO 待验证
            //加1 是为了避免出现0 即 Wa = 0 表示不可能被选中，random 也必须大于0，避免出现0
            int random = new Random().nextInt(max)+1;
            //search random
            int low = 0;
            int high = preSum.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (random >= preSum[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {
        var s = new Solution(new int[] { 1, 9 });
        for (int i = 0; i < 20; i++) {
            System.out.println(s.pickIndex());
        }
    }
}
