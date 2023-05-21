package ru.kemichi.game.gui.windows.turns_window;

import ru.kemichi.game.gui.windows.abstractions.AbstractUtilityWindow;
import ru.kemichi.game.gui.windows.game.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class TurnsWindow extends AbstractUtilityWindow {
    private final ResourceBundle bundle;
    public TurnsWindow(ResourceBundle bundle, TicTacToe ticTacToe) {
        super(bundle.getString("turnsWindowHeader"));
        Dimension dimension = new Dimension(350, 350);
        this.bundle = bundle;
        JPanel panel = new JPanel(new BorderLayout());
        TurnsVisualizer visualizer = new TurnsVisualizer(ticTacToe, dimension);
        panel.add(visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
//        ticTacToe.addObserver((o, arg) -> updateTextArea());
        this.setLocation(1200, 50);
        pack();
        this.setSize(350, 350);
    }



}
