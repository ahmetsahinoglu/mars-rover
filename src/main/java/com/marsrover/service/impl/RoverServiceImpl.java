package com.marsrover.service.impl;

import com.marsrover.domain.FaceDirection;
import com.marsrover.domain.Mars;
import com.marsrover.domain.MoveType;
import com.marsrover.domain.Rover;
import com.marsrover.service.RoverService;

public class RoverServiceImpl implements RoverService {

    @Override
    public void changeDirection(Rover rover, MoveType rotateDirection) {
        switch (rover.getFaceDirection()) {
            case N:
                if (rotateDirection.equals(MoveType.L)) {
                    rover.setFaceDirection(FaceDirection.W);
                } else {
                    rover.setFaceDirection(FaceDirection.E);
                }
                break;
            case W:
                if (rotateDirection.equals(MoveType.L)) {
                    rover.setFaceDirection(FaceDirection.S);
                } else {
                    rover.setFaceDirection(FaceDirection.N);
                }
                break;
            case E:
                if (rotateDirection.equals(MoveType.L)) {
                    rover.setFaceDirection(FaceDirection.N);
                } else {
                    rover.setFaceDirection(FaceDirection.S);
                }
                break;
            case S:
                if (rotateDirection.equals(MoveType.L)) {
                    rover.setFaceDirection(FaceDirection.E);
                } else {
                    rover.setFaceDirection(FaceDirection.W);
                }
                break;
        }
    }

    @Override
    public void move(Rover rover) {
        switch (rover.getFaceDirection()) {
            case N:
                rover.setYCoordinate(rover.getYCoordinate() + 1);
                break;
            case W:
                rover.setxCoordinate(rover.getxCoordinate() - 1);
                break;
            case E:
                rover.setxCoordinate(rover.getxCoordinate() + 1);
                break;
            case S:
                rover.setYCoordinate(rover.getYCoordinate() - 1);
                break;
        }
    }

    @Override
    public boolean canMove(Rover rover, Mars mars) {
        switch (rover.getFaceDirection()) {
            case N:
                return rover.getYCoordinate() < mars.getySize();
            case W:
                return rover.getxCoordinate() > 0;
            case E:
                return rover.getxCoordinate() < mars.getxSize();
            case S:
                return rover.getYCoordinate() > 0;
        }
        return false;
    }
}
