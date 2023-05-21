package ru.kemichi.game.figures.grid;

import lombok.Data;

import java.awt.*;

@Data
public class GridLine {

    private final Point firstGridLinePosition = new Point(40, 260);
//    private final Point firstGridLinePosition = new Point(15, 100);
    private final int offset = 250; // distance to next line
//    private final int offset = 95; // distance to next line
//    private final int length = 270;
    private final int length = offset * 3 - firstGridLinePosition.x;
    private final int width = 10;
}
