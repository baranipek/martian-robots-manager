package com.martian.robots.direction;

import com.martian.robots.models.Robot;
import com.martian.robots.models.Coordinates;

public class SouthDirection implements Direction {

    @Override
    public Direction turnRight() {
        return new WestDirection();
    }

    @Override
    public Direction turnLeft() {
        return new EastDirection();
    }

    @Override
    public void moveForward(Robot robot) {
        Coordinates currentCoordinate = robot.getCurrentCoordinates();
        currentCoordinate.setYCoordinate(currentCoordinate.getYCoordinate() - 1);
        robot.setCurrentCoordinates(currentCoordinate);
    }

    @Override
    public void moveBackward(Robot robot) {
        Coordinates currentCoordinate = robot.getCurrentCoordinates();
        currentCoordinate.setYCoordinate(currentCoordinate.getYCoordinate() + 1);
        robot.setCurrentCoordinates(currentCoordinate);
    }
}
