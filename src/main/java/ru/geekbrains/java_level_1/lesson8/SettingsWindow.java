package ru.geekbrains.java_level_1.lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JDialog {

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 250;

    public static final int MIN_FIELD_SIZE = 3;
    public static final int MAX_FIELD_SIZE = 10;

    JRadioButton playerVsAi;
    JRadioButton playerVsPlayer;
    JSlider fieldSizeSlider;
    JComboBox<Integer> winLengthComboBox;

    public SettingsWindow(MainMenuWindow mainMenuWindow) {
        super(mainMenuWindow, true);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(mainMenuWindow);
        setTitle("Settings");
        setResizable(false);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton saveButton = new JButton("<html><body><b>SAVE</b></body></html>");
        saveButton.addActionListener(e -> {
            GameSettings.setGameMode(playerVsAi.isSelected() ? 0 : 1);
            GameSettings.setFieldSize(fieldSizeSlider.getValue());
            GameSettings.setWinLength((Integer) winLengthComboBox.getSelectedItem());
            this.dispose();
        });
        JButton cancelButton = new JButton("<html><body><b>CANCEL</b></body></html>");
        cancelButton.addActionListener(e -> this.dispose());
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
        JPanel settingsPanel = new JPanel(new GridLayout(8, 1));

        //Game mode
        settingsPanel.add(new JLabel("   Choose game mode:"));
        playerVsAi = new JRadioButton("Player vs AI");
        playerVsPlayer = new JRadioButton("Player vs Player");
        ButtonGroup gameModeButtonsGroup = new ButtonGroup();
        gameModeButtonsGroup.add(playerVsAi);
        gameModeButtonsGroup.add(playerVsPlayer);
        JPanel gameModePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        gameModePanel.add(playerVsAi);
        gameModePanel.add(playerVsPlayer);
        settingsPanel.add(gameModePanel);

        //Field Size
        settingsPanel.add(new JLabel("   Choose field size:"));
        JPanel fieldSizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldSizeSlider = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE);
        fieldSizeSlider.setMajorTickSpacing(1);
        fieldSizeSlider.setPaintTicks(true);
        fieldSizeSlider.setPaintLabels(true);
        fieldSizePanel.add(fieldSizeSlider);
        settingsPanel.add(fieldSizePanel);
        settingsPanel.add(new JPanel());
        fieldSizeSlider.addChangeListener(e -> {
            int pos = fieldSizeSlider.getValue();
            updateWinLengthComboBox(pos);
        });

        //Win Length
        JPanel winLengthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        winLengthPanel.add(new JLabel("   Choose win length:    "));
        winLengthComboBox = new JComboBox<>();
        winLengthPanel.add(winLengthComboBox);
        settingsPanel.add(winLengthPanel);

        add(settingsPanel);
        pack();

        loadGameSettings();
        setVisible(true);
    }

    private void loadGameSettings() {
        if (GameSettings.getGameMode() == 0)
            playerVsAi.setSelected(true);
        else
            playerVsPlayer.setSelected(true);
        fieldSizeSlider.setValue(GameSettings.getFieldSize());
        if (fieldSizeSlider.getValue() == MIN_FIELD_SIZE)
            updateWinLengthComboBox(MIN_FIELD_SIZE);
        else
            winLengthComboBox.setSelectedItem(GameSettings.getWinLength());
    }

    private void updateWinLengthComboBox(int toValue) {
        Integer currVal = (Integer) winLengthComboBox.getSelectedItem();
        winLengthComboBox.removeAllItems();
        for (int i = MIN_FIELD_SIZE; i <= toValue; i++)
            winLengthComboBox.addItem(i);
        if (currVal == null || currVal > toValue)
            winLengthComboBox.setSelectedItem(toValue);
        else winLengthComboBox.setSelectedItem(currVal);
    }
}
