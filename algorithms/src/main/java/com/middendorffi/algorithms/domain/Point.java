package com.middendorffi.algorithms.domain;

import com.google.common.base.Objects;

/**
 * Created by hdavis on 13/07/2017.
 */
public class Point implements Comparable<Point> {
    public double x;
    public double y;

    public Point(double x,double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }

    public int compareTo(Point o) {
       // distance from origin
        double distance = euclideanDistance(this);
        double oDistance = euclideanDistance(o);

        if (distance > oDistance) {
            return 1;
        }
        else if (distance < oDistance){
            return -1;
        }
        return 0;
    }

    private static double euclideanDistance(Point point) {
        return Math.sqrt(Math.pow(point.x,2) + Math.pow(point.y,2));
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
