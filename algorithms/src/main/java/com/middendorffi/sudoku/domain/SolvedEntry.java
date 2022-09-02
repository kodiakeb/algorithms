package com.middendorffi.sudoku.domain;

import com.middendorffi.sudoku.exceptions.ParseValueException;

/**
 * Created by hdavis on 23/07/2018.
 */
public class SolvedEntry extends CompleteEntry {

    private SolvedEntry() {

    }
    public SolvedEntry(Value value) {
       super(value);
    }

    public EntryState getState() {
        return EntryState.SOLVED;
    }
}
