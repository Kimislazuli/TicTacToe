package ru.kemichi.game.gui.windows.game;
import ru.kemichi.game.gui.windows.abstractions.AbstractWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class GameWindow extends AbstractWindow {
    private final TicTacToe ticTacToe;
    public GameWindow(ResourceBundle bundle, TicTacToe ticTacToe) {
        super(bundle.getString("gameWindowHeader"));
        this.ticTacToe = ticTacToe;
        Dimension dimension = ticTacToe.getDimension();
        TicTacToeVisualizer visualizer = new TicTacToeVisualizer(ticTacToe);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);

        this.setLocation(350, 50);
        pack();
        this.setSize(dimension);
    }

}
