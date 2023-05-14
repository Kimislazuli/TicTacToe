package ru.kemichi.game.gui.windows;
import ru.kemichi.game.gui.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class GameWindow extends AbstractWindow {
    public GameWindow(ResourceBundle bundle) {
        super(bundle.getString("gameWindowHeader"));
        Dimension dimension = new Dimension(850, 850);
        Point point = new Point(350, 50);
        this.setLocation(point);
        TicTacToe ticTacToe = new TicTacToe(this.getSize());
        TicTacToeVisualizer visualizer = new TicTacToeVisualizer(ticTacToe);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
        this.setSize(dimension);
    }

}
