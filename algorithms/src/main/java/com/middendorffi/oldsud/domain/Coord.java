package com.middendorffi.oldsud.domain;

import com.google.common.base.Objects;
import com.middendorffi.oldsud.exceptions.InvalidIndexException;

/**
 * Created by hdavis on 01/07/2018.
 */
public class Coord {
    private int i;
    private int j;

    public static Coord newInstance(int i, int j) {

        if (!isIndexValid(i) || !isIndexValid(j)) {
            throw new InvalidIndexException("Index must be between 0 and 8");
        }
        return new Coord(i, j);
    }

    private Coord(int i, int j) {

        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    private static boolean isIndexValid(int index) {
        return index >= 0 && index < 9;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return i == coord.i &&
                j == coord.j;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(i, j);
    }
}
