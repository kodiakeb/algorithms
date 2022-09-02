package com.middendorffi.oldsud.domain;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

import static com.middendorffi.oldsud.domain.State.*;

/**
 * Created by hdavis on 21/06/2018.
 */
public class Value {
    private State state;
    private final boolean given;
    private List<State> potentialStates;

    public Value() {
        this(EMPTY,false);
    }

    public Value(State state) {
        this(state,isValidValue(state));
    }

    private Value(State state,boolean given) {
        setState(state);
        this.given = given;
    }

    public boolean isGiven() {
        return given;
    }

    public void setState(State state) {
        if (isGiven()) {
            throw new IllegalStateException("Cannot set a given value");
        }
        this.state = state;
        buildPotentialStates();
    }

    public State getState() {
        return state;
    }

    public boolean isCompleted() {
        return isValidValue(state);
    }

    public void removePotentialState(State stateToRemove) {
        if (potentialStates.contains(stateToRemove)) {
            potentialStates.remove(stateToRemove);
        }
        updateStateIfRequired();
    }

    public void resetPotentialStates() {
        buildPotentialStates();
    }

    public void updateStateIfRequired() {
        if (potentialStates.size() == 1) {
            state = potentialStates.get(0);
            buildPotentialStates();
        }
    }

    public ImmutableList<State> getPotentialStates() {
        return ImmutableList.copyOf(potentialStates);
    }

    private List<State> singlePotentialStates() {
        return Lists.newArrayList(state);
    }

    public static List<State> fullPotentialStates() {
        return Lists.newArrayList(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE);
    }
    private static boolean isValidValue(State stateToCheck) {
        return !stateToCheck.equals(State.EMPTY);
    }

    private void buildPotentialStates() {
        potentialStates = state.equals(EMPTY) ? fullPotentialStates():singlePotentialStates();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return given == value.given &&
                state == value.state &&
                Objects.equal(potentialStates, value.potentialStates);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(state, given, potentialStates);
    }
}
