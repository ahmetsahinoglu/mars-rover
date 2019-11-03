package com.marsrover;

import com.marsrover.domain.Mars;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MarsTest {
    private Mars mars;
    private static final int MARS_X_SIZE = 5;
    private static final int MARS_Y_SIZE = 5;

    @Before
    public void init() {
        mars = new Mars(MARS_X_SIZE, MARS_Y_SIZE);
    }

    @Test
    public void shouldNewMarsInstanceWithGivenParameters() {
        assertEquals(MARS_X_SIZE, mars.getxSize());
        assertEquals(MARS_Y_SIZE, mars.getySize());
    }
}
