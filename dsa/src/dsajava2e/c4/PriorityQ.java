package dsajava2e.c4;

public class PriorityQ {
    private int maxSize;
    private long[] queArray;
    private int nItems;
    
    public PriorityQ(int maxSize) {
        this.maxSize = maxSize;
        queArray = new long[maxSize];
        nItems = 0;
    }
    
    public void insert(long item) {
        int j;

        if (nItems == 0) {
            queArray[nItems++] = item; // insert at 0
        } else { 
            for (j = nItems - 1; j >= 0; j--) { 
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {                           
                    break;
                }                          
            }
            queArray[j + 1] = item; // insert it (queArray[0], j = -1)
            System.out.println(queArray[2]);
            nItems++;
        }
    }
    
    /* Remove minimum item */
    public long remove() {
        return queArray[--nItems]; 
    }

    /* Peek at minimum item */
    public long peekMin() { 
        return queArray[nItems - 1]; 
    }

    public boolean isEmpty() { 
        return (nItems == 0); 
    }

    public boolean isFull() { 
        return (nItems == maxSize); 
    }

    public int getSize() {
        return nItems;
    }

    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityQ(5);
        
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        while(!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.print(item + " ");  // 10, 20, 30, 40, 50
        }
        System.out.println("");
    }
}