package com.martian.robots.command;

import com.martian.robots.exception.MartianRobotException;
import com.martian.robots.utility.BaseTest;
import com.martian.robots.direction.NorthDirection;
import com.martian.robots.direction.WestDirection;
import com.martian.robots.models.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpinLeftCommandTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        direction = new NorthDirection();
        robot = new Robot(mars, coordinates, direction);
        command = new SpinLeftCommand();
    }

    @Test
    public void testWhenExecutedRobotDirectionToWest() throws MartianRobotException {
        command.execute(robot);
        Assertions.assertEquals(WestDirection.class, robot.getCurrentDirection().getClass());
    }
}
