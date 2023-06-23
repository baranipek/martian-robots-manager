package com.martian.robots.enums;

import com.martian.robots.direction.EastDirection;
import com.martian.robots.direction.NorthDirection;
import com.martian.robots.direction.SouthDirection;
import com.martian.robots.direction.WestDirection;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DirectionEnum {

    N(new NorthDirection()),
    E(new EastDirection()),
    S(new SouthDirection()),
    W(new WestDirection());

    private final com.martian.robots.direction.Direction direction;
}
