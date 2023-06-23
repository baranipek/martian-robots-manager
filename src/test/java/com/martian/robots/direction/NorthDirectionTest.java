package com.martian.robots.direction;

import com.martian.robots.models.Robot;
import com.martian.robots.utility.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NorthDirectionTest extends BaseTest {

  @BeforeEach
  public void setUp() {
    direction = new NorthDirection();
    robot = new Robot(mars, coordinates, direction);
  }

  @Test
  public void testWhenTurnsRightNewDirectionIsEast() {
    assertEquals(EastDirection.class, direction.turnRight().getClass());
  }

  @Test
  public void testWhenTurnsLeftNewDirectionIsWest() {
    assertEquals(WestDirection.class, direction.turnLeft().getClass());
  }

  @Test
  public void testWhenMovesForwardCoordinateYIncrements() {
    int expected = coordinates.getYCoordinate() + 1;
    direction.moveForward(robot);
    assertEquals(expected, robot.getCurrentCoordinates().getYCoordinate());
  }

  @Test
  public void testWhenMovesBackCoordinateYDecrements() {
    int expected = coordinates.getYCoordinate() - 1;
    direction.moveBackward(robot);
    assertEquals(expected, robot.getCurrentCoordinates().getYCoordinate());
  }
}
