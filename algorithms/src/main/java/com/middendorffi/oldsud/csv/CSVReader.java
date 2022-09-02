package com.middendorffi.oldsud.csv;

import com.middendorffi.oldsud.domain.Grid;
import com.middendorffi.oldsud.domain.GridImpl;
import com.middendorffi.oldsud.domain.State;
import com.middendorffi.oldsud.exceptions.CountException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.middendorffi.oldsud.domain.Grid.COUNT;
import static com.middendorffi.oldsud.domain.State.valueOf;

/**
 * Created by hdavis on 21/06/2018.
 */
public class CSVReader {
    public Grid readCsv(FileReader fileReader) {
        GridImpl grid = new GridImpl();

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int lineNumber = 0;

        try {

            br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {


                // use comma as separator
                String[] fields = line.split(cvsSplitBy);

                if (fields.length != Grid.COUNT) {
                    throw new CountException("We require " + COUNT + " fields");
                }

                // TODO this is horrific
                switch (lineNumber) {
                    case 1:
                        setValues(grid, fields, 0, 0);
                        break;
                    case 2:
                        setValues(grid, fields, 0, 3);
                        break;
                    case 3:
                        setValues(grid, fields, 0, 6);
                        break;
                    case 4:
                        setValues(grid, fields, 3, 0);
                        break;
                    case 5:
                        setValues(grid, fields, 3, 3);
                        break;
                    case 6:
                        setValues(grid, fields, 3, 6);
                        break;
                    case 7:
                        setValues(grid, fields, 6, 0);
                        break;
                    case 8:
                        setValues(grid, fields, 6, 3);
                        break;
                    case 9:
                        setValues(grid, fields, 6, 6);
                        break;
                    default:
                        break;

                }

                lineNumber++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return grid;
    }

    private void setValues(GridImpl grid, String[] fields, int boxStartIndex, int valueStartIndex) {
        setValue(grid, fields[0], boxStartIndex, valueStartIndex);
        setValue(grid, fields[1], boxStartIndex, valueStartIndex + 1);
        setValue(grid, fields[2], boxStartIndex, valueStartIndex + 2);
        setValue(grid, fields[3], boxStartIndex + 1, valueStartIndex);
        setValue(grid, fields[4], boxStartIndex + 1, valueStartIndex + 1);
        setValue(grid, fields[5], boxStartIndex + 1, valueStartIndex + 2);
        setValue(grid, fields[6], boxStartIndex + 2, valueStartIndex);
        setValue(grid, fields[7], boxStartIndex + 2, valueStartIndex + 1);
        setValue(grid, fields[8], boxStartIndex + 2, valueStartIndex + 2);
    }

    private void setValue(GridImpl grid, String field, int boxIndex, int valueIndex) {
        // TODO yuk
        for (State v : State.values()) {
            if (v.getLabel().equals(field)) {
                grid.setValue(boxIndex, valueIndex, v);
            }
        }

    }
}
