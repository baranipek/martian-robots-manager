package com.martian.robots.command;

import com.martian.robots.models.Robot;

public class SpinLeftCommand implements Command {

    @Override
    public void execute(Robot robot) {
        robot.turnLeft();
    }
}
