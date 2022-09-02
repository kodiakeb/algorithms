package com.middendorffi.sudoku.controller;

import com.google.common.collect.Lists;
import com.middendorffi.sudoku.domain.Grid;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.middendorffi.sudoku.controller.GridFixtures.*;

/**
 * Created by hdavis on 06/08/2018.
 */
public class SudokuSolverTest {

    private SudokuSolver solver;

    @Before
    public void setup() {
        List<Solver> solvers = Lists.newArrayList();

        solver = new SudokuSolver(solvers);
    }

    @Test
    public void testSolve() {
        Grid inputGrid = createInputGrid();
        Grid expectedGrid = createExpectedGrid();

        solver.getSolvers().add(new DummySolver());

        Grid actualGrid = solver.solve(inputGrid);

        assertGridEquals(actualGrid, expectedGrid);
    }
}