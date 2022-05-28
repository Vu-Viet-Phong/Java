
package goodrich.c3;

/** Simulation of a Tic-Tac-Toe game (does not do strategy). */
public class TicTacToe {
    public static final int X = 1, O = -1; 
    public static final int EMPTY = 0;
    private int[][] board = new int[3][3];
    private int player;

    public TicTacToe() { 
        clearBoard(); 
    }

    public void clearBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = EMPTY;
            }
        }
        player = X;
    }

    /** Puts an X or O mark at position i, j */
    public void putMark(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2)) {
            throw new IllegalArgumentException("Invalid board position");
        } 

        if (board[i][j] != EMPTY) {
            throw new IllegalArgumentException("Board position occupied");
        }
        board[i][j] = player;
        player = - player;
    }

    /** Checks whether the board configuration is a win for the given player */
    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3)   // row 0
             || (board[1][0] + board[1][1] + board[1][2] == mark * 3)   // row 1
             || (board[2][0] + board[2][1] + board[2][2] == mark * 3)   // row 2
             || (board[0][0] + board[1][0] + board[2][0] == mark * 3)   // column 0
             || (board[0][1] + board[1][1] + board[2][1] == mark * 3)   // column 1
             || (board[0][2] + board[1][2] + board[2][2] == mark * 3)   // column 2
             || (board[0][0] + board[1][1] + board[2][2] == mark * 3)   // diagonal
             || (board[2][0] + board[1][1] + board[0][2] == mark * 3)); // rev diag
    }

    /** Returns the winning player's code, or 0 to indicate a tie (or unfinished game) */
    public int winner() {
        if (isWin(X)) {
            return X;
        } else if (isWin(O)) {
            return O;
        } else {
            return 0;
        }
    }

    /** Returns a simple character string showing the current board */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                switch (board[row][col]) {
                    case X: 
                        sb.append("X");
                        break;
                    case O: 
                        sb.append("O");
                        break;
                    case EMPTY:
                        sb.append(" ");
                        break;
                }

                if (col < 2) {
                    sb.append("|");
                }
            }
            if (row < 2) {
                sb.append("\n-----\n");
            }
        }
        return sb.toString();
    }
}
