package com.middendorffi.work.domain;

import com.google.common.base.Objects;

/**
 * Created by hdavis on 26/01/2019.
 */
public class GroundLevel implements Level {
    private int value = 432;

    public LevelType getType() {
        return LevelType.GROUND;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroundLevel)) return false;
        GroundLevel that = (GroundLevel) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public int compareTo(Level o) {
        return Integer.compare(this.getType().ordinal(),o.getType().ordinal());
    }
}
