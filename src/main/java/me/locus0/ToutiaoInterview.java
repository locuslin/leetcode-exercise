package me.locus0;

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
 * Created on 2020/1/3.
 *
 * @author LingChuan
 */
public class ToutiaoInterview {

    public int decodeNum(String s) {

        // f(s) = f(s-1)+f(s-2)
        // f 代表解法数量 -1 代表去除一个subString(1),-2 subString(2)

        //第一步 列举当前子串的取法
        // 要么取一个当做子串 要么取两个当子串

        //递归临界条件
        char firstC = s.charAt(0);
        if (firstC == '0') {
            return 0;
        }
        if (s.length() == 1) {
            //长度为1时 只要不是0 解法就为1
            return 1;
        } else if (s.length() == 2) {
            // 长度为2
            char secChar = s.charAt(1);
            if (firstC == '2') {
                if (secChar <= '6' && secChar > '0') {
                    return 2;
                } else {
                    return 1;
                }
            } else if (firstC == '1') {
                return 1 + decodeNum(s.substring(1));
            } else {
                //把首位去除之后，看末位是否能够满足
                return decodeNum(s.substring(1));
            }
        } else {
            return decodeNum(s.substring(0, 1)) * decodeNum(s.substring(1)) + decodeNum(s.substring(0, 2)) * decodeNum(
                    s.substring(2));
        }

    }

}
