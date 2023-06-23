package com.martian.robots.controllers;

import com.martian.robots.exception.MartianRobotException;
import com.martian.robots.service.RobotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RobotController {
  private final RobotService robotService;

  @RequestMapping(value = "/move-robots", produces = MediaType.TEXT_PLAIN_VALUE)
  public String moveRobots() throws IOException, MartianRobotException {
    return robotService.moveRobots();
  }
}
