package IntList;

public class IntListExercises {

    /**
     * Part A: (Buggy) mutative method that adds a constant C to each
     * element of an IntList
     *
     * @param lst IntList from Lecture
     */
    public static void addConstant(IntList lst, int c) {
        IntList head = lst;
        do {
            head.first += c;
            head = head.rest;
        } while (head != null);
    }

    /**
     * Part B: Buggy method that sets node.first to zero if
     * the max value in the list starting at node has the same
     * first and last digit, for every node in L
     *
     * @param L IntList from Lecture
     */
    public static void setToZeroIfMaxFEL(IntList L) {
        IntList p = L;
        // 1 22 15
        while (p != null) {
            if (firstDigitEqualsLastDigit(max(p))) {
                p.first = 0;
            }
            p = p.rest;
        }

    }

    /** Returns the max value in the IntList starting at L. */
    public static int max(IntList L) {
        return maxIntList(L).first;
    }

    public static IntList maxIntList(IntList L) {
        IntList res = L;
        IntList max = L;
        while (res != null) {
            if (res.first > max.first)
                max = res;
            res = res.rest;
        }
        return max;
    }

    /**
     * Returns true if the last digit of x is equal to
     * the first digit of x.
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        int lastDigit = x % 10;
        while (x >= 10) {
            x = x / 10;
        }
        int firstDigit = x;
        return firstDigit == lastDigit;
    }

    /**
     * Part C: (Buggy) mutative method that squares each prime
     * element of the IntList.
     *
     * @param lst IntList from Lecture
     * @return True if there was an update to the list
     */
    public static boolean squarePrimes(IntList lst) {
        // Base Case: we have reached the end of the list
        if (lst == null) {
            return false;
        }

        boolean currElemIsPrime = Primes.isPrime(lst.first);

        if (currElemIsPrime) {
            lst.first *= lst.first;
        }

        boolean rest =  squarePrimes(lst.rest);
        return currElemIsPrime || rest;
    }
}
