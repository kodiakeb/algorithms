package com.middendorffi.work.domain;

import com.google.common.base.Objects;
import com.middendorffi.sudoku.domain.CompleteEntry;

/**
 * Created by hdavis on 26/01/2019.
 */
public class ForecastOffset implements Comparable<ForecastOffset> {
    private final int offsetInMins;

    public ForecastOffset(int offsetInMins) {
        this.offsetInMins = offsetInMins;
    }

    public int getOffsetInMins() {
        return offsetInMins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForecastOffset)) return false;
        ForecastOffset that = (ForecastOffset) o;
        return offsetInMins == that.offsetInMins;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(offsetInMins);
    }

    @Override
    public int compareTo(ForecastOffset o) {
        return Integer.compare(this.offsetInMins,o.offsetInMins);
    }
}
