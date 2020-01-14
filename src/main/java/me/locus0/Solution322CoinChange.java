package me.locus0;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * Created on 2020/1/14.
 *
 * @author LingChuan
 */
public class Solution322CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] solvesCache = new int[amount + 1];
        return cachedChange(solvesCache, coins, amount);
    }

    private int cachedChange(int[] solvesCache, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int ret = solvesCache[amount];
        if (ret != 0) {
            return ret;
        }
        int minChange = Integer.MAX_VALUE;
        for (int coin : coins) {
            int leftAmount = amount - coin;
            if (leftAmount > 0) {
                int leftCoinNum = cachedChange(solvesCache, coins, leftAmount);
                if (leftCoinNum > 0) {
                    minChange = Math.min(minChange, leftCoinNum);
                }
            } else if (leftAmount == 0) {
                return 1;
            } else {
                break;
            }
        }
        ret = minChange == Integer.MAX_VALUE ? -1 : minChange + 1;
        solvesCache[amount] = ret;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution322CoinChange().coinChange(new int[] { 1, 2, 5 }, 11));
    }
}
