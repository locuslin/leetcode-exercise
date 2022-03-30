package me.locus0;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * FIXME 错误解答，未修正
 * Created on 2022/3/29/029.
 *
 * @author LingChuan
 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {
        NavigableMap<Character, Integer> dict = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            dict.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length() && !dict.isEmpty(); i++) {
            Character c = s.charAt(i);

            Integer count = dict.get(c);
            if (count != null) {
                Character lower = dict.lowerKey(c);
                if (lower == null) {
                    builder.append(c);
                    dict.remove(c);
                    //减1 若为0 移除
                } else if (count == 1) {
                    builder.append(c);
                    dict.remove(c);
                }
            }
            //减1 若为0 移除
            dict.computeIfPresent(c, (k, v) -> v - 1 == 0 ? null : v - 1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        args = new String[] { "cbacdcbc", "abccaadb", "bcadacb" };
        for (String arg : args) {
            System.out.println(new Solution316().removeDuplicateLetters(arg));

        }

    }
}
