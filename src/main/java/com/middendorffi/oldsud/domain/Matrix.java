package com.middendorffi.oldsud.domain;

/**
 * Created by hdavis on 30/06/2018.
 *
 * Simple 2D array.
 *
 * Horizontal dimension index is i -> 0 to 8 starting with left edge
 *
 * Vertical dimension index is j -> 0 to 8 starting with bottom edge.
 *
 * j
 *
 * 8
 * 7
 * 6
 * 5
 * 4
 * 3
 * 2
 * 1
 * 0
 *  0 1 2 3 4 5 6 7 8  i
 */
public class Matrix {
    private Value[][] values;

    public Matrix() {
        values = new Value[Grid.COUNT][Grid.COUNT];
        clear();
    }

    public Value getValue(Coord coord) {
        return values[coord.getI()][coord.getJ()];
    }

    public void clear() {
        for (int i = 0; i < Grid.COUNT;i++) {
            for (int j = 0; j < Grid.COUNT;j++) {
                values[i][j] = new Value();
            }
        }
    }

    public void setValue(Coord coord, Value value) {
        values[coord.getI()][coord.getJ()] = value;
    }
}
