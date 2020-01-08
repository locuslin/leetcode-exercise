package me.locus0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * Created on 2020/1/7.
 *
 * @author LingChuan
 */
public class Solution40CombinationSum2 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates, 0, target, new Stack<>());
        return ans;
    }

    private void solve(int[] candidates, int start, int target, Stack<Integer> answer) {
        long preCandidate = Long.MAX_VALUE;
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (preCandidate == candidate) {
                continue;
            }
            preCandidate = candidate;
            int newTarget = target - candidate;
            if (newTarget >= 0) {
                answer.push(candidate);
                if (newTarget == 0) {
                    ans.add((List<Integer>) answer.clone());
                } else {
                    solve(candidates, i + 1, newTarget, answer);
                }
                answer.pop();
            } else {
                break;
            }
        }
    }
}
