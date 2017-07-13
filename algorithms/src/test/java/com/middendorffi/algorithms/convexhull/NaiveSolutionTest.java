package com.middendorffi.algorithms.convexhull;

import com.middendorffi.algorithms.domain.Point;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.SortedSet;

/**
 * Created by hdavis on 13/07/2017.
 */
public class NaiveSolutionTest {

    private NaiveSolution testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new NaiveSolution();
    }

    @Test
    public void calcConvexHullSingle() throws Exception {
        SortedSet<Point> inputs = ConvextHullFixtures.createSinglePointInputs();
        SortedSet<Point> expected = ConvextHullFixtures.createSinglePointOutputs();

        runTest(inputs, expected);
    }

    @Test
    public void calcConvexHullTwo() throws Exception {
        SortedSet<Point> inputs = ConvextHullFixtures.createTwoPointInputs();
        SortedSet<Point> expected = ConvextHullFixtures.createTwoPointOutputs();

        runTest(inputs, expected);
    }

    @Test
    public void calcConvexHullThree() throws Exception {
        SortedSet<Point> inputs = ConvextHullFixtures.createThreePointInputs();
        SortedSet<Point> expected = ConvextHullFixtures.createThreePointOutputs();

        runTest(inputs, expected);
    }

    @Test
    public void calcConvexHullFourThreeSides() throws Exception {
        SortedSet<Point> inputs = ConvextHullFixtures.createFourPointInputsThreeSides();
        SortedSet<Point> expected = ConvextHullFixtures.createFourPointOutputsThreeSides();

        runTest(inputs, expected);
    }

    @Test
    public void calcConvexHullFourFourSides() throws Exception {
        SortedSet<Point> inputs = ConvextHullFixtures.createFourPointInputsFourSides();
        SortedSet<Point> expected = ConvextHullFixtures.createFourPointOutputsFourSides();

        runTest(inputs, expected);
    }

    @Test
    public void calcConvexHullFullSet() throws Exception {
        SortedSet<Point> inputs = ConvextHullFixtures.createFullSetInputs();
        SortedSet<Point> expected = ConvextHullFixtures.createFullSetOutputs();

        runTest(inputs, expected);
    }


    private void runTest(SortedSet<Point> inputs, SortedSet<Point> expected) {
        ConvextHullFixtures.runTest(testObject, inputs, expected);
    }

}