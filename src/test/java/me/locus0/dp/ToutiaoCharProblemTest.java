package me.locus0.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created on 2022/3/2/002.
 *
 * @author LingChuan
 */
public class ToutiaoCharProblemTest {
    ToutiaoCharProblem toutiaoCharProblem;

    @Test
    public void decodeNum() {
        toutiaoCharProblem = new ToutiaoCharProblem();
        int ans = toutiaoCharProblem.decodeNum("123");
        Assert.assertEquals(3,ans);
    }
}