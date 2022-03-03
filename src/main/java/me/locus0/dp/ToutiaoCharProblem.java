package me.locus0.dp;

/**
 * Decode
 * 有如下映射关系
 * 字符编码 A -1
 * ……
 * Z - 26
 * <p>
 * 对于给定数字，请解出有多少种解码方法
 * <p>
 * 如
 * 123->
 * a.1 23
 * b.1 2 3
 * c. 12 3
 * 三种解法
 * <p>
 * Created on 2022/3/2/002.
 * <p>
 * <p>
 * 思路：
 * <p>
 * 遵从f(s)=f(s-1)+f(s-2)
 * 关键就需判断 -1即取一位，-2 是否成立，即1个字符两个字符能否被解析。数值范围在1-26。
 * 可以注意到f(s-1)+f(s-2)会有较多相同子问题，注意备忘录，同时剪支即可。
 *
 * @author LingChuan
 */
public class ToutiaoCharProblem {
    public int decodeNum(String str) {
        if (str.length() == 0) {
            return 0;
        }
        //解法1，自底部向上 从字符串较少的情况出发
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        char[] chars = str.toCharArray();
        if (isSingleCharIllegal(chars[0])) {
            dp[1] = 1;
        } else {
            return 0;
        }
        for (int i = 2; i <= str.length(); i++) {
            char pre1 = chars[i - 1];
            char pre2 = chars[i - 2];
            if (isSingleCharIllegal(pre1)) {
                dp[i] += dp[i - 1];
            }
            if (isDoubleCharIllegal(pre2, pre1)) {
                dp[i] += dp[i - 2];
            }
            //若无解，则整个都无解，直接返回
            if (dp[i] == 0) {
                return 0;
            }
        }
        return dp[str.length()];
    }

    private boolean isSingleCharIllegal(char c) {
        return c >= '1' && c <= '9';
    }

    private boolean isDoubleCharIllegal(char first, char second) {
        if (first == '1') {
            return second >= '0' && second <= '9';
        } else if (first == '2') {
            return second >= '0' && second <= '6';
        }
        return false;
    }
}
