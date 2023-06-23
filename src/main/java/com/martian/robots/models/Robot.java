package com.martian.robots.models;

import com.martian.robots.command.Command;
import com.martian.robots.direction.Direction;
import com.martian.robots.exception.MartianRobotException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@Slf4j
public class Robot {
  public final String POSITION_LOST = "LOST";

  @NonNull
  private Mars marsland;
  @NonNull
  private Coordinates currentCoordinates;
  @NonNull
  private Direction currentDirection;

  private boolean robotLost;

  public void turnRight() {
    currentDirection = getCurrentDirection().turnRight();
  }

  public void turnLeft() {
    currentDirection = getCurrentDirection().turnLeft();
  }

  public void moveForward() throws MartianRobotException {
    getCurrentDirection().moveForward(this);
    controlPosition();
  }

  public void executeCommandList(List<Command> commands) throws MartianRobotException {
    for (Command command : commands) {
      command.execute(this);
    }
  }

  public String currentPosition() {
    String checkIfLost = this.isRobotLost() ? " " + POSITION_LOST : "";
    return getCurrentCoordinates().getXCoordinate() + " "
        + getCurrentCoordinates().getYCoordinate() + " "
        + getCurrentDirection().getClass().getSimpleName().charAt(0)
        + checkIfLost;
  }

  private void controlPosition() throws MartianRobotException {
    if (!getMarsland().isInBounds(getCurrentCoordinates())) {
      this.getCurrentDirection().moveBackward(this);
      if (this.marsland.getScentedCoordinates().contains(this.getCurrentCoordinates())) {
        log.warn(this.currentCoordinates + " is already scented by previous robot.");
      } else {
        this.setRobotLost(true);
        marsland.dropScent(this.currentCoordinates);
        throw new MartianRobotException("Robot {" + System.identityHashCode(this) + "} is lost");
      }
    }
  }
}
