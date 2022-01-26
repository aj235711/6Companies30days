package intuit;

import java.util.*;

class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length, ans = 0;
        int[] trail = new int[n];
        for (int i = 0; i < n; i++) {
            int j = n - 1;
            while (j >= 0 && grid[i][j] == 0) {
                trail[i]++;
                j--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (trail[i] >= n - i - 1) {
                continue;
            }
            int x = trail[i], flag = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = x;
                x = trail[j];
                trail[j] = temp;
                if (x >= n - i - 1) {
                    flag = 1;
                    ans += j - i;
                    trail[i] = x;
                    break;
                }
            }
            if (flag == 0) {
                return -1;
            }
        }
        return ans;
    }
}

public class BinaryGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println(obj.minSwaps(grid));
        sc.close();
    }
}
