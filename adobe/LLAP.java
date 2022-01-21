package adobe;

import java.io.*;

class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        // code here
        if (n <= 2) {
            return n;
        }
        int[][] dp = new int[n][n];
        int ans = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        int j = n - 2, i, k;
        while (j >= 0) {
            i = j - 1;
            k = j + 1;
            while (i >= 0 && k < n) {
                if (A[i] + A[k] > 2 * A[j]) {
                    i--;
                } else if (A[i] + A[k] < 2 * A[j]) {
                    k++;
                } else {
                    dp[i][j] = dp[j][k] + 1;
                    ans = Math.max(ans, dp[i][j]);
                    i--;
                    k++;
                }
            }
            j--;
        }
        return ans;
    }
}

public class LLAP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}
