package ru.kemichi.game.gui.windows.abstractions;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;

public class AbstractVisualizer extends JPanel{
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
    }

    protected void addImage(File iconName, Graphics page, Point point, Dimension dimension) {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(iconName.toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Image image = icon.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
        page.drawImage(new ImageIcon(image).getImage(),point.x, point.y, null);
    }
}
