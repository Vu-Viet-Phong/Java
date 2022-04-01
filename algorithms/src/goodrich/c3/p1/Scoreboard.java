package goodrich.c3.p1;

/** Class for storing high scores in an array in nondecreasing order. */
public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    /* Attempt to add a new score to the collection (if it is high enough). */
    public void add(GameEntry e) {
        if (numEntries < board.length || e.getScore() >  board[numEntries - 1].getScore()) {
            if (numEntries < board.length) numEntries++;           

            // Sort high to low score
            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < e.getScore()) {
                board[j] = board[j - 1];  // shift entry form j - 1 to j
                j--;
            }
            board[j] = e;
        }
    }

    /* Remove and return the high score at index i. */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries) 
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        
        GameEntry temp = board[i];                  // save the object to be removed
        for (int j = i; j < numEntries - 1; j++) {  // count up form i (not down)
            board[j] = board[j + 1];                // move one cell to the left          
        }
        board[numEntries - 1] = null;               // null out the old last score 
        numEntries--;

        return temp;                                // return the removed object
    }

    public void display() {
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i]);
        }
        System.out.println("------------");
    }

    public static void main(String[] args) {
        Scoreboard sb = new Scoreboard(5);
        
        GameEntry ge1 = new GameEntry("phong1", 10);
        GameEntry ge2 = new GameEntry("phong2", 100);
        GameEntry ge3 = new GameEntry("phong3", 90);
        GameEntry ge4 = new GameEntry("phong4", 95);
        
        sb.add(ge1);
        sb.add(ge2);
        sb.add(ge3);
        sb.add(ge4);
        sb.display();

        GameEntry ge5 = new GameEntry("phong5", 60);
        sb.add(ge5);
        sb.display();

        GameEntry ge6 = new GameEntry("phong6", 65);
        sb.add(ge6);
        sb.display();

        sb.remove(0);
        sb.display();
    }
}
