package me.locus0;

/**
 * Created on 2022/3/16/016.
 *
 * @author LingChuan
 */
public class SimpleTest {
    public static void main(String[] args) {
        char[] nums = { '0', '0', '0', '0' };
        for (int j = 0; j < 2 * nums.length; j++) {
            char c = nums[j / 2];
            System.out.println(c);
        }
    }
}
