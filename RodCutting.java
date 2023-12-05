public class RodCutting {
    private int[] r;

    public static void main(String[] args) {
        RodCutting rc = new RodCutting();

        int[] p = Util.prepareSample(rc, args);
        analyzeSample(rc, p);
    }

    /**
     * The straight-forward recursive implementation.
     */
    public int cutRod(int[] p, int n) {
        if (n == 0) {
            return 0;
        }

        int q = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            q = Math.max(q, p[i] + cutRod(p, n - i - 1));
        }

        return q;
    }

    /**
     * The top-down memoized implementation.
     */
    public int memoizedCutRod(int[] p, int n) {
        r = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            r[i] = Integer.MIN_VALUE;
        }

        return memoizedCutRodAux(p, n, r);
    }

    private int memoizedCutRodAux(int[] p, int n, int[] r) {
        if (r[n] >= 0) {
            return r[n];
        }

        int q;

        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                q = Math.max(q, p[i] + memoizedCutRodAux(p, n - i - 1, r));
            }
        }

        r[n] = q;

        return q;
    }

    /**
     * The bottom-up iterative implementation.
     */
    public int bottomUpCutRod(int[] p, int n) {
        r = new int[n + 1];
        r[0] = 0;

        int q;

        for (int j = 1; j <= n; j++) {
            q = Integer.MIN_VALUE;

            for (int i = 0; i < j; i++) {
                q = Math.max(q, p[i] + r[j - i - 1]);
            }

            r[j] = q;
        }

        return r[n];
    }

    private static void analyzeSample(RodCutting rc, int[] p) {
        long start = System.nanoTime();
        int maxProfit = rc.cutRod(p, p.length);
        long finish = System.nanoTime();
        System.out.printf("%d, %d%n", maxProfit, (finish - start));

        start = System.nanoTime();
        maxProfit = rc.memoizedCutRod(p, p.length);
        finish = System.nanoTime();
        System.out.printf("%d, %d%n", maxProfit, (finish - start));

        start = System.nanoTime();
        maxProfit = rc.bottomUpCutRod(p, p.length);
        finish = System.nanoTime();
        System.out.printf("%d, %d%n", maxProfit, (finish - start));
    }
}
