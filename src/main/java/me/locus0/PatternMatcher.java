package me.locus0;

import java.util.HashMap;
import java.util.Map;

/**
 * 有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”， 要求输入一个匹配模式（简单的以字符来写）， 比如 aabb, 来判断该字符串是否符合该模式， 举个例子：
 * 1. pattern = "abba", str="北京 杭州 杭州 北京" 返回 ture
 * 2. pattern = "aabb", str="北京 杭州 杭州 北京" 返回 false
 * 3. pattern = "baab", str="北京 杭州 杭州 北京" 返回 ture
 *
 * NOTE.
 * 思路为将各自的字符a 或者 北京 转化为统一的值
 * 即使用map做映射。
 * 为了将不同的字符转化为统一的值，使用计数器，第一次出现的字符计数器+1，使用该值代表字符或字符串。
 * 最终pattern跟str的值相等
 * Created on 2022/3/31/031.
 *
 * @author LingChuan
 */
public class PatternMatcher {

    private static final char SEPARATOR = ' ';

    public static boolean isMatchPattern(String toMatch, String pattern) {
        String[] toMatchStrs = toMatch.split(String.valueOf(SEPARATOR));
        if (pattern.length() != toMatchStrs.length) {
            return false;
        }

        int patternNumCount = 0;
        int toMatchStrNumCount = 0;
        Map<Character, Integer> patterns = new HashMap<>();
        Map<String, Integer> toMatchDict = new HashMap<>();
        for (int i = 0; i < toMatchStrs.length; i++) {
            char c = pattern.charAt(i);
            Integer value = patterns.get(c);
            if (value == null) {
                value = ++patternNumCount;
                patterns.put(c, value);
            }
            String str = toMatchStrs[i];
            Integer strValue = toMatchDict.get(str);
            if (strValue == null) {
                strValue = ++toMatchStrNumCount;
                toMatchDict.put(str, strValue);
            }
            if (!value.equals(strValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param toMatch
     * @param pattern
     * @return
     */
    private static boolean beforeMatch(String toMatch, String pattern) {
        Map<Character, String> patternChar2Word = new HashMap<>(pattern.length());
        int wordCharIndex = 0;
        for (int patternCharIndex = 0, wordStartIndex = 0; patternCharIndex < pattern.length(); patternCharIndex++) {
            if (wordCharIndex >= toMatch.length()) {
                return false;
            }
            while (toMatch.charAt(wordCharIndex) != SEPARATOR) {
                if (++wordCharIndex == toMatch.length()) {
                    break;
                }
            }
            //不考虑存在多余空格的情况
            String word = toMatch.substring(wordStartIndex, wordCharIndex);
            wordStartIndex = wordCharIndex + 1;
            wordCharIndex = wordStartIndex;
            char patternChar = pattern.charAt(patternCharIndex);
            String mappedWord = patternChar2Word.get(patternChar);
            if (mappedWord != null) {
                if (!word.equals(mappedWord)) {
                    return false;
                }
            } else {
                patternChar2Word.put(patternChar, word);
            }
        }
        //在模式之外仍有多余的字符串
        if (wordCharIndex < toMatch.length() - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //        1. pattern = "abba", str="北京 杭州 杭州 北京" 返回 ture
        //        2. pattern = "aabb", str="北京 杭州 杭州 北京" 返回 false
        //        3. pattern = "baab", str="北京 杭州 杭州 北京" 返回 ture

        var ret = isMatchPattern("北京 杭州 杭州 北京", "abba");
        System.out.println(ret);
        ret = isMatchPattern("北京 杭州 杭州 北京", "aabb");
        System.out.println(ret);
        ret = isMatchPattern("北京 杭州 杭州 北京", "baab");
        System.out.println(ret);
        ret = isMatchPattern("北京 杭州 杭州 北京", "bcab");
        System.out.println(ret);

    }
}
