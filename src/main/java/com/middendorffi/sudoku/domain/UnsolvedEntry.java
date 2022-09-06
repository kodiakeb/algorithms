package com.middendorffi.sudoku.domain;

/**
 * Created by hdavis on 23/07/2018.
 */
public class UnsolvedEntry extends IncompleteEntry {


    public UnsolvedEntry() {
        super();
    }

    public EntryState getState() {
        return EntryState.UNSOLVED;
    }

    public boolean isSolvable() {
        return getPotentials().size() == 1;
    }
}
