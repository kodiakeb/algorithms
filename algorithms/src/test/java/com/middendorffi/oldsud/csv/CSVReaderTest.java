package com.middendorffi.oldsud.csv;

import com.middendorffi.oldsud.domain.Grid;
import com.middendorffi.oldsud.domain.GridImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static com.middendorffi.oldsud.domain.State.*;
import static org.junit.Assert.*;

/**
 * Created by hdavis on 21/06/2018.
 */
public class CSVReaderTest {
    private CSVReader reader;

    @Before
    public void setup() {
        reader = new CSVReader();
    }

    @Test
    public void testRead() throws IOException {
        FileReader fileReader = new FileReader("src/test/resources/input.csv");
        Grid expected = getExpectedGrid();

        Grid actual = reader.readCsv(fileReader);
        fileReader.close();

        assertEquals(expected, actual);
    }

    private GridImpl getExpectedGrid() {
        GridImpl grid = new GridImpl();

//        A,B,C,D,E,F,G,H,I
//        2,X,X,4,5,X,X,1,X
//        X,X,7,X,X,X,X,X,4
//        X,X,X,X,X,2,X,5,9
//        6,X,X,8,X,X,X,9,1
//        X,X,X,9,X,6,X,X,X
//        9,3,X,X,X,4,X,X,6
//        4,7,X,5,X,X,X,X,X
//        1,X,X,X,X,X,5,X,X
//        X,9,X,X,4,8,1,X,3

        grid.setValue(0,0, TWO);
        grid.setValue(0,5, SEVEN);

        grid.setValue(1,0, FOUR);
        grid.setValue(1,1, FIVE);
        grid.setValue(1,8, TWO);

        grid.setValue(2,1, ONE);
        grid.setValue(2,5, FOUR);
        grid.setValue(2,7, FIVE);
        grid.setValue(2,8, NINE);


        grid.setValue(3,0,SIX);
        grid.setValue(3,6,NINE);
        grid.setValue(3,7,THREE);

        grid.setValue(4,0,EIGHT);
        grid.setValue(4,3,NINE);
        grid.setValue(4,5,SIX);
        grid.setValue(4,8,FOUR);

        grid.setValue(5,1,NINE);
        grid.setValue(5,2,ONE);
        grid.setValue(5,8,SIX);


        grid.setValue(6,0,FOUR);
        grid.setValue(6,1,SEVEN);
        grid.setValue(6,3,ONE);
        grid.setValue(6,7,NINE);

        grid.setValue(7,0,FIVE);
        grid.setValue(7,7,FOUR);
        grid.setValue(7,8,EIGHT);

        grid.setValue(8,3,FIVE);
        grid.setValue(8,6,ONE);
        grid.setValue(8,8,THREE);
        return grid;
    }
}