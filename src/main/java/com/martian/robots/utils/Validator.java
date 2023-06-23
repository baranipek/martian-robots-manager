package com.martian.robots.utils;

import com.martian.robots.exception.MartianRobotException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Validator {
  public void validateCoordinate(String[] coordinates) throws MartianRobotException {
    int maxCoordinate = 50;

    for (String coordinateStr : coordinates) {
      if (!coordinateStr.matches("-?\\d+")) {
        continue;
      }

      int coordinate = Integer.parseInt(coordinateStr);
      if (coordinate < 0 || coordinate > maxCoordinate) {
        throw new MartianRobotException("Coordinate value is out of range: " + coordinate);
      }
    }
  }


}
