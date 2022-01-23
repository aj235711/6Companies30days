package intuit;

import java.io.*;

class Solution {
    public static boolean solve(char[][] board, int i, int j, String word, int k, int[][] visited) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j] == 1) {
            return false;
        }
        if (word.charAt(k) != board[i][j]) {
            return false;
        }
        visited[i][j] = 1;
        boolean ans = solve(board, i + 1, j, word, k + 1, visited) ||
                solve(board, i - 1, j, word, k + 1, visited) ||
                solve(board, i, j + 1, word, k + 1, visited) ||
                solve(board, i, j - 1, word, k + 1, visited);
        visited[i][j] = 0;
        return ans;
    }

    public boolean isWordExist(char[][] board, String word) {
        // Code here
        int visited[][] = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (solve(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class WordSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char[][] board = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
