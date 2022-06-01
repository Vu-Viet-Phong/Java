package algorithms.divideandconquer;

public class TowerOfHanoi {
    public static void doTowers(int n, char src, char inter, char dest) {
        if (n == 1) {
            System.out.println("Disk 1 from " + src + " to " + dest);
        } else {
            doTowers(n - 1, src, dest, inter);
            System.out.println("Disk " + n + " from " + src + " to " + dest);
            doTowers(n - 1, inter, src, dest);
        }
    }

    public static void main(String[] args) {
        doTowers(3, 'A', 'B', 'C');
    }
}
                            