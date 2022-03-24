package me.locus0;

import java.util.Map;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution76 {
    public String minWindow(String s, String t) {
        String window = "";
        int left = 0;
        int right = 0;

        String minContains = "";
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> needs = new HashMap<>(t.length());
        t.chars().forEach(c -> needs.compute((char) c, (k, v) -> v == null ? 1 : v + 1));
        Character curChar = s.charAt(0);
        boolean add = true;
        while (right < s.length()) {
            window = s.substring(left, right + 1);
            curChar = s.charAt(add ? right : left - 1);
            if (needs.containsKey(curChar)) {
                //若增加了包含的 字符串，需求数-1
                //若移动走了包含的字符串，需求数+1
                if (add) {
                    needs.compute(curChar, (k, v) -> v - 1);
                } else {
                    needs.compute(curChar, (k, v) -> v + 1);
                }
            }
            System.out.printf("window %s,cur %s left %d,right %d,needs %s \r\n", window, curChar.toString(), left,
                    right, needs.toString());
            //若所有的needs值<=0 怎表示找到了匹配的目标子串
            //等价命题为 不存在大于0 的need
            if (!needs.values().stream().filter(v -> v > 0).findAny().isPresent()) {
                //对比最小子串，看看是否是最小子串，并更新结果
                if (window.length() < minLength) {
                    minContains = window;
                    minLength = minContains.length();
                }
                //还可继续缩小窗口，则缩小窗口，只处理左边界，跳过右边界
                if (right - left >= t.length()) {
                    left++;
                    add = false;
                    continue;
                }
            }
            right++;
            add = true;
        }
        return minContains;
    }

    public static void main(String[] args) {
        new Solution76().minWindow("ab","b");
    }
}