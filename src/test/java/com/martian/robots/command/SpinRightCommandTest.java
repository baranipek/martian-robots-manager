package com.martian.robots.command;

import com.martian.robots.exception.MartianRobotException;
import com.martian.robots.utility.BaseTest;
import com.martian.robots.direction.EastDirection;
import com.martian.robots.direction.NorthDirection;
import com.martian.robots.models.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpinRightCommandTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        direction = new NorthDirection();
        robot = new Robot(mars, coordinates, direction);
        command = new SpinRightCommand();
    }

    @Test
    public void testWhenExecutedRobotDirectionToEast() throws MartianRobotException {
        command.execute(robot);
        Assertions.assertEquals(EastDirection.class, robot.getCurrentDirection().getClass());
    }
}
