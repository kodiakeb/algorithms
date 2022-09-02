package com.middendorffi.oldsud.controller;

import com.middendorffi.oldsud.domain.GridImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static com.middendorffi.oldsud.TestFixtures.readInputGrid;
import static com.middendorffi.oldsud.controller.GridWriterImpl.BLANK_LINE;
import static com.middendorffi.oldsud.controller.GridWriterImpl.HORIZONTAL;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 21/06/2018.
 */
public class GridWriterImplTest {
    private GridWriterImpl writer;

    @Before
    public void setup() {
        writer = new GridWriterImpl();
    }

    @Test
    public void testWriteWithEmptyGrid() {
        assertEquals(createEmptyGrid(), writer.write(new GridImpl()));
    }

    @Test
    public void testWriteGrid() throws FileNotFoundException {
        assertEquals(createGrid(),writer.write(readInputGrid()));
    }

    private String createEmptyGrid() {
        StringBuilder sb = new StringBuilder();
        sb.append(HORIZONTAL);
        sb.append(BLANK_LINE);
        sb.append(BLANK_LINE);
        sb.append(BLANK_LINE);

        sb.append(HORIZONTAL);
        sb.append(BLANK_LINE);
        sb.append(BLANK_LINE);
        sb.append(BLANK_LINE);

        sb.append(HORIZONTAL);
        sb.append(BLANK_LINE);
        sb.append(BLANK_LINE);
        sb.append(BLANK_LINE);

        sb.append(HORIZONTAL);

        return sb.toString();
    }

    private String createGrid() {
        StringBuilder sb = new StringBuilder();

        sb.append(HORIZONTAL);
        sb.append("| 2     | 4 5   |   1   |\n");
        sb.append("|     7 |       |     4 |\n");
        sb.append("|       |     2 |   5 9 |\n");

        sb.append(HORIZONTAL);
        sb.append("| 6     | 8     |   9 1 |\n");
        sb.append("|       | 9   6 |       |\n");
        sb.append("| 9 3   |     4 |     6 |\n");

        sb.append(HORIZONTAL);
        sb.append("| 4 7   | 5     |       |\n");
        sb.append("| 1     |       | 5     |\n");
        sb.append("|   9   |   4 8 | 1   3 |\n");

        sb.append(HORIZONTAL);

        return sb.toString();
    }
}