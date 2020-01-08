package me.locus0;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 * Created on 2020/1/7.
 *
 * @author LingChuan
 */
public class Solution38CountAndSay {

    public String countAndSay(int n) {
        String pre = "1";
        for (int i = 1; i < n; i++) {
            char preChar = pre.charAt(0);
            int count = 1;
            StringBuilder builder = new StringBuilder();
            for (int j = 1; j < pre.length(); j++) {
                char c = pre.charAt(j);
                if (c == preChar) {
                    count++;
                } else {
                    builder.append(count).append(preChar);
                    preChar = c;
                    count = 1;
                }
            }
            builder.append(count).append(preChar);
            pre = builder.toString();
        }
        return pre;
    }

}
