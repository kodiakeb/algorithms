package com.middendorffi.oldsud.controller.check;

import com.middendorffi.oldsud.domain.Grid;
import com.middendorffi.oldsud.domain.Group;
import com.middendorffi.oldsud.domain.State;
import com.middendorffi.oldsud.domain.Value;

import java.util.List;

/**
 * Created by hdavis on 10/07/2018.
 */
public abstract class GroupChecker implements Checker {
    public boolean check(Group group) {
        List<State> allStates = Value.fullPotentialStates();
        for (int i = 0; i < Grid.COUNT; i++) {
            State state = group.getValue(i);
            if (!allStates.contains(state)) {
                return false;
            }
            allStates.remove(state);
        }
        return true;
    }
}
