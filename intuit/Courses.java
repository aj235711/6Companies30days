package intuit;

import java.util.*;

class Solution {

    public boolean dfsHelper(List<List<Integer>> graph, int[] visited, int v, Stack<Integer> stk) {
        if (visited[v] == 1) {
            return true;
        }
        if (visited[v] == 2) {
            return false;
        }
        visited[v] = 1;
        for (int i = 0; i < graph.get(v).size(); i++) {
            if (dfsHelper(graph, visited, graph.get(v).get(i), stk)) {
                return true;
            }
        }
        stk.push(v);
        visited[v] = 2;
        return false;
    }

    public boolean dfs(List<List<Integer>> graph, int n, Stack<Integer> stk) {
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (dfsHelper(graph, visited, i, stk)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] findOrder(int n, int[][] p) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < p.length; i++) {
            if (p[i][1] == p[i][0]) {
                return new int[0];
            }
            graph.get(p[i][1]).add(p[i][0]);
        }
        Stack<Integer> stk = new Stack<>();
        if (dfs(graph, n, stk)) {
            return new int[0];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = stk.pop();
        }
        return ans;
    }
}

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] p = new int[m][2];
        for (int i = 0; i < n; i++) {
            p[i][0] = sc.nextInt();
            p[i][1] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans = obj.findOrder(n, p);
        for (int x : ans) {
            System.out.print(x);
        }
        sc.close();
    }
}
