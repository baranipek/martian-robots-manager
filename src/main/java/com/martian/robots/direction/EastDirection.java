package com.martian.robots.direction;

import com.martian.robots.models.Robot;
import com.martian.robots.models.Coordinates;

public class EastDirection implements Direction {

    @Override
    public Direction turnRight() {
        return new SouthDirection();
    }

    @Override
    public Direction turnLeft() {
        return new NorthDirection();
    }

    @Override
    public void moveForward(Robot robot) {
        Coordinates currentCoordinate = robot.getCurrentCoordinates();
        currentCoordinate.setXCoordinate(currentCoordinate.getXCoordinate() + 1);
        robot.setCurrentCoordinates(currentCoordinate);
    }

    @Override
    public void moveBackward(Robot robot) {
        Coordinates currentCoordinate = robot.getCurrentCoordinates();
        currentCoordinate.setXCoordinate(currentCoordinate.getXCoordinate() - 1);
        robot.setCurrentCoordinates(currentCoordinate);
    }
}
