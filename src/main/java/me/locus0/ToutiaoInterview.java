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

    public int getDecodeMethodsNum(String s) {

        // f(s) = f(s的子串)+1当前子串

        //第一步 列举当前子串的取法
        // 要么取一个当做子串 要么取两个当子串

        return 0;
    }
}
