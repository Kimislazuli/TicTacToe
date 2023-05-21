package ru.kemichi.game.gui.windows.stat_window;

import ru.kemichi.game.gui.windows.abstractions.AbstractUtilityWindow;
import ru.kemichi.game.gui.windows.game.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class StatWindow extends AbstractUtilityWindow {
    private final ResourceBundle bundle;

    public StatWindow(ResourceBundle bundle, TicTacToe ticTacToe) {
        super(bundle.getString("statWindow"));
        this.bundle = bundle;
        Dimension dimension = new Dimension(350, 400);
        StatVisualizer visualizer = new StatVisualizer(ticTacToe, dimension);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
//        ticTacToe.addObserver((o, arg) -> updateTextArea());

        this.setLocation(1200, 500);
        pack();
        this.setSize(dimension);
    }
}
