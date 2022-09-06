package com.middendorffi.sudoku.domain;

import com.middendorffi.sudoku.exceptions.InvalidIndexException;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static com.middendorffi.sudoku.domain.Value.ONE;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 26/07/2018.
 */
public class BaseGroupTest {

    public static final GivenEntry GIVEN_ENTRY = new GivenEntry(ONE);
    public static final int LOWEST_VALID = 0;
    public static final int HIGHEST_VALID = Group.GROUP_LENGTH-1;
    private BaseGroup baseGroup;

    @Before
    public void setup() {
        baseGroup = new BaseGroup();
    }

    @Test
    public void testSetAndGet_LowestValid() {
        baseGroup.setEntry(LOWEST_VALID, GIVEN_ENTRY);

        assertEquals(GIVEN_ENTRY,baseGroup.getEntry(LOWEST_VALID));
    }

    @Test
    public void testSetAndGet_HighestValid() {
        baseGroup.setEntry(HIGHEST_VALID, GIVEN_ENTRY);

        assertEquals(GIVEN_ENTRY,baseGroup.getEntry(HIGHEST_VALID));
    }

    @Test (expected = InvalidIndexException.class)
    public void testSetAndGet_indexBelowLowest() {
        baseGroup.setEntry(LOWEST_VALID-1, GIVEN_ENTRY);
    }

    @Test (expected = InvalidIndexException.class)
    public void testSetAndGet_indexAboveHighest() {
        baseGroup.setEntry(HIGHEST_VALID+1, GIVEN_ENTRY);
    }

    @Test
    public void testIterator() {
        baseGroup.setEntry(LOWEST_VALID, GIVEN_ENTRY);

        Iterator<Entry> entryIterator = baseGroup.iterator();

        assertTrue(entryIterator.hasNext());
        assertEquals(GIVEN_ENTRY,entryIterator.next());
    }
}