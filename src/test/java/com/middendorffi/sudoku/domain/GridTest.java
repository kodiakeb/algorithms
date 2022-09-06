package com.middendorffi.sudoku.domain;

import com.middendorffi.sudoku.controller.GridFixtures;
import org.junit.Test;

import static com.middendorffi.sudoku.controller.GridFixtures.createExpectedGrid;
import static com.middendorffi.sudoku.controller.GridFixtures.createFirstRow;
import static com.middendorffi.sudoku.controller.GridFixtures.createInputGrid;
import static com.middendorffi.sudoku.domain.Group.GROUP_LENGTH;
import static com.middendorffi.sudoku.domain.Value.*;
import static org.junit.Assert.*;

/**
 * Underlying store of all the entries.
 * Created by hdavis on 06/08/2018.
 */
public class GridTest {

    @Test
    public void testEmptyMatrixTotalsEqual() {
        Grid grid = new Grid();

        assertEquals(new Grid().total(), grid.total());
    }

    @Test
    public void testPartialGrid() {
        Grid grid = createInputGrid();

        Row expected = createFirstRow();

        Row actual = grid.getRowEntry(0);

        for (int i = 0;i < GROUP_LENGTH;i++) {
            assertEquals(expected.getEntry(i).getValue(),actual.getEntry(i).getValue());
        }
    }

    @Test
    public void testCreateFromGrid() {
        Grid expected = createInputGrid();

        Grid actual = new Grid(expected);

        assertFalse(expected == actual); // not the object
        for (int i = 0;i < GROUP_LENGTH;i++) {
            for (int j = 0;j < GROUP_LENGTH;j++) {
                assertEquals(expected.getEntry(i,j).getState(), actual.getEntry(i,j).getState());
                assertEquals(expected.getEntry(i,j).getValue(), actual.getEntry(i,j).getValue());
            }
        }
    }
}