package Pareto;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class n {
    public static List<Point> compute(java.util.List<Point> points){//points is sorted by xValue

        //output pareto points, take O(n)
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
