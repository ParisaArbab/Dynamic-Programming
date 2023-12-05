public class MatrixChainMultiplication {
    private int[][] m;
    private int[][] s;
    private int n;

    public static void main(String[] args) {
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        int[] dimensions = Util.prepareSample(mcm, args);
        mcm.n = dimensions.length - 1;
        mcm.m = new int[mcm.n][mcm.n];

        analyzeSample(mcm, dimensions);
    }

    public int recursiveMatrixChain(int[] p) {
        return recursiveMatrixChain(p, 0, p.length - 2);
    }

    /**
     * The straight-forward recursive implementation.
     */
    public int recursiveMatrixChain(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }

        m[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int q = recursiveMatrixChain(p, i, k) + recursiveMatrixChain(p, k + 1, j) + p[i] * p[k + 1] * p[j + 1];
            if (q < m[i][j]) {
                m[i][j] = q;
            }
        }

        return m[i][j];
    }

    /**
     * The top-down memoized implementation.
     */
    public int memoizedMatrixChain(int[] p) {
        m = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                m[i][j] = Integer.MAX_VALUE;
            }
        }

        return lookupChain(m, p, 0, n - 1);
    }

    private int lookupChain(int[][] m, int[] p, int i, int j) {
        if (m[i][j] < Integer.MAX_VALUE) {
            return m[i][j];
        }
        if (i == j) {
            m[i][j] = 0;
        } else {
            for (int k = i; k < j; k++) {
                int q = lookupChain(m, p, i, k) + lookupChain(m, p, k + 1, j) + p[i] * p[k + 1] * p[j + 1];
                if (q < m[i][j]) {
                    m[i][j] = q;
                }
            }
        }

        return m[i][j];
    }

    /**
     * The bottom-up iterative implementation.
     */
    public void matrixChainOrder(int[] p) {
        m = new int[n][n];
        s = new int[n][n];

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l < n + 1; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    /**
     * parenthesize the matrix multiplications optimally.
     */
    public String parenthesize(int[][] indices, int i, int j) {
        if (i == j)
            return "A" + (i + 1);
        else
            return "(" + parenthesize(indices, i, indices[i][j])
                    + parenthesize(indices, indices[i][j] + 1, j) + ")";
    }

    private static void analyzeSample(MatrixChainMultiplication mcm, int[] dimensions) {
        long dpStart = System.nanoTime();
        mcm.matrixChainOrder(dimensions);
        long dpFinish = System.nanoTime();

        String optimalParenthesization = mcm.parenthesize(mcm.s, 0, dimensions.length - 2);

        long start = System.nanoTime();
        long minMultiplications = mcm.recursiveMatrixChain(dimensions);
        long finish = System.nanoTime();
        System.out.printf("%d, %s, %d%n", minMultiplications, optimalParenthesization, (finish - start));

        start = System.nanoTime();
        minMultiplications = mcm.memoizedMatrixChain(dimensions);
        finish = System.nanoTime();
        System.out.printf("%d, %s, %d%n", minMultiplications, optimalParenthesization, (finish - start));

        System.out.printf("%d, %s, %d%n", mcm.m[0][dimensions.length - 2], optimalParenthesization, (dpFinish - dpStart));
    }
}
