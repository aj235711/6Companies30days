package intuit;

import java.util.*;

class Solution {
    public static int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int d = getDistance(points[i], points[j]);
                if (map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                } else {
                    map.put(d, 1);
                }
            }
            for (int v : map.values()) {
                ans += v * (v - 1);
            }
        }
        return ans;
    }
}

public class Boomerangs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.numberOfBoomerangs(array));
        sc.close();
    }
}
