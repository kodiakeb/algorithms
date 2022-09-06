package com.middendorffi.work.domain;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hdavis on 26/01/2019.
 */
public class TestUtils {

    public static void assertCoveragesEquals(List<Coverage> expected,List<Coverage> actual) {
        assertEquals(expected.size(),actual.size());

        for (int i = 0; i < expected.size();i++) {
            assertEquals(expected.get(i).getSource(),actual.get(i).getSource());
            assertEquals(expected.get(i).getParameter(),actual.get(i).getParameter());
            assertLevelsEquals(expected.get(i).getLevels(),actual.get(i).getLevels());
            assertForecastOffsetsEquals(expected.get(i).getOffsets(),actual.get(i).getOffsets());

        }
    }

    public static void assertLevelsEquals(List<Level> expected,List<Level> actual) {
        assertEquals(expected.size(),actual.size());

        for (int i = 0; i < expected.size();i++) {
            assertEquals(expected.get(i),actual.get(i));
        }
    }

    public static void assertForecastOffsetsEquals(List<ForecastOffset> expected,List<ForecastOffset> actual) {
        assertEquals(expected.size(),actual.size());

        for (int i = 0; i < expected.size();i++) {
            assertEquals(expected.get(i),actual.get(i));
        }
    }
}
