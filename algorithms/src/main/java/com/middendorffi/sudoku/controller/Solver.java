package com.middendorffi.sudoku.controller;

import com.middendorffi.sudoku.domain.Grid;

/**
 * Created by hdavis on 06/08/2018.
 */
public interface Solver {
    void solve(Grid grid);
}
