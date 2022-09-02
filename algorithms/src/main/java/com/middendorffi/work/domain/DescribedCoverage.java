package com.middendorffi.work.domain;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// TODO this is way too much for capabilites. Probably need NWPCapability
// tp have a list of Coverage but something uses this idea when it builds it at
// start.
public class DescribedCoverage {
    private static final String DEFAULT_SOURCE = "default";
    private Map<String, Set<Pair>> map;
    private Parameter parameter;

    public DescribedCoverage() {
        map = Maps.newHashMap();

    }

    public DescribedCoverage(Parameter parameter) {
        this();
        this.parameter = parameter;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public DescribedCoverage(Coverage coverage) {
        this();
        addCoverage(coverage);
    }

    public DescribedCoverage(List<Coverage> coverages) {
        this();
        addCoverages(coverages);
    }

    public DescribedCoverage(Coverage... coverages) {
        this(Lists.newArrayList(coverages));
    }

    public void addCoverage(Coverage coverage) {
        if (coverage == null) {
            return;
        }
        if (parameter == null) {
            parameter = coverage.getParameter();
        }
        if (coverage.getParameter().equals(parameter)) {
            addCoverageToSet(coverage);
        }
    }

    private void addCoverageToSet(Coverage coverage) {
        String source = coverageToSource(coverage);
        Set<Pair> coverageSetAll = extractPairs(coverage);

        Set<Pair> coverageSet = removeAnyExisting(coverageSetAll);

        if (coverageSet.size() > 0) {
            if (!map.containsKey(source)) {

                map.put(source, coverageSet);
            } else {
                Set<Pair> existingSet = map.get(source);
                existingSet.addAll(coverageSet);
            }
        }
    }

    private Set<Pair> removeAnyExisting(Set<Pair> coverageSetAll) {
        return coverageSetAll.stream().filter(x -> !pairAlreadyInMap(x)).collect(Collectors.toSet());
    }

    private boolean pairAlreadyInMap(Pair pair) {
        return map.entrySet().stream().filter(e -> e.getValue().contains(pair)).count() > 0L;
    }

    private Set<Pair> extractPairs(Coverage coverage) {
        Set<Pair> pairs = Sets.newHashSet();

        for (Level level : coverage.getLevels()) {
            for (ForecastOffset forecastOffset : coverage.getOffsets()) {
                pairs.add(new Pair(level, forecastOffset));
            }
        }

        return pairs;
    }

    private String coverageToSource(Coverage coverage) {
        return coverage.getSource() == null ? DEFAULT_SOURCE : coverage.getSource();
    }

    private String reverseSource(String keySource) {
        return keySource.equals(DEFAULT_SOURCE) ? null : keySource;
    }

    public void addCoverages(List<Coverage> coverages) {
        if (coverages == null || coverages.size() == 0) {
            return;
        }
        coverages.stream().forEach(c -> addCoverage(c));
    }

    public void addCoverages(Coverage... coverages) {
        if (coverages == null || coverages.length == 0) {
            return;
        }
        addCoverages(Lists.newArrayList(coverages));
    }

    public List<Coverage> getCoverages() {
        return rebuildCoverages();
    }

    private List<Coverage> rebuildCoverages() {
        List<Coverage> output = Lists.newArrayList();

        for (String source : map.keySet()) {
            List<Coverage> sourceCoverages = rebuildCoverages(source);
            output.addAll(sourceCoverages);
        }
        return output;
    }

    private List<Coverage> rebuildCoverages(String source) {
        List<Coverage> output = Lists.newArrayList();

        Set<Pair> set = map.get(source);
        if (set != null && set.size() > 0) {

            // This is a nonsensical way to do this
            List<Level> levels = set.stream().map(p -> p.getLevel()).distinct().sorted().collect(Collectors.toList());
            List<ForecastOffset> forecastOffsets = set.stream().map(p -> p.getForecastOffset()).distinct().sorted().collect(Collectors.toList());

            // Get what forecast offsets we have for what levels
            Map<Level, List<ForecastOffset>> levelOffsets = Maps.newHashMap();
            for (Level level : levels) {
                List<ForecastOffset> levelOffsetList = set.stream().filter(p -> p.getLevel().equals(level)).map(p -> p.getForecastOffset()).sorted().collect(Collectors.toList());

                levelOffsets.put(level, levelOffsetList);
            }

            // Get how many options we have for forecast offsets
            List<List<ForecastOffset>> optionOffsetLists = levelOffsets.values().stream().distinct().collect(Collectors.toList());

            for (List<ForecastOffset> optionOffsets : optionOffsetLists) {
                List<Level> optionLevels = levelOffsets.entrySet().stream().filter(z -> z.getValue().equals(optionOffsets)).map(x -> x.getKey()).sorted().collect(Collectors.toList());
                output.add(new Coverage(parameter, optionLevels, optionOffsets, reverseSource(source)));

            }
//
//            for (Map.Entry<Level,List<ForecastOffset>> entry: levelOffsets.entrySet()) {
//                output.add(new Coverage(parameter,Lists.newArrayList(entry.getKey()),entry.getValue(),reverseSource(source)));
//            }
//            for (Pair pair : set) {
//                output.add(new Coverage(parameter, Lists.newArrayList(pair.getLevel()), Lists.newArrayList(pair.getForecastOffset()), reverseSource(source)));
//            }
        }

        // TODO need to look at Coverage to see what search order should be
        return output;
    }


    public static class Pair {
        private Level level;
        private ForecastOffset forecastOffset;

        public Pair(Level level, ForecastOffset forecastOffset) {
            this.level = level;
            this.forecastOffset = forecastOffset;
        }

        public Level getLevel() {
            return level;
        }

        public void setLevel(Level level) {
            this.level = level;
        }

        public ForecastOffset getForecastOffset() {
            return forecastOffset;
        }

        public void setForecastOffset(ForecastOffset forecastOffset) {
            this.forecastOffset = forecastOffset;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return Objects.equal(level, pair.level) &&
                    Objects.equal(forecastOffset, pair.forecastOffset);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(level, forecastOffset);
        }

        @Override
        public String toString() {
            return "Pair{" + level +
                    ", " + forecastOffset +
                    '}';
        }
    }
}
