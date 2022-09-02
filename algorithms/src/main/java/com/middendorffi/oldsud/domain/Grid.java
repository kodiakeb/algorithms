package com.middendorffi.oldsud.domain;

import java.util.List;

/**
 * Created by hdavis on 21/06/2018.
 */
public interface Grid {
    int COUNT = 9;
    List<Box> getBoxes();
    List<Row> getRows();
    List<Column> getColumns();
}
