package com.marsrover.service;

import com.marsrover.domain.Mars;
import com.marsrover.domain.MoveType;
import com.marsrover.domain.Rover;

public interface RoverService {
    void changeDirection(Rover rover, MoveType rotateDirection);

    void move(Rover rover);

    boolean canMove(Rover rover, Mars mars);
}
