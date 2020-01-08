package me.locus0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ans(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void ans(int[] candidates, int target, int index, ArrayList<Integer> answer, List<List<Integer>> answers) {
        for (int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                ArrayList<Integer> currentAnswer = (ArrayList) answer.clone();
                currentAnswer.add(candidates[i]);
                if (newTarget == 0) {
                    answers.add(currentAnswer);
                } else {
                    ans(candidates, target - candidates[i], i, currentAnswer, answers);
                }
            } else {
                break;
            }
        }
    }

}
