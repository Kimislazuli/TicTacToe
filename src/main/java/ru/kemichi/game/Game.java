package ru.kemichi.game;

import ru.kemichi.game.gui.MainApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class Game
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ResourceBundle bundle = ResourceBundle.getBundle("locale");
            MainApplicationFrame mainApplicationFrame = new MainApplicationFrame(bundle, 50);
            mainApplicationFrame.pack();
            mainApplicationFrame.setVisible(true);
            mainApplicationFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
    });
}}
