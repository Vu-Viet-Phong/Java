package goodrich.c3;

public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) {
                numEntries++;
            }

            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = e;
        }
    }

    /**
     * Remove the high score at index 
     * @param i index
     * @return return the high score at index
     * @throws IndexOutOfBoundsException
     */
    public GameEntry remove(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        }

        GameEntry temp = board[idx];
        for (int j = idx; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return temp;
    }
}
