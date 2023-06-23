package com.martian.robots.command;

import com.martian.robots.exception.MartianRobotException;
import com.martian.robots.models.Robot;

public class MoveForwardCommand implements Command {

    @Override
    public void execute(Robot robot) throws MartianRobotException {
        robot.moveForward();
    }
}
