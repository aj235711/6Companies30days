package wallmart;

class Solution {
    // Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) {
        // Your code here
        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < b; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[a - 1][b - 1];
    }
}

public class UniquePaths {

}
