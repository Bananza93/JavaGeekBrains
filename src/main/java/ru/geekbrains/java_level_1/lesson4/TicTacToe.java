package ru.geekbrains.java_level_1.lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] gameField;

    private static final Scanner PLAYER_ANSWER = new Scanner(System.in);
    private static boolean hasCombination = true;

    private static int xAxis;
    private static int yAxis;
    private static int tokensForWin;

    private static final char PLAYER_TOKEN = 'X';
    private static final char AI_TOKEN = 'O';
    private static final char EMPTY_TOKEN = '.';

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру крестики - нолики!");
        initGameField();
        gameplay();
        System.out.println("Игра окончена.");
    }

    private static void gameplay() {
        while (true) {
            playerTurn();
            if (isGameOver(PLAYER_TOKEN)) break;
            aiSmartTurn();
            if (isGameOver(AI_TOKEN)) break;
        }
    }

    private static void initGameField() {
        System.out.print("Задайте размер игрового поля (кол-во строк и столбцов через пробел): ");
        yAxis = PLAYER_ANSWER.nextInt();
        xAxis = PLAYER_ANSWER.nextInt();
        System.out.print("Задайте длину выигрышной комбинации: ");
        tokensForWin = PLAYER_ANSWER.nextInt();
        gameField = new char[yAxis][xAxis];
        for (char[] arr : gameField) Arrays.fill(arr, '.');
    }

    private static void drawGameField() {
        System.out.print("+-");
        for (int i = 1; i <= xAxis; i++) System.out.print(i + "-");
        for (int y = 0; y < yAxis; y++) {
            System.out.print("\n" + (y + 1) + "|");
            for (int x = 0; x < xAxis; x++) {
                System.out.print(gameField[y][x] + "|");
            }
        }
    }

    private static void playerTurn() {
        drawGameField();
        int y;
        int x;
        do {
            System.out.print("\nУкажите ячейку для хода (№ ряда и № столбца через пробел): ");
            y = PLAYER_ANSWER.nextInt() - 1;
            x = PLAYER_ANSWER.nextInt() - 1;
        } while (!checkPlayerChoice(y, x));
        gameField[y][x] = PLAYER_TOKEN;
    }

    /**
     * Сначала проверяем, может ли ИИ атаковать (если максимальная комбинация ИИ >= максимальной комбинации игрока).
     * Если нет, пытаемся прервать максимальную комбинацию игрока.
     * Если ни одной "неперекрытой" комбинации не будет найдено, то просто ставим токен в любую свободную ячейку (возможен только ничейный результат).
     */
    private static void aiSmartTurn() {
        //Поиск возможности для атаки/обороны
        if (hasCombination) {
            for (int combinationSize = tokensForWin - 1; combinationSize > 0; combinationSize--) {
                if (hasCombination = makeAiTurn(AI_TOKEN, combinationSize) || makeAiTurn(PLAYER_TOKEN, combinationSize)) {
                    return;
                }
            }
        }
        //Если такой возможности нет, то просто доигрываем матч
        if (!hasCombination) {
            for (int y = 0; y < yAxis; y++) {
                for (int x = 0; x < xAxis; x++) {
                    if (!isFieldOccupied(y, x)) {
                        gameField[y][x] = AI_TOKEN;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Поиск наиболее выгодной комбинации для атаки/обороны ИИ.
     * @param token           - токен для проверки ({@code PLAYER_TOKEN} для обороны, {@code AI_TOKEN} для атаки)
     * @param combinationSize - количество {@code token} в пределах проверяемой длины {@code tokensForWin}
     * @return {@code true} если комбинация найдена и ход выполнен
     */
    private static boolean makeAiTurn(char token, int combinationSize) {
        for (int y = 0; y < yAxis; y++) {
            for (int x = 0; x < xAxis; x++) {
                if (checkVerticalCombination(token, combinationSize, y, x)) {
                    aiPlaceTokenForVerticalCombination(combinationSize, y, x);
                    return true;
                } else if (checkHorizontalCombination(token, combinationSize, y, x)) {
                    aiPlaceTokenForHorizontalCombination(combinationSize, y, x);
                    return true;
                } else if (checkRightDiagonalCombination(token, combinationSize, y, x)) {
                    aiPlaceTokenForRightDiagonalCombination(combinationSize, y, x);
                    return true;
                } else if (checkLeftDiagonalCombination(token, combinationSize, y, x)) {
                    aiPlaceTokenForLeftDiagonalCombination(combinationSize, y, x);
                    return true;
                }
            }
        }
        return false;
    }

    private static void aiPlaceTokenForVerticalCombination(int combinationSize, int startY, int startX) {
        for (int shiftY = 0; shiftY < tokensForWin; shiftY++) {
            int currY = startY + shiftY;
            if (combinationSize == tokensForWin - 1) {
                if (!isFieldOccupied(currY, startX)) {
                    gameField[currY][startX] = AI_TOKEN;
                    break;
                }
            } else if (isFieldOccupied(currY, startX)) {
                if (!isFieldOccupied(currY + 1, startX)) {
                    gameField[currY + 1][startX] = AI_TOKEN;
                    break;
                }
            } else {
                if (currY != 0 && isFieldOccupied(currY + 1, startX)) {
                    gameField[currY][startX] = AI_TOKEN;
                    break;
                }
            }
        }
    }

    private static void aiPlaceTokenForHorizontalCombination(int combinationSize, int startY, int startX) {
        for (int shiftX = 0; shiftX < tokensForWin; shiftX++) {
            int currX = startX + shiftX;
            if (combinationSize == tokensForWin - 1) {
                if (!isFieldOccupied(startY, currX)) {
                    gameField[startY][currX] = AI_TOKEN;
                    break;
                }
            } else if (isFieldOccupied(startY, currX)) {
                if (!isFieldOccupied(startY, currX + 1)) {
                    gameField[startY][currX + 1] = AI_TOKEN;
                    break;
                }
            } else {
                if (currX != 0 && isFieldOccupied(startY, currX + 1)) {
                    gameField[startY][currX] = AI_TOKEN;
                    break;
                }
            }
        }
    }

    private static void aiPlaceTokenForRightDiagonalCombination(int combinationSize, int startY, int startX) {
        for (int shiftYX = 0; shiftYX < tokensForWin; shiftYX++) {
            int currY = startY + shiftYX;
            int currX = startX + shiftYX;
            if (combinationSize == tokensForWin - 1) {
                if (!isFieldOccupied(currY, currX)) {
                    gameField[currY][currX] = AI_TOKEN;
                    break;
                }
            } else if (isFieldOccupied(currY, currX)) {
                if (!isFieldOccupied(currY + 1, currX + 1)) {
                    gameField[currY + 1][currX + 1] = AI_TOKEN;
                    break;
                }
            } else {
                if (currY > 0 && currX > 0 && isFieldOccupied(currY + 1, currX + 1)) {
                    gameField[currY][currX] = AI_TOKEN;
                    break;
                }
            }
        }
    }

    private static void aiPlaceTokenForLeftDiagonalCombination(int combinationSize, int startY, int startX) {
        for (int shiftYX = 0; shiftYX < tokensForWin; shiftYX++) {
            int currY = startY + shiftYX;
            int currX = startX - shiftYX;
            if (combinationSize == tokensForWin - 1) {
                if (!isFieldOccupied(currY, currX)) {
                    gameField[currY][currX] = AI_TOKEN;
                    break;
                }
            } else if (isFieldOccupied(currY, currX)) {
                if (!isFieldOccupied(currY + 1, currX - 1)) {
                    gameField[currY + 1][currX - 1] = AI_TOKEN;
                    break;
                }
            } else {
                if (currY > 0 && currX < xAxis - 1 && isFieldOccupied(currY + 1, currX - 1)) {
                    gameField[currY][currX] = AI_TOKEN;
                    break;
                }
            }
        }
    }

    private static boolean checkPlayerChoice(int y, int x) {
        if (!isFieldValid(y, x)) {
            System.out.print("Такой ячейки не существует");
            return false;
        }
        if (isFieldOccupied(y, x)) {
            System.out.print("Данная ячейча занята");
            return false;
        }
        return true;
    }

    private static boolean isFieldValid(int y, int x) {
        return y >= 0 && y < yAxis && x >= 0 && x < xAxis;
    }

    private static boolean isFieldOccupied(int y, int x) {
        return gameField[y][x] != EMPTY_TOKEN;
    }

    private static boolean isGameOver(char token) {
        if (isWin(token)) {
            drawGameField();
            if (token == PLAYER_TOKEN) System.out.println("\nПобеда за игроком!");
            else System.out.println("\nПобедил компьютер!");
            return true;
        }
        if (isDraw()) {
            drawGameField();
            System.out.println("\nНичья!");
            return true;
        }
        return false;
    }

    private static boolean isDraw() {
        for (char[] arr : gameField) {
            for (char token : arr) {
                if (token == EMPTY_TOKEN) return false;
            }
        }
        return true;
    }

    private static boolean isWin(char token) {
        for (int y = 0; y < yAxis; y++) {
            for (int x = 0; x < xAxis; x++) {
                if (gameField[y][x] == token) {
                    if (checkVerticalCombination(token, tokensForWin, y, x)
                            || checkHorizontalCombination(token, tokensForWin, y, x)
                            || checkRightDiagonalCombination(token, tokensForWin, y, x)
                            || checkLeftDiagonalCombination(token, tokensForWin, y, x))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean checkVerticalCombination(char token, int numberToFind, int startY, int startX) {
        if (startY + tokensForWin <= yAxis) {
            int tokenCount = 0;
            for (int shiftY = 0; shiftY < tokensForWin; shiftY++) {
                if (gameField[startY + shiftY][startX] == token) tokenCount++;
                else if (isFieldOccupied(startY + shiftY, startX)) return false;
            }
            return tokenCount == numberToFind;
        }
        return false;
    }

    private static boolean checkHorizontalCombination(char token, int numberToFind, int startY, int startX) {
        if (startX + tokensForWin <= xAxis) {
            int tokenCount = 0;
            for (int shiftX = 0; shiftX < tokensForWin; shiftX++) {
                if (gameField[startY][startX + shiftX] == token) tokenCount++;
                else if (isFieldOccupied(startY, startX + shiftX)) return false;
            }
            return tokenCount == numberToFind;
        }
        return false;
    }

    private static boolean checkRightDiagonalCombination(char token, int numberToFind, int startY, int startX) {
        if (startY + tokensForWin <= yAxis) {
            int tokenCount = 0;
            if (startX + tokensForWin <= xAxis) {
                for (int shiftYX = 0; shiftYX < tokensForWin; shiftYX++) {
                    if (gameField[startY + shiftYX][startX + shiftYX] == token) tokenCount++;
                    else if (isFieldOccupied(startY + shiftYX, startX + shiftYX)) return false;
                }
                return tokenCount == numberToFind;
            }
        }
        return false;
    }

    private static boolean checkLeftDiagonalCombination(char token, int numberToFind, int startY, int startX) {
        if (startY + tokensForWin <= yAxis) {
            int tokenCount = 0;
            if (startX + 1 >= tokensForWin) {
                for (int shiftYX = 0; shiftYX < tokensForWin; shiftYX++) {
                    if (gameField[startY + shiftYX][startX - shiftYX] == token) tokenCount++;
                    else if (isFieldOccupied(startY + shiftYX, startX - shiftYX)) return false;
                }
                return tokenCount == numberToFind;
            }
        }
        return false;
    }
}

