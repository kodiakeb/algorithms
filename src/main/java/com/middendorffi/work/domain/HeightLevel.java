package com.middendorffi.work.domain;

import com.google.common.base.Objects;

/**
 * Created by hdavis on 26/01/2019.
 */
public class HeightLevel implements Level {

    private final double value;

    public HeightLevel(double value) {
        this.value = value;
    }
    public LevelType getType() {
        return LevelType.HEIGHT;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(Level o) {
        int typeCompare = Integer.compare(this.getType().ordinal(),o.getType().ordinal());
        if (typeCompare == 0) {
            return Double.compare(this.getValue(),o.getValue());
        }
        return typeCompare;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeightLevel)) return false;
        HeightLevel that = (HeightLevel) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
