package ru.kemichi.game.gui.windows;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class StatWindow extends AbstractUtilityWindow {
    private final ResourceBundle bundle;
    private final TextArea textArea = new TextArea();


    public StatWindow(ResourceBundle bundle) {
        super(bundle.getString("statWindow"));
        this.bundle = bundle;
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        updateTextArea();
        getContentPane().add(panel);
//        ticTacToe.addObserver((o, arg) -> updateTextArea());
        this.setLocation(1200, 500);
        pack();
        this.setSize(350, 400);
    }

    private void updateTextArea() {

    }
}
