package amazon;

import java.io.*;

class Solution {
    static char ch;

    static void solve(int i, int j, StringBuilder ans, int[][] helper) {
        if (i == j) {
            ans.append(ch++);
            return;
        }
        ans.append('(');
        solve(i, helper[i][j], ans, helper);
        solve(helper[i][j] + 1, j, ans, helper);
        ans.append(')');
    }

    String matrixChainOrder(int p[], int n) {
        StringBuilder ans = new StringBuilder();
        int[][] dp = new int[n][n];
        int[][] helper = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int x = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (x < min) {
                        min = x;
                        helper[i][j] = k;
                    }
                }
                dp[i][j] = min;
            }
        }
        ch = 'A';
        solve(1, n - 1, ans, helper);
        return ans.toString();
    }
}

public class MatrixChain {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = Integer.parseInt(a[i]);

            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}
