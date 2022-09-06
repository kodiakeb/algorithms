package com.middendorffi.algorithms.convexhull;

import com.google.common.collect.Sets;
import com.middendorffi.algorithms.domain.Point;
import com.middendorffi.algorithms.domain.Triangle;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * This is me trying to solve the problem without looking at the book!
 */
public class NaiveSolution implements ConvexHullCalculator {

    public SortedSet<Point> calcConvexHull(SortedSet<Point> points) {
        SortedSet<Point> results = new TreeSet<Point>();

        if (points.size() <= 3) {
            // trivial solution
            System.out.println("minimal");
            results.addAll(points);
        }
        else {
            for (Point point: points) {
                SortedSet<Point> otherPoints = Sets.newTreeSet(points);

                otherPoints.remove(point);

                if (!pointWithinTriangles(point,otherPoints)) {
                    results.add(point);
                }

            }

        }
        return results;
    }

    /**
     * Hideously inefficient way of finding the convex hull.
     * @param point
     * @param otherPoints
     * @return
     */
    private boolean pointWithinTriangles(Point point, SortedSet<Point> otherPoints) {
        for (Point firstVertice: otherPoints) {
            SortedSet<Point> withoutFirstVertice = Sets.newTreeSet(otherPoints.tailSet(firstVertice));
            withoutFirstVertice.remove(firstVertice);

            // Make all the triangles possible from vertice onwards
            for (Point secondVertice: withoutFirstVertice ) {
                SortedSet<Point> withoutSecondVertice = Sets.newTreeSet(withoutFirstVertice.tailSet(secondVertice));
                withoutSecondVertice.remove(secondVertice);

                for (Point thirdVertice: withoutSecondVertice) {
                    Triangle triangle = new Triangle(firstVertice,secondVertice,thirdVertice);

                    if (triangle.contains(point)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
