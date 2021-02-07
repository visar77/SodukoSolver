package com.sudoku;

public class Main {
    public static int[][] puzzle = new int[][]{
            {0,0,0,0,0,0,0,5,3},
            {0,0,2,7,0,9,0,4,0},
            {0,0,7,8,0,0,0,0,0},
            {0,3,0,0,0,0,0,0,6},
            {0,0,0,9,0,1,0,0,0},
            {0,8,9,0,0,2,0,0,7},
            {4,0,0,0,0,0,2,0,0},
            {1,0,0,0,6,0,9,0,0},
            {8,0,0,0,4,0,0,0,0},
    };
    public static void main(String[] args) {
        solve(puzzle);
    }
    public static void solve(int[][] puzzle) {
        for(int y=0; y<9;y++) {
            for(int x=0; x<9;x++) {
                if(puzzle[y][x] == 0) {
                    for(int n=1; n<10;n++) {
                        if (possible(y, x, n)) {
                            puzzle[y][x] = n;
                            solve(puzzle);
                            puzzle[y][x] = 0;
                        }
                    }
                    return;
                }
            }
        }
        StringBuilder solvedpuzzle = new StringBuilder();
        for(int x=0; x<9; x++) {
            if(x % 3 == 0) solvedpuzzle.append("------------" + "\n");
            for(int y=0; y<9; y++) {
                if( y % 3 == 0) solvedpuzzle.append("|");
                solvedpuzzle.append(puzzle[x][y]);
            }
            solvedpuzzle.append("\n");
        }
        System.out.println(solvedpuzzle);
    }
    public static boolean possible(int y, int x, int n) {

        for(int column = 0; column < 9; column++) {
            if(n==puzzle[column][x]) return false;
        }

        for(int row = 0; row < 9; row++) {
            if(n==puzzle[y][row]) return false;
        }

        for(int column=(y/3)*3; column < (y/3)*3+3; column++) {
            for(int row = (x/3)*3; row < (x/3)*3+3; row++) {
                if(puzzle[column][row]==n) return false;
            }
        }

        return true;
    }
}
