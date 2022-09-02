package com.middendorffi.sudoku.exceptions;

/**
 * Created by hdavis on 21/06/2018.
 */
public class InvalidIndexException extends RuntimeException {
    public InvalidIndexException(String message) {
        super(message);
    }
}
