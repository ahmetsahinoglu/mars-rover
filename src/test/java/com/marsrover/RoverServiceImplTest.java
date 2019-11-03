package com.marsrover;

import com.marsrover.domain.FaceDirection;
import com.marsrover.domain.Mars;
import com.marsrover.domain.MoveType;
import com.marsrover.domain.Rover;
import com.marsrover.service.RoverService;
import com.marsrover.service.impl.RoverServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoverServiceImplTest {

    private RoverService roverService;
    private Mars mars;
    private Rover rover;

    private static final int MARS_X_SIZE = 5;
    private static final int MARS_Y_SIZE = 5;
    private static final int X_COORDINATE = 1;
    private static final int Y_COORDINATE = 2;
    private static final FaceDirection FACE_DIRECTION = FaceDirection.N;

    @Before
    public void init() {
        roverService = new RoverServiceImpl();
        mars = new Mars(MARS_X_SIZE, MARS_Y_SIZE);
        rover = new Rover(X_COORDINATE, Y_COORDINATE, FACE_DIRECTION);
    }

    @Test
    public void shouldChangeDirection() {
        assertEquals(rover.getFaceDirection(), FaceDirection.N);
        roverService.changeDirection(rover, MoveType.L);
        assertEquals(rover.getFaceDirection(), FaceDirection.W);

        roverService.changeDirection(rover, MoveType.L);
        assertEquals(rover.getFaceDirection(), FaceDirection.S);

        roverService.changeDirection(rover, MoveType.L);
        assertEquals(rover.getFaceDirection(), FaceDirection.E);

        roverService.changeDirection(rover, MoveType.L);
        assertEquals(rover.getFaceDirection(), FaceDirection.N);

        roverService.changeDirection(rover, MoveType.R);
        assertEquals(rover.getFaceDirection(), FaceDirection.E);

        roverService.changeDirection(rover, MoveType.R);
        assertEquals(rover.getFaceDirection(), FaceDirection.S);

        roverService.changeDirection(rover, MoveType.R);
        assertEquals(rover.getFaceDirection(), FaceDirection.W);
    }

    @Test
    public void shouldMove() {
        assertEquals(rover.getFaceDirection(), FaceDirection.N);
        assertEquals(rover.getYCoordinate(), 2);
        roverService.move(rover);
        assertEquals(rover.getYCoordinate(), 3);

        rover.setFaceDirection(FaceDirection.W);
        assertEquals(rover.getxCoordinate(), 1);
        roverService.move(rover);
        assertEquals(rover.getxCoordinate(), 0);

        rover.setFaceDirection(FaceDirection.E);
        assertEquals(rover.getxCoordinate(), 0);
        roverService.move(rover);
        assertEquals(rover.getxCoordinate(), 1);

        rover.setFaceDirection(FaceDirection.S);
        assertEquals(rover.getYCoordinate(), 3);
        roverService.move(rover);
        assertEquals(rover.getYCoordinate(), 2);
    }

    @Test
    public void shouldNotMoveWithUnacceptableParams() {
        assertEquals(rover.getFaceDirection(), FaceDirection.N);
        mars.setySize(2);
        assertEquals(mars.getySize(), 2);
        assertFalse(roverService.canMove(rover, mars));

        rover.setFaceDirection(FaceDirection.W);
        rover.setxCoordinate(0);
        assertEquals(rover.getFaceDirection(), FaceDirection.W);
        assertEquals(rover.getxCoordinate(), 0);
        roverService.canMove(rover, mars);
        assertFalse(roverService.canMove(rover, mars));

        rover.setFaceDirection(FaceDirection.E);
        mars.setxSize(0);
        assertEquals(rover.getFaceDirection(), FaceDirection.E);
        assertEquals(mars.getxSize(), 0);
        roverService.canMove(rover, mars);
        assertFalse(roverService.canMove(rover, mars));

        rover.setFaceDirection(FaceDirection.S);
        rover.setYCoordinate(0);
        assertEquals(rover.getFaceDirection(), FaceDirection.S);
        assertEquals(rover.getYCoordinate(), 0);
        roverService.canMove(rover, mars);
        assertFalse(roverService.canMove(rover, mars));
    }

    @Test
    public void shouldMoveWithAcceptableParams() {
        assertEquals(rover.getFaceDirection(), FaceDirection.N);
        assertEquals(rover.getYCoordinate(), 2);
        assertEquals(mars.getySize(), 5);
        assertTrue(roverService.canMove(rover, mars));

        rover.setFaceDirection(FaceDirection.W);
        assertEquals(rover.getxCoordinate(), 1);
        assertEquals(rover.getFaceDirection(), FaceDirection.W);
        assertTrue(roverService.canMove(rover, mars));

        rover.setFaceDirection(FaceDirection.E);
        assertEquals(rover.getFaceDirection(), FaceDirection.E);
        assertEquals(rover.getYCoordinate(), 2);
        assertEquals(mars.getySize(), 5);
        assertTrue(roverService.canMove(rover, mars));

        rover.setFaceDirection(FaceDirection.S);
        assertEquals(rover.getFaceDirection(), FaceDirection.S);
        assertEquals(rover.getYCoordinate(), 2);
        assertTrue(roverService.canMove(rover, mars));

    }
}
