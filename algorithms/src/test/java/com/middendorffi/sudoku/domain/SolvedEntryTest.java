package com.middendorffi.sudoku.domain;

import com.middendorffi.sudoku.exceptions.ParseValueException;
import org.junit.Before;
import org.junit.Test;

import static com.middendorffi.sudoku.domain.Value.EMPTY;
import static com.middendorffi.sudoku.domain.Value.NINE;
import static com.middendorffi.sudoku.domain.Value.ONE;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 23/07/2018.
 */
public class SolvedEntryTest {
    private SolvedEntry entry;

    @Before
    public void setup() {
        entry = new SolvedEntry(Value.ONE);
    }

    @Test
    public void testValue() {
        assertEquals(ONE,entry.getValue());
    }


    @Test
    public void testAnotherValue() {
        assertEquals(NINE,new SolvedEntry(NINE).getValue());
    }

    @Test
    public void testToString() {
        assertEquals("1",entry.toString());
    }

    @Test
    public void testGetState() {
        assertEquals(EntryState.SOLVED,entry.getState());
    }

    @Test (expected = ParseValueException.class)
    public void testInitialiseToEmpty() {
        new GivenEntry(EMPTY);
    }

    @Test (expected = ParseValueException.class)
    public void testInitialiseToNull() {
        new GivenEntry(null);
    }


    @Test
    public void testComplete() {
        assertTrue(entry.isComplete());
    }

}