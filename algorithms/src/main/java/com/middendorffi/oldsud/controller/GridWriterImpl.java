package com.middendorffi.oldsud.controller;

import com.middendorffi.oldsud.domain.Box;
import com.middendorffi.oldsud.domain.Grid;

import java.util.List;

/**
 * Created by hdavis on 21/06/2018.
 */
public class GridWriterImpl implements GridWriter {
    public static final String HORIZONTAL = "-------------------------\n";
    public static final String BLANK_LINE = "|       |       |       |\n";
    public static final String VERTICAL = "|";
    public static final String GAP = " ";
    public static final String INTERMEDIATE = " | ";
    public static final String END = " |\n";

    private int[][] indexArray = new int[][]{{0,1,2},{3,4,5},{6,7,8}};

    public String write(Grid grid) {
        if (!isGridWritable(grid)) {
            return "No grid";
        }

        StringBuilder sb = new StringBuilder();

        // TODO clean this up

        sb.append(HORIZONTAL);

        List<Box> boxes = grid.getBoxes();

        addBoxes(sb,boxes,indexArray[0]);
        addBoxes(sb,boxes,indexArray[1]);
        addBoxes(sb,boxes,indexArray[2]);


        return sb.toString();
    }

    private void addBoxes(StringBuilder sb,List<Box> boxes,int[] boxIndices) {

        addBoxRow(sb,boxes,boxIndices,indexArray[0]);
        addBoxRow(sb,boxes,boxIndices,indexArray[1]);
        addBoxRow(sb,boxes,boxIndices,indexArray[2]);
        sb.append(HORIZONTAL);
    }

    private void addBoxRow(StringBuilder sb,List<Box> boxes,int[] boxIndices,int[] cellIndices) {
        sb.append(VERTICAL);

        for (int boxIndex : boxIndices) {
            sb.append(GAP);
            for (int cellIndex: cellIndices) {
                sb.append(boxes.get(boxIndex).getValue(cellIndex).getLabel());
                sb.append(GAP);
            }
            sb.append(VERTICAL);
        }
        sb.append("\n");
    }

    private boolean isGridWritable(Grid grid) {
        return grid != null;
    }
}
