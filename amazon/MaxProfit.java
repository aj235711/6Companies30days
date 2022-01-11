package amazon;

import java.util.*;

class Solution {
    int maxProfit(int k, int n, int A[]) {
        // code here
        int[][] dp = new int[k + 1][n];
        int max = 0;
        for (int i = 1; i <= k; i++) {
            max = dp[i - 1][0] - A[0];
            for (int j = 1; j < n; j++) {
                max = Math.max(max, dp[i - 1][j - 1] - A[j - 1]);
                dp[i][j] = Math.max(max + A[j], dp[i][j - 1]);
            }
        }
        return dp[k][n - 1];
    }
}

public class MaxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.maxProfit(k, n, arr));
        sc.close();
    }
}
