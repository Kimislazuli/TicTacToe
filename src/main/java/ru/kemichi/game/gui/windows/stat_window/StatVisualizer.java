package ru.kemichi.game.gui.windows.stat_window;

import ru.kemichi.game.gui.windows.abstractions.AbstractVisualizer;
import ru.kemichi.game.gui.windows.game.TicTacToe;

import java.awt.*;

public class StatVisualizer extends AbstractVisualizer {
    private final TicTacToe ticTacToe;
    public StatVisualizer(TicTacToe ticTacToe, Dimension dimension) {
        this.ticTacToe = ticTacToe;
        setSize(dimension);
    }

    @Override
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        drawContent(page);
    }

    private void drawContent(Graphics page) {
        Font font = new Font("Helvetica", Font.BOLD, 20);
        setBackground(Color.darkGray);

        page.setFont(font);
        page.setColor(Color.white);
        page.drawString("game count: " + ticTacToe.getWinCounter(), 20, 30);

        addImage(ticTacToe.getBatsuIcon(), page, new Point(20, 40), new Dimension(27, 27));
        page.drawString(": " + ticTacToe.getXPlayerWins(), 60, 60);

        addImage(ticTacToe.getMaruIcon(), page, new Point(20, 70), new Dimension(27, 27));
        page.drawString(": " + ticTacToe.getOPlayerWins(), 60, 90);

    }
}
