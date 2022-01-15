package microsoft;

import java.io.*;

class Solution {
    public static int solve(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + solve(grid, visited, i + 1, j) + solve(grid, visited, i - 1, j) + solve(grid, visited, i, j + 1)
                + solve(grid, visited, i, j - 1) + solve(grid, visited, i - 1, j - 1)
                + solve(grid, visited, i - 1, j + 1)
                + solve(grid, visited, i + 1, j - 1) + solve(grid, visited, i + 1, j + 1);
    }

    public int findMaxArea(int[][] grid) {
        // Code here
        int ans = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, solve(grid, visited, i, j));
            }
        }
        return ans;
    }
}

public class RegionOfOnes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
