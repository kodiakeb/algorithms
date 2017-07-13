package com.middendorffi.algorithms.convexhull;

import com.google.common.collect.Sets;
import com.middendorffi.algorithms.domain.Point;

import java.util.Set;
import java.util.Set;
import java.util.SortedSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by hdavis on 13/07/2017.
 */
public class ConvextHullFixtures {

    public static void runTest(ConvexHullCalculator convexHullCalculator, SortedSet<Point> inputs, SortedSet<Point> expected) {

        SortedSet<Point> actual = convexHullCalculator.calcConvexHull(inputs);

        assertEquals(expected.size(), actual.size());
        for (Point point : actual) {
            assertTrue(expected.contains(point));
        }
    }

    public static SortedSet<Point> createSinglePointInputs() {
        SortedSet<Point> points = Sets.newTreeSet();
        points.add(new Point(2,1));
        return points;
    }

    public static SortedSet<Point> createTwoPointInputs() {
        SortedSet<Point> points = Sets.newTreeSet();
        points.add(new Point(2,1));
        points.add(new Point(3,4));

        return points;
    }

    public static SortedSet<Point> createThreePointInputs() {
        SortedSet<Point> points = Sets.newTreeSet();
        points.add(new Point(2,1));
        points.add(new Point(3,4));
        points.add(new Point(5,2));

        return points;
    }

    public static SortedSet<Point> createFourPointInputsThreeSides() {
        SortedSet<Point> points = Sets.newTreeSet();
        points.add(new Point(2,1));
        points.add(new Point(3,4));
        points.add(new Point(5,2));
        points.add(new Point(4,2));

        return points;
    }

    public static SortedSet<Point> createFourPointInputsFourSides() {
        SortedSet<Point> points = Sets.newTreeSet();
        points.add(new Point(2,1));
        points.add(new Point(3,4));
        points.add(new Point(5,2));
        points.add(new Point(6,4));
        return points;
    }

    public static SortedSet<Point> createFullSetInputs() {
        SortedSet<Point> points = Sets.newTreeSet();
        points.add(new Point(0,4));
        points.add(new Point(1,8));
        points.add(new Point(1.5,5));
        points.add(new Point(2,0));
        points.add(new Point(3,1));
        points.add(new Point(2.5,9));
        points.add(new Point(4,8.5));
        points.add(new Point(7,10));
        points.add(new Point(6,1));
        points.add(new Point(7.5,2.5));
        points.add(new Point(10,2.5));
        points.add(new Point(9,5));
        points.add(new Point(6.5,6));
        points.add(new Point(9.1,8.5));
        points.add(new Point(7.2,8.4));


        return points;
    }

    public static SortedSet<Point> createSinglePointOutputs() {
        // outputs are the same as inputs
        return createSinglePointInputs();
    }

    public static SortedSet<Point> createTwoPointOutputs() {
        // outputs are the same as inputs
        return createTwoPointInputs();
    }

    public static SortedSet<Point> createThreePointOutputs() {
        // outputs are the same as inputs
        return createThreePointInputs();
    }

    public static SortedSet<Point> createFourPointOutputsThreeSides() {
        SortedSet<Point> points = Sets.newTreeSet();
        points.add(new Point(2,1));
        points.add(new Point(3,4));
        points.add(new Point(5,2));
        return points;
    }

    public static SortedSet<Point> createFourPointOutputsFourSides() {
        SortedSet<Point> points = Sets.newTreeSet();
        points.add(new Point(2,1));
        points.add(new Point(3,4));
        points.add(new Point(5,2));
        points.add(new Point(6,4));
        return points;
    }

    public static SortedSet<Point> createFullSetOutputs() {
        SortedSet<Point> points = Sets.newTreeSet();
        return points;
    }
}
