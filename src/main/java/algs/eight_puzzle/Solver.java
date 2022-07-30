package algs.eight_puzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    private MinPQ<Node> minPQReal = new MinPQ<>();
    private MinPQ<Node> minPQTwin = new MinPQ<>();
    private List<Board> historyReal = new ArrayList<>();
    private int moves;
    private boolean isSolveable;

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        minPQReal.insert(new Node(initial, 0, null));
        minPQTwin.insert(new Node(initial.twin(), 0, null));
        Node currentReal = minPQReal.delMin();
        Node currentTwin = minPQTwin.delMin();
        while (true) {
            historyReal.add(currentReal.board);
            if (currentReal.board.isGoal()) {
                moves = currentReal.moves;
                isSolveable = true;
                break;
            }
            if (currentTwin.board.isGoal()) {
                isSolveable = false;
                break;
            }

            for (Board b : currentReal.board.neighbors()) {
                if (currentReal.previous == null || !b.equals(currentReal.previous.board)) {
                    Node temp = new Node(b, currentReal.moves + 1, currentReal);
                    minPQReal.insert(temp);
                }
            }
            for (Board b : currentTwin.board.neighbors()) {
                if (currentTwin.previous == null || !b.equals(currentTwin.previous.board)) {
                    Node temp = new Node(b, currentTwin.moves + 1, currentTwin);
                    minPQTwin.insert(temp);
                }
            }
            currentReal = minPQReal.delMin();
            currentTwin = minPQTwin.delMin();
        }
    }


    public static void main(String[] args) {

        // create initial board from file
        In in = new In("input.txt");
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);
        System.out.println(initial);
        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    public boolean isSolvable() {
        return isSolveable;
    }

    public Iterable<Board> solution() {
        if (isSolveable) {
            return historyReal;
        }
        return null;
    }

    public int moves() {
        if (isSolveable) {
            return moves;
        }
        return -1;
    }

    private static class Node implements Comparable<Node> {
        Board board;
        int moves = 0;
        Node previous = null;
        int priority;

        public Node(Board board, int moves, Node previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
            this.priority = board.manhattan() + moves;
        }

        @Override
        public int compareTo(Node o) {

            return Integer.compare(this.priority, o.priority);
        }
    }
}
