package com.middendorffi.oldsud.domain;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.middendorffi.oldsud.exceptions.InvalidIndexException;

import java.util.List;

/**
 * Created by hdavis on 21/06/2018.
 * TODO going to convert to Matrix internals.
 */
public class GridImpl implements Grid {
    private List<Box> boxes;

    public GridImpl() {
        boxes = Lists.newArrayList();
        for (int i = 0; i<  Grid.COUNT; i++) {
            boxes.add(new Box());
        }

    }
    public List<Box> getBoxes() {
        return boxes;
    }

    public List<Row> getRows() { return null;}

    public List<Column> getColumns() { return null;}

//    public State getValue(int boxIndex, int valueIndex) {
//        if (boxIndex < 0 || boxIndex >= COUNT) {
//            throw new InvalidIndexException("There are only " + COUNT + " boxes");
//        }
//        return boxes.get(boxIndex).getValue(valueIndex);
//    }

    public void setValue(int boxIndex,int valueIndex,State state) {
        if (boxIndex < 0 || boxIndex >= COUNT) {
            throw new InvalidIndexException("There are only " + COUNT + " boxes");
        }
        boxes.get(boxIndex).setValue(valueIndex, state);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridImpl grid = (GridImpl) o;
        return Objects.equal(boxes, grid.boxes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(boxes);
    }

    @Override
    public String toString() {
        return "GridImpl{" +
                "boxes=" + boxes +
                '}';
    }
}
