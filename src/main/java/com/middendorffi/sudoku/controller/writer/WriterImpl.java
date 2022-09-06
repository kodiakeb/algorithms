package com.middendorffi.sudoku.controller.writer;

import com.middendorffi.sudoku.domain.Grid;
import com.middendorffi.sudoku.domain.Group;
import com.middendorffi.sudoku.domain.Row;

import java.util.List;

import static com.middendorffi.sudoku.domain.Group.GROUP_LENGTH;

/**
 * Created by hdavis on 06/08/2018.
 */
public class WriterImpl implements Writer {
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


        for (int j =0; j < GROUP_LENGTH;j++) {
            addRow(sb,grid.getRowEntry(j));

            if (j == 2 || j == 5 || j ==8) {
                sb.append(HORIZONTAL);
            }
        }

        return sb.toString();
    }

    private void addRow(StringBuilder sb, Row row) {
        sb.append(VERTICAL);
        for (int i = 0; i < GROUP_LENGTH;i++) {

            sb.append(GAP);
            if (i == 3 || i == 6) {
                sb.append(VERTICAL);
                sb.append(GAP);
            }
            sb.append(row.getEntry(i).getValue().getLabel());

        }
        sb.append(END);

//            sb.append(GAP);
//            for (int cellIndex: cellIndices) {
//                sb.append(boxes.get(boxIndex).getValue(cellIndex).getLabel());
//                sb.append(GAP);
//            }
//            sb.append(VERTICAL);
//        }
    }

//    private void addBoxes(StringBuilder sb,List<Box> boxes,int[] boxIndices) {
//
//        addBoxRow(sb,boxes,boxIndices,indexArray[0]);
//        addBoxRow(sb,boxes,boxIndices,indexArray[1]);
//        addBoxRow(sb,boxes,boxIndices,indexArray[2]);
//        sb.append(HORIZONTAL);
//    }
//
//    private void addBoxRow(StringBuilder sb,List<Box> boxes,int[] boxIndices,int[] cellIndices) {
//        sb.append(VERTICAL);
//
//        for (int boxIndex : boxIndices) {
//            sb.append(GAP);
//            for (int cellIndex: cellIndices) {
//                sb.append(boxes.get(boxIndex).getValue(cellIndex).getLabel());
//                sb.append(GAP);
//            }
//            sb.append(VERTICAL);
//        }
//        sb.append("\n");
//    }

    private boolean isGridWritable(Grid grid) {
        return grid != null;
    }
}
