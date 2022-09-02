package com.middendorffi.oldsud.controller.check;

import com.middendorffi.oldsud.domain.*;

import java.util.List;

/**
 * Created by hdavis on 10/07/2018.
 */
public class AllBoxesChecker extends GroupChecker {
    public boolean check(Grid grid) {
        List<Box> boxList = grid.getBoxes();

        for (Box box:boxList) {
            if (!check(box)) {
                return false;
            }
        }
        return false;
    }
}
