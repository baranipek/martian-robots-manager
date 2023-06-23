package com.martian.robots.command;

import com.martian.robots.exception.MartianRobotException;
import com.martian.robots.utility.BaseTest;
import com.martian.robots.direction.NorthDirection;
import com.martian.robots.models.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class MoveForwardCommandTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        direction = new NorthDirection();
        robot = new Robot(mars, coordinates, direction);
        command = new MoveForwardCommand();
    }

    @Test
    public void testWhenExecutedRobotMovesForward() throws MartianRobotException {
        int expected = coordinates.getYCoordinate() + 1;
        command.execute(robot);
        assertEquals(expected, robot.getCurrentCoordinates().getYCoordinate());
    }
}

