package wallmart;

class Solution {

    public static int solve(int left, int right, int[][] dp) {
        if (left >= right)
            return 0;
        if (dp[left][right] > 0)
            return dp[left][right];
        int minCost = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int cost = i + Math.max(solve(left, i - 1, dp), solve(i + 1, right, dp));
            minCost = Math.min(minCost, cost);
        }
        dp[left][right] = minCost;
        return minCost;
    }

    public int getMoneyAmount(int n) {
        if (n <= 1)
            return 0;
        int[][] dp = new int[n + 1][n + 1];
        return solve(0, n, dp);
    }
}

public class GuessNumber {

}
