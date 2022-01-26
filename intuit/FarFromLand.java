package intuit;

import java.util.*;

class Solution {
    public static void helper(int[][] grid, int n, int[][] visited, int i, int j, Queue<int[]> queue) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return;
        }
        if (visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        int[] arr = new int[2];
        arr[0] = i;
        arr[1] = j;
        queue.add(arr);
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    int arr[] = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    queue.add(arr);
                    visited[i][j] = 1;
                }
            }
        }
        if (count == 0 || count == n * n) {
            return -1;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                helper(grid, n, visited, x + 1, y, queue);
                helper(grid, n, visited, x - 1, y, queue);
                helper(grid, n, visited, x, y + 1, queue);
                helper(grid, n, visited, x, y - 1, queue);
            }
            ans++;
        }
        return ans - 1;
    }
}

public class FarFromLand {
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
        System.out.println(obj.maxDistance(grid));
        sc.close();
    }
}
