package com.martian.robots.direction;

import com.martian.robots.utility.BaseTest;
import com.martian.robots.models.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EastDirectionTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        direction = new EastDirection();
        robot = new Robot(mars, coordinates, direction);
    }

    @Test
    public void testWhenTurnsRightNewDirectionIsSouth() {
        assertEquals(SouthDirection.class, direction.turnRight().getClass());
    }

    @Test
    public void testWhenTurnsLeftNewDirectionIsNorth() {
        assertEquals(NorthDirection.class, direction.turnLeft().getClass());
    }

    @Test
    public void testWhenMovesForwardCoordinateXIncrements() {
        int expected = coordinates.getXCoordinate() + 1;
        direction.moveForward(robot);
        Assertions.assertEquals(expected, robot.getCurrentCoordinates().getXCoordinate());
    }

    @Test
    public void testWhenMovesBackCoordinateXDecrements() {
        int expected = coordinates.getXCoordinate() - 1;
        direction.moveBackward(robot);
        assertEquals(expected, robot.getCurrentCoordinates().getXCoordinate());
    }
}
