package com.middendorffi.sudoku.domain;

import com.google.common.collect.Lists;
import com.middendorffi.sudoku.exceptions.InvalidIndexException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hdavis on 26/07/2018.
 */
public class BaseGroup implements Group {

    private final List<Entry> entries;

    public BaseGroup() {
        entries = Lists.newArrayList();
        for (int i = 0; i < GROUP_LENGTH; i++) {
            entries.add(new UnsolvedEntry());
        }
    }

    public BaseGroup(Value[] values) {
        this();
        int size = values.length;
        if (size < 0 || size > GROUP_LENGTH) {
            throw new InvalidIndexException("There must be " + GROUP_LENGTH + " values");
        }

        for (int i =0;i < GROUP_LENGTH;i++) {
            if (!values[i].equals(Value.EMPTY)) {
                entries.set(i,new SolvedEntry(values[i]));
            }
        }
    }

    public void setEntry(int index, Entry entry) {
        checkIndex(index);
        entries.set(index, entry);
    }

    public Entry getEntry(int index) {
        checkIndex(index);
        return entries.get(index);
    }

    public Iterator<Entry> iterator() {
        return entries.iterator();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= GROUP_LENGTH) {
            throw new InvalidIndexException("There are only " + GROUP_LENGTH + " values allowed");
        }
    }

    @Override
    public String toString() {
        return "BaseGroup{" +
                "entries=" + entries +
                '}';
    }
}
