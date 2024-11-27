package ch.bbw.pr.GoL;
import java.util.Random;
import java.util.random.*;
// Hat Kommentrae weil ich ein Problem hatt wegen einem Fehler und es ihn Chatgpt getan hat für Behebung un der Hatt Coments gemacht
public class GridMaker {
    private final int GRID_SIZE = 25; // Grid size
    private char[][] grid;
    Random rand = new Random();

    public GridMaker() {
        grid = new char[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '0';
            }
        }
         // max 20 Zellen
        for (int i = 0; i < (GRID_SIZE*3); i++) {
            grid[rand.nextInt(GRID_SIZE)][rand.nextInt(GRID_SIZE)] = 'X';
        }
    }

    public void printGrid() {
        int anzX = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == 'X') {
                    System.out.print("\u001B[43m" + "\u001B[33m" + grid[i][j] + " \u001B[0m");
                    anzX++;
                }
                else {
                    System.out.print("\u001B[40m" + "\u001B[30m" + grid[i][j] + " \u001B[0m");
                }
            }
            System.out.println();
        }
    }

    public char[][] getGrid() {
        return grid;
    }

    public char getValueOf(int x, int y) {
        return grid[x][y];
    }

    public int getGridWidth() {
        return grid[0].length; // braucht wegen Anti Overflow
    }

    public int getGridHeight() {
        return grid.length; // braucht wegen anti Overflow
    }
}
