package ru.kemichi.game.gui.windows.game_state;

import ru.kemichi.game.gui.windows.abstractions.AbstractWindow;
import ru.kemichi.game.gui.windows.game.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class GameStateWindow extends AbstractWindow {
    private final TextArea textArea = new TextArea();
    private final ResourceBundle bundle;
    public GameStateWindow(ResourceBundle bundle, TicTacToe ticTacToe) {
        super(bundle.getString("gameStateWindow"));
        this.bundle = bundle;
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        updateTextArea();
        getContentPane().add(panel);
//        ticTacToe.addObserver((o, arg) -> updateTextArea());
        this.setLocation(1200, 400);
        pack();
        this.setSize(350, 100);
    }

    private void updateTextArea() {

    }
}
