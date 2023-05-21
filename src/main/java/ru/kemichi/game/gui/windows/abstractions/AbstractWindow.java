package ru.kemichi.game.gui.windows.abstractions;

import javax.swing.*;

public abstract class AbstractWindow extends JInternalFrame {
    public AbstractWindow(String title) {
        super(title, false, false, false, false);
    }
}
