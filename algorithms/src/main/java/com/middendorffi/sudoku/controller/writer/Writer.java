package com.middendorffi.sudoku.controller.writer;

import com.middendorffi.sudoku.domain.Grid;

/**
 * Created by hdavis on 06/08/2018.
 */
public interface Writer {
    String write(Grid grid);
}
