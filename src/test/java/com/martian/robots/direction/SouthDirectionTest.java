package com.martian.robots.direction;

import com.martian.robots.utility.BaseTest;
import com.martian.robots.models.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SouthDirectionTest extends BaseTest {

    @BeforeEach
    public void setUp() throws Exception {
        direction = new SouthDirection();
        robot = new Robot(mars, coordinates, direction);
    }

    @Test
    public void whenTurnsRightNewDirectionIsWest() throws Exception {
        assertEquals(WestDirection.class, direction.turnRight().getClass());
    }

    @Test
    public void whenTurnsLeftNewDirectionIsEast() throws Exception {
        assertEquals(EastDirection.class, direction.turnLeft().getClass());
    }

    @Test
    public void whenMovesForwardCoordinateYDecrements() throws Exception {
        int expected = coordinates.getYCoordinate() - 1;
        direction.moveForward(robot);
        Assertions.assertEquals(expected, robot.getCurrentCoordinates().getYCoordinate());
    }

    @Test
    public void whenMovesBackCoordinateYIncrements() throws Exception {
        int expected = coordinates.getYCoordinate() + 1;
        direction.moveBackward(robot);
        Assertions.assertEquals(expected, robot.getCurrentCoordinates().getYCoordinate());
    }
}