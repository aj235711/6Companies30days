package intuit;

import java.util.*;

class Solution {
    public int findCircleNum(int[][] grid) {
        int[] visited = new int[grid.length];
        Stack<Integer> stk = new Stack<Integer>();
        int ans = 0, i = 0;
        while (i < grid.length) {
            if (visited[i] == 1) {
                i++;
                continue;
            }
            ans++;
            visited[i] = 1;
            stk.push(i);
            while (!stk.isEmpty()) {
                int x = stk.pop();
                for (int j = 0; j < grid[0].length; j++) {
                    if (visited[j] == 0 && grid[x][j] == 1) {
                        stk.push(j);
                        visited[j] = 1;
                    }
                }
            }
            i++;
        }
        return ans;
    }
}

public class Provinces {
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
        System.out.println(obj.findCircleNum(grid));
        sc.close();
    }
}
