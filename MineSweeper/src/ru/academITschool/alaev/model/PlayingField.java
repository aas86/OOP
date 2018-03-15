package ru.academITschool.alaev.model;

import java.util.LinkedList;
import java.util.Random;

public class PlayingField {
    private Cell[][] field;
    private int rows;
    private int columns;
    private int mines;
    private long startTime;
    private long gameTime;
    private boolean gameOver;
    private boolean victory;
    private int openedCount = 0;

    public PlayingField(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        this.field = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public long getGameTime() {
        return gameTime;
    }

    public boolean isVictory() {
        return victory;
    }

    public int getOpenedCount() {
        return openedCount;
    }

    void generateBombs(int x, int y, int mines, int rows, int columns) {
        Random generator = new Random();
        int minesCount = mines;

        Cell firstMoveCell = field[x][y];

        while (minesCount != 0) {
            int xBomb = generator.nextInt(rows);
            int yBomb = generator.nextInt(columns);
            Cell cell = field[xBomb][yBomb];
            if (!cell.isMined() && cell != firstMoveCell) {
                cell.setMined(true);
                cell.setBombLabel("B");
                minesCount--;
            }
        }
    }

    public void generate_Bombs_Debug() {
        field[1][0].setMined(true);
        field[1][0].setMineCounter_Debug(0);
        field[2][8].setMined(true);
        field[2][8].setMineCounter_Debug(0);
        field[3][0].setMined(true);
        field[3][0].setMineCounter_Debug(0);
        field[4][7].setMined(true);
        field[4][7].setMineCounter_Debug(0);
        field[7][4].setMined(true);
        field[7][4].setMineCounter_Debug(0);
        field[7][7].setMined(true);
        field[7][7].setMineCounter_Debug(0);
        field[8][0].setMined(true);
        field[8][0].setMineCounter_Debug(0);
        field[8][1].setMined(true);
        field[8][1].setMineCounter_Debug(0);
        field[8][7].setMined(true);
        field[8][7].setMineCounter_Debug(0);
        field[8][8].setMined(true);
        field[8][8].setMineCounter_Debug(0);
    }

    public void countBombs(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (field[i][j].isMined()) {
                    while (field[i][j].isMined() && i != rows - 1 && j != columns - 1) {
                        if (j != columns - 1) {
                            j++;
                        } else {
                            j = 0;
                            i++;
                        }
                    }
                }
                for (int n = i - 1; n <= i + 1; n++) {
                    if (n < 0) {
                        n++;
                    } else if (n == rows) {
                        break;
                    }
                    for (int m = j - 1; m <= j + 1; m++) {
                        if (m < 0) {
                            m++;
                        } else if (m == columns) {
                            break;
                        }
                        if (field[n][m].isMined()) {
                            field[i][j].setMineCounter();
                        }
                    }
                }
            }
        }
    }

    private void openField(Cell[][] field) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field[i][j].setOpen(true);
            }
        }
    }

    private void zeroCase(int x, int y) {
        LinkedList<Cell> queue = new LinkedList<>();
        queue.add(field[x][y]);
        while (queue.size() != 0) {
            Cell cell = queue.removeFirst();
            cell.setOpen(true);
            openedCount += 1;

            if (openedCount == rows * columns - mines) {
                openField(field);
                victory = true;
                gameTime = Math.round((System.nanoTime() - startTime) / 1000000000.0);
                System.out.println(gameTime + " секунд!");
                return;
            }
            if (cell.getMineCounter() == 0) {
                for (int i = cell.getRowPosition() - 1; i <= cell.getRowPosition() + 1; i++) {
                    if (i < 0) {
                        i++;
                    } else if (i == rows) {
                        break;
                    }
                    for (int j = cell.getColumnPosition() - 1; j <= cell.getColumnPosition() + 1; j++) {
                        if (j < 0) {
                            j++;
                        } else if (j == columns) {
                            break;
                        }
                        if (!field[i][j].isMined() && !field[i][j].isOpen() && !queue.contains(field[i][j])) {
                            queue.add(field[i][j]);
                        }
                    }
                }
            }
        }
    }


    private int flagsCount(int x, int y) {
        int flagCount = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0) {
                i++;
            } else if (i == rows) {
                break;
            }
            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0) {
                    j++;
                } else if (j == columns) {
                    break;
                }
                if (field[i][j].isFlagged()) {
                    flagCount++;
                }
            }
        }
        return flagCount;
    }

    private void openFlagNeighbors(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0) {
                i++;
            } else if (i == rows) {
                break;
            }
            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0) {
                    j++;
                } else if (j == columns) {
                    break;
                }
                if (!field[i][j].isOpen() && !field[i][j].isFlagged()) {
                    if (field[i][j].getMineCounter() == 0 && !field[i][j].isMined()) {
                        zeroCase(i, j);
                    }
                    if (!field[i][j].isOpen()) {
                        field[i][j].setOpen(true);
                        openedCount += 1;
                    }
                    if (field[i][j].isMined()) {
                        openField(field);
                        gameOver = true;
                        break;
                    } else {
                        if (openedCount == rows * columns - mines) {
                            openField(field);
                            victory = true;
                            gameTime = Math.round((System.nanoTime() - startTime) / 1000000000.0);
                            System.out.println(gameTime + " секунд!");
                        }
                    }
                }
            }
        }
    }


    public void move(int x, int y, boolean flag, boolean questioned, boolean wheelClick, boolean firstMove) {

        // Если была введена команда flag.
        if (flag) {
            if (field[x][y].isFlagged()) {
                field[x][y].setFlagged(false);
                return;
            } else {
                field[x][y].setFlagged(true);
                return;
            }
        }
        if (questioned) {  // Если была введена команда question
            if (field[x][y].isQuestioned()) {
                field[x][y].setQuestioned(false);
                return;
            } else {
                field[x][y].setQuestioned(true);
                return;
            }
        }
        if (wheelClick) {
            int flagCount = 0;
            if (field[x][y].isOpen() && field[x][y].getMineCounter() != 0) { // если клетка открыта и не 0
                // то нужно посчитать кол-во флажков в соседях
                flagCount = flagsCount(x, y);
                if (flagCount == field[x][y].getMineCounter()) { // если кол-во флажков в соседях равно цифре в поле,
                    // то открываем всех соседей если они закрыты.
                    openFlagNeighbors(x, y);
                    return;
                }
            } else {
                return;
            }
            return;
        }
        //-------------Нажатие левой кнопки------------------------------------------------
        if (firstMove) { // Засекается время во время первого хода
            startTime = System.nanoTime();
        }
        //   System.out.println(start);
        if (field[x][y].isFlagged()) {
            gameOver = false;
        } else if (field[x][y].getMineCounter() != 0 && !field[x][y].isMined() /*&& !field[x][y].isOpen()*/) { //Если попали на цифру
            field[x][y].setOpen(true);
            openedCount += 1;
            if (openedCount == rows * columns - mines) {
                openField(field);
                victory = true;
                gameTime = Math.round((System.nanoTime() - startTime) / 1000000000.0);
                System.out.println(gameTime + " секунд!");
            }
        } else if (field[x][y].isMined()) { // Если заминировано, то тогда открываем все ячейки
            openField(field);
            gameOver = true;
        } else {                           // Если попали на 0
            zeroCase(x, y);
        }
     /*   if (openedCount == rows * columns - mines) {
            openField(field);
            victory = true;
        }*/
    }

    public Cell[][] getField() {
        return field;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
