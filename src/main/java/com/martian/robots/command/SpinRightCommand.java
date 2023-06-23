package com.martian.robots.command;

import com.martian.robots.models.Robot;

public class SpinRightCommand implements Command {

    @Override
    public void execute(Robot robot) {
        robot.turnRight();
    }
}
