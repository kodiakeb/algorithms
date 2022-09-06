package com.middendorffi.algorithms.convexhull;

import com.middendorffi.algorithms.domain.Point;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by hdavis on 13/07/2017.
 */
public interface ConvexHullCalculator {
    SortedSet<Point> calcConvexHull(SortedSet<Point> points);
}
