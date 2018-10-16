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

        List<Point> set = new ArrayList<>();
        Point poPoints;

        if(points.size() < 1){
            return set;
        }
        if(points.size() == 1){
            set.addAll(points);
            return set;
        }

        /**
         * Find the x-median
         */
        double xMax = -1;
        double xMin = 2000;
        double xMid;
        for(int i = 0; i < points.size(); i++)
        {
            if(points.get(i).getX() >= xMax)
                xMax = points.get(i).getX();

            if(points.get(i).getX() <= xMin)
                xMin = points.get(i).getX();
        }
        xMid = (xMax + xMin)/2;


        /**
         * Find point P with max(y) where x >= xMid
         */
        poPoints = new Point(-1, -1);
        for(int i = 0; i < points.size(); i++)
        {
            double yMax = poPoints.getY();
            if(points.get(i).getX() >= xMid && points.get(i).getY() >= yMax){
                    poPoints = points.get(i);
            }
        }
        set.add(poPoints);

        /**
         * Divide
         * keep lef-top and right parts
         */
        List<Point> leftTop = new ArrayList<>();
        List<Point> right = new ArrayList<>();
        for(int j = 0; j < points.size(); j++)
        {
            if(points.get(j).getX() < poPoints.getX() && points.get(j).getY() > poPoints.getY())
                leftTop.add(points.get(j));
            else if(points.get(j).getX() > poPoints.getX())
                right.add(points.get(j));
        }

        //Conquer
        set.addAll(nlogh.compute(leftTop)); // left-top part
        set.addAll(nlogh.compute(right)); // right part

        //Merge
        return set;
    }
}
