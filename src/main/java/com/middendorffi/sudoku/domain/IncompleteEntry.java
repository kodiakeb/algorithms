package com.middendorffi.sudoku.domain;

import com.google.common.collect.Lists;

import java.util.List;

import static com.middendorffi.sudoku.domain.Value.EMPTY;

/**
 * Created by hdavis on 23/07/2018.
 */
public abstract class IncompleteEntry extends Entry {
    private List<Value> potentials;

    public IncompleteEntry() {
        this.value = EMPTY;
        this.potentials = Lists.newArrayList(Value.values());
        potentials.remove(EMPTY);
    }

    public List<Value> getPotentials() {
        return potentials;
    }

    public boolean isComplete() {
        return false;
    }
}
