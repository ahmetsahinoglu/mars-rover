package com.marsrover.domain;

public class Rover {
    private int xCoordinate;
    private int YCoordinate;
    private FaceDirection faceDirection;

    public Rover(int xCoordinate, int YCoordinate, FaceDirection faceDirection) {
        this.xCoordinate = xCoordinate;
        this.YCoordinate = YCoordinate;
        this.faceDirection = faceDirection;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return YCoordinate;
    }

    public void setYCoordinate(int YCoordinate) {
        this.YCoordinate = YCoordinate;
    }

    public FaceDirection getFaceDirection() {
        return faceDirection;
    }

    public void setFaceDirection(FaceDirection faceDirection) {
        this.faceDirection = faceDirection;
    }
}
