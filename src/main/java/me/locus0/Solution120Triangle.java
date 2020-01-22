package me.locus0;

import java.util.List;

/**
 * Created on 2020/1/19.
 *
 * @author LingChuan
 */
public class Solution120Triangle {

    int[][] minRouteCost;

    public int minimumTotal(List<List<Integer>> triangle) {

        minRouteCost = new int[triangle.size()][triangle.size()];

        for (int i = 0; i < triangle.size(); i++) {
            minRouteCost(triangle, i, triangle.size() - 1);
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            minCost = Math.min(minCost, minRouteCost[i][triangle.size() - 1]);
        }
        return minCost;
    }

    private int minRouteCost(List<List<Integer>> triangle, int x, int y) {
        if (y == 0) {
            return triangle.get(0).get(0);
        }

        return 0;
    }

    private Point findUpperNearByLeftPoint(int x,int y) {

        return null;
    }

    private static class Point{
        private  int x;

        private  int y;

    }

}
