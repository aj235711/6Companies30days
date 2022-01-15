package microsoft;

import java.util.*;

class Solution {
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        // Your code here
        if (n == 1) {
            return arr[0];
        }
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], arr[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}

public class SticklerThief {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking count of testcases
        int t = sc.nextInt();
        while (t-- > 0) {

            // taking count of houses
            int n = sc.nextInt();
            int arr[] = new int[n];

            // inserting money present in
            // each house in the array
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            // calling method FindMaxSum() of class solve
            System.out.println(new Solution().FindMaxSum(arr, n));
        }
        sc.close();
    }
}
