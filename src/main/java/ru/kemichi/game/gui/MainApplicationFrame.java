package ru.kemichi.game.gui;

import ru.kemichi.game.gui.windows.abstractions.AbstractWindow;
import ru.kemichi.game.gui.windows.game.GameWindow;
import ru.kemichi.game.gui.windows.game.TicTacToe;
import ru.kemichi.game.gui.windows.game_state.GameStateWindow;
import ru.kemichi.game.gui.windows.stat_window.StatWindow;
import ru.kemichi.game.gui.windows.turns_window.TurnsWindow;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

public class MainApplicationFrame extends JFrame {
    private final JDesktopPane desktopPane = new JDesktopPane();
    private final ResourceBundle bundle;

    public MainApplicationFrame(ResourceBundle bundle, int inset) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.bundle = bundle;
        setBounds(inset, inset, screenSize.width - inset * 2, screenSize.width - inset * 2);

        setContentPane(desktopPane);

        TicTacToe ticTacToe = new TicTacToe(new Dimension(850, 850));

        loadWindows(
                new GameWindow(bundle, ticTacToe),
                new TurnsWindow(bundle, ticTacToe),
                new GameStateWindow(bundle, ticTacToe),
                new StatWindow(bundle, ticTacToe)
        );

        setJMenuBar(generateMenuBar());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void loadWindows(AbstractWindow... windows) {
        for (AbstractWindow window: windows) {
            addWindow(window);
        }
    }

    protected void addWindow(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    private JMenuBar generateMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        addActionsMenu(menuBar);

        return menuBar;
    }

    private void addActionsMenu(JMenuBar menuBar) {
        addMenu(
                menuBar,
                generateMenu(
                        bundle.getString("actionsMenu"),
                        KeyEvent.VK_A,
                        bundle.getString("actionsMenuDescription")
                ),
                generateMenuItem(
                        bundle.getString("quitItem"),
                        KeyEvent.VK_Q,
                        (event) -> exitConfirmation()
                ));
    }

    private void addMenu(JMenuBar menuBar, JMenu menu, JMenuItem... items) {
        for (JMenuItem item : items) {
            menu.add(item);
        }
        menuBar.add(menu);
    }

    private JMenu generateMenu(String menuName, int menuHotkey, String menuDescription) {
        JMenu jMenu = new JMenu(menuName);
        jMenu.setMnemonic(menuHotkey);
        jMenu.getAccessibleContext().setAccessibleDescription(menuDescription);
        return jMenu;
    }

    private JMenuItem generateMenuItem(String menuItemName, int menuItemMnemonic, ActionListener actionListener) {
        JMenuItem jMenuItem = new JMenuItem(menuItemName);
        jMenuItem.setMnemonic(menuItemMnemonic);
        jMenuItem.addActionListener(actionListener);
        return jMenuItem;
    }

    private void exitConfirmation() {
        Object[] choices = {bundle.getString("quit"), bundle.getString("cancel")};
        Object defaultChoice = choices[0];
        int confirmed = JOptionPane.showOptionDialog(null,
                bundle.getString("quitQuestion"),
                bundle.getString("quitTitle"),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                choices,
                defaultChoice);

        if (confirmed == JOptionPane.YES_OPTION) {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
