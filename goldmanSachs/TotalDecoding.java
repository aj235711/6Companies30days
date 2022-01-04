package goldmanSachs;

import java.util.*;

class Solution {
    public int CountWays(String str) {
        int n = str.length();
        if (toInt(str, 0, 1) == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        int a = toInt(str, n - 1, n), b = toInt(str, n - 2, n - 1), c = toInt(str, n - 2, n);
        if (a == 0 && b == 0) {
            return 0;
        } else if (a == 0 && b > 2) {
            return 0;
        } else if (a == 0) {
            dp[n - 1] = 0;
            dp[n - 2] = 1;
        } else if (b == 0) {
            dp[n - 1] = 1;
            dp[n - 2] = 0;
        } else if (c <= 26) {
            dp[n - 1] = 1;
            dp[n - 2] = 2;
        } else {
            dp[n - 1] = 1;
            dp[n - 2] = 1;
        }
        if (n == 2) {
            return dp[0];
        }
        boolean flag = false;
        for (int i = n - 3; i >= 0; i--) {
            if (toInt(str, i, i + 1) == 0) {
                dp[i] = 0;
                flag = true;
                continue;
            }
            if (flag == true && (toInt(str, i, i + 1) == 0 || toInt(str, i, i + 1) > 2)) {
                return 0;
            }
            if (toInt(str, i, i + 2) <= 26) {
                dp[i] = (dp[i + 1] % 1000000007 + dp[i + 2] % 1000000007) % 1000000007;
            } else {
                dp[i] = dp[i + 1] % 1000000007;
            }
            flag = false;
        }
        return dp[0];
    }

    public static int toInt(String s, int l, int h) {
        return Integer.parseInt(s.substring(l, h));
    }
}

public class TotalDecoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.CountWays(str));
        sc.close();
    }
}
