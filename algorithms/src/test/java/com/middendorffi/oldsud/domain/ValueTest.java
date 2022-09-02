package com.middendorffi.oldsud.domain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static com.middendorffi.oldsud.domain.State.*;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 30/06/2018.
 */
public class ValueTest {

    @Test
    public void testConstructEmptyValue_notGiven() {
        Value value = new Value();

        assertFalse(value.isGiven());
    }

    @Test
    public void testConstructEmptyValue_value() {
        Value value = new Value();

        assertEquals(EMPTY,value.getState());
    }

    @Test
    public void testConstructEmptyValue_getPotentialStates() {
        Value value = new Value();

        List<State> expected = Lists.newArrayList(ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE);

        assertEquals(expected,value.getPotentialStates());
    }

    @Test
    public void testConstructEmptyValue_notCompleted() {
        Value value = new Value();

        assertFalse(value.isCompleted());
    }

    @Test
    public void testConstructValue_given() {
        Value value = new Value(TWO);

        assertTrue(value.isGiven());
    }

    @Test
    public void testConstructValue_value() {
        Value value = new Value(TWO);

        assertEquals(TWO,value.getState());
    }

    @Test
    public void testConstructValue_getPotentialStates() {
        Value value = new Value(TWO);

        ImmutableList<State> expected = ImmutableList.of(TWO);

        assertEquals(expected,value.getPotentialStates());
    }

    @Test
    public void testConstructValue_Completed() {
        Value value = new Value(TWO);

        assertTrue(value.isCompleted());
    }
}