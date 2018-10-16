package Pareto;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Sort the points by x-axis.
 * Consider the point with the largest x-value. Note down its y-value as the current highest y-value.
 * Go to the point with next lower x-value. If the y-value of this is greater than current best-value, then it is Pareto-optimal, otherwise it is not.
 * Iterating it for all the points.
 * Time complexity: O(n log n) for sorting by x, and O(n) for iterating the points after that.
 *
 */
public class nlogn {
    public static List<Point> compute(java.util.List<Point> points){//get input of points

        //sort points by xValue Descending, take O(nlogn)
        List<Point> x = new ArrayList<>(points);
        x.sort(Comparator.comparing(Point::getX).reversed());

        //output pareto points, take O(n)
        List<Point> poPoints  = new ArrayList<>();
        double currMaxY = -1;
        for (Point p: x) {
            if (p.getY() > currMaxY) {
                poPoints.add(p);
                currMaxY = p.getY();
            }
        }
        return poPoints;
    }

}
