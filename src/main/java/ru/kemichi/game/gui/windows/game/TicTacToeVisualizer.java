package ru.kemichi.game.gui.windows.game;

import ru.kemichi.game.enums.FieldState;
import ru.kemichi.game.enums.Player;
import ru.kemichi.game.gui.windows.abstractions.AbstractVisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Timer;

import static ru.kemichi.game.enums.FieldState.O_FIGURE;
import static ru.kemichi.game.enums.FieldState.X_FIGURE;

public class TicTacToeVisualizer extends AbstractVisualizer {
    // window elements
    private final JButton playAgainButton;
    private final TicTacToe ticTacToe;



    // TODO: colors
    public TicTacToeVisualizer(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
        ticTacToe.emptyGrid();
        playAgainButton = new JButton("Play again");
        playAgainButton.addActionListener((actionEvent -> restartGame()));
        playAgainButton.setVisible(false);
//        Timer timer = initTimer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                onRedrawEvent();
//            }
//        }, 0, 50);
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                ticTacToe.onModelUpdateEvent();
//            }
//        }, 0, 10);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ticTacToe.newTurn(e.getPoint());
                repaint();
            }
        });
        setDoubleBuffered(true);
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        DrawGameGrid(page);
        drawContent(page);
    }

    private void drawContent(Graphics page) {
//        FieldState[][] board = new FieldState[3][3];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                board[i][j] = X_FIGURE;
//            }
//        }
//
//        ticTacToe.setBoard(board);



        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToe.getBoard()[i][j] == X_FIGURE) {
                    drawFigure(X_FIGURE, i, j, page);
                } else if (ticTacToe.getBoard()[i][j] == O_FIGURE) {
                    drawFigure(O_FIGURE, i, j, page);
                }
            }
        }
    }

    private void drawFigure(FieldState figureName, int i, int j, Graphics page) {
        File icon = ticTacToe.getBatsuIcon();
        if (figureName == O_FIGURE) {
            icon = ticTacToe.getMaruIcon();
        }

        addImage(
                icon,
                page,
                new Point(
                        ticTacToe.getLine().getWidth() + ticTacToe.getLine().getOffset() * i,
                        ticTacToe.getLine().getWidth() + ticTacToe.getLine().getOffset() * j),
                new Dimension(ticTacToe.getLine().getOffset(), ticTacToe.getLine().getOffset()));
    }

    private void DrawGameGrid(Graphics page) {
        // background
        setBackground(Color.LIGHT_GRAY);

        // lines
        page.setColor(Color.BLUE);
        // horizontal
        page.fillRoundRect(
                ticTacToe.getLine().getFirstGridLinePosition().x,
                ticTacToe.getLine().getFirstGridLinePosition().y,
                ticTacToe.getLine().getLength(),
                ticTacToe.getLine().getWidth(),
                5, 30
        );
        page.fillRoundRect(
                ticTacToe.getLine().getFirstGridLinePosition().x,
                ticTacToe.getLine().getFirstGridLinePosition().y + ticTacToe.getLine().getOffset(),
                ticTacToe.getLine().getLength(),
                ticTacToe.getLine().getWidth(),
                5, 30
        );
        // vertical
        page.fillRoundRect(
                ticTacToe.getLine().getFirstGridLinePosition().y,
                ticTacToe.getLine().getFirstGridLinePosition().x,
                ticTacToe.getLine().getWidth(),
                ticTacToe.getLine().getLength(),
                30, 5
        );
        page.fillRoundRect(
                ticTacToe.getLine().getFirstGridLinePosition().y + ticTacToe.getLine().getOffset(),
                ticTacToe.getLine().getFirstGridLinePosition().x,
                ticTacToe.getLine().getWidth(),
                ticTacToe.getLine().getLength(),
                30, 5
        );

    }

    private void restartGame() {
        ticTacToe.setTurn(Player.X_PLAYER);
        ticTacToe.setGameEnded(false);
        ticTacToe.setWinner(Player.NOBODY);
        ticTacToe.emptyGrid();
    }
}
