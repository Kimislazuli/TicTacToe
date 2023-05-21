package ru.kemichi.game.gui.windows.turns_window;

import ru.kemichi.game.gui.windows.abstractions.AbstractVisualizer;
import ru.kemichi.game.gui.windows.game.TicTacToe;

import java.awt.*;

public class TurnsVisualizer extends AbstractVisualizer {
    private final TicTacToe ticTacToe;

    public TurnsVisualizer(TicTacToe ticTacToe, Dimension dimension) {
        this.ticTacToe = ticTacToe;
        setSize(dimension);
    }

    @Override
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        drawContent(page);
    }

    private void drawContent(Graphics page) {
        setBackground(Color.darkGray);
        addImage(ticTacToe.getBatsuIcon(), page, new Point(10, 10), new Dimension(300, 300));
    }


}