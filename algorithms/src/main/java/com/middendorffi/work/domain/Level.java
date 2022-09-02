package com.middendorffi.work.domain;

/**
 * Created by hdavis on 26/01/2019.
 */
public interface Level extends Comparable<Level> {
    LevelType getType();
    double getValue();
}
