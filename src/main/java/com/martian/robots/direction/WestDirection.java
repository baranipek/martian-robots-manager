package com.martian.robots.direction;

import com.martian.robots.models.Robot;
import com.martian.robots.models.Coordinates;

public class WestDirection implements Direction {

    @Override
    public Direction turnRight() {
        return new NorthDirection();
    }

    @Override
    public Direction turnLeft() {
        return new SouthDirection();
    }

    @Override
    public void moveForward(Robot robot) {
        Coordinates currentCoordinate = robot.getCurrentCoordinates();
        currentCoordinate.setXCoordinate(currentCoordinate.getXCoordinate() - 1);
        robot.setCurrentCoordinates(currentCoordinate);
    }

    @Override
    public void moveBackward(Robot robot) {
        Coordinates currentCoordinate = robot.getCurrentCoordinates();
        currentCoordinate.setXCoordinate(currentCoordinate.getXCoordinate() + 1);
        robot.setCurrentCoordinates(currentCoordinate);
    }
}
