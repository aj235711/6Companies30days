package adobe;

import java.util.*;
import java.lang.Math;

class GfG {
    static int solve(int A[], int i, int j, int dp[][]) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            dp[i][j] = A[i];
            return dp[i][j];
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int max = Math.max(A[i] + Math.min(solve(A, i + 2, j, dp), solve(A, i + 1, j - 1, dp)),
                A[j] + Math.min(solve(A, i, j - 2, dp), solve(A, i + 1, j - 1, dp)));
        dp[i][j] = max;
        return max;
    }

    public int maxCoins(int A[], int n) {
        // add code here.
        int dp[][] = new int[n][n];
        return solve(A, 0, n - 1, dp);
    }
}

public class PotsOfGold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            GfG g = new GfG();
            System.out.println(g.maxCoins(a, n));
        }
        sc.close();
    }
}
