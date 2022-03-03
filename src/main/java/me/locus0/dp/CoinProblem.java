package me.locus0.dp;

import java.util.List;

/**
 * Created on 2022/2/28/028.
 *
 * @author LingChuan
 */
public class CoinProblem {

    public int getChangeMoneyMethodNumber(int money, List<Integer> coins) {
        int[] dp = new int[money];
        for (int i = 0; i < money; i++) {
            int num = Integer.MAX_VALUE;
            for (Integer coin : coins) {
                //有问题，参见leetCode的解法
                num = Math.min(num, cal(money - coin, coins, dp) + 1);
            }
            dp[money] = num;
        }
        return cal(money, coins, dp);
    }

    private int cal(int money, List<Integer> coins, int[] dp) {
        if (money < 0) {
            return -1;
        }
        if (money == 0) {
            return 0;
        }
        if (dp[money] != 0) {
            return dp[money];
        }

        return 0;
    }
}
