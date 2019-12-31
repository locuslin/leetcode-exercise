package me.locus0;

/**
 * N字形变换
 * <p>
 * 题目理解错误，无须输出中间空白部分
 * Created on 2019/12/31.
 *
 * @author LingChuan
 */
public class Solution6 {

    /**
     * 竖线策略
     */
    static final int STRATEGY_STRAIGHT_LINE = 1;

    /**
     * 对角线策略
     */
    static final int STRATEGY_LEAN_LINE = 2;

    /**
     * 考虑设计成二维数组，填充完成后，再拼接成字符串。
     * 左上角坐标为(0,0)
     * 首要问题是，行数一直，列数未知，需估计
     * 最保守的策略，row*column >= s.length ,即 column > length / row
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int numColumns = (int) Math.ceil(s.length() / (double) numRows);
        Character[][] chars = new Character[numColumns][numRows];
        StringBuilder builder = new StringBuilder(numRows * numColumns);

        //考虑行进策略
        //一共有两种策略，当y==0时，x不变，y++
        //当y==row时，y--,x++
        int x = 0;
        int y = 0;

        int strategy = STRATEGY_STRAIGHT_LINE;

        for (int i = 0; i < s.length(); i++) {
            chars[y][x] = s.charAt(i);
            //决定下个点的路线策略
            if (strategy == STRATEGY_STRAIGHT_LINE) {
                //判断是否达到底部边缘
                if (y == numRows - 1) {
                    strategy = STRATEGY_LEAN_LINE;
                }
            } else if (strategy == STRATEGY_LEAN_LINE) {
                //判断是否到达顶部边缘
                if (y == 0) {
                    strategy = STRATEGY_STRAIGHT_LINE;
                }
            }

            switch (strategy) {
            case STRATEGY_STRAIGHT_LINE:
                y++;
                break;
            case STRATEGY_LEAN_LINE:
                x++;
                y--;
                break;
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                Character c = chars[i][j];
                if (c != null) {
                    builder.append(c);
                }
            }
            builder.append(System.getProperty("line.separator"));
        }

        return builder.toString();
    }
}
