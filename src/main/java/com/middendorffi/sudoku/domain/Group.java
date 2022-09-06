package com.middendorffi.sudoku.domain;

import com.middendorffi.oldsud.domain.State;

/**
 * Created by hdavis on 21/06/2018.
 */
public interface Group  extends Iterable<Entry> {
    int GROUP_LENGTH = Value.NUM_VALUES;

    Entry getEntry(int index);
    void setEntry(int index, Entry entry);
}
