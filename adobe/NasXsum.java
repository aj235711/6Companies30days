package adobe;

import java.io.*;

class Solution {
    static long helper(int i, int sum, int z, int n, int x, long[][] dp) {
        if (i > z + 1 || sum > n) {
            return 0;
        }
        if (dp[i][sum] > -1) {
            return dp[i][sum];
        }
        if (sum == n) {
            return 1;
        }
        long ans = helper(i + 1, sum + (int) Math.pow(i, x), z, n, x, dp) + helper(i + 1, sum, z, n, x, dp);
        dp[i][sum] = ans;
        return ans;
    }

    long numOfWays(int n, int x) {
        // code here
        int z = 0;
        for (int i = 1;; i++) {
            int pow = (int) Math.pow(i, x);
            if (pow > n) {
                break;
            }
            z = i;
        }
        long[][] dp = new long[z + 2][n + 1];
        for (int i = 0; i <= z + 1; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(1, 0, z, n, x, dp);
    }
}

public class NasXsum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] input = new String[2];
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}
