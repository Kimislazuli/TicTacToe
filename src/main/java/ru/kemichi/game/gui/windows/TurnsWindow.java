package ru.kemichi.game.gui.windows;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class TurnsWindow extends AbstractUtilityWindow {
    private final TextArea textArea = new TextArea();
    private final ResourceBundle bundle;
    public TurnsWindow(ResourceBundle bundle) {
        super(bundle.getString("turnsWindowHeader"));
        this.bundle = bundle;
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        updateTextArea();
        getContentPane().add(panel);
//        ticTacToe.addObserver((o, arg) -> updateTextArea());
        this.setLocation(1200, 50);
        pack();
        this.setSize(350, 350);
    }

    private void updateTextArea() {

    }

}
