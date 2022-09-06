package com.middendorffi.sudoku.domain;

import com.google.common.base.Objects;
import com.middendorffi.sudoku.exceptions.InvalidIndexException;

import static com.middendorffi.sudoku.domain.Group.GROUP_LENGTH;

/**
 * Underlying grid. 0,0 is bottom left corner.
 * Created by hdavis on 06/08/2018.
 */
public class Grid {
    // [x][y]
    private final Entry[][] entries;

    public Grid() {
        entries = new Entry[GROUP_LENGTH][GROUP_LENGTH];
        for (int i = 0; i < GROUP_LENGTH; i++) {
            for (int j = 0; j < GROUP_LENGTH; j++) {
                entries[i][j] = new UnsolvedEntry();
            }
        }
    }

    public Grid(Row[] rows) {
        this();

        int size = rows.length;
        if (size < 0 || size > GROUP_LENGTH) {
            throw new InvalidIndexException("There must be " + GROUP_LENGTH + " rows");
        }

        for (int j = 0; j < GROUP_LENGTH; j++) {
            for (int i = 0; i < GROUP_LENGTH; i++) {
                entries[i][j] = rows[j].getEntry(i);
            }
        }
    }

    public Grid(Grid grid) {
        this();

        for (int i = 0; i < GROUP_LENGTH; i++) {
            for (int j = 0; j < GROUP_LENGTH; j++) {
                Entry entry = grid.getEntry(i, j);

                switch (entry.getState()) {
                    case GIVEN:
                        entries[i][j] = new GivenEntry(entry.value);
                        break;
                    case UNSOLVED:
                        // Already initiallised to unsolved
                        break;
                    case SOLVED:
                        entries[i][j] = new SolvedEntry(entry.value);
                        break;
                }
            }
        }
    }

    public void setEntry(int x, int y, Entry entry) {
        checkIndex(x);
        checkIndex(y);

        entries[x][y] = entry;
    }


    public Entry getEntry(int x, int y) {
        checkIndex(x);
        checkIndex(y);

        return entries[x][y];
    }

    public void setRowEntry(int y, Row row) {
        checkIndex(y);
        for (int i = 0; i < GROUP_LENGTH; i++) {
            entries[i][y] = row.getEntry(i);
        }
    }

    public Row getRowEntry(int y) {
        checkIndex(y);

        Row row = new Row();

        for (int i = 0; i < GROUP_LENGTH; i++) {
            row.setEntry(i, entries[i][y]);
        }

        return row;
    }

    public void setColumnEntry(int x, Column column) {
        checkIndex(x);
        for (int j = 0; j < GROUP_LENGTH; j++) {
            entries[x][j] = column.getEntry(j);
        }
    }

    public Column getColumnEntry(int x) {
        checkIndex(x);

        Column column = new Column();

        for (int j = 0; j < GROUP_LENGTH; j++) {
            column.setEntry(j, entries[x][j]);
        }

        return column;
    }

    public int total() {
        int total = 0;

        for (int i = 0; i < GROUP_LENGTH; i++) {
            for (int j = 0; j < GROUP_LENGTH; j++) {
                total += entries[i][j].getValue().ordinal();
            }
        }
        return total;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= GROUP_LENGTH) {
            throw new InvalidIndexException("There are only " + GROUP_LENGTH + " values allowed");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grid)) return false;
        Grid grid = (Grid) o;
        return Objects.equal(entries, grid.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(entries);
    }
}
