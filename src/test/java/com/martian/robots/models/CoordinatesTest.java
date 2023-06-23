package com.martian.robots.models;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void createCoordinate_shouldReturnNewCoordinateWithCorrectValues() {
        // Given
        Coordinates coordinates = new Coordinates(2, 3);

        // When
        Coordinates newCoordinates = coordinates.createCoordinate(1, -1);

        // Then
        assertEquals(3, newCoordinates.getXCoordinate());
        assertEquals(2, newCoordinates.getYCoordinate());
    }

    @Test
    void toString_shouldReturnFormattedCoordinatesString() {
        // Given
        Coordinates coordinates = new Coordinates(2, 3);

        // When
        String result = coordinates.toString();

        // Then
        assertEquals("2 3", result);
    }

    @Test
    void isWithinBounds_shouldReturnTrueWhenCoordinatesAreWithinBounds() {
        // Given
        Coordinates coordinates = new Coordinates(5, 5);
        Coordinates internalPoint = new Coordinates(4, 4);

        // Then
        assertTrue(coordinates.isWithinBounds(internalPoint));
    }

    @Test
    void isWithinBounds_shouldReturnFalseWhenCoordinatesAreOutsideBounds() {
        // Given
        Coordinates coordinates = new Coordinates(5, 5);
        Coordinates externalPoint = new Coordinates(8, 5);

        // Then
        assertFalse(coordinates.isWithinBounds(externalPoint));
    }

    @Test
    void isOutsideBounds_shouldReturnTrueWhenCoordinatesAreOutsideBounds() {
        // Given
        Coordinates coordinates = new Coordinates(5, 5);
        Coordinates externalPoint = new Coordinates(8, 5);

        // Then
        assertTrue(coordinates.isOutsideBounds(externalPoint));
    }

    @Test
    void isOutsideBounds_shouldReturnFalseWhenCoordinatesAreWithinBounds() {
        // Given
        Coordinates coordinates = new Coordinates(5, 5);
        Coordinates internalPoint = new Coordinates(4, 4);

        // Then
        assertFalse(coordinates.isOutsideBounds(internalPoint));
    }
}
