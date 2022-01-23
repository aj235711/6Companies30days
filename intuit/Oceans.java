package intuit;

import java.util.*;

class Solution {
    public static void solve(int[][] heights, int i, int j, int prev, boolean[][] ocean) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) {
            return;
        }
        if (ocean[i][j] || prev > heights[i][j]) {
            return;
        }
        ocean[i][j] = true;
        solve(heights, i - 1, j, heights[i][j], ocean);
        solve(heights, i + 1, j, heights[i][j], ocean);
        solve(heights, i, j - 1, heights[i][j], ocean);
        solve(heights, i, j + 1, heights[i][j], ocean);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights[0].length; i++) {
            solve(heights, 0, i, -1, pacific);
            solve(heights, heights.length - 1, i, -1, atlantic);
        }

        for (int i = 0; i < heights.length; i++) {
            solve(heights, i, 0, -1, pacific);
            solve(heights, i, heights[0].length - 1, -1, atlantic);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;

    }
}

public class Oceans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] heights = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println(obj.pacificAtlantic(heights));
        sc.close();
    }
}
