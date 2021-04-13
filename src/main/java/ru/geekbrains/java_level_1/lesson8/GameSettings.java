package ru.geekbrains.java_level_1.lesson8;

public class GameSettings {
    private static int gameMode = 0;
    private static int fieldSize = 3;
    private static int winLength = 3;

    private GameSettings() {
    }

    public static void setGameMode(int gameMode) {
        GameSettings.gameMode = gameMode;
    }

    public static void setFieldSize(int fieldSize) {
        GameSettings.fieldSize = fieldSize;
    }

    public static void setWinLength(int winLength) {
        GameSettings.winLength = winLength;
    }

    public static int getGameMode() {
        return gameMode;
    }

    public static int getFieldSize() {
        return fieldSize;
    }

    public static int getWinLength() {
        return winLength;
    }
}
