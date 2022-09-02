package com.middendorffi.sudoku.controller;

import com.middendorffi.sudoku.domain.Grid;
import com.middendorffi.sudoku.domain.Row;
import com.middendorffi.sudoku.domain.Value;

import static com.middendorffi.sudoku.domain.Group.GROUP_LENGTH;
import static com.middendorffi.sudoku.domain.Value.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by hdavis on 06/08/2018.
 */
public class GridFixtures {

    public static void assertGridEquals(Grid expected, Grid actual) {
        for (int i = 0; i < GROUP_LENGTH; i++) {
            for (int j = 0; j < GROUP_LENGTH; j++) {
                assertEquals(expected.getEntry(i, j).getValue(), actual.getEntry(i, j).getValue());
            }
        }
    }

    public static Grid createExpectedGrid() {

        Row[] rows = new Row[]{
                new Row(new Value[]{FOUR, ONE, SIX, NINE, FIVE, EIGHT, TWO, THREE, SEVEN}),
                new Row(new Value[]{EIGHT, FIVE, SEVEN, THREE, TWO, SIX, ONE, NINE, FOUR}),
                new Row(new Value[]{TWO, THREE, NINE, ONE, FOUR, SEVEN, SIX, FIVE, EIGHT}),
                new Row(new Value[]{SEVEN, SIX, FIVE, FOUR, ONE, NINE, THREE, EIGHT, TWO}),
                new Row(new Value[]{THREE, NINE, TWO, SEVEN, EIGHT, FIVE, FOUR, SIX, ONE}),
                new Row(new Value[]{ONE, EIGHT, FOUR, TWO, SIX, THREE, FIVE, SEVEN, NINE}),
                new Row(new Value[]{SIX, FOUR, THREE, EIGHT, NINE, ONE, SEVEN, TWO, FIVE}),
                new Row(new Value[]{NINE, SEVEN, ONE, FIVE, THREE, TWO, EIGHT, FOUR, SIX}),
                new Row(new Value[]{FIVE, TWO, EIGHT, SIX, SEVEN, FOUR, NINE, ONE, THREE})
        };

        Grid grid = new Grid(rows);

//        Grid grid = createInputGrid();
//
//        grid.setEntry(0, 0, new SolvedEntry(FIVE));
//        grid.setEntry(3, 0, new SolvedEntry(SIX));
//        grid.setEntry(4, 0, new SolvedEntry(SEVEN));
//        grid.setEntry(5, 0, new SolvedEntry(FOUR));
//        grid.setEntry(6, 0, new SolvedEntry(NINE));
//        grid.setEntry(7, 0, new SolvedEntry(ONE));
//
//        grid.setEntry(1, 1, new SolvedEntry(SEVEN));
//        grid.setEntry(2, 1, new SolvedEntry(ONE));
//        grid.setEntry(4, 1, new SolvedEntry(THREE));
//        grid.setEntry(5, 1, new SolvedEntry(TWO));
//        grid.setEntry(7, 1, new SolvedEntry(FOUR));
//        grid.setEntry(8, 1, new SolvedEntry(SIX));
//
//        grid.setEntry(0, 2, new SolvedEntry(SIX));
//        grid.setEntry(1, 2, new SolvedEntry(FOUR));
//        grid.setEntry(2, 2, new SolvedEntry(THREE));
//        grid.setEntry(3, 2, new SolvedEntry(EIGHT));
//        grid.setEntry(6, 2, new SolvedEntry(SEVEN));
//        grid.setEntry(7, 2, new SolvedEntry(TWO));
//        grid.setEntry(8, 2, new SolvedEntry(FIVE));
//
//        grid.setEntry(1, 3, new SolvedEntry(EIGHT));
//        grid.setEntry(2, 3, new SolvedEntry(FOUR));
//        grid.setEntry(3, 3, new SolvedEntry(TWO));
//        grid.setEntry(4, 3, new SolvedEntry(SIX));
//        grid.setEntry(5, 3, new SolvedEntry(THREE));
//        grid.setEntry(6, 3, new SolvedEntry(FIVE));
//        grid.setEntry(8, 3, new SolvedEntry(NINE));
//
//        grid.setEntry(0, 4, new SolvedEntry(THREE));
//        grid.setEntry(2, 4, new SolvedEntry(TWO));
//        grid.setEntry(3, 4, new SolvedEntry(SEVEN));
//        grid.setEntry(5, 4, new SolvedEntry(FIVE));
//        grid.setEntry(6, 4, new SolvedEntry(FOUR));
//        grid.setEntry(8, 4, new SolvedEntry(ONE));
//
//        grid.setEntry(1, 5, new SolvedEntry(SIX));
//        grid.setEntry(2, 5, new SolvedEntry(FIVE));
//        grid.setEntry(3, 5, new SolvedEntry(FOUR));
//        grid.setEntry(4, 5, new SolvedEntry(ONE));
//        grid.setEntry(5, 5, new SolvedEntry(NINE));
//        grid.setEntry(6, 5, new SolvedEntry(THREE));
//        grid.setEntry(7, 5, new SolvedEntry(EIGHT));
//
//        grid.setEntry(1, 6, new SolvedEntry(THREE));
//        grid.setEntry(2, 6, new SolvedEntry(NINE));
//        grid.setEntry(4, 6, new SolvedEntry(FOUR));
//        grid.setEntry(6, 6, new SolvedEntry(SIX));
//        grid.setEntry(7, 6, new SolvedEntry(NINE));
//        grid.setEntry(8, 6, new SolvedEntry(EIGHT));
//
//        grid.setEntry(0, 7, new SolvedEntry(EIGHT));
//        grid.setEntry(2, 7, new SolvedEntry(SEVEN));
//        grid.setEntry(5, 7, new SolvedEntry(SIX));
//        grid.setEntry(7, 7, new SolvedEntry(NINE));
//        grid.setEntry(8, 7, new SolvedEntry(FOUR));
//
//
//        grid.setEntry(0, 8, new SolvedEntry(FOUR));
//        grid.setEntry(1, 8, new SolvedEntry(ONE));
//        grid.setEntry(3, 8, new SolvedEntry(NINE));
//        grid.setEntry(5, 8, new SolvedEntry(EIGHT));
//        grid.setEntry(6, 8, new SolvedEntry(TWO));
//        grid.setEntry(7, 8, new SolvedEntry(THREE));
//        grid.setEntry(8, 8, new SolvedEntry(SEVEN));

        return grid;
    }

    public static Grid createInputGrid() {
        Value e = EMPTY;
        Row[] rows = new Row[]{
                createFirstRow(),
                new Row(new Value[]{e, FIVE, e, THREE, TWO, e, ONE, e, e}),
                new Row(new Value[]{TWO, e, e, ONE, e, SEVEN, e, e, e}),
                new Row(new Value[]{SEVEN, e, e, e, e, e, e, e, TWO}),
                new Row(new Value[]{e, NINE, e, e, EIGHT, e, e, SIX, e}),
                new Row(new Value[]{ONE, e, e, e, e, e, e, SEVEN, e}),
                new Row(new Value[]{e, e, e, e, NINE, ONE, e, e, e}),
                new Row(new Value[]{NINE, e, e, FIVE, e, e, EIGHT, e, e}),
                new Row(new Value[]{e, TWO, EIGHT, e, e, e, e, e, THREE})
        };

        Grid grid = new Grid(rows);


//        Grid grid = new Grid();
//
//        grid.setEntry(1, 0, new GivenEntry(TWO));
//        grid.setEntry(2, 0, new GivenEntry(EIGHT));
//        grid.setEntry(8, 0, new GivenEntry(THREE));
//
//        grid.setEntry(0, 1, new GivenEntry(NINE));
//        grid.setEntry(3, 1, new GivenEntry(FIVE));
//        grid.setEntry(6, 1, new GivenEntry(EIGHT));
//
//        grid.setEntry(4, 2, new GivenEntry(NINE));
//        grid.setEntry(5, 2, new GivenEntry(ONE));
//
//        grid.setEntry(0, 3, new GivenEntry(ONE));
//        grid.setEntry(7, 3, new GivenEntry(SEVEN));
//
//        grid.setEntry(1, 4, new GivenEntry(NINE));
//        grid.setEntry(4, 4, new GivenEntry(EIGHT));
//        grid.setEntry(8, 4, new GivenEntry(SIX));
//
//        grid.setEntry(0, 5, new GivenEntry(SEVEN));
//        grid.setEntry(8, 5, new GivenEntry(TWO));
//
//        grid.setEntry(0, 6, new GivenEntry(TWO));
//        grid.setEntry(3, 6, new GivenEntry(ONE));
//        grid.setEntry(5, 6, new GivenEntry(SEVEN));
//
//        grid.setEntry(1, 7, new GivenEntry(FIVE));
//        grid.setEntry(3, 7, new GivenEntry(THREE));
//        grid.setEntry(4, 7, new GivenEntry(TWO));
//        grid.setEntry(6, 7, new GivenEntry(ONE));
//
//
//        grid.setEntry(2, 8, new GivenEntry(SIX));
//        grid.setEntry(4, 8, new GivenEntry(FIVE));

        return grid;
    }

    public static Row createFirstRow() {
        Value e = EMPTY;
        return new Row(new Value[]{e, e, SIX, e, FIVE, e, e, e, e});
    }

    public static class DummySolver implements Solver {

        public void solve(Grid grid) {
            Grid completed = createExpectedGrid();

            for (int i = 0; i < GROUP_LENGTH; i++) {
                for (int j = 0; j < GROUP_LENGTH; j++) {
                    grid.setEntry(i, j, completed.getEntry(i, j));
                }
            }
        }
    }
}
