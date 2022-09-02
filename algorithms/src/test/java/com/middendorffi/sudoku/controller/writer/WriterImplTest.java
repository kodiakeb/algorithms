package com.middendorffi.sudoku.controller.writer;

import com.middendorffi.sudoku.controller.GridFixtures;
import com.middendorffi.sudoku.domain.Grid;
import org.junit.Before;
import org.junit.Test;

import static com.middendorffi.sudoku.controller.GridFixtures.createInputGrid;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 07/08/2018.
 */
public class WriterImplTest {

    private Writer writer;

    @Before
    public void setup() {
        writer = new WriterImpl();
    }

    @Test
    public void testWrite() {

        String expected = createExpected();

        String actual = writer.write(createInputGrid());

        System.out.println(expected);

        assertEquals(expected,actual);
    }

    private String createExpected(){
        return "-------------------------\n" +
                "|     6 |   5   |       |\n" +
                "|   5   | 3 2   | 1     |\n" +
                "| 2     | 1   7 |       |\n" +
                "-------------------------\n" +
                "| 7     |       |     2 |\n" +
                "|   9   |   8   |   6   |\n" +
                "| 1     |       |   7   |\n" +
                "-------------------------\n" +
                "|       |   9 1 |       |\n" +
                "| 9     | 5     | 8     |\n" +
                "|   2 8 |       |     3 |\n" +
                "-------------------------\n";
    }
}