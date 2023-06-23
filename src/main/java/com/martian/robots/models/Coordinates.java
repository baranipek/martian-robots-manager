package com.martian.robots.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;

    public Coordinates createCoordinate(final int xCoordinateStep, final int yCoordinateStep) {
        return new Coordinates(this.xCoordinate + xCoordinateStep, this.yCoordinate + yCoordinateStep);
    }

    @Override
    public String toString() {
        return xCoordinate + " " + yCoordinate;
    }

    public boolean isWithinBounds(final Coordinates coordinates) {
        return isXWithinBounds(coordinates.xCoordinate) && isYWithinBounds(coordinates.yCoordinate);
    }

    public boolean isOutsideBounds(final Coordinates coordinates) {
        return isXOutsideBounds(coordinates.xCoordinate) && isYOutsideBounds(coordinates.yCoordinate);
    }

    private boolean isXOutsideBounds(final int xCoordinate) {
        return xCoordinate >= this.xCoordinate;
    }

    private boolean isYOutsideBounds(final int yCoordinate) {
        return yCoordinate >= this.yCoordinate;
    }

    private boolean isYWithinBounds(final int yCoordinate) {
        return yCoordinate <= this.yCoordinate;
    }

    private boolean isXWithinBounds(final int xCoordinate) {
        return xCoordinate <= this.xCoordinate;
    }
}
