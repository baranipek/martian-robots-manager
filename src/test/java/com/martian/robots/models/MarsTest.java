package com.martian.robots.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarsTest {

    @Test
    void isInBounds_shouldReturnTrueForCoordinatesWithinBounds() {
        // Given
        Mars mars = new Mars(5, 5);
        Coordinates coordinates = new Coordinates(3, 4);

        // Then
        assertTrue(mars.isInBounds(coordinates));
    }

    @Test
    void isInBounds_shouldReturnFalseForCoordinatesOutsideBounds() {
        // Given
        Mars mars = new Mars(5, 5);
        Coordinates coordinates = new Coordinates(6, 2);

        // Then
        assertFalse(mars.isInBounds(coordinates));
    }

    @Test
    void dropScent_shouldAddCoordinatesToScentedCoordinatesList() {
        // Given
        Mars mars = new Mars(5, 5);
        Coordinates coordinatesToSprayScent = new Coordinates(3, 4);

        // When
        mars.dropScent(coordinatesToSprayScent);

        // Then
        assertTrue(mars.getScentedCoordinates().contains(coordinatesToSprayScent));
    }
}
