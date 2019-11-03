package com.marsrover.util;

import com.marsrover.domain.Mars;

import java.util.InputMismatchException;

public class ValidationUtilDev implements ValidationUtil {

    public void checkNegativeValues(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 0 || yCoordinate < 0) {
            throw new InputMismatchException("Coordinates must be positive!");
        }
    }

    public void checkMaxValues(int xCoordinate, int yCoordinate, Mars mars) {
        if (xCoordinate > mars.getxSize() || yCoordinate > mars.getySize()) {
            throw new InputMismatchException("Rover coordinates must be in range of Nasa's research field in Mars!");
        }
    }
}
