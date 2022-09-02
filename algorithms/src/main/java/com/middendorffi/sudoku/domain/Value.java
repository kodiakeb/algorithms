package com.middendorffi.sudoku.domain;

/**
 * Created by hdavis on 23/07/2018.
 */
public enum Value {
    ONE("1"),TWO("2"),THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8"),NINE("9"),EMPTY(" ");

    private String label;
    public static int NUM_VALUES = values().length -1;

    Value(String label) {
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
