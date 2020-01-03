package me.locus0;

/**
 * Created on 2020/1/3.
 *
 * @author LingChuan
 * @see <a href="https://www.zhihu.com/question/23995189">动态规划</a>
 */
public class DpDemo {

    public int getMinPieceOfMoney(int money, int[] factors) {
        int nextMinPieceNum = Integer.MAX_VALUE;
        for (int factor : factors) {
            int nextPieceNum = getMinPieceOfMoney(money - factor, factors);
            nextMinPieceNum = Math.min(nextPieceNum, nextMinPieceNum);
        }
        return 1 + nextMinPieceNum;
    }

}
