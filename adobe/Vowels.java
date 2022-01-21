package adobe;

import java.io.*;
import java.util.*;

class Solution {
    final static long m = 1000000007;

    public int kvowelwords(int n, int k) {
        // code here
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    if (j == 0) {
                        dp[i][j] = (dp[i - 1][k] * 21) % m;
                    } else {
                        dp[i][j] = ((dp[i - 1][k] * 21) % m + (dp[i - 1][j - 1] * 5) % m) % m;
                    }
                }

            }

        }
        return (int) dp[n][k];
    }
}

public class Vowels {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.kvowelwords(N, K);
            System.out.println(ans);
        }
        sc.close();
    }
}
