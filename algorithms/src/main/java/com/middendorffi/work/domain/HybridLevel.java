package com.middendorffi.work.domain;

import com.google.common.base.Objects;

/**
 * Created by hdavis on 26/01/2019.
 */
public class HybridLevel implements Level {
    private final int value;

    public HybridLevel(int value) {
        this.value = value;
    }
    public LevelType getType() {
        return LevelType.HYBRID;
    }

    public double getValue() {
        return value;
    }


    @Override
    public int compareTo(Level o) {
        int typeCompare = Integer.compare(this.getType().ordinal(),o.getType().ordinal());
        if (typeCompare == 0) {
            HybridLevel other = (HybridLevel) o;
            return Integer.compare(this.value,other.value);
        }
        return typeCompare;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HybridLevel)) return false;
        HybridLevel that = (HybridLevel) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
