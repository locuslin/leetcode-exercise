package me.locus0;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * Created on 2020/1/19.
 *
 * @author LingChuan
 */
public class Solution70 {

    /**
     * dp[n] = dp[n-1]+dp[n-2]
     *
     * @param n
     * @return
     */
    public int climbStairsRecursion(int n) {
        if (n >= 2) {
            return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
        } else {
            return 1;
        }
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
