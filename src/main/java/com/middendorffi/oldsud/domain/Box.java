package com.middendorffi.oldsud.domain;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.middendorffi.oldsud.exceptions.InvalidIndexException;

import java.util.List;

import static com.middendorffi.oldsud.domain.Grid.COUNT;
import static com.middendorffi.oldsud.domain.State.EMPTY;

/**
 * Created by hdavis on 21/06/2018.
 *
 * 0 1 2
 * 3 4 5
 * 6 7 8
 */
public class Box implements Group {
    private List<State> states;

    public Box() {
        states = Lists.newArrayList();
        for (int i = 0; i < COUNT; i++) {
            states.add(EMPTY);
        }
    }

    public void setValue(int index,State state) {
        if (index < 0 || index >= COUNT) {
            throw new InvalidIndexException("There are only " + COUNT + " values in a box");
        }
        states.set(index, state);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Objects.equal(states, box.states);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(states);
    }

    public State getValue(int index) {
        if (index < 0 || index >= COUNT) {
            throw new InvalidIndexException("There are only " + COUNT + " values in a box");
        }
        return states.get(index);
    }

    public List<State> getStates() {
        return states;
    }

    @Override
    public String toString() {
        return "Box{" +
                "values=" + states +
                '}';
    }
}
