package ru.academITschool.alaev.model;


import java.util.LinkedList;
import java.util.Random;

public class PlayingField {
    private Cell[][] field;
    private int rows;
    private int columns;

    public PlayingField(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.field = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public void generateBombs(int x, int y, int mines, int rows, int columns) {
        Random generator = new Random();
        int minesCount = mines;
        while (minesCount != 0) {
            int xBomb = generator.nextInt(rows);
            int yBomb = generator.nextInt(columns);
            Cell cell = field[xBomb][yBomb];
            Cell firstMoveCell = field[x][y];
            if (!cell.isMined() && cell != firstMoveCell) {
                cell.setMined(true);
                minesCount--;
            }
        }
        //  field[x][y].setOpen(true);


    }

    public void generate_Bombs_Debug() {
        Cell firstMoveCell = field[0][0];
        field[0][0].setMined(true);
        field[0][1].setMined(true);
        field[0][2].setMined(true);
    }

    public void countBombs(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (field[i][j].isMined()) {
                    while (field[i][j].isMined()) {
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
                            field[i][j].setMineCounter(1);
                        }
                    }
                }
            }
        }
    }

    public void move(int x, int y) {
        if (field[x][y].getMineCounter() != 0) {
            field[x][y].setOpen(true);
        } else {
            LinkedList<Cell> queue = new LinkedList<>();
            queue.add(field[x][y]);
            while (queue.size() != 0) {
                Cell cell = queue.removeFirst();
                cell.setOpen(true);
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
                        if (field[i][j].getMineCounter() == 0 && !field[i][j].isMined()
                                && !field[i][j].isOpen()) {
                            queue.add(field[i][j]);
                        }
                    }
                }
            }
           /* while (queue.size() != 0) {
                for (int i = x; i < rows; i++) {
                    for (int j = y; j < columns; j++) {
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
                                if (field[n][m].getMineCounter() == 0 && !field[n][m].isMined()
                                        && !queue.contains(field[n][m])) {
                                    queue.add(field[n][m]);
                                }
                            }
                        }
                    }
                }
            }*/
        }

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
}
