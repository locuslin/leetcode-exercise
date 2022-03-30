package me.locus0;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution76 {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        //用来存储匹配串的字符以及其频率
        HashMap<Character, Integer> need = new HashMap<>();
        int valid = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int l = 0, r = 0;
        while (right < s.length()) {
            char addingChar = s.charAt(right);
            if (need.containsKey(addingChar)) {
                int count = need.compute(addingChar, (k, v) -> v - 1);
                if (count == 0) {
                    valid++;
                }
            }
            // System.out.printf("right %d %s needed %s valid %d \r\n", right, addingChar, need.toString(), valid);
            while (valid == need.size()) {
                //左移
                int len = right - left + 1;
                if (len < minLen) {
                    l = left;
                    r = right;
                    minLen = len;
                    //  System.out.println("updated");
                }
                //  System.out.printf("cur %s len %d \r\n", s.substring(left, right + 1), len);
                char removingChar = s.charAt(left);
                if (need.containsKey(removingChar)) {
                    int count = need.compute(removingChar, (k, v) -> v + 1);
                    if (count == 1) {
                        valid--;
                    }
                }
                //  System.out.printf("left %d %s needed %s valid %d\r\n", left, removingChar, need.toString(), valid);
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        String ret = new Solution76().minWindow("ADOBECODEBANC", "ABC");
        System.out.println("ret " + ret);
    }
}