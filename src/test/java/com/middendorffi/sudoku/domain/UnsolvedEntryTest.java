package com.middendorffi.sudoku.domain;

import com.google.common.collect.Lists;
import com.middendorffi.sudoku.exceptions.ParseValueException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.middendorffi.sudoku.domain.Value.*;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 23/07/2018.
 */
public class UnsolvedEntryTest {
    private UnsolvedEntry entry;

    @Before
    public void setup() {
        entry = new UnsolvedEntry();
    }

    @Test
    public void testValue() {
        assertEquals(EMPTY,entry.getValue());
    }

    @Test
    public void testToString() {
        assertEquals(" ",entry.toString());
    }

    @Test
    public void testGetState() {
        assertEquals(EntryState.UNSOLVED,entry.getState());
    }

    @Test
    public void testPotentials() {
        List<Value> expected = Lists.newArrayList(ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE);
        assertEquals(expected,entry.getPotentials());
    }

    @Test
    public void testComplete() {
        assertFalse(entry.isComplete());
    }


    @Test
    public void testIsSolveable_Not() {
        assertFalse(entry.isSolvable());
    }

    @Test
    public void testIsSolveable_True() {
        entry.getPotentials().removeAll(Lists.newArrayList(ONE,TWO,THREE,FOUR,SIX,SEVEN,EIGHT,NINE));
        assertTrue(entry.isSolvable());
    }
}