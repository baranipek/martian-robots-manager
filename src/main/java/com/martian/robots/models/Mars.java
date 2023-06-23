package com.martian.robots.models;

import java.util.ArrayList;
import java.util.List;

public class Mars {

    private Coordinates topRight = new Coordinates(0, 0);
    private final Coordinates bottomLeft = new Coordinates(0, 0);

    private final List<Coordinates> scentedCoordinates = new ArrayList<>();

    public Mars(final int topRightX, final int topRightY) {
        this.topRight = this.topRight.createCoordinate(topRightX, topRightY);
    }

    public boolean isInBounds(final Coordinates coordinates) {
        return this.bottomLeft.isOutsideBounds(coordinates) && this.topRight.isWithinBounds(coordinates);
    }

    public void dropScent(Coordinates coordinatesToSprayScent) {
        scentedCoordinates.add(coordinatesToSprayScent);
    }

    public List<Coordinates> getScentedCoordinates() {
        return scentedCoordinates;
    }
}
