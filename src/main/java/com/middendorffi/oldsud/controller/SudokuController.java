package com.middendorffi.oldsud.controller;

import com.middendorffi.oldsud.controller.check.ValidityChecker;
import com.middendorffi.oldsud.controller.solve.Solver;
import com.middendorffi.oldsud.controller.solve.SolverFactory;
import com.middendorffi.oldsud.domain.Grid;
import com.middendorffi.oldsud.domain.Method;

import java.util.List;

import static com.middendorffi.oldsud.domain.Method.BRUTEFORCE;

/**
 * Created by hdavis on 21/06/2018.
 */
public class SudokuController {
    private ValidityChecker checker;
    private SolverFactory solverFactory;
    private Method defaultMethod = BRUTEFORCE;

    public Grid solve(Grid input, Method method) {
        Grid result = input;

        List<Solver> solvers = solverFactory.createSolvers(method);
        for (Solver solver: solvers) {
            if (!checker.check(result)) {
                solver.solve(result);
            }
        }

        return result;
    }

    public Grid solve(Grid input) {
        return solve(input,defaultMethod);
    }

    public void setChecker(ValidityChecker checker) {
        this.checker = checker;
    }

    public void setDefaultMethod(Method defaultMethod) {
        this.defaultMethod = defaultMethod;
    }

    public void setSolverFactory(SolverFactory solverFactory) {
        this.solverFactory = solverFactory;
    }
}