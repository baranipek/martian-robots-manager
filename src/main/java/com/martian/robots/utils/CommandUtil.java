package com.martian.robots.utils;

import com.martian.robots.command.Command;
import com.martian.robots.direction.Direction;
import com.martian.robots.enums.CommandEnum;
import com.martian.robots.enums.DirectionEnum;
import com.martian.robots.exception.MartianRobotException;
import com.martian.robots.models.Robot;
import com.martian.robots.models.Coordinates;
import com.martian.robots.models.Mars;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CommandUtil {

  public List<String> readFromInputStream(InputStream inputStream) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      return br.lines()
          .collect(Collectors.toList());
    }
  }

  public Mars getMarsFromInput(String marsLandInputSize) throws MartianRobotException {
    String[] inputArray = marsLandInputSize.split(" ");
    Validator.validateCoordinate(inputArray);
    int topRightXCoordinate = Integer.parseInt(inputArray[0]);
    int topRightYCoordinate = Integer.parseInt(inputArray[1]);
    return new Mars(topRightXCoordinate, topRightYCoordinate);
  }

  public Robot createRobotFromInput(final String positionInput, final Mars mars) throws MartianRobotException {
    String[] inputArray = positionInput.split(" ");
    Validator.validateCoordinate(inputArray);
    Coordinates landingCoordinates = new Coordinates(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]));
    Direction direction = DirectionEnum.valueOf(inputArray[2]).getDirection();
    return new Robot(mars, landingCoordinates, direction);
  }

  public List<Command> getCommands(final String command) {
    return command.chars()
        .mapToObj(character -> Character.toString((char) character))
        .map(CommandEnum::valueOf)
        .map(CommandEnum::getCommand)
        .collect(Collectors.toList());
  }
}
