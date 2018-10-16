package Pareto;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Use divide and conquer strategy.
 * Find point P with max(y) where x >= (min(x) + max(x)) / 2. That is pareto point somewhere in the middle.
 * If we can find pareto point P which splits rest of pareto points in half's in O(n) than it can be done in O(n log(h)).
 * Splitting points in three parts: right of P, left and up of P, left and down of P. Third set doesn't have pareto points.
 * Recursively do same procedure on other two set of points. Set that three parts split points in ratio: a, b, 1 - a - b.
 * Time complexity is:
 *    T(n, h) = T(a*n, h/2) + T(b*n, h/2) + O(n)
 *       	 <= T(n, h/2) + O(n)
 *       	 <= T(n, h/4) + 2 * O(n)
 *       	 <= T(n, h/8) + 3 * O(n)
 *      	 <= ...
 *       	 <= O(n log(h))
 */
public class nlogh {
    public static java.util.List<Point> compute(java.util.List<Point> points){

        java.util.List<Point> x = new ArrayList<>(points);


        //output pareto points
        List<Point> poPoints  = new ArrayList<>();
        double currMaxY = -1;
        for (Point p: points) {
            if (p.getY() > currMaxY) {
                poPoints.add(p);
                currMaxY = p.getY();
            }
        }
        return poPoints;
    }
}
