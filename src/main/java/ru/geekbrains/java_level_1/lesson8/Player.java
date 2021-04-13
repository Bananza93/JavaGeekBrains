package ru.geekbrains.java_level_1.lesson8;

public abstract class Player {

    private String name;
    private int playerToken;

    public Player(String name, int token) {
        this.name = name;
        this.playerToken = token;
    }

    public String getName() {
        return name;
    }

    public int getPlayerToken() {
        return playerToken;
    }
}
