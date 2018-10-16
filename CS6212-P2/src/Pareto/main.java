package Pareto;

import java.awt.*;
import java.util.*;
import java.util.List;

public class main {
    public static void main(String args[]){
        long start = System.currentTimeMillis();

        //generate points
        List<Point> points = new ArrayList();
        int n = 20;//The number of points
        for(int i=0; i<n; i++){
            int x = (int) (Math.random()*1000);
            int y = (int) (Math.random()*1000);
            Point d = new Point(x, y);
            points.add(d);
        }

        //print point
        for(Point e : points){
            System.out.println(e);
        }



        List<Point> problemc = Pareto.nlogh.compute(points);
        System.out.println("\nPareto-optimal points: ");
        for(Point e : problemc) {
            System.out.println(e);
        }
        System.out.println("\nThe number of Pareto-optimal points is : " + problemc.size());

        long end = System.currentTimeMillis();
        System.out.println("use " + (end - start) + " times");
    }


}
