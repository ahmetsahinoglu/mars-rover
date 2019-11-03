package com.marsrover.domain;

public class Mars {
    private int xSize;
    private int ySize;

    public Mars(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }
}
