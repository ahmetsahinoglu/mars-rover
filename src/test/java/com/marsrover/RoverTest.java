package com.marsrover;

import com.marsrover.domain.FaceDirection;
import com.marsrover.domain.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RoverTest {
    private Rover rover;
    private static final int X_COORDINATE = 1;
    private static final int Y_COORDINATE = 2;
    private static final FaceDirection FACE_DIRECTION = FaceDirection.N;

    @Before
    public void init() {
        rover = new Rover(X_COORDINATE, Y_COORDINATE, FACE_DIRECTION);
    }

    @Test
    public void shouldNewRoverInstanceWithGivenParameters() {
        assertEquals(rover.getFaceDirection(), FACE_DIRECTION);
        assertEquals(rover.getxCoordinate(), X_COORDINATE);
        assertEquals(rover.getYCoordinate(), Y_COORDINATE);
    }
}
