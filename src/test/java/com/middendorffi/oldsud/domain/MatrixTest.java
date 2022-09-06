package com.middendorffi.oldsud.domain;

import org.junit.Before;
import org.junit.Test;

import static com.middendorffi.oldsud.domain.State.EMPTY;
import static com.middendorffi.oldsud.domain.State.TWO;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 30/06/2018.
 */
public class MatrixTest {

    private Matrix matrix;

    @Before
    public void setup() {
        matrix = new Matrix();
    }

    @Test
    public void testClear() {
        matrix.clear();

        assertEmptyMatrix(matrix);
    }

    @Test
    public void testGetValue() {
        matrix.setValue(Coord.newInstance(2,3),new Value(TWO));
        assertEquals(new Value(TWO),matrix.getValue(Coord.newInstance(2,3)));

    }

    private void assertEmptyMatrix(Matrix matrix) {
        for (int i = 0; i < Grid.COUNT;i++) {
            for (int j = 0; j < Grid.COUNT;j++) {
                assertEquals(EMPTY,matrix.getValue(Coord.newInstance(i,j)).getState());
            }
        }
    }
}