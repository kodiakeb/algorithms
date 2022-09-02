package com.middendorffi.oldsud.domain;

/**
 * Created by hdavis on 21/06/2018.
 */
public enum State {
    ONE("1"),TWO("2"),THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8"),NINE("9"),EMPTY(" ");

    private String label;

    State(String label) {
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
