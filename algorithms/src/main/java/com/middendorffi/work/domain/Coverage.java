package com.middendorffi.work.domain;

import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by hdavis on 26/01/2019.
 */
public class Coverage {
    private final Parameter parameter;
    private final List<Level> levels;
    private final List<ForecastOffset> offsets;
    private final String source;

    public Coverage(Parameter parameter,List<Level> levels,List<ForecastOffset> offsets,String source) {
        this.parameter = parameter;
        this.levels = levels;
        this.offsets = offsets;
        this.source = source;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public List<ForecastOffset> getOffsets() {
        return offsets;
    }

    public String getSource() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coverage)) return false;
        Coverage coverage = (Coverage) o;
        return parameter == coverage.parameter &&
                Objects.equal(levels, coverage.levels) &&
                Objects.equal(offsets, coverage.offsets) &&
                Objects.equal(source, coverage.source);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(parameter, levels, offsets, source);
    }
}
