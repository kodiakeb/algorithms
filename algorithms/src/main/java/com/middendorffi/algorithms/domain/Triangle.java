package com.middendorffi.algorithms.domain;

/**
 * Created by hdavis on 14/07/2017.
 */
public class Triangle {
    private Point v1;
    private Point v2;
    private Point v3;

    public Triangle(Point v1, Point v2, Point v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public boolean contains(Point point) {

        double area123 = area(v1,v2,v3);
        double areap12= area(point,v1,v2);
        double areap23 = area(point,v2,v3);
        double areap13 = area(point,v1,v3);

        return (areap12 + areap23 + areap13) == area123;
    }

    public static double area(Point a, Point b, Point c) {
        double temp = a.x * (b.y -c.y) + b.x * (c.y - a.y) + c.x * (a.y -b.y);
        return Math.abs(temp)/2;
    }
}
