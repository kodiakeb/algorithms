package com.middendorffi.oldsud.controller.check;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static com.middendorffi.oldsud.TestFixtures.readCompleteGrid;
import static com.middendorffi.oldsud.TestFixtures.readInputGrid;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by hdavis on 26/06/2018.
 */
public class CompleteCheckerTest {

    private CompleteChecker completeChecker;

    @Before
    public void setup() {
        completeChecker = new CompleteChecker();
    }

    @Test
    public void testCheck_incompleteGrid() throws FileNotFoundException {
        assertFalse(completeChecker.check(readInputGrid()));
    }

    @Test
    public void testCheck_completeGrid() throws FileNotFoundException {
        assertTrue(completeChecker.check(readCompleteGrid()));
    }
}