package com.middendorffi.oldsud;

import com.middendorffi.oldsud.csv.CSVReader;
import com.middendorffi.oldsud.domain.Grid;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by hdavis on 26/06/2018.
 */
public class TestFixtures {
    public static Grid readInputGrid() throws FileNotFoundException {
        return readGrid("src/test/resources/input.csv");
    }

    public static Grid readCompleteGrid() throws FileNotFoundException {
        return readGrid("src/test/resources/complete.csv");
    }

    public static Grid readGrid(String filename) throws FileNotFoundException {
        CSVReader reader = new CSVReader();

        FileReader fileReader  = new FileReader(filename);

        return reader.readCsv(fileReader);
    }
}
