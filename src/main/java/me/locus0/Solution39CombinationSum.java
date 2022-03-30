package me.locus0;

import java.util.*;

/**
 * Created on 2020/1/7.
 * <p>
 * //NOTE 这里的clone消耗太大了
 *
 * @author LingChuan
 */
public class Solution39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> track = new ArrayDeque<>();
        bp(ans, candidates, track, target, 0);
        return ans;
    }

    void bp(List<List<Integer>> ans, int[] candidates, Deque<Integer> track, int target, int index) {
        if (target == 0) {
            ans.add(Arrays.asList(track.toArray(new Integer[0])));
            return;
        } else if (target < 0) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                int rest = target - candidates[i];
                //做出选择
                track.add(candidates[i]);
                //进入下一层
                bp(ans, candidates, track, rest, i);
                //撤销选择
                track.removeLast();
            }
        }
    }

}
