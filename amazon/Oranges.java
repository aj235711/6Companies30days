package amazon;

import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0, fresh = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                int i = queue.peek().x, j = queue.peek().y;
                queue.poll();
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    fresh--;
                    queue.add(new Pair(i + 1, j));
                }
                if (i - 1 > -1 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    fresh--;
                    queue.add(new Pair(i - 1, j));
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    fresh--;
                    queue.add(new Pair(i, j + 1));
                }
                if (j - 1 > -1 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    fresh--;
                    queue.add(new Pair(i, j - 1));
                }
            }
            ans++;
        }
        if (fresh > 0) {
            return -1;
        }
        return ans - 1;
    }
}

public class Oranges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println(obj.orangesRotting(grid));
        sc.close();
    }
}
