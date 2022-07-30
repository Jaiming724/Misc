package algs.hackerrank;

public class Array_Part_Two {
    public static boolean canWin(int leap, int[] game) {
        return canWinHelper(leap, game, 0);
    }

    private static boolean canWinHelper(int leap, int[] game, int i) {
        if ((i >= game.length)) {
            return true;
        }
        if (i < 0 || game[i] != 0) {
            return false;
        }
        if (game[i] == 0 && i == game.length - 1)
            return true;
        if (game[i] == 200) {
            return false;
        }
        if (game[i] == 100)
            game[i] = 200;
        game[i] = 100;
        return canWinHelper(leap, game, i + 1) ||
                canWinHelper(leap, game, i + leap) ||
                canWinHelper(leap, game, i - 1);

    }
}
