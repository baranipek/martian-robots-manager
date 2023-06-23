package com.martian.robots.direction;

import com.martian.robots.utility.BaseTest;
import com.martian.robots.models.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WestDirectionTest extends BaseTest {

    @BeforeEach
    public void setUp() throws Exception {
        direction = new WestDirection();
        robot = new Robot(mars, coordinates, direction);
    }

    @Test
    public void whenTurnsRightNewDirectionIsNorth() throws Exception {
        assertEquals(direction.turnRight().getClass(), NorthDirection.class);
    }

    @Test
    public void whenTurnsLeftNewDirectionIsSouth() throws Exception {
        assertEquals(direction.turnLeft().getClass(), SouthDirection.class);
    }

    @Test
    public void whenMovesForwardCoordinateXDecrements() throws Exception {
        int expected = coordinates.getXCoordinate() - 1;
        direction.moveForward(robot);
        Assertions.assertEquals(expected, robot.getCurrentCoordinates().getXCoordinate());
    }

    @Test
    public void whenMovesBackCoordinateXIncrements() throws Exception {
        int expected = coordinates.getXCoordinate() + 1;
        direction.moveBackward(robot);
        Assertions.assertEquals(expected, robot.getCurrentCoordinates().getXCoordinate());
    }
}