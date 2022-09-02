package com.middendorffi.sudoku.controller;

import com.middendorffi.oldsud.controller.GridWriter;
import com.middendorffi.oldsud.controller.GridWriterImpl;
import com.middendorffi.sudoku.controller.writer.WriterImpl;
import com.middendorffi.sudoku.domain.Grid;

import java.util.List;

/**
 * Created by hdavis on 06/08/2018.
 */
public class SudokuSolver {

    private final List<Solver> solvers;

    public SudokuSolver(List<Solver> solvers) {
        this.solvers = solvers;

    }

    public Grid solve(Grid grid) {

        System.out.println("\nBEFORE\n");
        System.out.println(new WriterImpl().write(grid));

        for (Solver solver: solvers) {
            solver.solve(grid);
        }

        System.out.println("\nAFTER\n");
        System.out.println(new WriterImpl().write(grid));

        return grid;
    }

    public List<Solver> getSolvers() {
        return solvers;
    }
}
