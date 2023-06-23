package com.martian.robots.command;

import com.martian.robots.exception.MartianRobotException;
import com.martian.robots.models.Robot;

public interface Command {

    void execute(final Robot robot) throws MartianRobotException;
}
