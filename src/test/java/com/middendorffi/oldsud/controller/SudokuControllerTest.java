package com.middendorffi.oldsud.controller;

import com.google.common.collect.Lists;
import com.middendorffi.oldsud.controller.check.ValidityChecker;
import com.middendorffi.oldsud.controller.solve.SolverFactory;
import com.middendorffi.oldsud.domain.Grid;
import com.middendorffi.oldsud.domain.GridImpl;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 21/06/2018.
 */
public class SudokuControllerTest {
    private SudokuController controller;
    @Before
    public void setup() {
        controller = new SudokuController();
        controller.setChecker(new ValidityChecker(Lists.newArrayList()));
        controller.setSolverFactory(new SolverFactory());
    }

    @Test
    public void testSolve() {
        Grid grid = new GridImpl();

        Grid actual = controller.solve(grid);

        assertEquals(grid,actual);
    }
}