package com.middendorffi.oldsud.controller.check;

import com.middendorffi.oldsud.domain.Box;
import com.middendorffi.oldsud.domain.Grid;
import com.middendorffi.oldsud.domain.State;

/**
 * Check if we have numbers in each slot.
 * DOES NOT CHECK VALIDITY
 * Created by hdavis on 26/06/2018.
 */
public class CompleteChecker implements Checker {
    public boolean check(Grid grid) {

        for (Box box : grid.getBoxes()) {
            for (State state : box.getStates()) {
                if (state.equals(State.EMPTY)) {
                    return false;
                }
            }
        }

        return true;
    }
}
