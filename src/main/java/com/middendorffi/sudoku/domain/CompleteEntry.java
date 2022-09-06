package com.middendorffi.sudoku.domain;

import com.middendorffi.sudoku.exceptions.ParseValueException;

/**
 * Created by hdavis on 23/07/2018.
 */
public abstract class CompleteEntry extends Entry {
    protected CompleteEntry() {

    }
    public CompleteEntry(Value value) {
        if (isEmpty(value)) {
            throw new ParseValueException("Solved entry values must be between 1 and 9");
        }
        this.value = value;
    }
    public boolean isComplete() {
        return true;
    }

    protected boolean isEmpty(Value value) {
        return value == null || value.equals(Value.EMPTY);
    }
}
