package me.locus0;

/**
 * Created on 2019/12/31.
 *
 * @author LingChuan
 */
public class Solution7 {

    public int reverse(int x) {
        long revered = 0;
        //从低位开始
        while (x != 0) {
            revered = revered * 10 + x % 10;
            x = x / 10;
        }
        //判断是否溢出
        if (revered >= Integer.MIN_VALUE && revered <= Integer.MAX_VALUE) {
            return (int) revered;
        } else {
            return 0;
        }
    }
}
