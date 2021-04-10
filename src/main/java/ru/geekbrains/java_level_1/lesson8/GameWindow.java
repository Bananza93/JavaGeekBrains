package ru.geekbrains.java_level_1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JPanel {

    private static final int EMPTY_TOKEN = 0;
    private static final int PLAYER1_TOKEN = 1;
    private static final int PLAYER2_TOKEN = 2;
    private static final int DOT_PADDING = 7;

    private Player player1;
    private Player player2;
    private Player winner;
    private int[][] gameField;
    private int fieldSizeX;
    private int fieldSizeY;
    private int tokensForWin;
    private int cellWidth;
    private int cellHeight;

    private boolean initialized;
    private boolean switchPlayer;
    private boolean hasCombination;
    private boolean isGameOver;


    public GameWindow() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
        initialized = false;
    }

    private void update(MouseEvent e) {
        if (isGameOver || !initialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        Player currPlayer = switchPlayer ? player1 : player2;
        if (isFieldOccupied(cellY, cellX)) return;
        gameField[cellY][cellX] = currPlayer.getPlayerToken();
        repaint();
        if (isGameOver(currPlayer)) return;
        if (player2 instanceof AI) {
            makeAITurn();
            repaint();
            isGameOver(player2);
            return;
        }
        switchPlayer = !switchPlayer;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!initialized) return;
        int width = getWidth();
        int height = getHeight();
        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (!isFieldOccupied(y, x)) continue;
                if (gameField[y][x] == PLAYER1_TOKEN) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                }

            }
        }

        if (isGameOver) showMessageGameOver(g);
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 100);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("TimesNewRoman", Font.BOLD, 60));
        if (winner == null) {
            g.drawString("DRAW", 150, getHeight() / 2 + 20);
        } else if (winner instanceof AI) {
            g.drawString(winner.getName() + " wins!", 150, getHeight() / 2 + 20);
        } else {
            g.drawString(winner.getName() + " wins!", 50, getHeight() / 2 + 20);
        }
    }

    public void startGame() {
        player1 = new Human("Player 1", PLAYER1_TOKEN);
        if (GameSettings.getGameMode() == 0) {
            player2 = new AI("AI", PLAYER2_TOKEN);
        } else {
            player2 = new Human("Player 2", PLAYER2_TOKEN);
        }
        this.fieldSizeX = GameSettings.getFieldSize();
        this.fieldSizeY = GameSettings.getFieldSize();
        this.tokensForWin = GameSettings.getWinLength();
        gameField = new int[fieldSizeY][fieldSizeX];
        initialized = true;
        isGameOver = false;
        hasCombination = true;
        winner = null;
        switchPlayer = true;
        repaint();
    }

    public void makeAITurn() {
        //Поиск возможности для атаки/обороны
        if (hasCombination) {
            for (int combinationSize = tokensForWin - 1; combinationSize > 0; combinationSize--) {
                if (hasCombination = makeTurn(player2.getPlayerToken(), combinationSize)
                        || makeTurn(player1.getPlayerToken(), combinationSize)) {
                    return;
                }
            }
        }
        //Если такой возможности нет, то просто доигрываем матч
        if (!hasCombination) {
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    if (!isFieldOccupied(y, x)) {
                        gameField[y][x] = player2.getPlayerToken();
                        return;
                    }
                }
            }
        }
    }

    private boolean makeTurn(int token, int combinationSize) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkLine(x, y, 0, 1, combinationSize, token)) {
                    aiPlaceTokenForVerticalCombination(combinationSize, y, x);
                    return true;
                } else if (checkLine(x, y, 1, 0, combinationSize, token)) {
                    aiPlaceTokenForHorizontalCombination(combinationSize, y, x);
                    return true;
                } else if (checkLine(x, y, 1, 1, combinationSize, token)) {
                    aiPlaceTokenForRightDiagonalCombination(combinationSize, y, x);
                    return true;
                } else if (checkLine(x, y, -1, 1, combinationSize, token)) {
                    aiPlaceTokenForLeftDiagonalCombination(combinationSize, y, x);
                    return true;
                }
            }
        }
        return false;
    }

    private void aiPlaceTokenForVerticalCombination(int combinationSize, int startY, int startX) {
        for (int shiftY = 0; shiftY < tokensForWin; shiftY++) {
            int currY = startY + shiftY;
            if (combinationSize == tokensForWin - 1) {
                if (!isFieldOccupied(currY, startX)) {
                    gameField[currY][startX] = player2.getPlayerToken();
                    break;
                }
            } else if (isFieldOccupied(currY, startX)) {
                if (!isFieldOccupied(currY + 1, startX)) {
                    gameField[currY + 1][startX] = player2.getPlayerToken();
                    break;
                }
            } else {
                if (currY != 0 && isFieldOccupied(currY + 1, startX)) {
                    gameField[currY][startX] = player2.getPlayerToken();
                    break;
                }
            }
        }
    }

    private void aiPlaceTokenForHorizontalCombination(int combinationSize, int startY, int startX) {
        for (int shiftX = 0; shiftX < tokensForWin; shiftX++) {
            int currX = startX + shiftX;
            if (combinationSize == tokensForWin - 1) {
                if (!isFieldOccupied(startY, currX)) {
                    gameField[startY][currX] = player2.getPlayerToken();
                    break;
                }
            } else if (isFieldOccupied(startY, currX)) {
                if (!isFieldOccupied(startY, currX + 1)) {
                    gameField[startY][currX + 1] = player2.getPlayerToken();
                    break;
                }
            } else {
                if (currX != 0 && isFieldOccupied(startY, currX + 1)) {
                    gameField[startY][currX] = player2.getPlayerToken();
                    break;
                }
            }
        }
    }

    private void aiPlaceTokenForRightDiagonalCombination(int combinationSize, int startY, int startX) {
        for (int shiftYX = 0; shiftYX < tokensForWin; shiftYX++) {
            int currY = startY + shiftYX;
            int currX = startX + shiftYX;
            if (combinationSize == tokensForWin - 1) {
                if (!isFieldOccupied(currY, currX)) {
                    gameField[currY][currX] = player2.getPlayerToken();
                    break;
                }
            } else if (isFieldOccupied(currY, currX)) {
                if (!isFieldOccupied(currY + 1, currX + 1)) {
                    gameField[currY + 1][currX + 1] = player2.getPlayerToken();
                    break;
                }
            } else {
                if (currY > 0 && currX > 0 && isFieldOccupied(currY + 1, currX + 1)) {
                    gameField[currY][currX] = player2.getPlayerToken();
                    break;
                }
            }
        }
    }

    private void aiPlaceTokenForLeftDiagonalCombination(int combinationSize, int startY, int startX) {
        for (int shiftYX = 0; shiftYX < tokensForWin; shiftYX++) {
            int currY = startY + shiftYX;
            int currX = startX - shiftYX;
            if (combinationSize == tokensForWin - 1) {
                if (!isFieldOccupied(currY, currX)) {
                    gameField[currY][currX] = player2.getPlayerToken();
                    break;
                }
            } else if (isFieldOccupied(currY, currX)) {
                if (!isFieldOccupied(currY + 1, currX - 1)) {
                    gameField[currY + 1][currX - 1] = player2.getPlayerToken();
                    break;
                }
            } else {
                if (currY > 0 && currX < fieldSizeX - 1 && isFieldOccupied(currY + 1, currX - 1)) {
                    gameField[currY][currX] = player2.getPlayerToken();
                    break;
                }
            }
        }
    }

    private boolean checkLine(int x, int y, int incrementX, int incrementY, int len, int token) {
        int endXLine = x + (tokensForWin - 1) * incrementX; //Конец линии по x
        int endYLine = y + (tokensForWin - 1) * incrementY; //Конец линии по y
        if (!isFieldValid(endYLine, endXLine)) return false;
        int tokenCount = 0;
        for (int i = 0; i < tokensForWin; i++) {
            if (gameField[y + i * incrementY][x + i * incrementX] == token) tokenCount++;
            else if (isFieldOccupied(y + i * incrementY, x + i * incrementX)) return false;
        }
        return tokenCount == len;
    }

    private boolean isFieldValid(int y, int x) {
        return y >= 0 && y < fieldSizeY && x >= 0 && x < fieldSizeX;
    }

    private boolean isFieldOccupied(int y, int x) {
        return gameField[y][x] != EMPTY_TOKEN;
    }

    private boolean isGameOver(Player player) {
        if (isWin(player.getPlayerToken())) {
            isGameOver = true;
            winner = player;
            return true;
        }
        if (isDraw()) {
            isGameOver = true;
            return true;
        }
        return false;
    }

    private boolean isDraw() {
        for (int[] arr : gameField) {
            for (int token : arr) {
                if (token == EMPTY_TOKEN) return false;
            }
        }
        return true;
    }

    private boolean isWin(int token) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (gameField[y][x] == token) {
                    if (checkLine(x, y, 1, 0, tokensForWin, token) //Проверка горизонталь +х
                            || checkLine(x, y, 1, 1, tokensForWin, token) //проверка диагонали +х +у
                            || checkLine(x, y, 0, 1, tokensForWin, token) //проверка вертикали +у
                            || checkLine(x, y, -1, 1, tokensForWin, token)) //проверка диагонали +х -у
                        return true;
                }
            }
        }
        return false;
    }
}
