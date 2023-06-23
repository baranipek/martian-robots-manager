package com.martian.robots.direction;

import com.martian.robots.models.Robot;

public interface Direction {

    Direction turnRight();

    Direction turnLeft();

    void moveForward(Robot robot);

    void moveBackward(Robot robot);
}
