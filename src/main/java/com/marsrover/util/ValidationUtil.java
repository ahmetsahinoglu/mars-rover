package com.marsrover.util;

import com.marsrover.domain.Mars;

public interface ValidationUtil {

    void checkNegativeValues(int xCoordinate, int yCoordinate);

    void checkMaxValues(int xCoordinate, int yCoordinate, Mars mars);
}
