package com.middendorffi.sudoku.controller;

import com.google.common.collect.Lists;
import com.middendorffi.sudoku.domain.*;

import java.util.List;

import static com.middendorffi.sudoku.domain.Group.GROUP_LENGTH;

/**
 * Created by hdavis on 09/08/2018.
 */
public class RationaliseGroupSolver implements GroupSolver {
    public void solve(Group group) {

        List<Value> completedValues = getCompletedValues(group);

        if (completedValues.size() == GROUP_LENGTH) {
            return;
        }

        removeAlreadyCompletedValues(group, completedValues);
    }

    public List<Value> getCompletedValues(Group group) {
        List<Value> completedValues = Lists.newArrayList();

        for (int i = 0; i < GROUP_LENGTH; i++) {
            Entry entry = group.getEntry(i);

            if (entry instanceof CompleteEntry) {
                CompleteEntry completeEntry = (CompleteEntry) entry;

                completedValues.add(completeEntry.getValue());
            }
        }
        return completedValues;
    }

    private void removeAlreadyCompletedValues(Group group, List<Value> completedValues) {
        for (int i = 0; i < GROUP_LENGTH; i++) {
            Entry entry = group.getEntry(i);

            if (entry instanceof IncompleteEntry) {
                IncompleteEntry incompleteEntry = (IncompleteEntry) entry;

                incompleteEntry.getPotentials().removeAll(completedValues);
            }
        }

    }
}
