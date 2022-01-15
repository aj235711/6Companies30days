package microsoft;

import java.util.*;

class Solution {
    static boolean isReachable(ArrayList<ArrayList<Integer>> adj, HashSet<Integer> set, int x, int d) {
        if (x == d) {
            return true;
        }
        set.add(x);
        for (int y : adj.get(x)) {
            if (!set.contains(y) && isReachable(adj, set, y, d)) {
                return true;
            }
        }
        return false;
    }

    int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        // code here
        HashSet<Integer> set = new HashSet<Integer>();
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));
        if (isReachable(adj, set, c, d)) {
            return 0;
        }
        return 1;
    }
}

public class GraphBridge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();

            Solution ob = new Solution();

            System.out.println(ob.isBridge(V, list, c, d));
        }
        sc.close();
    }
}
