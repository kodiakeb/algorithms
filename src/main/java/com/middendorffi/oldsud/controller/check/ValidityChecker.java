package com.middendorffi.oldsud.controller.check;

import com.google.common.collect.Lists;
import com.middendorffi.oldsud.domain.Grid;

import java.util.List;

/**
 * Created by hdavis on 26/06/2018.
 */
public class ValidityChecker {
    private final List<Checker> checkers;

    public ValidityChecker(List<Checker> checkers) {
        this.checkers = (checkers == null)? Lists.<Checker>newArrayList():checkers;
    }

    public boolean check(Grid grid) {
        for (Checker checker: checkers) {
            boolean check = checker.check(grid);
            if (!check) {
                return false;
            }
        }

        return true;
    }
}
