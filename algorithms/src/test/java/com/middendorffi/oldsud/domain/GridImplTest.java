package com.middendorffi.oldsud.domain;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hdavis on 21/06/2018.
 */
public class GridImplTest {
    private GridImpl grid;

    @Before
    public void setup() {
        grid = new GridImpl();
    }

    @Test
    public void testBlankGrid() {
        List<Box> blankBoxes = addBlankBoxes();

        assertEquals(blankBoxes,grid.getBoxes());
    }

    private List<Box> addBlankBoxes() {
        List<Box> blankBoxes = Lists.newArrayList();
        for (int i = 0; i < Grid.COUNT; i++) {
            blankBoxes.add(new Box());
        }
        return blankBoxes;
    }
}