package com.middendorffi.sudoku.domain;

/**
 * Created by hdavis on 23/07/2018.
 */
public abstract class Entry {
    protected Value value;

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.getLabel();
    }

    public abstract EntryState getState();
}
