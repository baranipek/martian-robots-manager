package com.martian.robots.enums;

import com.martian.robots.command.MoveForwardCommand;
import com.martian.robots.command.SpinLeftCommand;
import com.martian.robots.command.SpinRightCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommandEnum {

    R(new SpinRightCommand()),
    L(new SpinLeftCommand()),
    F(new MoveForwardCommand());

    private final com.martian.robots.command.Command command;
}
