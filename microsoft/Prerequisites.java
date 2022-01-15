package microsoft;

import java.util.*;

class Solution {
    public boolean isPossible(int N, int[][] p) {
        // Your Code goes here
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            int x = p[i][0];
            int y = p[i][1];
            if (x == y) {
                return false;
            }
            if (map.containsKey(y)) {
                if (map.get(y).contains(x)) {
                    return false;
                }
                for (int z : map.get(y)) {
                    if (map.containsKey(z) && map.get(z).contains(x)) {
                        return false;
                    }
                }
            }
            if (map.containsKey(x)) {
                map.get(x).add(y);
            } else {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(y);
                map.put(x, newSet);
            }
        }
        return true;
    }

}

public class Prerequisites {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int P = sc.nextInt();
            int prerequisites[][] = new int[P][2];
            for (int i = 0; i < P; i++) {
                for (int j = 0; j < 2; j++) {
                    prerequisites[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            if (ob.isPossible(N, prerequisites)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            t--;
        }
        sc.close();
    }
}
