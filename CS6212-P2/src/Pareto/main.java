package Pareto;

import java.awt.*;
import java.util.*;
import java.util.List;

public class main {
    public static void main(String args[]){
        //generate points
        List<Point> points = new ArrayList();
        int n = 20;//The number of points
        for(int i=0; i<n; i++){
            int x = (int) (Math.random()*1000);
            int y = (int) (Math.random()*1000);
            Point d = new Point(x, y);
            points.add(d);
        }

        for(Point e : points){
            System.out.println(e);
        }

        long startTime = System.currentTimeMillis();
        List<Point> problemb = Pareto.nlogn.compute(points);
        System.out.println("\nPareto-optimal points: ");
        long endTime = System.currentTimeMillis();
        for(Point e : problemb) {
            System.out.println(e);
        }
        System.out.println("\nThe number of Pareto-optimal points is : " + problemb.size());
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }


}
