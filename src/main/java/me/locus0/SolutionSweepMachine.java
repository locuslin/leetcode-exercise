package me.locus0;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.HashSet;
import java.util.Set;

/**
 * DFS 深度优先算法
 * https://zhuanlan.zhihu.com/p/70580961
 * Created on 2020/1/14.
 *
 * @author LingChuan
 */
public class SolutionSweepMachine {

    public int getMoveWays(int step) {
        Set<Point> routes = new HashSet<>(step);
        Point start = new Point();
        routes.add(start);
        return move(routes, start, step);
    }

    private int move(Set<Point> routes, Point current, int step) {
        int routesNum = 0;
        Point next;
        for (int direction = 0; direction < 4; direction++) {
            switch (direction) {
            //向上移动
            case 0:
                next = current.withY(current.y - 1);
                break;
            case 1:
                next = current.withX(current.x + 1);
                break;
            case 2:
                next = current.withY(current.y + 1);
                break;
            case 3:
                next = current.withX(current.x - 1);
                break;
            default:
                throw new IllegalArgumentException();
            }
            if (routes.contains(next)) {
                continue;
            }
            int num = 0;
            try {
                routes.add(next);
                if (routes.size() <= step) {
                    num = move(routes, next, step);
                } else {
                    num = 1;
                }
                routesNum += num;
            } finally {
                routes.remove(next);
            }
        }

        return routesNum;
    }

    @Data
    @AllArgsConstructor
    @With
    @NoArgsConstructor
    private static class Point implements Cloneable {

        private int x;

        private int y;

        boolean isValid() {
            return x >= 0 && y >= 0;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            System.out.println(new SolutionSweepMachine().getMoveWays(i));
        }
        System.out.println(new SolutionSweepMachine().getMoveWays(2));

    }
}
