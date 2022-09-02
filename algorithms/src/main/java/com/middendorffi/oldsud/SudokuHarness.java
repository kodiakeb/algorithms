package com.middendorffi.oldsud;

import com.google.common.collect.Lists;
import com.middendorffi.oldsud.controller.GridWriter;
import com.middendorffi.oldsud.controller.GridWriterImpl;
import com.middendorffi.oldsud.controller.SudokuController;
import com.middendorffi.oldsud.controller.check.*;
import com.middendorffi.oldsud.controller.solve.SolverFactory;
import com.middendorffi.oldsud.csv.CSVReader;
import com.middendorffi.oldsud.domain.Grid;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by hdavis on 20/06/2018.
 */
public class SudokuHarness {
    public static void main(String[] args) throws FileNotFoundException {
        SudokuController controller = createController();

        GridWriter gridWriter = new GridWriterImpl();

        Grid input = new CSVReader().readCsv(new FileReader("/Users/hdavis/Documents/GitHub/Algorithms/algorithms/src/main/resources/input.csv"));

        System.out.println("SUDOKU inputs");
        System.out.println(gridWriter.write(input));

        Grid result = controller.solve(input);

        System.out.println("\nSUDOKU result");
        System.out.println(gridWriter.write(result));
    }

    private static SudokuController createController() {
        SudokuController controller = new SudokuController();
        controller.setChecker(createValidityChecker());
        controller.setSolverFactory(createSolverFactory());
        return controller;
    }

    private static ValidityChecker createValidityChecker() {
        Checker completeChecker = new CompleteChecker();
        Checker boxesChecker = new AllBoxesChecker();
        Checker rowsChecker = new AllRowsChecker();
        Checker columnsChecker = new AllColumnsChecker();
        return new ValidityChecker(Lists.newArrayList(completeChecker,boxesChecker,boxesChecker,rowsChecker,columnsChecker));
    }

    private static SolverFactory createSolverFactory() {
        return new SolverFactory();
    }
}
