package com.middendorffi.sudoku.domain;

import com.middendorffi.sudoku.exceptions.ParseValueException;

/**
 * Created by hdavis on 23/07/2018.
 */
public class GivenEntry extends CompleteEntry {
    private GivenEntry() {

    }

    public GivenEntry(Value value) {
        super(value);
    }

    public EntryState getState() {
        return EntryState.GIVEN;
    }

}
