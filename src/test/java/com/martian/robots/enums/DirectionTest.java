package com.martian.robots.enums;

import com.martian.robots.utility.BaseTest;
import com.martian.robots.direction.EastDirection;
import com.martian.robots.direction.NorthDirection;
import com.martian.robots.direction.SouthDirection;
import com.martian.robots.direction.WestDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DirectionTest extends BaseTest {

    @Test
    void should() {
        assertTrue(DirectionEnum.valueOf("N").getDirection().getClass().isInstance(new NorthDirection()));
        assertTrue(DirectionEnum.valueOf("E").getDirection().getClass().isInstance(new EastDirection()));
        assertTrue(DirectionEnum.valueOf("S").getDirection().getClass().isInstance(new SouthDirection()));
        assertTrue(DirectionEnum.valueOf("W").getDirection().getClass().isInstance(new WestDirection()));
    }
}