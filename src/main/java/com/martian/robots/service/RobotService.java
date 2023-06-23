package com.martian.robots.service;

import com.martian.robots.command.Command;
import com.martian.robots.exception.MartianRobotException;
import com.martian.robots.models.Mars;
import com.martian.robots.models.Robot;
import com.martian.robots.utils.CommandUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class RobotService {

  @Value("${inputFile}")
  private String input = "/wrongFormatInput.txt";

  public String moveRobots() throws IOException, MartianRobotException {
    StringBuilder landings = new StringBuilder();

    List<String> inputFileAsList = CommandUtil.readFromInputStream(RobotService.class.getResourceAsStream(input));
    landings.append("Sample Input\n");
    for (String line : inputFileAsList)
      landings.append(line).append("\n");

    // First line for  Mars
    Mars mars = CommandUtil.getMarsFromInput(inputFileAsList.get(0));

    List<String> commandList = inputFileAsList.subList(1, inputFileAsList.size());


    landings.append("\nOutput\n");
    for (int i = 0; i < commandList.size(); i += 2) {

      Robot robot;
      try {
        robot = CommandUtil.createRobotFromInput(commandList.get(i), mars);
      } catch (MartianRobotException e) {
        throw e;
      }
      List<Command> commands = CommandUtil.getCommands(commandList.get(i + 1));
      if (commands.size() > 100) {
        throw new MartianRobotException("All instruction strings will be less than 100 characters in length.");
      }
      try {
        robot.executeCommandList(commands);
      } catch (MartianRobotException e) {
        log.error("Error in executing commands" + e.getMessage());
      }
      landings.append(robot.currentPosition()).append("\n");
    }

    return landings.toString();
  }
}
