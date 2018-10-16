package Pareto;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sort points by x coordinate.The time complexity of sort is O(nlogn).
 * pick the largest one, remove all points with y <= y(Xmax).
 * repeat until list is empty.
 * Then pick h times a point and scan the remaining items,
 * so it's something like O(nh/2)+O(nlogn), which is approaching to O(nh) if nlogn grows slower than nh.
 */

public class nh {
    public static java.util.List<Point> compute(java.util.List<Point> points){

        //sort points by xValue Descending, take O(nlogn)
        List<Point> x = new ArrayList<>(points);
        x.sort(Comparator.comparing(Point::getX).reversed());

        //remove all points with y <= y(Xmax), take O(nh/2)
        for(int i=1; i<x.size() ; i++){
            if (x.get(i).getY() < x.get(i-1).getY()){
                x.remove(i);
            }
        }

        //output pareto points
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
