package com.middendorffi.oldsud.controller.check;

import com.google.common.collect.Lists;
import com.middendorffi.oldsud.domain.Grid;
import org.easymock.classextension.EasyMock;
import org.easymock.classextension.IMocksControl;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 10/07/2018.
 */
public class ValidityCheckerTest {

    private ValidityChecker validityChecker;

    private IMocksControl mocksControl;
    private Checker mockChecker1;
    private Checker mockChecker2;

    private Grid mockGrid;

    @Before
    public void setup(){
        mocksControl = EasyMock.createControl();

        mockChecker1 = mocksControl.createMock(Checker.class);
        mockChecker2 = mocksControl.createMock(Checker.class);
        mockGrid = mocksControl.createMock(Grid.class);

        validityChecker = new ValidityChecker(Lists.newArrayList(mockChecker1,mockChecker2));
    }

    @Test
    public void testCheck_firstFalse_false() {
        runTest(false,true,false);
    }

    @Test
    public void testCheck_firstTrueSecondFalse_false() {
        runTest(true,false,false);
    }


    @Test
    public void testCheck_firstTrueSecondTrue_true() {
        runTest(true,true,true);
    }

    private void runTest(boolean firstResult,boolean secondResult,boolean expected) {
        expect(mockChecker1.check(mockGrid)).andReturn(firstResult);
        if (firstResult) {
            expect(mockChecker2.check(mockGrid)).andReturn(secondResult);
        }

        mocksControl.replay();
        boolean actual = validityChecker.check(mockGrid);
        mocksControl.verify();

        assertEquals(expected,actual);
    }

}