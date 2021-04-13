package ru.geekbrains.java_level_1.lesson8;

import javax.swing.*;
import java.awt.*;

public class MainMenuWindow extends JFrame {

    public static final int WINDOW_WIDTH = 516;
    public static final int WINDOW_HEIGHT = 565;
    private static final Dimension userScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WINDOW_POS_X = userScreenSize.width / 2 - WINDOW_WIDTH / 2;
    public static final int WINDOW_POS_Y = userScreenSize.height / 2 - WINDOW_HEIGHT / 2;

    private GameWindow gameWindow;

    public MainMenuWindow() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JButton startButton = new JButton("<html><body><b>START GAME</b></body></html>");
        JButton settingsButton = new JButton("<html><body><b>SETTINGS</b></body></html>");
        JButton exitButton = new JButton("<html><body><b>EXIT</b></body></html>");
        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(startButton);
        startButton.addActionListener(e -> gameWindow.startGame());
        buttonPanel.add(settingsButton);
        settingsButton.addActionListener(e -> new SettingsWindow(this));
        buttonPanel.add(exitButton);
        exitButton.addActionListener(e -> System.exit(0));

        gameWindow = new GameWindow();
        add(gameWindow, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
