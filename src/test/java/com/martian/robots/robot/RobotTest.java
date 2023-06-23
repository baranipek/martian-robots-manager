package com.martian.robots.robot;

import com.martian.robots.utility.BaseTest;
import com.martian.robots.command.Command;
import com.martian.robots.command.MoveForwardCommand;
import com.martian.robots.command.SpinLeftCommand;
import com.martian.robots.direction.EastDirection;
import com.martian.robots.direction.NorthDirection;
import com.martian.robots.direction.WestDirection;
import com.martian.robots.exception.MartianRobotException;
import com.martian.robots.models.Coordinates;
import com.martian.robots.models.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest extends BaseTest {

    @BeforeEach
    public void setUp() throws Exception {
        direction = new NorthDirection();
        robot = new Robot(mars, coordinates, direction);
    }

    @Test
    public void testRobotSpinRight() throws Exception {
        robot.turnRight();
        Assertions.assertEquals(EastDirection.class, robot.getCurrentDirection().getClass());
    }

    @Test
    public void testRobotSpinLeft() throws Exception {
        robot.turnLeft();
        Assertions.assertEquals(WestDirection.class, robot.getCurrentDirection().getClass());
    }

    @Test
    public void testRobotMoveForward() throws Exception {
        int expected = robot.getCurrentCoordinates().getYCoordinate() + 1;
        robot.moveForward();
        Assertions.assertEquals(expected, robot.getCurrentCoordinates().getYCoordinate());
    }

    @Test
    public void testRobotCurrentPosition() throws Exception {
        assertEquals("2 2 N", robot.currentPosition());

        /*
            1 1 E
            RFRFRFRF
            Output : 1 1 E
         */
        robot = new Robot(mars, new Coordinates(1, 1), new EastDirection());
        try {
            robot.turnRight();
            robot.moveForward();
            robot.turnRight();
            robot.moveForward();
            robot.turnRight();
            robot.moveForward();
            robot.turnRight();
            robot.moveForward();
        } catch (MartianRobotException e) {
        }
        assertEquals("1 1 E", robot.currentPosition());

        /*
            0 3 W
            LLFFFLLFL
            Output : 2 3 S
         */
        Robot robot1 = new Robot(mars, new Coordinates(0, 3), new WestDirection());
        try {
            robot1.turnLeft();
            robot1.turnLeft();
            robot1.moveForward();
            robot1.moveForward();
            robot1.moveForward();
            robot1.turnLeft();
            robot1.turnLeft();
            robot1.moveForward();
            robot1.turnLeft();
        } catch (MartianRobotException e) {
        }
        assertEquals("2 3 S", robot1.currentPosition());
    }

    @Test
    public void testRobotCurrentPositionWithStatusLOST() {
        /*
            3 2 N
            FRRFLLFFRRFLL
            Output : 3 3 N LOST
         */
        Robot robot = new Robot(mars, new Coordinates(3, 2), new NorthDirection());
        try {
            robot.moveForward();
            robot.turnRight();
            robot.turnRight();
            robot.moveForward();
            robot.turnLeft();
            robot.turnLeft();
            robot.moveForward();
            robot.moveForward();
            robot.turnRight();
            robot.turnRight();
            robot.moveForward();
            robot.turnLeft();
            robot.turnLeft();
        } catch (MartianRobotException e){
        }

        assertEquals("3 3 N " + robot.POSITION_LOST, robot.currentPosition());
    }

    @Test
    public void testRoverCanExecuteCommandAsAList() throws Exception {
        /*
            0 3 W
            LLFFFLFLFL
            Output : 3 3 N LOST
         */
        robot = new Robot(mars, new Coordinates(0, 3), new WestDirection());
        List<Command> commandArrayList = new ArrayList<>();
        commandArrayList.add(new SpinLeftCommand());
        commandArrayList.add(new SpinLeftCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new SpinLeftCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new SpinLeftCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new SpinLeftCommand());
        try {
            robot.executeCommandList(commandArrayList);
        } catch (MartianRobotException e){
        }

        assertEquals("3 3 N " + robot.POSITION_LOST, robot.currentPosition());
    }
}
