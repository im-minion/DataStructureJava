import java.util.HashSet;

public class Q_036_ValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {

        boolean rows = checkRows(board);
        System.out.println("done rows");
        if (!rows) return false;


        boolean b = issubBoxValid(0, 0, board);
        System.out.println("done box");
        if (!b) return false;


        transpose(board);
        boolean cols = checkRows(board);
        System.out.println("done cols");
        if (!cols) return false;

        return true;
    }

    public static boolean issubBoxValid(int colNumber, int rowNumber, char[][] board) {
        HashSet<Character> hs = new HashSet<>();
        Character empty = '.';

        if (colNumber >= 9 || rowNumber >= 9) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Character c = board[rowNumber + i][colNumber + j];
                if (!c.equals(empty)) {
                    if (hs.contains(c)) {
                        return false;
                    }
                    hs.add(c);
                }
            }
        }

        return issubBoxValid(colNumber + 3, rowNumber, board) && issubBoxValid(colNumber, rowNumber + 3, board);
    }

    public static boolean checkRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> h = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (h.contains(board[i][j])) {
                        return false;
                    } else {
                        h.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    public static void transpose(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = i; j < board[i].length; j++) {
                // swap i j
                // if(i != j) {
                char t = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = t;
                // }
            }
        }
    }

}
