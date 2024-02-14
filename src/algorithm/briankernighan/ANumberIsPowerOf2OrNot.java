package algorithm.briankernighan;

public class ANumberIsPowerOf2OrNot {

    /**
     * Brian Kernighan's Algorithm (n - (n-1)) bitwise operator AND is 0 true else false
     * Check the binary of the n and n-1.
     * Perform bitwise AND logical operation
     * if result is 0 ; power of 2 else not
     */
    static  boolean powerOrNot(int n) {
        if (n==0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }


    public static void main(String[] args) {
        int n = 11;
        System.out.println(powerOrNot(n));
    }
}
