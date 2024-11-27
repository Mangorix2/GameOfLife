package ch.bbw.pr.GoL.Logic;

import ch.bbw.pr.GoL.*;

public class Logic {

    private char[][] adjacentGrid = new char[3][3];

    public void checkEveryCell(char[][] grid, GridMaker game) {
        char[][] danachGrid = new char[grid.length][grid[0].length];
        for (int i = 0; i < danachGrid.length; i++) { // füllen von Danachgrid
            for (int j = 0; j < danachGrid[i].length; j++) {
                danachGrid[i][j] = '0';
            }
        }
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {

                if (grid[x][y] == 'X') {  // Regel 1 Wenn zwei Nachbarn dann bleibst am Leben
                    getAdjacentGrid(x, y, game);
                    if (wieVielX(adjacentGrid) == 3 || wieVielX(adjacentGrid) == 4) {
                        danachGrid[x][y] = 'X';
                    } else {
                        danachGrid[x][y] = '0';
                    }
                }
                else{ // Regel 1 Tote Zelle mit 3 Nachbarn wird Leben
                    getAdjacentGrid(x, y, game);
                    if (wieVielX(adjacentGrid) == 3) {
                        danachGrid[x][y] = 'X';
                    } else {
                        danachGrid[x][y] = '0';
                    }
                }
            }
        }
        for (int x = 0; x < grid.length; x++) {  // macht jede Data 1 zu 1 in grid
            System.arraycopy(danachGrid[x], 0, grid[x], 0, grid[x].length);
        }
    }

    private void getAdjacentGrid(int x, int y, GridMaker game) {
        for (int i = -1; i <= 1; i++) { // Damit flaas overflow überkanten nicht Kaputt geht
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;

                if (newX >= 0 && newX < game.getGridWidth() && newY >= 0 && newY < game.getGridHeight()) { //Anti Kaputt bei Overflow
                    adjacentGrid[i + 1][j + 1] = game.getValueOf(newX, newY);
                } else {
                    adjacentGrid[i + 1][j + 1] = 'O';
                }
            }
        }
    }

    public int wieVielX(char [][]g) {
        int anzahlX = 0;
        for (int x = 0; x < g.length; x++) {
            for (int y = 0; y < g[x].length; y++) {
                if (g[x][y] == 'X') {
                    anzahlX++;
                }
            }
        }
        return anzahlX;
    }
}
