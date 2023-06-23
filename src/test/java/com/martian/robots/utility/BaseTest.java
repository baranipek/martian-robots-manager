package com.martian.robots.utility;

import com.martian.robots.command.Command;
import com.martian.robots.direction.Direction;
import com.martian.robots.models.Robot;
import com.martian.robots.models.Coordinates;
import com.martian.robots.models.Mars;

public abstract class BaseTest {

    protected final Mars mars = new Mars(5, 3);
    protected Direction direction;
    protected Coordinates coordinates = new Coordinates(2, 2);
    protected Robot robot;
    protected Command command;
}
