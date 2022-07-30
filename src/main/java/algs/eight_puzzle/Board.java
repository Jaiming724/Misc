package algs.eight_puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Board {
    private final int[][] board;

    public Board(int[][] tiles) {
        this.board = tiles;
    }

    public int dimension() {
        return board.length;
    }

    public int hamming() {
        int errors = 0;
        int count = 1;
        for (int[] i : board) {
            for (int j : i) {
                if (j != 0 && j != count) {
                    errors++;
                }
                count++;
            }
        }
        return errors;
    }

    public boolean isGoal() {
        return manhattan() == 0;
    }

    public Iterable<Board> neighbors() {
        List<Board> boards = new ArrayList<>();
        int targetRow = -1;
        int targetCol = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    targetCol = j;
                    targetRow = i;
                }
            }
        }

        if (targetCol == -1 || targetRow == -1) {
            return null;
        }
        //swap element to its left
        if (targetCol > 0) {
            boards.add(new Board(swap(targetRow, targetCol, targetRow, targetCol - 1)));
        }
        if (targetCol < dimension() - 1) {
            boards.add(new Board(swap(targetRow, targetCol, targetRow, targetCol + 1)));
        }
        if (targetRow > 0) {
            boards.add(new Board(swap(targetRow, targetCol, targetRow - 1, targetCol)));
        }
        if (targetRow < dimension() - 1) {
            boards.add(new Board(swap(targetRow, targetCol, targetRow + 1, targetCol)));
        }
        return boards;
    }

    private int[][] swap(int i1, int j1, int i2, int j2) {
        int[][] arr = new int[dimension()][dimension()];
        for (int k = 0; k < board.length; k++) {
            System.arraycopy(board[k], 0, arr[k], 0, board.length);
        }
        if (!Arrays.deepEquals(arr, board)) {
            System.out.println("Error in copying");
        }
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
        return arr;
    }

    public int manhattan() {
        int error = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int num = board[i][j];
                if (num == 0) {
                    continue;
                }
                int row = (num - 1) / dimension();
                int col = (num % dimension()) - 1;
                if (num % dimension() == 0) {
                    col = dimension() - 1;
                }
                int rowDiff = Math.abs(row - i);
                int colDiff = Math.abs(col - j);
                error += rowDiff;
                error += colDiff;
            }
        }
        return error;
    }

    public Board twin() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
                if (board[i][j] != 0 && board[i][j + 1] != 0) {
                    return new Board(swap(i, j, i, j + 1));
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(dimension()).append("\n");
        for (int[] ints : board) {
            for (int j = 0; j < ints.length; j++) {
                if (j == ints.length - 1) {
                    s.append(ints[j]);
                } else {
                    s.append(ints[j]).append(" ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {0, 7, 6}, {5, 4, 8}};
        Board board1 = new Board(arr);
        System.out.println(board1.toString());
        for (Board board2 : board1.neighbors()) {
            System.out.println(board2);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board1 = (Board) o;

        return Arrays.deepEquals(board, board1.board);
    }

}